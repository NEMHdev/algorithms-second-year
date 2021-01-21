
/************************************************/
/*** Purpose:                                 ***/
/***                                          ***/
/***                                          ***/
/*** Author:                                  ***/
/*** Date:                                    ***/
/***                                          ***/
/*** Note: Based on skeleton code provided by ***/
/*** Jason Steggles 23/09/2016                ***/
/************************************************/

import java.io.*;
import java.text.*;
import java.util.*;

public class Search {

	/** Global variables for counting comparisons **/
	public int compSeq = 0;
	public int compBin = 0;
	public int compHash = 0;
	

	/** Array of values to be searched and size **/
	private int[] A;
	private int size;

	/** Hash array and size **/
	private int[] H;
	private int hSize;

	/** Constructor **/
	Search(int n, int hn) {
		/** set size of array **/
		size = n;
		hSize = hn;

		/** Create arrays **/
		A = new int[size];
		H = new int[hSize];

		/** Initialize hash array **/
		/** Assume -1 indicates a location is empty **/
		for (int i = 0; i < hSize; i++) {
			H[i] = -1;
		}
	}

	/********************************************/

	/*** Read a file of numbers into an array ***/
	/********************************************/
	public void readFileIn(String file) {
		try {
			/** Set up file for reading **/
			FileReader reader = new FileReader(file);
			Scanner in = new Scanner(reader);

			/** Loop round reading in data **/
			for (int i = 0; i < size; i++) {
				/** Get net value **/
				A[i] = in.nextInt();
			}
		} catch (IOException e) {
			System.out.println("Error processing file " + file);
		}
	}

	/*********************/

	/*** Hash Function ***/
	/*********************/
	public int hash(int key) {
		return key % hSize;
	}

	/*****************************/

	/*** Display array of data ***/
	/*****************************/
	public void displayData(int line, String header) {
		/* ** Integer Formatter ** */
		NumberFormat FI = NumberFormat.getInstance();
		FI.setMinimumIntegerDigits(3);

		/** Print header string **/
		System.out.print("\n\n" + header);

		/** Display array data **/
		for (int i = 0; i < size; i++) {
			/** New line? **/
			if (i % line == 0) {
				System.out.println();
			}

			/** Display value **/
			System.out.print(FI.format(A[i]) + " ");
		}
	}

	/**************************/

	/*** Display hash array ***/
	/**************************/
	public void displayHash(int line) {
		/** Integer Formatter **/
		NumberFormat FI = NumberFormat.getInstance();
		FI.setMinimumIntegerDigits(3);

		/** Print header string **/
		System.out.print("\n\nHash Array of size " + hSize);

		/** Display array data **/
		for (int i = 0; i < hSize; i++) {
			/** New line? **/
			if (i % line == 0) {
				System.out.println();
			}

			/** Display value **/
			System.out.print(FI.format(H[i]) + " ");
		}
	}

	public int seqSearch(int key) {

		for (int i = 0; i < size; i++) {
			compSeq = compSeq + 2;
			if (A[i] > key){
				compSeq= compSeq - 1;
				return -1;
			}
			
			if ((A[i] == key)) {
				
				return i;
			}

		}
		
		return -1;
	}

	public int binSearch(int key, int L, int R) {
		if (R < L) {
			compBin = compBin + 1;
			return -1;
		}
		int m = (R + L) / 2;
		if (key == A[m]) {
			compBin = compBin + 2;
			
			return m;
		}
		if (key > A[m]) {
			compBin = compBin + 3;
			
			return binSearch(key, m + 1, R);
		} else {
			compBin = compBin + 3;
			
			return binSearch(key, L, m - 1);
		}
	}

	private void addToHash(int value) {

		int index = hash(value);
		while (H[index] != -1) {
			index = index + 1;
		}
		H[index] = value;
	}

	public void readIntoHash(String file) {
		try {
			/** Set up file for reading **/
			FileReader reader2 = new FileReader(file);
			Scanner in2 = new Scanner(reader2);

			/** Loop round reading in data **/
			for (int i = 0; i < size; i++) {
				/** Get net value **/
				addToHash(in2.nextInt());
			}
		} catch (IOException e) {
			System.out.println("Error processing file " + file);
		}
	}

	public int hashSearch(int key) {
		int index = hash(key);
		if (H[index] == key) {
			compHash = compHash + 1;
			return index;
		}

		else {
			compHash = compHash + 1;
			while ((H[index] != key) && (index != hSize - 1)) {
				compHash = compHash +3;
				index = index + 1;
				if (H[index] == key) {

					return index;
				}
				if (H[index] == -1){
					return -1;
				}
			}
			
		}
		for (int i = 0; i < hash(key); i++) {
			compHash = compHash + 1;
			if (H[i] == key) {

				index = i;
				return index;
			}
			

		}
		

		return -1;
	}

	
}

/*** End of class Search ***/