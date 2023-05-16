package stepanyan.konstantin.lab_2;

import java.util.Scanner;

public class A_exercise4 {
    public static void main(String[] args) {
        System.out.println("Введите целое трёхзначное число:");

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt(); //вводимое число

        //если введено трёхзначное число (это числа от 100 до 999 включительно):
        if( x>=100 && x<= 999) {
            int change_hundreds = x%100; //остаток от деления на сто

            int x_hundreds = x/100; //разряд сотых
            int x_tens = (x % 100)/10; //разряд десяток
            int x_ones = change_hundreds%10; //разряд единиц

            System.out.println("Вы ввели число: "+x+"\n"
                    +"В обратном порядке: "+x_ones+x_tens+x_hundreds);
        }
        //если ввели НЕ трёхзначное число
        else{
            System.out.println("Введите трёхзначное число");
        }
    }
}
