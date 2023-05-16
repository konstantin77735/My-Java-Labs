package stepanyan.konstantin.lab_3;
import java.util.Arrays;
import java.util.Scanner;

public class task_29_array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько вы хотите заплатить?");
        int S = scanner.nextInt(); //сумма к оплате
        int[] nominals = new int[]{500, 100, 50, 10, 5, 2, 1}; //какие номиналы имеются
        int[] paidNominals = new int[]{}; // какие номиналы внесли
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
                        paidNominals = addX(paidNominals.length, paidNominals, nominals[z]);
                    }
                    s = s%(nominals[z]*enters); //сколько останется заплатить
                    s++;
                    break;
                }
            }
        }
        int[] differentBills = removeDuplicates(paidNominals); //массив заплаченных купюр БЕЗ повторений
        System.out.println("Было потрачено: "+ differentBills.length + " купюр разного достоинства");
    }

    public static int[] removeDuplicates(int[] arr) { //удаляет дубликаты
        return Arrays.stream(arr).distinct().toArray();
    }
    
    public static int[] addX(int n, int arr[], int x)   // добавляет x в массив
    {
        int i;
        int newarr[] = new int[n + 1]; // создаём новый массив на 1 эл больше
        for (i = 0; i < n; i++) {
            newarr[i] = arr[i]; // добавить все элементы с пред. массива до n,
        }
        newarr[n] = x; // затем добавить x на позиции n
        return newarr;
    }

}
