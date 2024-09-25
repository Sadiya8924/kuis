public class Video extends Konten{
    private int durasi; // durasi dalam menit

    public Video(String id, String judul, int durasi) {
        super(id, judul);
        this.durasi = durasi;
    }

    @Override
    public void tampilkanKonten() {
        System.out.println("Memutar video: " + getJudul() + " (Durasi: " + durasi + " menit)");
    }
}
