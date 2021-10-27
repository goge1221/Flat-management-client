import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HausverwaltungSerializationDAO implements HausverwaltungDAO {

    private final String fileName;

    public HausverwaltungSerializationDAO(String name){
        fileName = "/" + name;
    }


    @Override
    public List<Wohnung> getWohnungen() {
        File file = new File(fileName);

        List<Wohnung> wohnungen = null;

        try {
            ObjectInputStream reader;
            reader = new ObjectInputStream(new FileInputStream(fileName));
            wohnungen = (List<Wohnung>) reader.readObject();
            reader.close();
        }catch (Exception e){
            System.out.println("Fehler bei Deserializierung: " + e.getMessage());
            System.exit(1);
        }
        return wohnungen;
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

        if(getWohnungbyId(wohnung.getId()) != null){
            throw new IllegalArgumentException("Error: Wohnung bereits vorhanden. (id=" + wohnung.getId() + ")");
        }

        File file = new File(fileName);

        if(file.exists()){
            try{
                FileOutputStream fileOutput = new FileOutputStream(fileName);
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
                outputStream.writeObject(wohnung);
                outputStream.close();
            }catch (Exception e){
                System.out.println("Fehler bei Serializierung: " + e.getMessage());
                System.exit(1);
            }
        }

        else{
            try{
                ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName, true));
                writer.writeObject(wohnung);
                writer.close();
            }catch (Exception e){
                System.out.println("Fehler bei Serializierung: " + e.getMessage());
                System.exit(1);
            }
        }
    }

    @Override
    public void deleteWohnung(int id) {
        if(getWohnungbyId(id) == null){
            throw new IllegalArgumentException("Error: Wohnung nicht vorhanden. (id=" + id + ")");
        }
        List<Wohnung>alleWohnungen = getWohnungen();
        File file = new File(fileName);
        file.delete();
        for(Wohnung a : alleWohnungen){
            saveWohnung(a);
        }
    }
}