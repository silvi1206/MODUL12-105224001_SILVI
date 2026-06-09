import java.util.InputMismatchException;
import java.util.Scanner;

public class ReservasiPrinter {

    private final SistemReservasi reservasi;
    private final Scanner input;

    public ReservasiPrinter(SistemReservasi reservasi) {
        this.reservasi = reservasi;
        this.input = new Scanner(System.in);
    }

    public void jalankan() {
        boolean jalan = true;

        while (jalan) {
            try {
                cetakMenuUtama();
                int pilihan = input.nextInt();
                input.nextLine(); // Membersihkan sisa buffer setelah input angka

                switch (pilihan) {
                    case 1:
                        reservasi.tampilkanJadwal();
                        break;
                    case 2:
                        bukaFormulirPemesanan();
                        break;
                    case 3:
                        System.out.println("\nTerima kasih telah menggunakan JAVA EXPRESS.");
                        jalan = false;
                        break;
                    default:
                        System.out.println("Menu tidak tersedia.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Input harus berupa angka!");
                input.nextLine(); // Membersihkan input salah dari buffer
            } catch (DataPenumpangTidakValidException e) {
                System.out.println("Error Data Penumpang : " + e.getMessage());
            } catch (RuteTidakDitemukanException e) {
                System.out.println("Error Rute : " + e.getMessage());
            } catch (TiketHabisException e) {
                System.out.println("Tiket untuk " + e.getNamaKereta() + " tidak mencukupi.");
                System.out.println("Sisa kursi tersedia : " + e.getSisaKursi());
            } catch (IllegalArgumentException e) {
                System.out.println("Error Validasi: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan sistem: " + e.getMessage());
            }
        }

        input.close();
        System.out.println("\nScanner berhasil ditutup.");
    }

    private void cetakMenuUtama() {
        System.out.println("\n=====================");
        System.out.println("     JAVA EXPRESS");
        System.out.println("=====================");
        System.out.println("1. Lihat Jadwal");
        System.out.println("2. Pesan Tiket");
        System.out.println("3. Keluar");
        System.out.print("Pilih Menu : ");
    }

    private void bukaFormulirPemesanan() throws RuteTidakDitemukanException, TiketHabisException {
        System.out.print("Kode Kereta : ");
        String kode = input.nextLine();
        System.out.print("NIK : ");
        String nik = input.nextLine();
        System.out.print("Nama Penumpang : ");
        String nama = input.nextLine();
        System.out.print("Jumlah Tiket : ");
        int jumlah = input.nextInt();
        input.nextLine(); // Membersihkan buffer

        // Menjalankan core logic pemesanan tiket
        KeretaApi keretaTerpesan = reservasi.pesanTiket(kode, nik, nama, jumlah);

        // Pencetakan struk transaksi sukses ditarik penuh ke layer UI printer ini
        System.out.println("\n===== PEMESANAN BERHASIL =====");
        System.out.println("Nama Penumpang : " + nama);
        System.out.println("NIK: " + nik);
        System.out.println("Kereta: " + keretaTerpesan.getNama());
        System.out.println("Jumlah Tiket: " + jumlah);
        System.out.println("Sisa Kursi: " + keretaTerpesan.getSisaKursi());
    }
}