
package cst8284.wordsort;

import java.util.Comparator;

public class StringSortCompare implements Comparator<String> {

	@Override
	public int compare(String firstStr, String secondStr) {
		return firstStr.length() - secondStr.length();
	}
	
	

}
