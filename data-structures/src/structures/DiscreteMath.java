package structures;



public class DiscreteMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(binomialCoeff(5,2));
		System.out.println(binomialCoeff(5,3));
		System.out.println(binomialCoeff(5,4));
	}
	
	static int binomialCoeff(int n, int k) {
		
		if (n == 0 || k == n || k == 0)
			return 1;
		
		return binomialCoeff(n - 1, k - 1) * n / k;
		
		
	}

}
