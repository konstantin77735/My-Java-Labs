package stepanyan.konstantin.lab_2;

import java.util.Scanner;

public class B_5 {
    public static void main(String[] args) {
        System.out.println("Введите 3 числа");

        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double sum = (a*b*c)/3;
        double part = sum - (int) sum;

        System.out.println("Среднее геометрическое: "+sum+" его дробная частЬ: "+part);
    }
}
