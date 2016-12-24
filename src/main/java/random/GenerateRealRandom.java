package random;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateRealRandom {
	
	
	public static byte generate0to127Random(String[] random){

		int number = Integer.parseInt(random[ThreadLocalRandom.current().nextInt(0,10000+1)]);	
		byte ourRandom = (byte) (number % 128);
		return ourRandom;
	}

}
