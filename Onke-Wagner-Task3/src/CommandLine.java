import java.util.List;

public class CommandLine {
	public CommandLine(List<DesignPatternInformation> informations) {
		// #ifdef ListAllPatterns
		for (DesignPatternInformation information : informations) {
			// #ifdef Name
			System.out.println(information.getName());
			// #endif
			// #ifdef Type
			System.out.println(information.getType());
			// #endif
		}
		// #endif
	}

}
