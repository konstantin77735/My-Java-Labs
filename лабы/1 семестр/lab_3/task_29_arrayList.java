package stepanyan.konstantin.lab_3;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class task_29_arrayList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько вы хотите заплатить?");
        int S = scanner.nextInt(); //сумма к оплате
        int[] nominals = new int[]{500, 100, 50, 10, 5, 2, 1}; //какие купюры имеются
        ArrayList<Integer> paidNominalsArrayList = new ArrayList<Integer>(); // какие номиналы внесли
        //перебор числа S по убывающей ↓
        for (int s = S; s >= 1; s--) {
            // перебор номиналов по убывающей ↓
            for (int z = 0; z < nominals.length; z++) {
                //Если номинал входит в сумму хоть один раз ↓
                if ((s / nominals[z]) >= 1) {
                    System.out.println("Нужно заплатить: "+s);
                    int enters = s/nominals[z]; //сколько раз помещается купюра в числе
                    System.out.println("В сумме "+s+" помещается " +
                            enters+" купюр номиналом: " + nominals[z]+" р.");
                    for(int i=0; i<enters; i++){
                        //добавляем потраченный номинал в массив столько раз, сколько раз он входит в число
                        //System.out.println("Отправляем купюру: "+nominals[z]+" в массив");
                        paidNominalsArrayList.add(nominals[z]);
                    }
                    s = s%(nominals[z]*enters); //сколько останется заплатить
                    s++;
                    break;
                }
            }
        }
        // Сколько было потрачено РАЗНЫХ купюр? Чтобы узнать
        // помещаем нашу коллекцию в сет (в нём не бывает дубликатов)
        Set<Integer> set = new HashSet<>(paidNominalsArrayList);

        System.out.println("Было потрачено: "+ set.size()+" купюр разного достоинства");
    }
}
