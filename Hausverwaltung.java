public class Hausverwaltung {

    private HausverwaltungDAO haus;

    public Hausverwaltung(String dateiName){
        haus = new HausverwaltungSerializationDAO(dateiName);
    }

}