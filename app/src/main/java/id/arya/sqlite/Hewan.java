package id.arya.sqlite;

public class Hewan {
    private String namaHewan, jenisKelamin;
    public Hewan (String namaHewan , String jenisKelamin){
        this.namaHewan = namaHewan;
        this.jenisKelamin = jenisKelamin;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public String getNamaHewan() {
        return namaHewan;
    }

}
