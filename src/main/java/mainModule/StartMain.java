package mainModule;

import java.util.ArrayList;
import java.util.List;

import random.GenerateRealRandom;

public class StartMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// char[] testArray = { '0', '0', '0', '0', '1', '0', '1' };
		// char[] testArray2 = { '0', '0', '0', '0', '0', '1', '1' };
		int sumOfAdaptation = 0;
		double avarageOfAdaptationInPopulation = 0;

		// System.out.println(GenerateRealRandom.random.length);
		// int count = 0;
		// for (String string : GenerateRealRandom.random) {
		// System.out.println(count + ": " + string);
		// count++;
		// }
		//
		// // System.out.print(testFile[0].replaceAll("\\r", ""));
		// // System.out.println("test");
		// // int test = Integer.parseInt("123 ".replaceAll("\\n", ""));
		// // System.out.println(test);
		// for (int i = 0; i < 10; i++) {
		// System.out.println(GenerateRealRandom.generate0to127Random());
		// }

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

		System.out.println("######### START OF GENERATION 0 #########");
		System.out.println();
		for (Individual individual : startingPopulation) {
			System.out.println(individual.toString());
			System.out.println();
		}
		System.out.println("######### END OF GENERATION 0 #########\n");

		List<Individual> currentPopulation = new ArrayList<Individual>(startingPopulation);

		int generationNumber = 1;
		do {

			sumOfAdaptation = 0;

			System.out.println("#### SELECTION PHASE ####");
			currentPopulation = new ArrayList<Individual>(Selection.makeSelection(currentPopulation));
			System.out.println("#### END OF SELECTION PHASE ####");

			System.out.println("#### CROSSING PHASE ####");
			List<Individual> tmpCurrentPopulation = new ArrayList<Individual>();
			for (int i = 0; i < (currentPopulation.size() - 1); i += 2) {
				if (Selection.isCrossing()) {

					Individual[] tmpIndiv = currentPopulation.get(i).crossWith(currentPopulation.get(i + 1));
					tmpCurrentPopulation.add(tmpIndiv[0]);
					tmpCurrentPopulation.add(tmpIndiv[1]);

				} else {
					tmpCurrentPopulation.add(new Individual(currentPopulation.get(i).chromosom.chromosomAsCharArray));
					tmpCurrentPopulation
							.add(new Individual(currentPopulation.get(i + 1).chromosom.chromosomAsCharArray));
				}
			}
			System.out.println("#### END OF CROSSING PHASE ####");

			currentPopulation = new ArrayList<Individual>(tmpCurrentPopulation);

			System.out.println("#### MUTATION PHASE ####");
			if (Selection.isMutation()) {
				int index = GenerateRealRandom.generate0to7Random();
				Individual tmpIndiv = currentPopulation.get(index).mutate(GenerateRealRandom.generate0to6Random());

				currentPopulation.remove(index);
				currentPopulation.add(tmpIndiv);
			}
			System.out.println("#### END OF MUTATION PHASE ####");

			for (Individual individual : currentPopulation) {
				sumOfAdaptation += individual.valueOfAdaptation;
			}

			for (Individual individual : currentPopulation) {
				individual.setPercentOnRoulette(((double) individual.valueOfAdaptation / sumOfAdaptation) * 100);
			}

			System.out.println("\n######### START OF GENERATION " + generationNumber + " #########\n");

			for (Individual individual : currentPopulation) {
				System.out.println(individual.toString());
				System.out.println();
			}

			System.out.println("######### END OF GENERATION " + generationNumber + " #########\n");
			generationNumber++;

			for (Individual individual : currentPopulation) {
				avarageOfAdaptationInPopulation += individual.valueOfAdaptation;
			}

			avarageOfAdaptationInPopulation = avarageOfAdaptationInPopulation / 8.00;
			System.out.println(Selection.minNumberInPopulation(currentPopulation));
			System.out.println("Before while");
			System.out.println(avarageOfAdaptationInPopulation);

		} while (avarageOfAdaptationInPopulation < 30531 || Selection.minNumberInPopulation(currentPopulation) < 120);
		System.out.println("After while");
	}

}
