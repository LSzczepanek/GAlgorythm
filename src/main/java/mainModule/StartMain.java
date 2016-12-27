package mainModule;

import java.util.ArrayList;
import java.util.List;

import random.GenerateRealRandom;

public class StartMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		char[] testArray = {'0','0','0','0','1','0','1'};
		char[] testArray2 = {'0','0','0','0','0','1','1'};

		System.out.println(GenerateRealRandom.random.length);
		int count = 0;
		for (String string : GenerateRealRandom.random) {
			System.out.println(count + ": " + string);
			count++;
		}

		// System.out.print(testFile[0].replaceAll("\\r", ""));
		// System.out.println("test");
		// int test = Integer.parseInt("123 ".replaceAll("\\n", ""));
		// System.out.println(test);
		for (int i = 0; i < 10; i++) {
			System.out.println(GenerateRealRandom.generate0to127Random());
		}

		List<Individual> startingPopulation = new ArrayList<Individual>();
		startingPopulation.add(new Individual(GenerateRealRandom.generate0to127Random()));
		startingPopulation.add(new Individual(GenerateRealRandom.generate0to127Random()));
		startingPopulation.add(new Individual(GenerateRealRandom.generate0to127Random()));
		startingPopulation.add(new Individual(GenerateRealRandom.generate0to127Random()));
		startingPopulation.add(new Individual(GenerateRealRandom.generate0to127Random()));
		startingPopulation.add(new Individual(GenerateRealRandom.generate0to127Random()));
		startingPopulation.add(new Individual(GenerateRealRandom.generate0to127Random()));
		startingPopulation.add(new Individual(GenerateRealRandom.generate0to127Random()));
		
		System.out.println("###POPULATION###");
		for (Individual individual : startingPopulation) {
			System.out.println(individual.toString());
		}
		
		List<Individual> currentPopulation = new ArrayList<Individual>(startingPopulation);
		
		do{
			
			
		}while(0==1);
		
		System.out.println("###POPULATION###");
		
		System.out.println(Integer.toBinaryString(6));
		System.out.println(Integer.parseInt(Integer.toBinaryString(6), 2));

		Individual firstOne = new Individual(GenerateRealRandom.generate0to127Random());

		System.out.println(firstOne.toString());

		Individual secondOne = new Individual(firstOne.chromosom.chromosomAsCharArray);
		System.out.println();
		System.out.println(secondOne.toString());
		
		Individual thirdOne = new Individual((byte) 5);
		System.out.println();
		System.out.println(thirdOne.toString());
		Individual fourthOne = new Individual((byte) 20);
		System.out.println();
		System.out.println(fourthOne.toString());
		
		
		Individual[] testCross = thirdOne.crossWith(fourthOne);
		
		for (Individual individual : testCross) {
			System.out.println(individual);
		}

		System.out.println();
		Individual mutated = thirdOne.mutate(GenerateRealRandom.generate0to6Random());
		System.out.println(mutated.toString());
	}

}
