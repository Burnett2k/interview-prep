package structures;

public class Recursion {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//fibonacci stuff
//		int[] memo = new int[25];
//		memo[0] = 1;
//		memo[1] = 1;
//		System.out.println(fibonacci(13, memo));
		//end fibonacci stuff
		
		System.out.println(numSteps(3));
		
	}
	
	static int fibonacci(int i, int[] memo) {
		
		
		if (i==0) {return 0;}
		if (i==1) {return 1;}
		if (memo[i] != 0) {return memo[i];}
		
		memo[i] = fibonacci(i - 1, memo) + fibonacci(i - 2, memo);
		
		return memo[i];
		
	}
	
	static int numSteps(int n) {
		
		int combos = 0;
		
		
		return step(0, n);
		
		

		
		
	}
	
	static int step(int stepsTaken, int n) {
		
		for (int i = 1; i < 4; i++) {
			stepsTaken += i;
			
			if (stepsTaken == n) {
				System.out.println("found a combination!");
				return 1;
			} else if (stepsTaken < n) {
				return step(stepsTaken, n);
			} else if (stepsTaken > n) {
				return 0;
			}
			
		}
		
		return 0;
		
	}
	
	

}
