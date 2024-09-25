public class Kuis extends Konten {
    private int jumlahSoal;

    public Kuis(String id, String judul, int jumlahSoal) {
        super(id, judul);
        this.jumlahSoal = jumlahSoal;
    }

    @Override
    public void tampilkanKonten() {
        System.out.println("Menampilkan kuis: " + getJudul() + " dengan " + jumlahSoal + " soal.");
    }
}
