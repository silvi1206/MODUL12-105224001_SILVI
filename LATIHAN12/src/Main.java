public class Main {

    public static void main(String[] args) {
        KeretaRepository repository = new KeretaRepository();
        SistemReservasi reservasi = new SistemReservasi(repository.getDaftarKereta());
        ReservasiPrinter printer = new ReservasiPrinter(reservasi);
        printer.jalankan();
    }
}