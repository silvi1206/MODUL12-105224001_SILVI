public class ValidasiJumlahTiket {
    public static void validasiJumlahTiket(int jumlahTiket) {
    // Validasi jumlah tiket
        if (jumlahTiket <= 0) {

            throw new IllegalArgumentException("Jumlah tiket harus lebih dari 0.");
        }
    }
}
