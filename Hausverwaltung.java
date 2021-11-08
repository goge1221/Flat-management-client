/**
 * @author Andrei Goje
 * @id 12032793
 */

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
        if(hausverwaltungsDAO.getWohnungbyId(id) != null )System.out.println(hausverwaltungsDAO.getWohnungbyId(id));
    }

    public void addWohnung(Wohnung a){
        hausverwaltungsDAO.saveWohnung(a);
    }

    public void deleteWohnung(int a){
        hausverwaltungsDAO.deleteWohnung(a);
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

    public String getMonatlicheKosten(){
        double toReturn = 0;
        for(Wohnung a: hausverwaltungsDAO.getWohnungen()){
            toReturn += a.gesamtKosten();
        }
        return String.format("%.2f",toReturn / hausverwaltungsDAO.getWohnungen().size());
    }

    public void oldestOne(){
        int oldestMW = 0; int oldestEW = 0; int oldestEWID = 0; int oldestMWID = 0;
        boolean first = true; boolean firstSecond = true;
        for(Wohnung a : hausverwaltungsDAO.getWohnungen()){
            if(first && a instanceof MietWohnung){first = false; oldestMW = a.alter(); oldestMWID = a.getId();}
            if(a instanceof MietWohnung && a.alter() > oldestMW) {oldestMW = a.alter(); oldestMWID = a.getId();}
            if(firstSecond && a instanceof EigentumsWohnung){firstSecond = false; oldestEW = a.alter(); oldestEWID = a.getId();}
            if(a instanceof EigentumsWohnung && a.alter() > oldestEW) {oldestEW = a.alter(); oldestEWID = a.getId(); }
        }

        System.out.println("Id: " + oldestMWID);
        System.out.println("Id: " + oldestEWID);
    }

    public Wohnung getWohnung(int id){
        return hausverwaltungsDAO.getWohnungbyId(id);
    }

}