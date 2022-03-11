package fr.epita.helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHelper {

	public boolean moveFile(String src, String dest) throws IOException {
		Path path=Files.move(Paths.get(src), Paths.get(dest));
		   if(path!=null) {
			   return true;
		   }else {
			   return false;
		   }
		
	}

}
