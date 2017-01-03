package mainModule;

import java.util.ArrayList;
import java.util.List;

public class Selection {

	public static List<Individual> makeSelection(List<Individual> population) {

		List<Individual> newPopulation = new ArrayList<Individual>();
		double[] range = setRanges(population);
		do {
			double random = 0;

			if (random > range[0] && random < range[1]) {

			} else if (random >= range[0] && random <= range[1]) {
				newPopulation.add(new Individual(population.get(0).chromosom.chromosomAsCharArray));

			} else if (random > range[1] && random <= range[2]) {
				newPopulation.add(new Individual(population.get(1).chromosom.chromosomAsCharArray));

			} else if (random > range[2] && random <= range[3]) {
				newPopulation.add(new Individual(population.get(2).chromosom.chromosomAsCharArray));

			} else if (random > range[3] && random <= range[4]) {
				newPopulation.add(new Individual(population.get(3).chromosom.chromosomAsCharArray));

			} else if (random > range[4] && random <= range[5]) {
				newPopulation.add(new Individual(population.get(4).chromosom.chromosomAsCharArray));

			} else if (random > range[5] && random <= range[6]) {
				newPopulation.add(new Individual(population.get(5).chromosom.chromosomAsCharArray));

			} else if (random > range[6] && random <= range[7]) {
				newPopulation.add(new Individual(population.get(6).chromosom.chromosomAsCharArray));

			} else if (random > range[7] && random <= range[8]) {
				newPopulation.add(new Individual(population.get(7).chromosom.chromosomAsCharArray));

			}

		} while (newPopulation.size() < 8);

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

}
