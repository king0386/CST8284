package cst8284.solidObject;

import java.util.ArrayList;

public class SolidObjectLauncher {

	// define a new static ArrayList of type SolidObject called solidObjects.
	public static ArrayList<SolidObject<BasicShape>> solidObjects = new ArrayList<>();
	

	public static void main(String[] args) {

		/*
		 *  Load the ArrayList declared above with the following four SolidObjects
		 * indicated below, along with their associated depths, as shown
		 * 
		 * 			BasicShape Type <T> 			depth
		 * 
		 * 			Circle(3.0) 					39.2436654315 
		 * 			Square(16.0) 					2.0 
		 * 			Triangle(6.0) 					4.5 
		 * 			Square(8.0)
		 * 
		 * Note that the last SolidObject is a cube constructed using the Square
		 * BasicShape. For this, use the one-arg SolidObject constructor. For the top
		 * three, use the two-arg constructor, i.e. for BasicShape, double.
		 */
		
		solidObjects.add(new SolidObject<BasicShape>(new Circle(3), 39.2436654315));
		solidObjects.add(new SolidObject<BasicShape>(new Square(16), 2.0));
		solidObjects.add(new SolidObject<BasicShape>(new Triangle(6), 4.5));
		solidObjects.add(new SolidObject<BasicShape>(new Square(8)));
		
		displayVolumeComparison(solidObjects);
		displaySurfaceAreaComparison(solidObjects);
	}

	// TODO: Create a public static method isVolumeEqual() that takes two SolidObjects as
	// parameters, and if they have the same volume, returns true, otherwise false.
	// This method is called by the displayVolumeComparison method, whose code is
	// already provided below.  Assume the two SolidOjects have equal volume
	// if their volumes are the same to within 1e-8

	public static boolean isVolumeEqual(SolidObject<BasicShape> firstSolidObject, SolidObject<BasicShape> secondSolidObject) {
		return (Math.abs(firstSolidObject.getVolume() - secondSolidObject.getVolume()) < 1e-8);
	}

	// TODO: Create a public static method isSurfaceAreaEqual() that takes two SolidObjects
	// as parameters and if they have the same surface area, returns true, otherwise
	// false.  This method is called by the displayVolumeComparison method, whose code is
	// already provided below.  Assume the two SolidOjects have equal surface area
	// if their surface areas are the same to within 1e-8

	public static boolean isSurfaceAreaEqual(SolidObject<BasicShape> firstSolidObject, SolidObject<BasicShape> secondSolidObject) {
		return (Math.abs(firstSolidObject.getVolume() - secondSolidObject.getVolume()) < 1e-8);
	}

	
	
	public static void displayVolumeComparison(ArrayList<SolidObject<BasicShape>> arList) {

		// Print out column header
		System.out.println("Compare the objects' volumes.  Are they equal?");
		System.out.print("\t\t");
		for (SolidObject<BasicShape> columnHeader : arList)
			System.out.print("\t" + columnHeader);

		// Print out each row,starting with the name of the object
		for (SolidObject<BasicShape> solidObjRow : arList) {
			System.out.println(); // Next line
			System.out.print(solidObjRow);
			for (SolidObject<BasicShape> solidObjColumn : arList)
				System.out.print("\t\t" + (isVolumeEqual(solidObjColumn, solidObjRow) ? "TRUE" : false));
		}
		System.out.println("\n");
	}

	public static void displaySurfaceAreaComparison(ArrayList<SolidObject<BasicShape>> arList) {

		System.out.println("Compare the objects' surface areas.  Are they equal?");
		// Print out the header
		System.out.print("\t\t");
		for (SolidObject<BasicShape> columnHeader : arList)
			System.out.print("\t" + columnHeader);

		// Print out each row,starting with the name of the object
		for (SolidObject<BasicShape> solidObjRow : arList) {
			System.out.println(); // Next line
			System.out.print(solidObjRow);
			for (SolidObject<BasicShape> solidObjColumn : arList)
				System.out.print("\t\t" + (isSurfaceAreaEqual(solidObjColumn, solidObjRow) ? "TRUE" : false));
		}
		System.out.println("\n");
	}
}
