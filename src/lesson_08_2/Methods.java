package lesson_08_2;

public class Methods {
	
	public void Add(int a, int b) throws IllegalAccessException, MyException {
		if(a < 0 && b < 0) {
			throw new IllegalArgumentException();
		}else {
			System.out.println(a + b);
		}
		
		if((a == 0 && b != 0) || (a != 0 && b == 0)) {
			throw new ArithmeticException();
		}else {
			System.out.println(a + b);
		}
		
		if(a == 0 && b == 0) {
			throw new IllegalAccessException();
		}else {
			System.out.println(a + b);
		}
		
		if (a > 0 && b > 0) {
			throw new MyException("Exception is thrown.");
		}else {
			System.out.println(a + b);
		}
	}
	
	void Substract(int a, int b) throws MyException, IllegalAccessException {
		if(a < 0 && b < 0) {
			throw new IllegalArgumentException();
		}else {
			System.out.println(a - b);
		}
		
		if((a == 0 && b != 0) || (a != 0 && b == 0)) {
			throw new ArithmeticException();
		}else {
			System.out.println(a - b);
		}
		
		if(a == 0 && b == 0) {
			throw new IllegalAccessException();
		}else {
			System.out.println(a - b);
		}
		
		if (a > 0 && b > 0) {
			throw new MyException("Exception is thrown.");
		}else {
			System.out.println(a - b);
		}
	}
	
	void Multiply(int a, int b) throws MyException, IllegalAccessException {
		if(a < 0 && b < 0) {
			throw new IllegalArgumentException();
		}else {
			System.out.println(a * b);
		}
		
		if((a == 0 && b != 0) || (a != 0 && b == 0)) {
			throw new ArithmeticException();
		}else {
			System.out.println(a * b);
		}
		
		if(a == 0 && b == 0) {
			throw new IllegalAccessException();
		}else {
			System.out.println(a * b);
		}
		
		if (a > 0 && b > 0) {
			throw new MyException("Exception is thrown.");
		}else {
			System.out.println(a * b);
		}
	}
	
	void Divide(int a, int b) throws MyException, IllegalAccessException {
		if(a < 0 && b < 0) {
			throw new IllegalArgumentException();
		}else {
			System.out.println(a / b);
		}
		
		if((a == 0 && b != 0) || (a != 0 && b == 0)) {
			throw new ArithmeticException();
		}else {
			System.out.println(a / b);
		}
		
		if(a == 0 && b == 0) {
			throw new IllegalAccessException();
		}else {
			System.out.println(a / b);
		}
		
		if (a > 0 && b > 0) {
			throw new MyException("Exception is thrown.");
		}else {
			System.out.println(a / b);
		}
	}
}
