package mainModule;

import java.util.ArrayList;
import java.util.List;

import random.GenerateRealRandom;

public class StartMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		char[] testArray = { '0', '0', '0', '0', '1', '0', '1' };
//		char[] testArray2 = { '0', '0', '0', '0', '0', '1', '1' };
		int sumOfAdaptation = 0;

//		System.out.println(GenerateRealRandom.random.length);
//		int count = 0;
//		for (String string : GenerateRealRandom.random) {
//			System.out.println(count + ": " + string);
//			count++;
//		}
//
//		// System.out.print(testFile[0].replaceAll("\\r", ""));
//		// System.out.println("test");
//		// int test = Integer.parseInt("123 ".replaceAll("\\n", ""));
//		// System.out.println(test);
//		for (int i = 0; i < 10; i++) {
//			System.out.println(GenerateRealRandom.generate0to127Random());
//		}

		List<Individual> startingPopulation = new ArrayList<Individual>();
		startingPopulation.add(new Individual(GenerateRealRandom.generate0to127Random()));
		startingPopulation.add(new Individual(GenerateRealRandom.generate0to127Random()));
		startingPopulation.add(new Individual(GenerateRealRandom.generate0to127Random()));
		startingPopulation.add(new Individual(GenerateRealRandom.generate0to127Random()));
		startingPopulation.add(new Individual(GenerateRealRandom.generate0to127Random()));
		startingPopulation.add(new Individual(GenerateRealRandom.generate0to127Random()));
		startingPopulation.add(new Individual(GenerateRealRandom.generate0to127Random()));
		startingPopulation.add(new Individual(GenerateRealRandom.generate0to127Random()));

		for (Individual individual : startingPopulation) {
			sumOfAdaptation += individual.valueOfAdaptation;
		}

		for (Individual individual : startingPopulation) {
			individual.setPercentOnRoulette(((double) individual.valueOfAdaptation / sumOfAdaptation) * 100);
		}

		System.out.println("######### GENERATION 0 #########");
		System.out.println();
		for (Individual individual : startingPopulation) {
			System.out.println(individual.toString());
			System.out.println();
		}
		System.out.println("######### GENERATION 0 #########");

		List<Individual> currentPopulation = new ArrayList<Individual>(startingPopulation);

		int generationNumber = 1;
		do {

			currentPopulation = new ArrayList<Individual>(Selection.makeSelection(currentPopulation));
			
			for (Individual individual : startingPopulation) {
				sumOfAdaptation += individual.valueOfAdaptation;
			}
			
			for (Individual individual : currentPopulation) {
				individual.setPercentOnRoulette(((double) individual.valueOfAdaptation / sumOfAdaptation) * 100);
			}
//			List<Individual> tmpCurrentPopulation = new ArrayList<Individual>();
//			for (int i = 0; i < (currentPopulation.size() - 1); i+=2) {
//				if (Selection.isCrossing()) {
//					
//					Individual[] tmpIndiv = currentPopulation.get(i).crossWith(currentPopulation.get(i+1));
//					tmpCurrentPopulation.add(tmpIndiv[0]);
//					tmpCurrentPopulation.add(tmpIndiv[1]);
//					
//				}else{
//					tmpCurrentPopulation.add(new Individual(currentPopulation.get(i).chromosom.chromosomAsCharArray));
//					tmpCurrentPopulation.add(new Individual(currentPopulation.get(i+1).chromosom.chromosomAsCharArray));
//				}
//			}
//
//			currentPopulation = new ArrayList<Individual>(tmpCurrentPopulation);
			System.out.println("######### GENERATION " + generationNumber + " #########");

			for (Individual individual : currentPopulation) {
				System.out.println(individual.toString());
				System.out.println();
			}

			System.out.println("######### GENERATION " + generationNumber + " #########");
			generationNumber++;
		} while (generationNumber != 4);

	}

}
