package hcmiu.thesis.repositories.impl;

import java.io.*;
import java.util.*;

import opennlp.tools.util.StringList;

public class Summarizer {
	public static String summarize(String text, int maxSummarySize) throws IOException {
        NGram ngram = new NGram();
        StringList words = ngram.tokenize(text);
        ngram.generate(words, 1);
        ngram.filterStopWords();
        ngram.sort();
        ngram.getSentenceUsingModel(text);
        String firstSentence = ngram.sentences[0];
        List<String> setSummarySentences = new ArrayList<String>();
        setSummarySentences.add(firstSentence);
        // foreach string in the sorted list
        for (int i = 0; i < ngram.sorted.size(); i++)
        {
            String first_matching_sentence = ngram.search(ngram.sorted.get(i));
            if (!setSummarySentences.contains(first_matching_sentence)){
                // add to summary list
            	setSummarySentences.add(first_matching_sentence);
            }

            if (setSummarySentences.size() == maxSummarySize) {
                break;
            }
        }

        // construct the summary size out of select sentences
        String summary = "";
		// foreach string sentence in sentences
        for (String sentence : ngram.sentences)
        {
            if (setSummarySentences.contains(sentence)) {
                // produce each sentence with a bullet point and good amounts of spacing
                summary = summary + sentence + System.getProperty("line.separator");
            }
        }
        return summary;
    }

}