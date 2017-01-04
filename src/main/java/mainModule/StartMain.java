package mainModule;

import java.util.ArrayList;
import java.util.List;

import random.GenerateRealRandom;

public class StartMain {

	public static void main(String[] args) {

		int sumOfAdaptation = 0;
		double avarageOfAdaptationInPopulation = 0;
		int indexOfChromosom = 1;

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
			System.out.println("## Chromosom number " + indexOfChromosom++ + " ##");
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

			System.out.println("\n#### CROSSING PHASE ####");
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

			System.out.println("\n#### MUTATION PHASE ####");
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

			indexOfChromosom = 1;
			for (Individual individual : currentPopulation) {
				System.out.println("## Chromosom number " + indexOfChromosom++ + " ##");
				System.out.println(individual.toString());
				System.out.println();
			}

			System.out.println("######### END OF GENERATION " + generationNumber + " #########\n");
			generationNumber++;

			for (Individual individual : currentPopulation) {
				avarageOfAdaptationInPopulation += individual.valueOfAdaptation;
			}

			avarageOfAdaptationInPopulation = avarageOfAdaptationInPopulation / 8.00;

			if (avarageOfAdaptationInPopulation > 30531 && Selection.minNumberInPopulation(currentPopulation) > 120) {
				break;
			}
		} while (true);
		System.out.println("Smallest chromosom in population: "+Selection.minNumberInPopulation(currentPopulation));
		System.out.println("Avarage value of adapation in population: "+avarageOfAdaptationInPopulation);
	}

}
