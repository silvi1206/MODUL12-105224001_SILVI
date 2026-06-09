public class ValidasiPenumpang {
    public static void validasiNik(String nik) {

        if (nik.length() != 16) {
            throw new DataPenumpangTidakValidException(
                    "NIK harus 16 digit.");
        }

        for (int i = 0; i < nik.length(); i++) {

            char c = nik.charAt(i);

            if (c < '0' || c > '9') {

                throw new DataPenumpangTidakValidException(
                        "NIK hanya boleh berisi angka.");
            }
        }
    }
}
