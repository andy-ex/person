package com.test;

import java.io.*;

public class ManipulateDataApplication {

	public static void main(String[] args) throws IOException {
		File file = new File("manipulate-data.txt");
		System.out.println(file.getName() + " file exists = " + file.exists());

		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			helpfulMethodFeelFreeToDeleteOrUseElsewhere(line);
		}
		bufferedReader.close();
	}

	private static void helpfulMethodFeelFreeToDeleteOrUseElsewhere(String line) {
		String[] columns = line.split(",");
		for (String column : columns) {
			System.out.print(column);
		}
	}
}