package main.java.util;

import java.io.File;
import java.io.IOException;

public class FileUtils {

	public static File getFile(String path) throws IOException {
		File file = new File(path);
		if (!file.exists()) {
			file.createNewFile();
		}
		return file;
	}
}
