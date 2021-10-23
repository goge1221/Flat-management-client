public class MietWohnung extends Wohnung{

    private double mietkosten;
    private int anzahlMieter;

    //KONSTRUKTOR
    public MietWohnung(int id, double flaeche, int zimmerAnzahl, int stockwerk, int baujahr, int plz, String strasse, int top, int strasseNummer, double mietkosten, int anzahlMieter) {
        super(id, flaeche, zimmerAnzahl, stockwerk, baujahr, plz, strasse, top, strasseNummer);
        this.mietkosten = mietkosten;
        this.anzahlMieter = anzahlMieter;
    }

    @Override
    public double gesamtKosten(){
        if(anzahlMieter > 4){
            return mietkosten * 1.1;
        }
        if(anzahlMieter == 1){
            return mietkosten;
        }
        return mietkosten * (1+0.025*anzahlMieter);
    }

    @Override
    public String toString(){
        StringBuilder mwBuilder = new StringBuilder();
        mwBuilder.append("Typ:                ").append("MW").append("\n");
        mwBuilder.append(super.toString());
        mwBuilder.append("Miete/m2:     ").append(mietkosten).append("\n");
        mwBuilder.append("Anzahl Mieter:          ").append(anzahlMieter).append("\n");

        return mwBuilder.toString();
    }


}