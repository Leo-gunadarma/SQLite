package id.arya.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button tambahData;
    RecyclerView recyclerView;
    MainActivity2Adapter adapter;
    TernaKuDBHelper db;
    List<Hewan> listHewan = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tambahData = findViewById(R.id.buttonAdd);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        db=new TernaKuDBHelper(this);
        listHewan = db.getAllData();
        adapter = new MainActivity2Adapter(listHewan);
        recyclerView.setAdapter(adapter);
        tambahData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondActivity = new Intent(MainActivity.this , MainActivity2.class);
                startActivity(secondActivity);
            }
        });
    }
}