package konstantin.stepanyan.lab_0;

import java.util.Scanner;

public class xPlusY {
    public static void main(String[] args) {

        /*ниже создаем экземпляр класса Scanner и привязываем его к стандартному потоку ввода System.in*/
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt(); /* вводим целое число x через scanner*/
        double y = scanner.nextDouble(); /* вводим вещественное число y (в консоли вводится через запятую, а не точку) */

        System.out.printf("Avg(x,y) = " + ( (x+y) / 2) );
    }
}