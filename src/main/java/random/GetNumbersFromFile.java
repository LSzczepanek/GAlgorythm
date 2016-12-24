package random;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class GetNumbersFromFile {

	
	private static String readFile(String fileName) throws IOException {
		BufferedReader br;

		br = new BufferedReader(new FileReader(fileName));

		StringBuilder sb = new StringBuilder();
		String line = br.readLine();

		while (line != null) {
			sb.append(line);
			sb.append(System.lineSeparator());
			line = br.readLine();
		}
		String everything = sb.toString();

		br.close();
		return everything;

	}

	public static String[] getPreparedFile() {
		String testFile = null;
		try {
			 testFile = GetNumbersFromFile
			 .readFile("src/main/resources/random1.txt");
//			testFile = FileHelper.readFile("G:/ProjektyEclipse/kNNProblem/src/resources/dane.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String[] separatedString = testFile.split("\\n");
		
		return separatedString;
	}
}
