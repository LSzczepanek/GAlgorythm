package random;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateRealRandom {

	public static String[] random = GetNumbersFromFile.getPreparedFile();

	public static byte generate0to127Random() {

		int number = Integer.parseInt(random[ThreadLocalRandom.current().nextInt(0, random.length)]);
		byte ourRandom = (byte) (number % 128);
		return ourRandom;
	}

	public static byte generate0to100Random() {

		int number = Integer.parseInt(random[ThreadLocalRandom.current().nextInt(0, random.length)]);
		byte ourRandom = (byte) (number % 101);
		return ourRandom;
	}

	public static byte generate0to6Random() {

		int number = Integer.parseInt(random[ThreadLocalRandom.current().nextInt(0, random.length)]);
		byte ourRandom = (byte) (number % 7);
		return ourRandom;
	}
	
	public static byte generate0to7Random() {

		int number = Integer.parseInt(random[ThreadLocalRandom.current().nextInt(0, random.length)]);
		byte ourRandom = (byte) (number % 8);
		return ourRandom;
	}

}
