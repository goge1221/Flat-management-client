import java.io.Serializable;

public abstract class Wohnung implements Serializable {
    private int id;
    private double flaeche;
    private int zimmerAnzahl;
    private int stockwerk;
    private int baujahr;
    private int plz;
    private String strasse;
    private int top;
    private int strasseNummer;

    //Konstruktor

    public Wohnung(int id, double flaeche, int zimmerAnzahl, int stockwerk, int baujahr, int plz, String strasse, int top, int strasseNummer){
        if(strasse == null){
            throw new IllegalArgumentException("Error: Parameter ungueltig.");
        }
        if(baujahr > 2021){
            throw new IllegalArgumentException("Error: Baujahr ungueltig.");
        }
        this.baujahr = baujahr;
        this.flaeche = flaeche;
        this.stockwerk = stockwerk;
        this.plz = plz;
        this.id = id;
        this.top = top;
        this.strasse = strasse;
        this.strasseNummer = strasseNummer;
        this.zimmerAnzahl = zimmerAnzahl;
    }

    //METHODEN

    public int getStockwerk(){return stockwerk;}

    public int alter(){return 2021-baujahr;}

    public int getId(){return id;}

    public double gesamtKosten(){return 0; }


    @Override
    public String toString(){
        StringBuilder toReturn = new StringBuilder();
        toReturn.append("Id:                 ").append(id).append("\n");
        toReturn.append("Flaeche:            ").append(flaeche).append("\n");
        toReturn.append("Zimmer:             ").append(zimmerAnzahl).append("\n");
        toReturn.append("Stock:              ").append(stockwerk).append("\n");
        toReturn.append("Baujahr:            ").append(baujahr).append("\n");
        toReturn.append("PLZ:                ").append(plz).append("\n");
        toReturn.append("Strasse:            ").append(strasse).append("\n");
        toReturn.append("Hausnummer:         ").append(strasseNummer).append("\n");
        toReturn.append("Top:                ").append(top).append("\n");
        return toReturn.toString();
    }

    /*
Id: 3
Flaeche: 125.80
Zimmer: 5
Stock: 2
Baujahr: 1890
PLZ: 1090
Strasse: Berggasse
Hausnummer: 19
Top: 5

*/
}
