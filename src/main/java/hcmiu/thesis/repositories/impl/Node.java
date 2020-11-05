package hcmiu.thesis.repositories.impl;

public class Node {
    public int freq;
    public String word;
    public Node previuos;
    public String name;
    public String token1,token2;

    public Node(String word, int freq) {
        this.word = word;
        this.freq = freq;
        this.name = word;
    }

    public Node(String val1, String val2, int freq){
        this.token1 = val1;
        this.token2 = val2;
        this.freq = freq;
        this.name = val1 + "," + val2;
    }

    public void setfreq(int freq) {
        this.freq = freq;
    }

    public void setword(String word) {
        this.word = word;
    }

    public int getFreq() {
        return this.freq;
    }

    public String getWord() {
        return this.word.replace("[","").replace("]","");
    }

    public String getWord(int index){
        String result;
        if (index==1){
            result = this.token1;
        } else result = this.token2;
        return result;
    }

    public boolean containsword(String word){
        return this.word == word;
    }

    public void print() {
        System.out.println("freq: " + this.getFreq() + " word: " + this.getWord());
    }

	public String getName() {
        return this.name;
	}
}