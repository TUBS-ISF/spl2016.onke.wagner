import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<DesignPatternInformation> informations = null;
		// #ifdef CSV
		CSVParser parser;
		parser = new CSVParser();
		informations = parser.readCSV();
		// #endif
		// #ifdef GUI
		GUI gui = new GUI(informations);
		// #endif
		// #ifdef CommandLine
//@		CommandLine commandLine = new CommandLine(informations);
		// #endif
	}
}
