package stepanyan.konstantin.lab_3;
import java.util.Scanner;

public class task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите последовательность:");
        int S = scanner.nextInt();
        int min=0;
        int max=0;
        //позиции в последовательности ↓
        int index_min=0;
        int index_max=0;
        while(S!=0){
            min = (min==0) ? S : Math.min(S, min);
            //в 1ой итерации min равен нулю и присвоить ему значение S, в последующих - Math.min(S, min)
            max = Math.max(S, max);
            if(S<=min){index_min++;}
            if(S>=max){index_max++;}
            S = scanner.nextInt();
        }

        String first_elem = (index_min<index_max) ? "Раньше встречается минимум." : "Раньше встречается максимум.";

        System.out.println("Итого:"+"\n"+"Минимум: "+min+" Максимум: "+max+"\n"+first_elem);
    }
}

