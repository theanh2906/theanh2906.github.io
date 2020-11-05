package hcmiu.thesis.utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
    public static List<Integer> getDigitsFromQuery(final String str) {
        if (str.isEmpty()) {
            return null;
        }
        final int sz = str.length();
        final StringBuilder strDigits = new StringBuilder(sz);
        for (int i = 0; i < sz; i++) {
            final char tempChar = str.charAt(i);
            if (Character.isDigit(tempChar)) {
                strDigits.append(tempChar);
            }
        }
        List<Integer> listInt = new ArrayList<Integer>();
        String[] strArr = strDigits.toString().split("");
        for (String each : strArr) {
        	listInt.add(Integer.parseInt(each));
        }
        return listInt;
    }
}
