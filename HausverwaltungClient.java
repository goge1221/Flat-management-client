/**
 * @author Andrei Goje
 * @id 12032793
 */

import java.util.Objects;

public class HausverwaltungClient {

	public static void main(String[] args) {
		Hausverwaltung hv = new Hausverwaltung(args[0]);

		if(args.length-1 == 0){
			throw new IllegalArgumentException("Parameter ungueltig.");
		}

		else if(args[1].equals("list")){
			if(!args[1].equals(args[args.length - 1])){
				hv.printById(Integer.parseInt(args[2]));
			}
			else hv.printAll();
		}


		else if(args[1].equals("add")){


			try{
				int num = Integer.parseInt(args[3]);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("Parameter ungueltig.");
			}

			if(args.length-1 != 13) throw new IllegalArgumentException("Parameter ungueltig.");


			if (args[2].equals("MW")) {
				MietWohnung toAdd = new MietWohnung(Integer.parseInt(args[3]), Double.parseDouble(args[4]), Integer.parseInt(args[5]),
						Integer.parseInt(args[6]), Integer.parseInt(args[7]), Integer.parseInt(args[8]), args[9],
						Integer.parseInt(args[11]), Integer.parseInt(args[10]), Double.parseDouble(args[12]), Integer.parseInt(args[13]));
				hv.addWohnung(toAdd);
				System.out.println("Info: Wohnung " + args[3] + " added.");
			} else {
				EigentumsWohnung toAdd = new EigentumsWohnung(Integer.parseInt(args[3]), Double.parseDouble(args[4]), Integer.parseInt(args[5]),
						Integer.parseInt(args[6]), Integer.parseInt(args[7]), Integer.parseInt(args[8]), args[9],
						Integer.parseInt(args[11]), Integer.parseInt(args[10]), Double.parseDouble(args[12]), Double.parseDouble(args[13]));
				hv.addWohnung(toAdd);
				System.out.println("Info: Wohnung " + args[3] + " added.");
			}
		}


		else if(args[1].equals("delete")){
			hv.deleteWohnung(Integer.parseInt(args[2]));
			System.out.println("Info: Wohnung " + args[2] + " deleted.");
		}

		else if(args[1].equals("count")){
			if(args[args.length-1].equals("MW")){
				System.out.println(hv.anzahlWohnungen().get(1));
			}
			else if(args[args.length-1].equals("EW")){
				System.out.println(hv.anzahlWohnungen().get(2));
			}
			else System.out.println(hv.anzahlWohnungen().get(0));
		}

		else if(args[1].equals("meancosts")){
			System.out.println(hv.getMonatlicheKosten());
		}

		else if(args[1].equals("oldest")){
			hv.oldestOne();
		}
		else{
			throw new IllegalArgumentException("Parameter ungueltig.");

		}
	}

}