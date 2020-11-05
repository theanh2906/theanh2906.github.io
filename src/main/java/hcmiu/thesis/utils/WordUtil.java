package hcmiu.thesis.utils;

import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.util.StringList;

public class WordUtil {
	public static int countWords (String text) {
		int total = 0;
		text = text.replaceAll("\\p{Punct}", "");
		StringList list = new StringList(SimpleTokenizer.INSTANCE.tokenize(text));
		total = list.size();
		return total;
	}
	
}
