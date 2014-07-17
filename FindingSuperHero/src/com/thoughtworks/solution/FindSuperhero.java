package com.thoughtworks.solution;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.CopyOnWriteArrayList;

public class FindSuperhero {

	private HashSet<String> superheroesList = new HashSet<String>();
	private HashMap<Character, Character[]> map;

	public static void main(String[] args) {

		FindSuperhero object = new FindSuperhero();
		object.initSuperheroesList();
		object.initCharMap();
		long start = System.nanoTime();
		// Java statements

		object.getSuperHeroNames(new char[] { '4', '8', '5', '5', '3' });

		long diff = System.nanoTime() - start;

		System.out.println("Time Difference ::" + diff);

	}

	private HashSet<AppendChar> findSuperHeroList(char[] code) {

		// Find the initial objects set

		Character[] charst = map.get(code[0]);
		HashSet<AppendChar> objects = new HashSet<AppendChar>();
		for (int k = 0; k < charst.length; k++) {
			AppendChar appendChar = new AppendChar();
			appendChar.appendChar(charst[k]);
			objects.add(appendChar);
		}
		// /printList(objects);

		// /System.out.println("Initial Object Set ========== Done");

		HashSet<AppendChar> list = new HashSet<AppendChar>();
		for (int i = 1; i < code.length; i++) {
			Character[] charset = map.get(code[i]);

			for (int j = 0; j < charset.length; j++) {
				for (AppendChar ac : objects) {
					AppendChar ch = new AppendChar(ac);
					ch.appendChar(charset[j]);

					list.add(ch);
				}
			}
			objects.clear();
			objects = new HashSet<>(list);

			list.clear();

		}
		printList(objects);
		return objects;

	}

	private String getSuperHeroNames(char[] code) {
		HashSet<AppendChar> heroSet = findSuperHeroList(code);
		String superHeroNames = "";
		for (AppendChar heroName : heroSet) {
			if (superheroesList.contains(heroName.characterString)) {
				superHeroNames = superHeroNames + " " + heroName.characterString;
			}
		}
		System.out.print(superHeroNames + ":");
		return superHeroNames;
	}

	private void printList(Set<AppendChar> list) {
		for (AppendChar ch : list) {
			System.out.println(ch.characterString);
		}
	}

	private void initCharMap() {
		map = new HashMap<Character, Character[]>();
		map.put('1', new Character[] { '@', '.', '?' });
		map.put('2', new Character[] { 'A', 'B', 'C' });
		map.put('3', new Character[] { 'D', 'E', 'F' });
		map.put('4', new Character[] { 'G', 'H', 'I' });
		map.put('5', new Character[] { 'J', 'K', 'L' });
		map.put('6', new Character[] { 'M', 'N', 'O' });
		map.put('7', new Character[] { 'P', 'Q', 'R', 'S' });
		map.put('8', new Character[] { 'T', 'U', 'V' });
		map.put('9', new Character[] { 'W', 'X', 'Y', 'Z' });
	}

	private void initSuperheroesList() {
		superheroesList.add("SUPERMAN");
		superheroesList.add("THOR");
		superheroesList.add("ROBIN");
		superheroesList.add("IRONMAN");
		superheroesList.add("GHOSTRIDER");
		superheroesList.add("CAPTAINAMERICA");
		superheroesList.add("FLASH");
		superheroesList.add("BATMAN");
		superheroesList.add("HULK");
		superheroesList.add("BLADE");
		superheroesList.add("PHANTOM");
		superheroesList.add("SPIDERMAN");
		superheroesList.add("BLACKWIDOW");
		superheroesList.add("HELLBOY");
		superheroesList.add("PUNISHER");
	}
}
