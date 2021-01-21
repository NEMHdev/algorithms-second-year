
/******************************************************/
/*** Purpose: Test class to illustrate Search class ***/
/***                                                ***/
/*** Author: L. J. Steggles                         ***/
/*** Date: 23/09/2016                               ***/
/******************************************************/

import java.io.*;

public class TestSearch {
	
	public static int averageComp(int comps){
		return comps / 10;
	}
	
	public static void main(String[] args) {

		Search S = new Search(100, 151);
		Search T = new Search(1000, 1499);

		/** Read in test data **/
		S.readFileIn("data1.txt");
		T.readFileIn("data2.txt");

		/** Display data array **/
		S.displayData(20, "Data Array 1 \n");
		T.displayData(20, "Data Array 2");
		
		S.readIntoHash("data1.txt");
		T.readIntoHash("data2.txt");
		
		/** Display hash array which will be empty **/
		S.displayHash(20);
		System.out.println();
		T.displayHash(20);

		System.out.println("\n" + "\n" + "Sequential Search 1:" + "\n");
		System.out.println("Position of the element 18 is:" + S.seqSearch(18));
		System.out.println("Position of the element 69 is:" + S.seqSearch(69));
		System.out.println("Position of the element 201 is:" + S.seqSearch(201));
		System.out.println("Position of the element 331 is:" + S.seqSearch(331));
		System.out.println("Position of the element 429 is:" + S.seqSearch(429));
		System.out.println("Position of the element 17 is:" + S.seqSearch(17) );
		System.out.println("Position of the element 67 is:" + S.seqSearch(67) );
		System.out.println("Position of the element 209 is:" + S.seqSearch(209));
		System.out.println("Position of the element 372 is:" + S.seqSearch(372));
		System.out.println("Position of the element 498 is:" + S.seqSearch(498));
		System.out.println("Average number of comparisons for Sequential search: " + averageComp(S.compSeq));

		System.out.println("\n" + "Binary Search 1:" + "\n");
		System.out.println("Position of the element 18 is:" + S.binSearch(18, 0, 99));
		System.out.println("Position of the element 69 is:" + S.binSearch(69, 0, 99));
		System.out.println("Position of the element 201 is:" + S.binSearch(201, 0, 99));
		System.out.println("Position of the element 331 is:" + S.binSearch(331, 0, 99));
		System.out.println("Position of the element 429 is:" + S.binSearch(429, 0, 99));
		System.out.println("Position of the element 17 is:" + S.binSearch(17, 0, 99));
		System.out.println("Position of the element 67 is:" + S.binSearch(67, 0, 99));
		System.out.println("Position of the element 209 is:" + S.binSearch(209, 0, 99));
		System.out.println("Position of the element 372 is:" + S.binSearch(372, 0, 99));
		System.out.println("Position of the element 498 is:" + S.binSearch(498, 0, 99));
		System.out.println("Average number of comparisons for Binary search: " + averageComp(S.compBin));
		
		System.out.println("\n" + "Hash Search 1:" + "\n");
		System.out.println("Position of the element 18 is:" + S.hashSearch(18));
		System.out.println("Position of the element 69 is:" + S.hashSearch(69));
		System.out.println("Position of the element 201 is:" + S.hashSearch(201));
		System.out.println("Position of the element 331 is:" + S.hashSearch(331));
		System.out.println("Position of the element 492 is:" + S.hashSearch(492));
		System.out.println("Position of the element 17 is:" + S.hashSearch(17));
		System.out.println("Position of the element 67 is:" + S.hashSearch(67));
		System.out.println("Position of the element 209 is:" + S.hashSearch(209));
		System.out.println("Position of the element 372 is:" + S.hashSearch(372));
		System.out.println("Position of the element 498 is:" + S.hashSearch(498));
		System.out.println("Average number of comparisons for Hash search: " + averageComp(S.compHash));
		
		System.out.println("\n" + "Sequential Search 2:" + "\n");
		System.out.println("Position of the element 20 is:" + T.seqSearch(20));
		System.out.println("Position of the element 832 is:" + T.seqSearch(832));
		System.out.println("Position of the element 1452 is:" + T.seqSearch(1452));
		System.out.println("Position of the element 1937 is:" + T.seqSearch(1937));
		System.out.println("Position of the element 2615 is:" + T.seqSearch(2615));
		System.out.println("Position of the element 87 is:" + T.seqSearch(87));
		System.out.println("Position of the element 851 is:" + T.seqSearch(851));
		System.out.println("Position of the element 1350 is:" + T.seqSearch(1350));
		System.out.println("Position of the element 1990 is:" + T.seqSearch(1990));
		System.out.println("Position of the element 2631 is:" + T.seqSearch(2631));
		System.out.println("Average number of comparisons for Sequential search: " + averageComp(T.compSeq));
		
		System.out.println("\n" + "Binary Search 2:" + "\n");
		System.out.println("Position of the element 20 is:" + T.binSearch(20, 0, 999));
		System.out.println("Position of the element 832 is:" + T.binSearch(832, 0, 999));
		System.out.println("Position of the element 1452 is:" + T.binSearch(1452, 0, 999));
		System.out.println("Position of the element 1937 is:" + T.binSearch(1937, 0, 999));
		System.out.println("Position of the element 2615 is:" + T.binSearch(2615, 0, 999));
		System.out.println("Position of the element 87 is:" + T.binSearch(87, 0, 999));
		System.out.println("Position of the element 851 is:" + T.binSearch(851, 0, 999));
		System.out.println("Position of the element 1350 is:" + T.binSearch(1350, 0, 999));
		System.out.println("Position of the element 1990 is:" + T.binSearch(1990, 0, 999));
		System.out.println("Position of the element 2631 is:" + T.binSearch(2631, 0, 999));
		System.out.println("Average number of comparisons for Binary search: " + averageComp(T.compBin));
		
		System.out.println("\n" + "Hash Search 2:" + "\n");
		System.out.println("Position of the element 20 is:" + T.hashSearch(20));
		System.out.println("Position of the element 832 is:" + T.hashSearch(832));
		System.out.println("Position of the element 1452 is:" + T.hashSearch(1452));
		System.out.println("Position of the element 1937 is:" + T.hashSearch(1937));
		System.out.println("Position of the element 2615 is:" + T.hashSearch(2615));
		System.out.println("Position of the element 87 is:" + T.hashSearch(87));
		System.out.println("Position of the element 851 is:" + T.hashSearch(851));
		System.out.println("Position of the element 1350 is:" + T.hashSearch(1350));
		System.out.println("Position of the element 1990 is:" + T.hashSearch(1990));
		System.out.println("Position of the element 2631 is:" + T.hashSearch(2631));
		System.out.println("Average number of comparisons for Hash search: " + averageComp(T.compHash));
		
	}

}