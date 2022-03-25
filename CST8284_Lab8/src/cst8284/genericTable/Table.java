package cst8284.genericTable;

import java.util.ArrayList;
import java.util.List;



public class Table {

	public static <E extends Comparable<E>> void outputTable(List<E> arList) {


		// Print out column header
		System.out.print("\t\t");
		for (E columnHeader : arList)
			System.out.print("\t" + columnHeader);

		// Print out each row,starting with the name of the object
		for (E solidObjRow : arList) {
			System.out.println(); // Next line
			System.out.print(solidObjRow);
			for (E solidObjColumn : arList)
				System.out.print("\t\t" + (compareResults(solidObjColumn, solidObjRow)));
		}
		System.out.println("\n");
	
	}

	public static <E extends Comparable<E>> String compareResults(E obj1, E obj2){
		if(obj1.compareTo(obj2) > 0) return ">";
		if(obj1.compareTo(obj2) < 0) return "<";
		return "=";
			
	}

}
