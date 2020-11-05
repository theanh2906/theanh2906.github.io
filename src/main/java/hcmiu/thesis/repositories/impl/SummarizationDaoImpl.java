package hcmiu.thesis.repositories.impl;

import java.io.IOException;

import org.springframework.stereotype.Repository;

import hcmiu.thesis.repositories.SummarizationDao;

@Repository
public class SummarizationDaoImpl implements SummarizationDao {

	@Override
	public String getSummary(String text, int sentenceNum)  {
		// TODO Auto-generated method stub
		try {
			return Summarizer.summarize(text,sentenceNum);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getLSA(String text, int number) {
		// TODO Auto-generated method stub
		try {
			return LSA.summarize(text, number);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
