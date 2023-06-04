package com.in28minutes.api.b;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReadWriteRunner {

	public static void main(String[] args) throws IOException {

		Path path = Paths.get("./resources/sample.txt");
		List<String> fileLines = Files.readAllLines(path);

		for (String line : fileLines) {
			System.out.println(line);
		}

		String newFileContent = "";
		for (String line : fileLines) {
			newFileContent += line.replace("Line", "Lines") + "\n";
		}

		Path newFilePath = Paths.get("./resources/sample-new.txt");
		Files.write(newFilePath, newFileContent.getBytes());

	}

}
