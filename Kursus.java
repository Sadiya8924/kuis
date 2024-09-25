import java.util.ArrayList;
import java.util.List;

public class Kursus {
    private String id;
    private String nama;
    private String deskripsi;
    private int harga;
    private List<Konten> daftarKonten;

    public Kursus(String id, String nama, String deskripsi, int harga) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.daftarKonten = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public int getHarga() {
        return harga;
    }

    public void tambahKonten(Konten konten) {
        daftarKonten.add(konten);
    }

    public List<Konten> getDaftarKonten() {
        return daftarKonten;
    }
    
}