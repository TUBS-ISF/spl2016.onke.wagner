import java.util.List;

import properties.PropertyManager;

public class Main {

	public static void main(String[] args) {
		List<DesignPatternInformation> informations = null;
		if (PropertyManager.getProperty("CSV")) {
			CSVParser parser;
			parser = new CSVParser();
			informations = parser.readCSV();
		}
		if (PropertyManager.getProperty("ListAllPatterns")) {
			for (DesignPatternInformation information : informations) {
				if (PropertyManager.getProperty("Name")) {
					System.out.println(information.getName());
				}
				if (PropertyManager.getProperty("Type")) {
					System.out.println(information.getType());
				}
			}
		}
	}
}
