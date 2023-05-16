package stepanyan.konstantin.lab_3;
import java.util.Scanner;

public class task_2_fewIfElse {
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
            if(min==0){ min = S;} else {min = Math.min(S, min);}
            //в 1ой итерации min равен нулю и присвоить ему значение S, в последующих - Math.min(S, min)

            max = Math.max(S, max);
            if(S<=min){index_min++;}
            if(S>=max){index_max++;}
            S = scanner.nextInt();
        }
        String first_elem;
        if(index_min<index_max) { first_elem="Раньше встречается минимум."; }
        else{ first_elem="Раньше встречается максимум."; }

        System.out.println("Итого:"+"\n"+"Минимум: "+min+" Максимум: "+max+"\n"+first_elem);
    }
}


