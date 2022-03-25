package cst8284.genericTable;

import java.util.Arrays;
import java.util.List;

public class GenericTableLauncher {

	public static void main(String[] args) {
		
		List<Integer> ints = Arrays.asList(1, 2, 3);
		List<String> strings = Arrays.asList("Larry", "Moe", "Curly");
		
		Table.outputTable(ints);
		Table.outputTable(strings);

	}
}