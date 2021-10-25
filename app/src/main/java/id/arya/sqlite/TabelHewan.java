package id.arya.sqlite;

import android.provider.BaseColumns;

public class TabelHewan {
    private TabelHewan(){}
    public static class KolomHewan implements BaseColumns{
        public static final String TABLE_NAME="tb_hewan";
        public static final String COLUMN_NAME_NAMA_HEWAN = "nama_hewan";
        public static final String COLUMN_NAME_JENIS_KELAMIN = "jenis_kelamin";
    }
}
