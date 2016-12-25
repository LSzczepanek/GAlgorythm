package mainModule;

import java.util.Arrays;

import random.GenerateRealRandom;

public class Individual {

	Chromosom chromosom;
	int valueOfAdaptation;

	public Individual(byte chromosom) {

		this.chromosom = new Chromosom(chromosom);
		this.valueOfAdaptation = calculateAdaptation();
	}

	public Individual(char[] chromosom) {

		this.chromosom = new Chromosom(chromosom);
		this.valueOfAdaptation = calculateAdaptation();
	}

	public Individual[] crossWithOther(Individual secondIndividual) {
		int locus = calculateLocus();
		
		System.out.println("Crossing from: "+ locus);
		
		char[] tmpArray = Arrays.copyOf(this.chromosom.chromosomAsCharArray, this.chromosom.chromosomAsCharArray.length);
		char[] thisSubject = Arrays.copyOf(this.chromosom.chromosomAsCharArray, this.chromosom.chromosomAsCharArray.length);
		char[] secondSubject = Arrays.copyOf(secondIndividual.chromosom.chromosomAsCharArray, secondIndividual.chromosom.chromosomAsCharArray.length);
		for(int i = locus; i < this.chromosom.chromosomAsCharArray.length; i++){
			
		}
		
		
		return null;
	}

	private int calculateLocus() {

		return GenerateRealRandom.generate0to7Random();
	}

	private int calculateAdaptation() {
		int result;
		result = (int) (2 * (Math.pow(chromosom.chromosomAsNumber, 2) + 1));
		return result;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Value of adaptation: " + valueOfAdaptation + chromosom.toString();
	}

}
