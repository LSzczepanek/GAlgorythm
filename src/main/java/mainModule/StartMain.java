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
		
		
//		System.out.print(testFile[0].replaceAll("\\r", ""));
//		System.out.println("test");
//		int test = Integer.parseInt("123 ".replaceAll("\\n", ""));
//		System.out.println(test);
		for(int i = 0; i <10 ; i++){
			System.out.println(GenerateRealRandom.generate0to127Random(testFile));
		}
		
		
		System.out.println(Integer.toBinaryString(6));
		System.out.println(Integer.parseInt(Integer.toBinaryString(6), 2));
		
		Individual firstOne = new Individual(GenerateRealRandom.generate0to127Random(testFile));
		
		System.out.println(firstOne.toString());

	}

}
