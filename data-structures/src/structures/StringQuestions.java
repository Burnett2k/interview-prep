package structures;

import java.util.Arrays;

public class StringQuestions {

	public static void main(String[] args) {

		

		//oneEditAwayQuestion();
		//sortedRowColumnQuestion();
		//firstIncreasingSequence();
		rotateImage();
	}
	
	static void rotateImage() {
		
		int[][] test1 = 
			{
					{1,0,0},
					{0,1,0},
					{0,0,1}
		};
		
		System.out.println(Arrays.deepToString(rotateArray(test1)));
		
	}
	
	static int[][] rotateArray(int[][] pic) {
		
		if (pic == null || pic.length < 2) {
			return new int[][] {{}};
		}
		
		int row = 0;
		int col = 0;
		
		int[][] result = new int[pic.length][pic[0].length];
		
		//making the assumption here that each array has the same length
		for (int i = 0; i < pic[0].length; i++) {
			col = 0;
			
			for (int j = pic.length - 1; j > -1; j--) {
				
				result[row][col] = pic[j][i];
				col++;
				
			}
			
			row++;
		}
		
		return result;
		
	}
	
	
	static void firstIncreasingSequence() {
		int[] test1 = {2,1,2,3};
		int[] test2 = {1,2};
		int[] test3 = {1,2,1,3};
		int[] test4 = {1};
		int[] test5 = {1,2,2,3};
		int[] test6 = {33,1,9,34,36,1,34,1,3,4};
		
		System.out.println(Arrays.toString(determineIncreasingSequence(test1)));
		System.out.println(Arrays.toString(determineIncreasingSequence(test2)));
		System.out.println(Arrays.toString(determineIncreasingSequence(test3)));
		System.out.println(Arrays.toString(determineIncreasingSequence(test4)));
		System.out.println(Arrays.toString(determineIncreasingSequence(test5)));
		System.out.println(Arrays.toString(determineIncreasingSequence(test6)));
		
		
	}
	
	static int[] determineIncreasingSequence(int [] nums) {
		
		int[] result;
		int end = 0;
		int beg = 0;
		
		if (nums == null || nums.length <= 1) {
			return new int[] {};
		}
		
		for (int i = 1; i < nums.length; i++) {
			int prev = nums[i-1];
			int curr = nums[i];
			
			if (prev < curr) {
				end++;
			} else {
				if (end - beg >= 1) {
					return Arrays.copyOfRange(nums, beg, end + 1);
				} else {
					end++;
					beg++;
				}
			}
		}
		
		if (end - beg == 0) {
			return new int[] {};
		} else { 
			return Arrays.copyOfRange(nums, beg, end + 1);
		}
		
		
	}
	
	
	static void sortedRowColumnQuestion() {
		
		int[][] nums = {
				{-3,-2,-1,1},
				{-2,2,3,4},
				{4,5,7,8}
		};
		System.out.println(numberOfNegativeNumbers(nums));
		
	}
	
	static int numberOfNegativeNumbers(int[][] nums) {
		int count = 0;
		
		for (int i = 0; i < nums.length; i ++) {
			
			for (int j = 0; j < nums[i].length; j++) {
				if (nums[i][j] > -1) {
					break;
				} else {
					count++;
				}
				
				
			}
			
		}
		
		
		return count;
	}
	
	static void oneEditAwayQuestion() {
		System.out.println(oneEditAway("pale", "ple"));
		System.out.println(oneEditAway("pales", "pale"));
		System.out.println(oneEditAway("pale", "bale"));
		System.out.println(oneEditAway("pale", "bae"));
	}
	

	static boolean oneEditAway(String word1, String word2) {
		if (word1.length() == word2.length()) {
			return replace(word1, word2);	
		} else if (word1.length() + 1 == word2.length()) {
			return insert(word1, word2);			
		} else if (word1.length() - 1 == word2.length()) {
			return insert(word2, word1);
		}

		return false;
	}
	
	static boolean replace(String w1, String w2) {
		System.out.println("entering replace");
		boolean foundDifference = false;
		for (int i = 0; i < w1.length(); i ++) {
			if (w1.charAt(i) != w2.charAt(i)) {
				if (foundDifference) {
					return false;
				}
				foundDifference = true;
			}	
		}
		return true;
	}
	
	static boolean insert(String w1, String w2) {
		int index1 = 0;
		int index2 = 0;
		System.out.println("entering insert");
		while (index1 < w1.length() && index2 < w2.length()) {
			if (w1.charAt(index1) != w2.charAt(index2)) {
				if (index1 != index2) {
					return false;
				}
				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}
	
	static boolean remove(String w1, String w2) {
		
		return true;
	}

}
