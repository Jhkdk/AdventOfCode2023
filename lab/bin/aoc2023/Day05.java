package lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class aocDay_5 {
	static Map<Long, Long> map = new HashMap<>();
	static ArrayList<Long> seeds = new ArrayList<>();

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("C:\\Users\\cnielson6\\Downloads\\eclipse-workspace\\lab\\src\\words.txt"));
		String seeders = scan.nextLine();
		for (String string : seeders.split(" ")) {
			try {
				seeds.add(Long.parseLong(string));
			} catch (NumberFormatException e) {
			}
		}
		seeds = nextBlock(scan);
		System.out.println("Seed:\t\t" + seeds.toString());
		seeds = nextBlock(scan);
		System.out.println("soil:\t\t" + seeds.toString());
		seeds = nextBlock(scan);
		System.out.println("fertilizer:\t" + seeds.toString());
		seeds = nextBlock(scan);
		System.out.println("water:\t\t" + seeds.toString());
		seeds = nextBlock(scan);
		System.out.println("light:\t\t" + seeds.toString());
		seeds = nextBlock(scan);
		System.out.println("temprature:\t" + seeds.toString());
		seeds = nextBlock(scan);
		System.out.println("humidity:\t" + seeds.toString());
		seeds = nextBlock(scan);
		System.out.println("location:\t" + seeds.toString());
	}

	private static ArrayList<Long> nextBlock(Scanner scan) {
		seperate(scan);
		return seedMin(seeds);
	}
	//uses the map to convert seeds into next line
	private static ArrayList<Long> seedMin(ArrayList<Long> seeds2) {
		ArrayList<Long> arr = new ArrayList<>();
		for (Long long1 : seeds2) {
			arr.add(map.getOrDefault(long1,long1));
		}
		return arr;
	}
	//seperates the lines and feeds them into split input which feed them into mapvalues
	private static void seperate(Scanner scan) {
		while (scan.hasNext()) {
			String input = scan.nextLine();
			if (input.isEmpty()) {
				break;
			} else if (input.matches(".*\\d.*")) {
				splitInput(input);
			}
		}
	}

	// splits almanac entry into parts and feeds those parts into addMap
	public static void splitInput(String str) {
		addMap(Long.parseLong(str.split(" ")[0]), Long.parseLong(str.split(" ")[1]), Long.parseLong(str.split(" ")[2]));
	}

	// uses parts from splitInput and puts into map with rangeLength difference
	public static void addMap(long destinationRange, long sourceRange, long rangeLength) {
		long j = destinationRange;
		for (long i = sourceRange; i <= rangeLength + sourceRange - 1; i++) {
			map.put(i, j);
			j++;
		}
	}
}
