package aoc2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

class aocDay_4 {
	public static void main(String[] args) throws FileNotFoundException {
		int fin = 0;

		Scanner scan;
		String line;
		for (scan = new Scanner(
				new File("C:\\Users\\cnielson6\\Downloads\\eclipse-workspace\\lab\\src\\words.txt")); scan
						.hasNextLine(); fin += getPoints(line)) {
			line = scan.nextLine();
		}

		System.out.println(fin);
		scan.close();
	}

	public static int getPoints(String line) {
		return compare(toIntArrayList(split(line)[1].strip()), getSet(toIntArrayList(split(line)[2].strip())));
	}

	public static int getVal(int times) {
		if (times < 1) {
			return 0;
		} else {
			int fin = 1;

			for (int i = 0; i < times - 1; ++i) {
				fin *= 2;
			}

			return fin;
		}
	}

	public static int compare(ArrayList<Integer> list, Set<Integer> set) {
		int fin = 0;
		Iterator var4 = list.iterator();

		while (var4.hasNext()) {
			Integer integer = (Integer) var4.next();
			if (set.contains(integer)) {
				++fin;
			}
		}

		return fin;
	}

	public static ArrayList<Integer> toIntArrayList(String str) {
		ArrayList<Integer> list = new ArrayList();
		String[] var5;
		int var4 = (var5 = str.replace("  ", " ").split(" ")).length;

		for (int var3 = 0; var3 < var4; ++var3) {
			String string = var5[var3];
			list.add(Integer.parseInt(string));
		}

		return list;
	}

	private static Set<Integer> getSet(ArrayList<Integer> arr) {
		Set<Integer> set = new HashSet();
		set.addAll(arr);
		return set;
	}

	public static String[] split(String str) {
		String[] arr = str.split("[:|]");
		return arr;
	}
}