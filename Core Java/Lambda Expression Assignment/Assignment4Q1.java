interface Func {
	double cal(double x, double y);
}

public class Assignment4Q1 {
	
	Func myAdd = (a, b) -> a + b;
	Func mySub = (a, b) -> a - b;
	Func myMul = (a, b) -> a * b;
	Func myDiv = (a, b) -> a / b;
	
	public double addition(int num1, int num2) {
		return myAdd.cal(13, 5);
	}

	public double subtraction(int num1, int num2) {
		return mySub.cal(13, 5);
	}

	public double multiplication(int num1, int num2) {
		return myMul.cal(13, 5);
	}

	public double division(double num1, double num2) {
		return myDiv.cal(13, 5);
	}

	public static void main(String[] args) {

	}
}

