package stepanyan.konstantin.coursework;
import java.util.Scanner;

public class ComputerConfiguration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название процессора: ");
        String cpu = scanner.nextLine();

        System.out.println("Введите объем оперативной памяти (в ГБ): ");
        int ram = scanner.nextInt();
        scanner.nextLine();

        // DDR3/4/5
        System.out.println("Введите тип оперативной памяти: ");
        String ramType = scanner.nextLine();

        System.out.println("Введите размер жёсткого диска (в ГБ): ");
        int storage = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите название операционной ситемы: ");
        String operatingSystem = scanner.nextLine();

        System.out.println("Введите название видеокарты: ");
        String gpu = scanner.nextLine();

        scanner.close();

        // Output computer information
        System.out.println("______");
        System.out.println("Ваша конфигурация компьютера:");
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram + " ГБ " + ramType);
        System.out.println("Жёсткий диск: " + storage + " ГБ");
        System.out.println("ОС: " + operatingSystem);
        System.out.println("GPU: " + gpu);
        System.out.println("______");
    }
}
