public class Instruktur extends Pengguna{
    public Instruktur(String id, String nama, String email) {
        super(id, nama, email);
    }

    public void buatKonten(Konten konten) {
        System.out.println("Instruktur " + getNama() + " telah membuat konten: " + konten.getJudul());
    }

    public void kelolaKursus(Kursus kursus) {
        System.out.println("Instruktur " + getNama() + " mengelola kursus: " + kursus.getNama());
    }
}
