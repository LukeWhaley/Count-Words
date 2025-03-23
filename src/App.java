import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class App {    
    public static void main(String[] args) throws Exception {
        String fileName = "sample.txt";
        int amount = 0;

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            String[] array = lines.toArray(new String[0]);

            HashMap<String, Integer> result = new HashMap<String, Integer>();

            for (int i = 0; i < array.length; i++){
                array[i] = array[i].toLowerCase(); 
            }
            
            for (String str : array) {

                amount = 0;

                for (int i = 0; i < array.length; i++){

                    if (str.equals(array[i])) {
                        amount = amount + 1;
                    }
                
                }     

                result.put(str, amount);

            }

            String filename = "result.txt";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                for (String key : result.keySet()){
                    String line = (key + " " + result.get(key));
                    writer.write(line);
                    writer.newLine();
                }
            } catch (IOException e) {
                System.err.println("An error occurred while writing to the file: " + e.getMessage());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
