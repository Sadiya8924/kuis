public class Pembayaran {
    private int jumlah;
    private String status;

    public Pembayaran(int jumlah, String status) {
        this.jumlah = jumlah;
        this.status = status;
    }

    public void prosesPembayaran() {
        System.out.println("Memproses pembayaran sebesar: " + jumlah);
        System.out.println("Status pembayaran: " + status);
    }

    public int getJumlah() {
        return jumlah;
    }

    public String getStatus() {
        return status;
    }
}
