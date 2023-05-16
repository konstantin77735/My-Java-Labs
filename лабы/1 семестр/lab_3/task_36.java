package stepanyan.konstantin.lab_3;
import java.util.Scanner;

//a=1 b=-6 c=1 d=14

public class task_36 {
    // вычисляет: ax^3 + bx^2 + cx + d с коэффициентами и иксом ↓
    public static int f(int a, int b, int c, int d, int x)
    {return (a * x * x * x) + (b * x * x) + (c * x) + d; }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Коэффициенты уравнения
        System.out.println("Введите a, b, c, d");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        if(a == 0 || d == 0){
            System.out.println("a и d не должны быть равны нулю!");
            return;
        }
        int i = 1;
        int iters = Math.abs(d)/2;

        // пока счётчик меньше половины d
        while (i <=  iters ) {
            // если счётчик является делителем d
            if (d % i == 0) {
                if (f(a, b, c, d, i) == 0) // и в то же время является корнем уравнения
                { System.out.println("Положительный корень: " + i); }
                if (f(a, b, c, d, -i) == 0) // если противоположное число тоже является корнем
                {System.out.println("Отрицательный корень: " + -i); }
            }
            i++;
        }
    }
}

