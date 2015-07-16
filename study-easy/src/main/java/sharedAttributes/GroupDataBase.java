package sharedAttributes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;

public class GroupDataBase {
	
	/*public static void copyFile(String sourcePath, String destPath) throws Exception{
	
		Path source = Paths.get(sourcePath);
		Path destination = Paths.get(destPath);
		try {
			Files.copy(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}*/
	
	public static void copyFile(/*File sourceFile, File destFile*/) throws IOException {
		//if(!destFile.exists()){
		//	destFile.createNewFile();
		
	
		JFileChooser chooser = new JFileChooser();				
		int sourceFile = chooser.showOpenDialog(null);
		int destFile = chooser.showSaveDialog(null);
		}
		
		/*FileChannel source = null;
		FileChannel destination = null;
			try {
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			
			long count = 0;
			long size = source.size();
			while((count += destination.transferFrom(source, count, size-count))<size);
		}
		finally {
			if(source != null) {
				source.close();
			}
			if(destination != null) {
				destination.close();
			}
		}
		
	}*/

}
