package mainModule;

import java.util.ArrayList;
import java.util.List;

import random.GenerateRealRandom;

public class Selection {

	public static List<Individual> makeSelection(List<Individual> population) {

		List<Individual> newPopulation = new ArrayList<Individual>();
		double[] range = setRanges(population);
		System.out.println("### Selected chromosoms as numbers ###");
		do {
			double random = GenerateRealRandom.generate0to100DoubleRandom();

			if (random > range[0] && random < range[1]) {

			} else if (random >= range[0] && random <= range[1]) {
				System.out.println("Has been selected: " + population.get(0).chromosom.chromosomAsNumber);
				newPopulation.add(new Individual(population.get(0).chromosom.chromosomAsCharArray));

			} else if (random > range[1] && random <= range[2]) {
				System.out.println("Has been selected: " + population.get(1).chromosom.chromosomAsNumber);
				newPopulation.add(new Individual(population.get(1).chromosom.chromosomAsCharArray));

			} else if (random > range[2] && random <= range[3]) {
				System.out.println("Has been selected: " + population.get(2).chromosom.chromosomAsNumber);
				newPopulation.add(new Individual(population.get(2).chromosom.chromosomAsCharArray));

			} else if (random > range[3] && random <= range[4]) {
				System.out.println("Has been selected: " + population.get(3).chromosom.chromosomAsNumber);
				newPopulation.add(new Individual(population.get(3).chromosom.chromosomAsCharArray));

			} else if (random > range[4] && random <= range[5]) {
				System.out.println("Has been selected: " + population.get(4).chromosom.chromosomAsNumber);
				newPopulation.add(new Individual(population.get(4).chromosom.chromosomAsCharArray));

			} else if (random > range[5] && random <= range[6]) {
				System.out.println("Has been selected: " + population.get(5).chromosom.chromosomAsNumber);
				newPopulation.add(new Individual(population.get(5).chromosom.chromosomAsCharArray));

			} else if (random > range[6] && random <= range[7]) {
				System.out.println("Has been selected: " + population.get(6).chromosom.chromosomAsNumber);
				newPopulation.add(new Individual(population.get(6).chromosom.chromosomAsCharArray));

			} else if (random > range[7] && random <= range[8]) {
				System.out.println("Has been selected: " + population.get(7).chromosom.chromosomAsNumber);
				newPopulation.add(new Individual(population.get(7).chromosom.chromosomAsCharArray));

			}

		} while (newPopulation.size() < population.size());

		return newPopulation;
	}

	private static double[] setRanges(List<Individual> population) {

		final int amountOfIndividualInPopulation = 9;

		double[] ranges = new double[amountOfIndividualInPopulation];
		ranges[0] = 0;
		ranges[1] = population.get(0).percentOnRoulette;
		ranges[2] = ranges[1] + population.get(1).percentOnRoulette;
		ranges[3] = ranges[2] + population.get(2).percentOnRoulette;
		ranges[4] = ranges[3] + population.get(3).percentOnRoulette;
		ranges[5] = ranges[4] + population.get(4).percentOnRoulette;
		ranges[6] = ranges[5] + population.get(5).percentOnRoulette;
		ranges[7] = ranges[6] + population.get(6).percentOnRoulette;
		ranges[8] = ranges[7] + population.get(7).percentOnRoulette;

		return ranges;
	}

	public static boolean isMutation() {

		int isMutation = GenerateRealRandom.generate0to100Random();
		System.out.println("Random value to get mutation is: "+ isMutation);
		if (isMutation > 0 && isMutation < 15) {
			System.out.println("There is mutation!!!");
			return true;
		} else {
			return false;
		}
	}

	public static boolean isCrossing() {

		int isCrossing = GenerateRealRandom.generate0to100Random();
		System.out.println("Random value to get crossing is: "+isCrossing);
		if (isCrossing > 0 && isCrossing < 75) {
			System.out.println("There is crossing!!!");
			return true;
		} else {
			return false;
		}
	}

	public static int minNumberInPopulation(List<Individual> population) {
		int[] arrayOfPopulation = new int[population.size()];
		for (int i = 0; i < population.size(); i++) {
			arrayOfPopulation[i] = population.get(i).chromosom.chromosomAsNumber;
		}

		int min = 128;
		int index = 0;
		for (int i = 0; i < arrayOfPopulation.length; i++)
			if (arrayOfPopulation[i] < min) {
				min = arrayOfPopulation[i];
				index = i;
			}
		return arrayOfPopulation[index];
	}
	
	public static int maxNumberInPopulation(List<Individual> population) {
		int[] arrayOfPopulation = new int[population.size()];
		for (int i = 0; i < population.size(); i++) {
			arrayOfPopulation[i] = population.get(i).chromosom.chromosomAsNumber;
		}

		int max = -1;
		int index = 0;
		for (int i = 0; i < arrayOfPopulation.length; i++)
			if (arrayOfPopulation[i] > max) {
				max = arrayOfPopulation[i];
				index = i;
			}
		return arrayOfPopulation[index];
	}

}
