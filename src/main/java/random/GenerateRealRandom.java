package random;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateRealRandom {
	
	
	public static byte generate0to127Random(String[] random){

		int number = Integer.parseInt(random[ThreadLocalRandom.current().nextInt(0,random.length)]);	
		byte ourRandom = (byte) (number % 128);
		return ourRandom;
	}
	
	
	public static byte generate0to100Random(String[] random){

		int number = Integer.parseInt(random[ThreadLocalRandom.current().nextInt(0,random.length)]);	
		byte ourRandom = (byte) (number % 101);
		return ourRandom;
	}
	
	public static byte generate0to7Random(String[] random){

		int number = Integer.parseInt(random[ThreadLocalRandom.current().nextInt(0,random.length)]);	
		byte ourRandom = (byte) (number % 8);
		return ourRandom;
	}

}
