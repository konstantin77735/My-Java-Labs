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

        // Создание экземпляра класса PC
        PC myPC = new PC(cpu, ram, ramType, storage, operatingSystem, gpu);

        // Вывод информации о конфигурации компьютера
        System.out.println("______");
        System.out.println("Ваша конфигурация компьютера:");
        myPC.printConfiguration();
        System.out.println("______");
    }
}

class PC {
    private String cpu;
    private int ram;
    private String ramType;
    private int storage;
    private String operatingSystem;
    private String gpu;

    public PC(String cpu, int ram, String ramType, int storage, String operatingSystem, String gpu) {
        this.cpu = cpu;
        this.ram = ram;
        this.ramType = ramType;
        this.storage = storage;
        this.operatingSystem = operatingSystem;
        this.gpu = gpu;
    }

    public void printConfiguration() {
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram + " ГБ " + ramType);
        System.out.println("Жёсткий диск: " + storage + " ГБ");
        System.out.println("ОС: " + operatingSystem);
        System.out.println("GPU: " + gpu);
    }
}