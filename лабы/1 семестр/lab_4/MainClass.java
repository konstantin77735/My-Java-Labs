package stepanyan.konstantin.lab_4;
import java.util.ArrayList; import java.util.HashSet; import java.util.Set; import java.util.Scanner;
class MyClass{
    public static void task1(){ Scanner scanner = new Scanner(System.in); System.out.println("Введите последовательность:");
        int S = scanner.nextInt(); int min=0; int max=0;
        //позиции в последовательности ↓
        int index_min=0; int index_max=0;
        while(S!=0){ min = (min==0) ? S : Math.min(S, min);
            //в 1ой итерации min равен нулю и присвоить ему значение S, в последующих - Math.min(S, min)
            max = Math.max(S, max); if(S<=min){index_min++;} if(S>=max){index_max++;}
            S = scanner.nextInt(); }

        String first_elem = (index_min<index_max) ? "Раньше встречается минимум." : "Раньше встречается максимум.";
        System.out.println("Итого:"+"\n"+"Минимум: "+min+" Максимум: "+max+"\n"+first_elem); }

    public static void task2() { Scanner scanner = new Scanner(System.in); System.out.println("Сколько вы хотите заплатить?");
        int S = scanner.nextInt(); int[] nominals = new int[]{500, 100, 50, 10, 5, 2, 1}; //какие купюры имеются
        ArrayList<Integer> paidNominalsArrayList = new ArrayList<Integer>(); // какие номиналы внесли
        //перебор числа S по убывающей ↓
        for (int s = S; s >= 1; s--) {
            // перебор номиналов по убывающей ↓
            for (int z = 0; z < nominals.length; z++) {
                //Если номинал входит в сумму хоть один раз ↓
                if ((s / nominals[z]) >= 1) {
                    System.out.println("Нужно заплатить: "+s); int enters = s/nominals[z]; //сколько раз помещается купюра в числе
                    System.out.println("В сумме "+s+" помещается " + enters+" купюр номиналом: " + nominals[z]+" р.");
                    for(int i=0; i<enters; i++){
                        //добавляем потраченный номинал в массив столько раз, сколько раз он входит в число
                        //System.out.println("Отправляем купюру: "+nominals[z]+" в массив");
                        paidNominalsArrayList.add(nominals[z]);  }
                    s = s%(nominals[z]*enters); //сколько останется заплатить
                    s++; break; } } }
        // Сколько было потрачено РАЗНЫХ купюр? Чтобы узнать
        // помещаем нашу коллекцию в сет (в нём не бывает дубликатов)
        Set<Integer> set = new HashSet<>(paidNominalsArrayList);
        System.out.println("Было потрачено: "+ set.size()+" купюр разного достоинства");
    }
    // вычисляет: ax^3 + bx^2 + cx + d с коэффициентами и иксом ↓
    public static int f(int a, int b, int c, int d, int x)
    {return (a * x * x * x) + (b * x * x) + (c * x) + d; }
    //a=1, b=2, c=-15, d=14
    public static void task3(){ Scanner scanner = new Scanner(System.in);
        // Коэффициенты уравнения
        System.out.println("Введите a, b, c, d"); int a = scanner.nextInt();
        int b = scanner.nextInt(); int c = scanner.nextInt(); int d = scanner.nextInt();
        if(a == 0 || d == 0){ System.out.println("a и d не должны быть равны нулю!"); return; }
        int i = 1; int iters = Math.abs(d)/2;

        // пока счётчик меньше половины d
        while (i <=  iters ) {
            // если счётчик является делителем d
            if (d % i == 0) { if (f(a, b, c, d, i) == 0) // и в то же время является корнем уравнения
                { System.out.println("Положительный корень: " + i); }
                if (f(a, b, c, d, -i) == 0)
                {System.out.println("Отрицательный корень: " + -i); }

            } i++; } } }

public class MainClass {
    public static void main(String[] args) { Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Меню: ");
            System.out.println("1. Задача 1");
            System.out.println("2. Задача 2");
            System.out.println("3. Задача 3");
            System.out.println("4. Выход");
            System.out.println("Выберете пункт меню (1..4)");
            int c = scanner.nextInt();
            switch (c) {
                case 1: MyClass.task1(); break;
                case 2: MyClass.task2(); break;
                case 3: MyClass.task3(); break;
                default: return;
            }
        }
    }
}