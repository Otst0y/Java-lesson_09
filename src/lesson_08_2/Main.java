package lesson_08_2;

public class Main {
	
	public static void main(String[] args) throws IllegalAccessException, MyException {
		Methods m = new Methods();
		
		m.Add(-5, -7);
		m.Add(0, 7);
		m.Add(5, 0);
		m.Add(0, 0);
		m.Add(5, 7);
		
		m.Substract(-4, -5);
		m.Substract(0, 5);
		m.Substract(4, 0);
		m.Substract(0, 0);
		m.Substract(4, 5);
		
		m.Multiply(-6, -3);
		m.Multiply(0, 3);
		m.Multiply(6, 0);
		m.Multiply(0, 0);
		m.Multiply(6, 3);
		
		m.Divide(-2, -8);
		m.Divide(0, 8);
		m.Divide(2, 0);
		m.Divide(0, 0);
		m.Divide(2, 8);
	}
}
