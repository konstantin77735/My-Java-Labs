package konstantin.stepanyan.lab_0;

import java.util.Scanner;
import java.text.DecimalFormat;

public class exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Вводим переменные в консоли
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double x = scanner.nextDouble();

        double x_in3pow = Math.pow(x, 3); // x в кубе
        double arcTg_x = Math.atan(x); //арктангенс x
        double module_of_ln_x = Math.abs(  Math.log(x) ); //модуль натурального логарифма x

        //выражение:
        double y = Math.sqrt( (a * x_in3pow + arcTg_x) / (c * x + b * module_of_ln_x ));


        //форматированный результат:
        String formated_y = new DecimalFormat("#0.00000").format(y); //форматировать по паттерну

        System.out.println("Если: a: "+a+", b: "+b+", c: "+c+", x: "+x+", то ответ равен: "+formated_y); //выводим результат

    }
}
