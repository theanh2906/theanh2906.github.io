package hcmiu.thesis.repositories;

public interface SummarizationDao{
	String getSummary(String text, int sentenceNum);
	String getLSA (String text, int number);
	
}