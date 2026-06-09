import java.util.ArrayList;

public class KeretaRepository {
    
    private ArrayList<KeretaApi> daftarKereta;

    public KeretaRepository() {
        daftarKereta = new ArrayList<>();
        daftarKereta.add(new KeretaApi( "K01", "Argo Bromo", "JKT - SBY",50));
        daftarKereta.add(new KeretaApi( "K02","Parahyangan","JKT - BDG",15));
    }

    public ArrayList<KeretaApi> getDaftarKereta() {
        return daftarKereta;
    }

    
}
