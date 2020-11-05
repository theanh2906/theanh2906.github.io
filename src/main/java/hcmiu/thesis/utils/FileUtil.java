package hcmiu.thesis.utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class FileUtil  {
	
	public static ArrayList<String> readFileAsList (File file) {
		ArrayList<String> list = new ArrayList<>();
		try (FileReader f = new FileReader(file)){
			StringBuffer sb = new StringBuffer();
			while (f.ready()) {
				char c = (char) f.read();
				if (c == '\n') {
					list.add(sb.toString());
					sb = new StringBuffer();
				} else sb.append(c);
			    if (sb.length() > 0) {
			        list.add(sb.toString());
			    }
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
    public void toFile(String text) throws IOException {
        // Scanner scan = new Scanner(new File("./ngram.txt"));
        File output = new File("./ngram.txt");
        if (output.exists()) {
        	output.delete();
            FileWriter write = new FileWriter("./ngram.txt");
            write.write(text);
            write.close();
        } else {
            FileWriter write = new FileWriter("./ngram.txt");
            write.write(text);
            write.close();
        }

    }

	
	public static String readFile(File file) throws IOException {
		String text = "";
		Scanner scan = new Scanner(file);
		while(scan.hasNextLine()) {
			text += scan.nextLine()+"\n";
		}
		return text;
	}
	
}
