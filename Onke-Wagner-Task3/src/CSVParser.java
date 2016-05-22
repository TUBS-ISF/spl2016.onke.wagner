import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {

	
	public List<DesignPatternInformation> readCSV() {
		List<DesignPatternInformation> informations = new ArrayList<>();
		String fileToParse = "DesignPatternInformation.csv";
        BufferedReader fileReader = null;
        final String DELIMITER = ",";
        try
        {
            String line = "";
            fileReader = new BufferedReader(new FileReader(fileToParse));
            while ((line = fileReader.readLine()) != null) 
            {
                String[] tokens = line.split(DELIMITER);
                DesignPatternInformation information = new DesignPatternInformation();
                information.setName(tokens[0]);
                information.setType(tokens[1]);
                informations.add(information);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally
        {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		return informations;
	}
}
