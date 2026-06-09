import java.util.List;

public class SistemReservasi {
    
    private final List<KeretaApi> daftarKereta;
    
    public SistemReservasi(List<KeretaApi> daftarKereta) {
        this.daftarKereta = daftarKereta;
    }

    public List<KeretaApi> getDaftarKereta() {
        return daftarKereta;
    }

    public void tampilkanJadwal() {
        System.out.println("\n===== JADWAL KERETA =====");
        for (KeretaApi kereta : daftarKereta) {
            System.out.println(kereta);
        }
    }

    private KeretaApi cariKereta(String kodeKereta) throws RuteTidakDitemukanException {
        for (KeretaApi kereta : daftarKereta) {
            if (kereta.getKode().equalsIgnoreCase(kodeKereta)) {
                return kereta;
            }
        }
        throw new RuteTidakDitemukanException("Kode kereta tidak ditemukan.");
    }

    public KeretaApi pesanTiket(String kodeKereta, String nik, String namaPenumpang, int jumlahTiket)
        throws RuteTidakDitemukanException, TiketHabisException {
        ValidasiPenumpang.validasiNik(nik);
        ValidasiJumlahTiket.validasiJumlahTiket(jumlahTiket);

        KeretaApi keretaDitemukan = cariKereta(kodeKereta);

        if (jumlahTiket > keretaDitemukan.getSisaKursi()) {
            throw new TiketHabisException(keretaDitemukan.getNama(), keretaDitemukan.getSisaKursi());
        }

        keretaDitemukan.kurangiKursi(jumlahTiket);
        return keretaDitemukan;
    }
}