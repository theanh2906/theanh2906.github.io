package hcmiu.thesis.utils;

import java.util.Random;

public class NumberUtil {
	public static int random(int min, int max) {
		return new Random().nextInt(max - min) + min;
	}
	
	public static Double round(double a, double b) {
		return a + b ;
	}
	
}
