package hcmiu.thesis.repositories.impl;

import java.io.*;
import java.util.*;

import org.springframework.core.io.ClassPathResource;

import hcmiu.thesis.utils.FileUtil;
import opennlp.tools.ngram.NGramModel;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.util.StringList;

public class NGram {
	ClassPathResource stopwordFile = new ClassPathResource("stopwords.txt");
	ClassPathResource modelFile = new ClassPathResource("/models/en-sent.bin");
    public NGramModel model;
    public String[] sentences;
    public String text;
    public Map<String, Integer> map = new HashMap<String, Integer>();
    public List<Node> list;
    public List<String> sorted;
    public String test = "";

    /**
     * This method is to break the whole document into set of token (words)
     * In this step, it is necessary to remove all punctuation by using replaceAll()
     * @param text is the input text from the text area in View
     * @return the list of word defined in StringList in OpenNLP
     */
    public StringList tokenize(String text) {
    	this.test = text.replaceAll("\\p{Punct}", "");
    	StringList list = new StringList(SimpleTokenizer.INSTANCE.tokenize(this.test));
    	return list;
    }
    
    /**
     * This method is to generate NGram model for doing counting frequency of each token
     * @param list is the return of the tokenize() step above
     * @param min is the minimum number of ngram
     * @param max is the maximum of ngram
     */
    public void generate(StringList list, int min, int max) {
        this.model = new NGramModel();
        this.model.add(list, min, max);
    }

    public void generate(StringList list, int num) {
        this.model = new NGramModel();
        this.model.add(list, num, num);
    }

    public void print() {
        System.out.println("Total ngrams: " + this.model.numberOfGrams());
        for (StringList ngram : this.model) {
            System.out.println(this.model.getCount(ngram) + " - " + ngram);
        }
    }

    /**
     * This method is to sort the tokens based on its frequency in descending order
     */
    public void sort() {

        Collections.sort(this.list, new Sort());
        this.sorted = new ArrayList<String>();
        for (Node node : this.list) {
            this.sorted.add(node.getWord().replace("[", "").replace("]", ""));
        }

    }

    public void printList() {
        for (Node node : this.list) {
            System.out.println(node.getFreq() + " - " + node.getWord());
        }
    }
    
    /**
     * This method is to remove all stopwords identified by the stopword list
     * @throws IOException
     */
    public void filterStopWords() throws IOException {
    	File file = stopwordFile.getFile();
        this.list = new ArrayList<Node>();
        for (StringList gram : this.model) {
            this.list.add(new Node(gram.toString(),this.model.getCount(gram)));
        }
        List<String> stopwords = FileUtil.readFileAsList(file);
        
        for (String word : stopwords){
            for (int i = 0; i<this.list.size();i++){
                Node node = this.list.get(i);
                if (node.getWord().equals(word)){
                    this.list.remove(node);
                }
            }
        }
        }

    
    /**
     * This method is to break the whole text into list of sentences
     * @return the list of sentences 
     * @throws IOException
     */
    public void getSentenceUsingModel(String text) throws IOException {
        File modelfile = modelFile.getFile();
    	this.text = text.replaceAll("([A-Z])\\.", "$1");

        InputStream is = new FileInputStream(modelfile);
        SentenceModel model = new SentenceModel(is);

        SentenceDetectorME sd = new SentenceDetectorME(model);

        this.sentences = sd.sentDetect(this.text);
    }
    
    

    /**
     * This method is to search the presentation of the word in sentence
     * @param word
     * @return the sentence that match the word
     */
    public String search(String word) {
        String first_match_sentence = null;
        for (int i = 0; i < this.sentences.length; i++) {
            if (this.sentences[i].contains(word)) {
                first_match_sentence = this.sentences[i];
            }
        }
        return first_match_sentence;
    }
    
    /**
     * This method to count number of word which appear in sentence
     * @param word: got from sorted token list
     * @param sentence: got from list of sentences
     * @return the frequency of word in sentence
     */
    public int countWords(String word, String sentence){
        int count = 0;
        String[] words = sentence.split("\\s+");
        for (String i : words){
            if (word.equals(i)){
                count++;
                
            }
        }
        return count;
    }

}


