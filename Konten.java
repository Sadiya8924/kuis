public class Konten {
    private String id;
    private String judul;

    public Konten(String id, String judul) {
        this.id = id;
        this.judul = judul;
    }

    public String getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public void tampilkanKonten() {
        System.out.println("Menampilkan konten: " + judul);
    }
}
