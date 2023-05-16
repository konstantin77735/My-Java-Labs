package stepanyan.konstantin.lab_2;

import java.util.Scanner;

public class C_exercise24 {
    static final double a = 4.9;
    static final double b = 1.3;

    public static void main(String[] args) {
		System.out.println("Введите число x, соответствующее одному из условий "
				+"\n 2 < x < 7 ИЛИ x >= 7 ИЛИ x <= 2");
		Scanner scanner = new Scanner(System.in);
		double x = scanner.nextDouble(); //вводимое число

		System.out.println("f(" + x + ") = " + f(x));
    }

    //функция f(x) ↓
    public static double f(double x) {
        //второе уравнение ↓
        if (x >= 7) {
            return 1 / (a * Math.pow(x, 3) + 1);
        }
        //третье уравнение ↓
        if (x <= 2) {
            return Math.log(Math.sqrt(1 + Math.pow((a * x), 2)));
        }
        return Math.pow(Math.E, (b * x - 1)); //первое уравнение
    }
}

