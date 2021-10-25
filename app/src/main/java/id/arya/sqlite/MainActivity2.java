package id.arya.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button simpan;
    EditText namaHewan, jenisKelamin;
    private SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TernaKuDBHelper dbHelper = new TernaKuDBHelper(this);
        //Menambahkan data
        database = dbHelper.getWritableDatabase();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        simpan = findViewById(R.id.buttonSimpan);
        namaHewan = findViewById(R.id.editTextTextPersonName);
        jenisKelamin = findViewById(R.id.editTextTextPersonName2);
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpan();
            }
        });
    }

    private void simpan(){
        if (namaHewan.getText().toString().trim().length() == 0){
            //method trim digunakan untuk menghapus spasi
            Toast toast = Toast.makeText(this, "Nama Hewan Belum diisi", Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        if (jenisKelamin.getText().toString().trim().length() == 0){
            Toast toast = Toast.makeText(this, "Jenis Kelamin belum diisi", Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        String nama = namaHewan.getText().toString();
        String jk = jenisKelamin.getText().toString();
        ContentValues cv = new ContentValues();
        //Parameter content values (nama kolom, dan nilai)
        cv.put(TabelHewan.KolomHewan.COLUMN_NAME_NAMA_HEWAN, nama);
        cv.put(TabelHewan.KolomHewan.COLUMN_NAME_JENIS_KELAMIN, jk);
        database.insert(TabelHewan.KolomHewan.TABLE_NAME, null , cv);
        Intent firstActivity = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(firstActivity);
    }
}