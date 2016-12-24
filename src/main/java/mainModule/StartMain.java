package mainModule;

import random.GenerateRealRandom;
import random.GetNumbersFromFile;

public class StartMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] testFile = GetNumbersFromFile.getPreparedFile();
		
		System.out.println(testFile.length);
		int count = 0;
		for (String string : testFile) {
			System.out.println(count+": "+string);
			count++;
		}
		
		
		for(int i = 0; i <10 ; i++){
			System.out.println(GenerateRealRandom.generate0to127Random(testFile));
		}

	}

}
