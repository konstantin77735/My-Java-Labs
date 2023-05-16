package konstantin.stepanyan.lab_0;

import java.util.Scanner;
import java.text.DecimalFormat;


public class exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Константы:
        final double a = 4.3;
        final double b = 2.9;

        //переменная x
        double x = scanner.nextDouble(); //вводить с клавиатуры

        double x_in2pow = Math.pow(x, 2); // x в квадрате

        double _log_in_2pow = Math.pow (Math.log(a * x + 2), 2 ); //натуральный логарифм из числителя в квадрате
        double _sin = Math.sin (b * x_in2pow - 1); //синус из числителя

        //числитель выражения
        double numerator = Math.sqrt(_log_in_2pow + _sin);

        //выражение ( числитель / x в квадрате )
        double result = numerator / x_in2pow;

        //форматированный результат:
        String formatedResult = new DecimalFormat("#0.00000").format(result); //форматировать по паттерну

        System.out.println("Если: a: "+a+", b: "+b+", x: "+x+", то ответ равен: "+formatedResult); //выводим результат
    }
}

