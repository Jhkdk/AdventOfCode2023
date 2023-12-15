import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day09 {
	public static void main(String[] args) throws FileNotFoundException {
		System.out
				.println(problem1("C:\\Users\\cnielson6\\Downloads\\eclipse-workspace\\AdventOfCode\\src\\words.txt"));
	}

	// @param filepath to file of digits
	// @return sum of the next digits in all patterns provided from file.
	private static int problem1(String filepath) throws FileNotFoundException {
		int fin = 0;
		Scanner scan = new Scanner(new File(filepath));
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		while (scan.hasNext()) {
			arr.add(toArrayList(scan.nextLine()));
		}
		for (ArrayList<Integer> arrayList : arr) {
			fin += getPrev(arrayList);
		}
		return fin;
	}

	private static ArrayList<Integer> moveElementsForward(ArrayList<Integer> arrayList) {
		int temp = arrayList.get(0);
		int temp2 = 0;
		final int size = arrayList.size() + 1;
		for (int i = 0; i < size; i++) {
			try {
				temp = arrayList.get(i);
				arrayList.set(i, temp2);
			} catch (IndexOutOfBoundsException e) {
				arrayList.add(temp2);
			}
			temp2 = temp;
		}
		return arrayList;
	}

	// @param arrayList
	// @return next in pattern
	private static int getNext(ArrayList<Integer> arrayList) {
		ArrayList<ArrayList<Integer>> change = getAllPattern(arrayList);
		for (int i = change.size() - 2; i >= 0; i--) {
			change.set(i, addNext(change.get(i), change.get(i + 1)));
		}
		return change.get(0).get(change.get(0).size() - 1);
	}

	// @param arrayList
	// @return element before first element in list
	private static int getPrev(ArrayList<Integer> arrayList) {
		ArrayList<ArrayList<Integer>> change = getAllPattern(arrayList);
		for (int i = change.size() - 2; i >= 0; i--) {
			change.set(i, addPrev(change.get(i), change.get(i + 1)));
		}
		return change.get(0).get(0);
	}

	// @param pattern, pattern by which next entry in change is calculated
	// @param change, arraylist of pattern
	// @return change with first number as the first entry
	private static ArrayList<Integer> addPrev(ArrayList<Integer> change, final ArrayList<Integer> pattern) {
		change = moveElementsForward(change);
		change.set(0, change.get(1) - pattern.get(0));
		System.out.println("change = " + change);
		return change;
	}

	// @param pattern, pattern by which next entry in change is calculated
	// @param change, arraylist of pattern
	// @return change with next number as the last entry
	private static ArrayList<Integer> addNext(ArrayList<Integer> change, final ArrayList<Integer> pattern) {
		change.add(change.get(change.size() - 1) + pattern.get(pattern.size() - 1));
		return change;
	}

	// @param string of digits
	// @return Arraylist of integers
	private static ArrayList<Integer> toArrayList(String string) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (String car : string.split(" ")) {
			temp.add(Integer.parseInt(car));
		}
		return temp;
	}

	// @param arrayList of items
	// @return calculates average change through arr
	public static ArrayList<Integer> pattern(ArrayList<Integer> arr) {
		int prev = arr.get(0);
		ArrayList<Integer> change = new ArrayList<Integer>();
		for (int i = 1; i < arr.size(); i++) {
			change.add(arr.get(i) - prev);
			prev = arr.get(i);
		}
		return change;
	}

	// @param arrayList of base pattern
	// @return Arraylist of arraylists of pattern to 0 change
	public static ArrayList<ArrayList<Integer>> getAllPattern(ArrayList<Integer> change) {
		ArrayList<ArrayList<Integer>> currentList = new ArrayList<>();
		currentList.add(change);
		int index = 1;
		while (!isDone(currentList.get(index - 1))) {
			currentList.add(pattern(currentList.get(index - 1)));
			index++;
		}
		return currentList;
	}

	// @param takes in arraylist of pattern
	// @return returns if has anything other than 0
	private static boolean isDone(ArrayList<Integer> change) {
		Set<Integer> set = new HashSet<>(change);
		String str = set.toString().substring(1, set.toString().length() - 1).replaceAll("[, ]", "");
		return str.matches("[0[,]]");
	}
}
