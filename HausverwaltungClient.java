import java.util.Objects;

public class HausverwaltungClient {

	public static void main(String[] args) {
		Hausverwaltung hv = new Hausverwaltung(args[0]);
		if(args[1].equals("list")){
			if(!args[2].isEmpty()){
				hv.printById(Integer.parseInt(args[2]));
			}
			else hv.printAll();
		}
		if(args[1].equals("add")){
			if(args[2].equals("MW")){
				MietWohnung toAdd = new MietWohnung(Integer.parseInt(args[3]), Double.parseDouble(args[4]), Integer.parseInt(args[5]),
						Integer.parseInt(args[6]), Integer.parseInt(args[7]), Integer.parseInt(args[8]), args[9],
				Integer.parseInt(args[11]), Integer.parseInt(args[10]), Double.parseDouble(args[12]),Integer.parseInt(args[13]));
				hv.addWohnung(toAdd);
				System.out.println("Info: Wohnung " + args[3] + " added.");
			}
			else{
				EigentumsWohnung toAdd = new EigentumsWohnung(Integer.parseInt(args[3]), Double.parseDouble(args[4]), Integer.parseInt(args[5]),
						Integer.parseInt(args[6]), Integer.parseInt(args[7]), Integer.parseInt(args[8]), args[9],
						Integer.parseInt(args[11]), Integer.parseInt(args[10]), Double.parseDouble(args[12]),Integer.parseInt(args[13]));
				hv.addWohnung(toAdd);
				System.out.println("Info: Wohnung " + args[3] + " added.");
			}
		}

		if(args[1].equals("delete")){
			hv.deleteWohnung(hv.getWohnung(Integer.parseInt(args[2])));
			System.out.println("Info: Wohnung " + args[2] + " deleted.");
		}

		if(args[1].equals("count")){
			if(args[2].isEmpty()) System.out.println(hv.anzahlWohnungen().get(0));
			if(args[2].equals("MW")){
				System.out.println(hv.anzahlWohnungen().get(1));
			}
			if(args[2].equals("EW")){
				System.out.println(hv.anzahlWohnungen().get(2));
			}
		}

		if(args[1].equals("meancosts")){
			System.out.println(hv.getMonatlicheKosten());
		}

		if(args[1].equals("oldest")){
			System.out.println(hv.oldestOne());
		}
	}
	
}