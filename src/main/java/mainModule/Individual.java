package mainModule;

import java.util.Arrays;

import random.GenerateRealRandom;

public class Individual {

	Chromosom chromosom;
	int valueOfAdaptation;
	double percentOnRoulette;

	public Individual(byte chromosom) {

		this.chromosom = new Chromosom(chromosom);
		this.valueOfAdaptation = calculateAdaptation();
	}

	public Individual(char[] chromosom) {

		this.chromosom = new Chromosom(chromosom);
		this.valueOfAdaptation = calculateAdaptation();
	}

	public Individual[] crossWith(Individual secondIndividual) {
		int locus = calculateLocus();
		
		System.out.println("Crossing with locus: "+ locus);
		
		char[] tmpArray = Arrays.copyOf(this.chromosom.chromosomAsCharArray, this.chromosom.chromosomAsCharArray.length);
		char[] thisSubject = Arrays.copyOf(this.chromosom.chromosomAsCharArray, this.chromosom.chromosomAsCharArray.length);
		char[] secondSubject = Arrays.copyOf(secondIndividual.chromosom.chromosomAsCharArray, secondIndividual.chromosom.chromosomAsCharArray.length);
		for(int i = locus; i < this.chromosom.chromosomAsCharArray.length; i++){
			thisSubject[i] = secondSubject[i];
			secondSubject[i] = tmpArray[i];
		}
		Individual[] crossedIndividuals = {new Individual(thisSubject), new Individual(secondSubject)};
		
		return crossedIndividuals;
	}
	
	public Individual mutate(byte locus){
		
		System.out.println("Mutation with locus: "+locus);
		char[] subjectToMutate = Arrays.copyOf(this.chromosom.chromosomAsCharArray, this.chromosom.chromosomAsCharArray.length);
		if(subjectToMutate[locus] == '0'){
			subjectToMutate[locus] = '1';
		}else if(subjectToMutate[locus] == '1'){
			subjectToMutate[locus] = '0';
		}
		else{
			System.out.println("Mutation gone wrong!!");
			return null;
		}
		return new Individual(subjectToMutate);
	}
	

	private int calculateLocus() {

		return GenerateRealRandom.generate0to6Random();
	}

	private int calculateAdaptation() {
		int result;
		result = (int) (2 * (Math.pow(chromosom.chromosomAsNumber, 2) + 1));
		return result;
	}
	
	
	public void setPercentOnRoulette(double percent){
		this.percentOnRoulette = percent;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Value of adaptation: " + valueOfAdaptation +"\npercentage: "+percentOnRoulette+ chromosom.toString();
	}

}
