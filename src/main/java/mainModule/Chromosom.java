package mainModule;

public class Chromosom {

	String chromosomAsBinary;
	byte chromosomAsNumber;
	char[] chromosomAsCharArray = { '0', '0', '0', '0', '0', '0', '0' };

	Chromosom(byte chromosom) {
		this.chromosomAsNumber = chromosom;
		this.chromosomAsBinary = Integer.toBinaryString(chromosomAsNumber);
		makeCharArray(this.chromosomAsBinary);

	}

	Chromosom(char[] chromosom) {

		this.chromosomAsNumber = Byte.parseByte(new String(chromosom), 2);
		this.chromosomAsBinary = Integer.toBinaryString(chromosomAsNumber);
		makeCharArray(this.chromosomAsBinary);

	}

	@Override
	public String toString() {

		return "\nChromosom as number: " + chromosomAsNumber + "\nChromosom as Binary: " + chromosomAsBinary
				+ "\nChromosom as FullBinary: " + printChromosomAsCharArray();
	}

	private void makeCharArray(String chromosom) {

		char[] tmpArray = chromosom.toCharArray();
		for (int i = 0; i < tmpArray.length; i++) {
			chromosomAsCharArray[i + (chromosomAsCharArray.length - tmpArray.length)] = tmpArray[i];
		}
	}

	private String printChromosomAsCharArray() {
		String arrayAsString = "";
		for (char c : chromosomAsCharArray) {
			arrayAsString += c;
		}
		return arrayAsString;
	}
}
