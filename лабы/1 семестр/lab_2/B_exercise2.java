package stepanyan.konstantin.lab_2;

import java.util.Scanner;

public class B_exercise2 {
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите число x:");
        double x = scanner.nextDouble(); //вводимое число x
		int x_tens = (int)(x % 100)/10; //разряд десяток
		double part = x - (int) x; //дробная часть
		int hundred_part = (int)(part / 0.01)%10; //разряд в сотой части

		boolean isSpecial = x_tens>hundred_part;

		System.out.println("isSpecial: "+isSpecial);
    }
}
