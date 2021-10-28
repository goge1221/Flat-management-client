/**
 * @author Andrei Goje
 * @id 12032793
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HausverwaltungSerializationDAO implements HausverwaltungDAO {

    private final String fileName;

    public HausverwaltungSerializationDAO(String name){
        fileName = name;
    }


    @Override
    public List<Wohnung> getWohnungen() {
        File file = new File(fileName);

        List<Wohnung> wohnungen = new ArrayList<>();
        if(file.exists()) {
            try {
                ObjectInputStream reader;
                reader = new ObjectInputStream(new FileInputStream(fileName));
                wohnungen = (List<Wohnung>) reader.readObject();
                reader.close();
            } catch (Exception e) {
                System.out.println("Fehler bei Deserializierung: " + e.getMessage());
                System.exit(1);
            }
            return wohnungen;
        }
        return new ArrayList<>();
    }

    @Override
    public Wohnung getWohnungbyId(int id) {
        for(Wohnung a: getWohnungen()){
            if(a.getId() == id){
                return a;
            }
        }
        return null;
    }

    @Override
    public void saveWohnung(Wohnung wohnung) {

        File file = new File(fileName);

        List<Wohnung> wohnungen = new ArrayList<>();

        if(file.exists()){
            wohnungen = getWohnungen();
            file.delete();
        }

        for(Wohnung a : wohnungen){
            if(a.getId() == wohnung.getId()){
                try{
                    ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName,true));
                    writer.writeObject(wohnungen);
                    writer.close();
                } catch (Exception e) {
                    System.out.println("Fehler bei Serializierung: " + e.getMessage());
                    System.exit(1);
                }
                throw new IllegalArgumentException("Wohnung bereits vorhanden. (id=" + wohnung.getId() + ")");
            }
        }

        wohnungen.add(wohnung);

        try{
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName,true));
            writer.writeObject(wohnungen);
            writer.close();
        } catch (Exception e) {
            System.out.println("Fehler bei Serializierung: " + e.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void deleteWohnung(int id) {

        List<Wohnung>alleWohnungen = getWohnungen();

        File file = new File(fileName);
        if(file.exists()) file.delete();

        boolean deleted = false;

        for(Wohnung a : alleWohnungen){
            if(a.getId() != id) saveWohnung(a);
            else deleted = true;
        }
        if(!deleted){
            throw new IllegalArgumentException("Wohnung nicht vorhanden. (id=" + id + ")");
        }
    }
}