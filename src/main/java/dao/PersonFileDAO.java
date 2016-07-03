package main.java.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import main.java.util.FileUtils;

public class PersonFileDAO {
	private static File storage;

	public static void add(String personToString) throws FileNotFoundException, IOException {
		storage = FileUtils.getFile("persons.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(storage));
		try {
			writer.write(personToString);
		} finally {
			writer.close();
		}
	}

	public static String get(String login, String password) throws FileNotFoundException, IOException {
		StringBuffer sb = new StringBuffer();

		BufferedReader reader = new BufferedReader(new FileReader(storage));
		try {
			String s;
			while ((s = reader.readLine()) != null) {
				if (s.contains(login) && s.contains(password)) {
					sb.append(s);
					break;
				}
			}
		} finally {
			reader.close();
		}

		return sb.toString();
	}

	public static boolean delete(String deletedString) throws FileNotFoundException, IOException {
		File tempFile = FileUtils.getFile("tempFile");

		BufferedReader reader = new BufferedReader(new FileReader(storage));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		boolean isSuccessful;
		try {
			String s;
			while ((s = reader.readLine()) != null) {
				if (!s.contains(deletedString)) {
					writer.write(s + "\n");
				}
			}
			isSuccessful = tempFile.renameTo(storage);
		} finally {
			reader.close();
			writer.close();
		}

		return isSuccessful;
	}

}
