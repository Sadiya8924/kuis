import java.util.List;
import java.util.ArrayList;
class Peserta extends Pengguna {
    private List<Kursus> kursusTerdaftar;

    public Peserta(String id, String nama, String email) {
        super(id, nama, email);
        this.kursusTerdaftar = new ArrayList<>();
    }

    public void daftarKursus(Kursus kursus) {
        kursusTerdaftar.add(kursus);
        System.out.println(getNama() + " telah mendaftar kursus: " + kursus.getNama());
    }

    public void bayarKursus(int jumlahPembayaran) {
        Pembayaran pembayaran = new Pembayaran(jumlahPembayaran, "Berhasil");
        pembayaran.prosesPembayaran();
        System.out.println("Pembayaran sebesar " + jumlahPembayaran + " diproses.");
    }

    public List<Kursus> getKursusTerdaftar() {
        return kursusTerdaftar;
    }

    public void aksesKonten() {
        System.out.println("\nAkses Konten Kursus:");
        for (int i = 0; i < kursusTerdaftar.size(); i++) {
            Kursus kursus = kursusTerdaftar.get(i);
            System.out.println((i + 1) + ". " + kursus.getNama());
        }
        System.out.println("0. Kembali ke Menu Utama");
    }
}
