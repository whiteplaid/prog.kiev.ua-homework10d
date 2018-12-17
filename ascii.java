package com.homework.asciiart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ascii {
	private Map<Character,List<String>> ascii = new HashMap<>();
	private File folder = new File("c:\\Users\\white\\eclipse-workspace\\prog.kiev.ua\\src\\com\\homework\\asciiart\\alphabet\\");

	public ascii(Map<Character, List<String>> ascii, File folder) {
		super();
		this.ascii = ascii;
		this.folder = folder;
	}

	public ascii() {
		super();
	}

	private void construct() throws FileNotFoundException, IOException {

		for (File name : folder.listFiles()) {
			List<String> upper = new ArrayList<>();
			List<String> lower = new ArrayList<>();
			String letter = name.getName().substring(0, 1);
			try (BufferedReader buf = new BufferedReader(new FileReader(name))) {
				for (int i = 0; i < 13; i++) {
					if (i < 6) {
					upper.add(buf.readLine());
					} else {
						lower.add(buf.readLine());
					}
				}
			}
			ascii.put(letter.charAt(0), upper);
			ascii.put(letter.toLowerCase().charAt(0), lower);
		}
	}
	
	public void art (String text) throws FileNotFoundException, IOException {
		construct();
		for(Character character : text.toCharArray()) {
			if (ascii.containsKey(character)) {
				ascii.get(character).stream().forEach(System.out::println);
				System.out.print(" ");
			}
		}
	}
}
