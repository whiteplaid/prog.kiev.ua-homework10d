package com.homework.asciiart;

import java.io.IOException;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		ascii ascii = new ascii();
		String text =JOptionPane.showInputDialog("Type in text");
		try {
		ascii.art(text);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
