import java.util.ArrayList;

public class Hausverwaltung {

    private HausverwaltungDAO hausverwaltungsDAO;

    public Hausverwaltung(String dateiName){
        hausverwaltungsDAO = new HausverwaltungSerializationDAO(dateiName);
    }

    public void printAll(){
        for(Wohnung a: hausverwaltungsDAO.getWohnungen()){
            System.out.println(a);
        }
    }

    public void printById(int id){
        System.out.println(hausverwaltungsDAO.getWohnungbyId(id));
    }

    public void addWohnung(Wohnung a){
        hausverwaltungsDAO.saveWohnung(a);
    }

    public void deleteWohnung(Wohnung a){
        hausverwaltungsDAO.deleteWohnung(a.getId());
    }

    public ArrayList<Integer> anzahlWohnungen(){
        int wgGesamt = 0;
        int mw = 0;
        for(Wohnung g : hausverwaltungsDAO.getWohnungen()){
            ++wgGesamt;
            if(g instanceof MietWohnung)
                ++mw;
        }
        ArrayList<Integer>toReturn = new ArrayList<>();
        toReturn.add(wgGesamt);
        toReturn.add(mw);
        toReturn.add(wgGesamt-mw);
        return toReturn;
    }

    public double getMonatlicheKosten(){
        //machen sachen am ende
        return 100;
    }

    public int oldestOne(){
        Wohnung oldest = null; boolean first = true;
        for(Wohnung a : hausverwaltungsDAO.getWohnungen()){
            if(first){
                first = false;
                oldest = a;
            }
            if(a.alter() > oldest.alter())
                oldest = a;
        }
        if(oldest != null)
        return oldest.getId();

        throw new NullPointerException("Wohnung nicht vorhanden");
    }

    public Wohnung getWohnung(int id){
        return hausverwaltungsDAO.getWohnungbyId(id);
    }

}