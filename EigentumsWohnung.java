public class EigentumsWohnung extends Wohnung{

    private double betriebskosten;
    private double reparaturRuecklage;

    //KONSTRUKTOR
    public EigentumsWohnung(int id, double flaeche, int zimmerAnzahl, int stockwerk, int baujahr, int plz, String strasse, int top, int strasseNummer, double betriebskosten, double reparaturRuecklage) {
        super(id, flaeche, zimmerAnzahl, stockwerk, baujahr, plz, strasse, top, strasseNummer);
        this.betriebskosten = betriebskosten;
        this.reparaturRuecklage = reparaturRuecklage;
    }

    //METHODEN

    @Override
    public double gesamtKosten(){
        if(getStockwerk() == 0){
            return betriebskosten + reparaturRuecklage;
        }
        return (betriebskosten + reparaturRuecklage) * (1 + getStockwerk() * 0.02);
    }

    @Override
    public String toString(){
        StringBuilder ewBuilder = new StringBuilder();
        ewBuilder.append("Typ:            ").append("EW").append("\n");
        ewBuilder.append(super.toString());
        ewBuilder.append("Betriebskosten: ").append(betriebskosten).append("\n");
        ewBuilder.append("Ruecklage:      ").append(reparaturRuecklage).append("\n");

        return ewBuilder.toString();
    }

}