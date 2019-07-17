package testmanusiacsv;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

public class CSV_Manusia implements CSV<Manusia>{
    
    @Override
    public void write(Path path, List<Manusia> items){
        try (FileWriter writing = new FileWriter(path.toString());){
            StringBuilder manusia = new StringBuilder();
            for(Manusia m : items){
                manusia.append(m.getNama()); 
                manusia.append(",");
                manusia.append(m.getUmur()); 
                manusia.append(",");
                manusia.append(m.getBerat());
                manusia.append(",");
                manusia.append(m.getJenisKelamin());
                manusia.append("\n");       
            }
            writing.write(manusia.toString());
        } catch (IOException ex) {
            System.err.println("I/O exception");
        }
    }  
    @Override
    public List<Manusia> read(Path path) {
        List<Manusia> manusia = new ArrayList<Manusia>();
        try(BufferedReader reading = new BufferedReader(new FileReader(path.toString()))){
            String kalimat;
            while((kalimat = reading.readLine()) != null){
                
                String[] kata = kalimat.split(",");
                
                Manusia manusia_add = new Manusia(kata[0], Integer.parseInt(kata[1]), Double.parseDouble(kata[2]), Boolean.parseBoolean(kata[3]));
                manusia.add(manusia_add);
                
            }
        } catch (IOException ex) {
            System.err.println("I/O exception");
        }
        return manusia;     
    }
}
