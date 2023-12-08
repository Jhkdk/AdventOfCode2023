package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hand {
	private String hand = new String();
	private String type = new String();
	ArrayList<Character> strenght = new ArrayList<>();
	private Map<Character, Integer> numOfOccur = new HashMap<>();

	public Hand(String values) {
		setHand(values);
	}

	public String getHand() {
		return hand;
	}

	public void setHand(String hand) {
		this.hand = hand;
		type = findType();
		fillMap();
	}

	private String findType() {
		return null;
	}

	public String getType() {
		return type;
	}

	private void fillMap() {
		for (Character char1 : getHand().toCharArray()) {
			System.out.println(numOfOccur);
			numOfOccur.put(char1, numOfOccur.getOrDefault(char1, 0)+1);
		}
		System.out.println(numOfOccur);
	}
}
