package mainModule;

public class Chromosom {

	
	
	String chromosomAsBinary;
	byte chromosomAsNumber;
	
	
	Chromosom(byte chromosom){
		chromosomAsNumber = chromosom;
		chromosomAsBinary = Integer.toBinaryString(chromosomAsNumber);
		
	}
	
	
	@Override
	public String toString() {
		
		return  "\nChromosom as number: "+chromosomAsNumber
						+ "\nChromosom as Binary: "+chromosomAsBinary;
	}
}
