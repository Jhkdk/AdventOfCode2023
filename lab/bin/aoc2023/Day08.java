package aoc2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import misc.ThreadSteps;

public class Day08 {
	public static Set<ThreadSteps> threads = new HashSet<>();

	public static void main(String[] args) throws FileNotFoundException {
		long start = System.nanoTime();
		Map<String, String> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		Scanner scan = new Scanner(new File("C:\\Users\\colen\\eclipse-workspace\\aoc\\src\\words.txt"));
		String instructions = scan.nextLine();
		scan.nextLine();
		while (scan.hasNext()) {
			String temp = scan.nextLine();
			if (temp.split("=")[0].strip().endsWith("A")) {
				set.add(temp.split("=")[0].strip());
			}
			map.put(temp.split("=")[0].strip(),
					temp.split("=")[1].substring(2, temp.split("=")[1].length() - 1).replaceAll(",", ""));
		}
		System.out.println(lcm(step(instructions, map, set)));
		System.out.println((System.nanoTime() - start) / 1000000 + " ms");
	}

	public static ArrayList<Long> step(String directions, Map<String, String> map, Set<String> set) {
		ArrayList<Long> fin = new ArrayList<>();
		for (String temp : set) {
			threads.add(new ThreadSteps(map, directions, temp));
		}
		for (ThreadSteps threadSteps : threads) {
			threadSteps.start();
		}
		for (ThreadSteps threadSteps : threads) {
			while (threadSteps.isAlive()) {
			}
			fin.add(threadSteps.getSteps());
		}
		return fin;
	}

	private static long gcd(long a, long b) {
		while (b > 0) {
			long temp = b;
			b = a % b; // % is remainder
			a = temp;
		}
		return a;
	}

	private static long gcd(long[] input) {
		long result = input[0];
		for (int i = 1; i < input.length; i++)
			result = gcd(result, input[i]);
		return result;
	}

	private static long lcm(long a, long b) {
		return a * (b / gcd(a, b));
	}

	private static long lcm(ArrayList<Long> arrayList) {
		long result = arrayList.get(0);
		for (int i = 1; i < arrayList.size(); i++)
			result = lcm(result, arrayList.get(i));
		return result;
	}

	private static boolean done() {
		ArrayList<Boolean> arr = new ArrayList<>();
		for (ThreadSteps threadSteps : threads) {
			arr.add(threadSteps.getCurrent().endsWith("Z"));
		}
		if (arr.contains(true))
			System.out.println(arr.toString());
		return arr.contains(false) ? false : true;
	}

	private static void stepForward(String instu, Map<String, String> maper, Set<String> sat) {
		for (ThreadSteps threadSteps : threads) {
			System.out.println(threadSteps.getSteps());
			threadSteps.step(instu, maper);
		}
	}
}
