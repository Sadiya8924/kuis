import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Buat objek Kursus
        Kursus kursus1 = new Kursus("101", "Pemrograman Java", "Belajar Java dari dasar hingga mahir.", 500000);
        Kursus kursus2 = new Kursus("102", "Desain Web", "Belajar membuat desain web responsif.", 400000);
        Kursus kursus3 = new Kursus("103", "Machine Learning", "Belajar dasar-dasar machine learning.", 700000);

        // Tambahkan konten ke kursus
        kursus1.tambahKonten(new Video("V101", "Pengenalan Java", 30));
        kursus1.tambahKonten(new Kuis("K101", "Kuis Bab 1", 10));

        kursus2.tambahKonten(new Video("V102", "Dasar-dasar Desain Web", 45));
        kursus2.tambahKonten(new Kuis("K102", "Kuis HTML dan CSS", 15));

        kursus3.tambahKonten(new Video("V103", "Memahami Algoritma ML", 60));
        kursus3.tambahKonten(new Kuis("K103", "Kuis Linear Regression", 20));

        List<Kursus> semuaKursus = new ArrayList<>();
        semuaKursus.add(kursus1);
        semuaKursus.add(kursus2);
        semuaKursus.add(kursus3);

        // Input data Peserta
        System.out.println("Input Data Peserta:");
        System.out.print("Masukkan ID: ");
        String id = scanner.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Email: ");
        String email = scanner.nextLine();

        // Buat objek Peserta
        Peserta peserta = new Peserta(id, nama, email);

        boolean keluar = false;

        while (!keluar) {
            // Menu Utama
            System.out.println("\n===== Menu Utama =====");
            System.out.println("1. Daftar Kursus");
            System.out.println("2. Lakukan Pembayaran");
            System.out.println("3. Akses Konten Kursus");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");
            int opsi = scanner.nextInt();

            switch (opsi) {
                case 1:
                    // Daftar kursus yang tersedia
                    boolean selesaiDaftar = false;
                    while (!selesaiDaftar) {
                        System.out.println("\nDaftar Kursus yang Tersedia:");
                        for (int i = 0; i < semuaKursus.size(); i++) {
                            Kursus kursus = semuaKursus.get(i);
                            System.out.println((i + 1) + ". " + kursus.getNama() + " - Rp " + kursus.getHarga());
                        }
                        System.out.println("0. Kembali ke Menu Utama");
                        System.out.print("Pilih kursus yang ingin didaftarkan (1-3, atau 0 untuk kembali): ");
                        int pilihanKursus = scanner.nextInt();

                        if (pilihanKursus == 0) {
                            selesaiDaftar = true;
                        } else if (pilihanKursus > 0 && pilihanKursus <= semuaKursus.size()) {
                            Kursus kursusDipilih = semuaKursus.get(pilihanKursus - 1);
                            peserta.daftarKursus(kursusDipilih);
                        } else {
                            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                        }
                    }
                    break;
                case 2:
                    // Pembayaran
                    if (peserta.getKursusTerdaftar().isEmpty()) {
                        System.out.println("Anda belum mendaftar kursus apa pun.");
                    } else {
                        int totalBiaya = 0;
                        for (Kursus kursus : peserta.getKursusTerdaftar()) {
                            totalBiaya += kursus.getHarga();
                        }
                        System.out.println("\nTotal biaya yang harus dibayar: Rp " + totalBiaya);
                        System.out.print("Masukkan jumlah pembayaran: Rp ");
                        int jumlahPembayaran = scanner.nextInt();

                        if (jumlahPembayaran >= totalBiaya) {
                            peserta.bayarKursus(jumlahPembayaran);
                        } else {
                            System.out.println("Jumlah pembayaran kurang.");
                        }
                    }
                    break;
                case 3:
                    // Akses konten setelah pembayaran
                    if (peserta.getKursusTerdaftar().isEmpty()) {
                        System.out.println("Anda belum mendaftar kursus apa pun.");
                    } else {
                        boolean kembaliKeMenu = false;
                        while (!kembaliKeMenu) {
                            peserta.aksesKonten();
                            System.out.print("Pilih konten untuk diakses (atau 0 untuk kembali ke menu utama): ");
                            int kontenPilihan = scanner.nextInt();

                            if (kontenPilihan == 0) {
                                kembaliKeMenu = true;
                            } else if (kontenPilihan > 0 && kontenPilihan <= peserta.getKursusTerdaftar().size()) {
                                Kursus kursusDipilih = peserta.getKursusTerdaftar().get(kontenPilihan - 1);
                                List<Konten> daftarKonten = kursusDipilih.getDaftarKonten();

                                // Menampilkan konten dalam kursus yang dipilih
                                for (int i = 0; i < daftarKonten.size(); i++) {
                                    Konten konten = daftarKonten.get(i);
                                    System.out.println((i + 1) + ". " + konten.getJudul());
                                }

                                System.out.print("Pilih konten untuk ditampilkan: ");
                                int kontenDipilih = scanner.nextInt();

                                if (kontenDipilih > 0 && kontenDipilih <= daftarKonten.size()) {
                                    Konten konten = daftarKonten.get(kontenDipilih - 1);
                                    konten.tampilkanKonten();
                                } else {
                                    System.out.println("Konten tidak valid.");
                                }
                            } else {
                                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                            }
                        }
                    }
                    break;
                case 0:
                    // Keluar
                    keluar = true;
                    System.out.println("Terima kasih telah menggunakan layanan kami.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
                }
            }
            scanner.close();
    }
}
