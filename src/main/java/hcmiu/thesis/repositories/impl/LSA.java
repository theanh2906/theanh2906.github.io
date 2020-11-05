package hcmiu.thesis.repositories.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.SingularValueDecomposition;

import opennlp.tools.util.*;

public class LSA {
	
	public static double maxEntry(RealMatrix mat) {
		double max = mat.getEntry(0, 0);
		for (int i = 0; i < mat.getRowDimension(); i++) {
			for (int k = 0; k < mat.getColumnDimension(); k++) {
				if (max < mat.getEntry(i, k)) {
					max = mat.getEntry(i, k);
				}
			}
		}
		return max;
	}
	public static void printMat(RealMatrix mat) {
		for (int i = 0; i < mat.getRowDimension(); i++) {
			for (int k = 0; k < mat.getColumnDimension(); k++) {
				System.out.printf("%9.3f", mat.getEntry(i, k));
			}
			System.out.println();
		}
	}
	
	public static String summarize(String text, int k) throws IOException {
		String summary = "";
		NGram ngram = new NGram();
		StringList list = ngram.tokenize(text);
		ngram.generate(list, 1);
		ngram.filterStopWords();
		ngram.sort();
		ngram.getSentenceUsingModel(text);
		
		Matrix docMat = new Matrix(ngram.list.size(), ngram.sentences.length);
		
		for (Node node : ngram.list) {
			for (int i = 0; i < ngram.sentences.length; i++) {
				docMat.add(ngram.list.indexOf(node), i, ngram.countWords(node.getWord(), ngram.sentences[i]));
			}
		}
		
		//Create RealMatrix
		RealMatrix mat = MatrixUtils.createRealMatrix(docMat.data);
		SingularValueDecomposition svd = new SingularValueDecomposition(mat);
		//Calculate diagonal matrix Σ (m * n)
		RealMatrix S = svd.getS();
		//Calculate transpose of orthogonal matrix V (n * n)
 		RealMatrix VT = svd.getVT();
		//Calculate sub matrix of transpose of V (k * n)
		RealMatrix Vp = VT.getSubMatrix(0, k, 0, VT.getColumnDimension() - 1);
		//Calculate sub matrix of Σ (k * k)
		RealMatrix Sp = S.getSubMatrix(0, k, 0, k);
		//Calculate the topic similarity
		RealMatrix Ap = Sp.multiply(Vp);
		List<String> setSummarySentences = new ArrayList<String>();
		
		for (int i = 0; i <= Ap.getRowDimension() - 1; i++) {
		for (int j = 0; j <= Ap.getColumnDimension() - 1; j++) {
			if (Ap.getEntry(i, j) >= maxEntry(Ap)/2 && !setSummarySentences.contains(ngram.sentences[j])) {
				setSummarySentences.add(ngram.sentences[j]);
				
			}
			if (setSummarySentences.size() == k) {
				break;
			}
			
		}
		
	}
		
		for (String string : setSummarySentences) {
			summary = summary + string + System.getProperty("line.separator");
		}
		return summary;
	}

	}

