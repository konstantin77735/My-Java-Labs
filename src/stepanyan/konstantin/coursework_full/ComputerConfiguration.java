import java.util.InputMismatchException; //импорт класса для обработки исключений, связанных с неправильным вводом данных, когда программа ожидает один тип данных, но получает другой.
import java.util.Scanner; //импорт класса Scanner, который предназначен для считывания ввода данных
import java.time.LocalDate; //импорт класса LocalDate, который предоставляет методы для работы с датой и временем.
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ComputerConfiguration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<PC> computerList = new ArrayList<>();

        // Массив с предопределенными конфигурациями компьютеров
        String[][] computerConfigs = {
                {"Intel Core i7", "8", "DDR3", "250", "Windows 10 x64", "NVidia GTX 550ti"},
                {"AMD Ryzen 3", "6", "DDR4", "450", "Windows 7 x64"},
                {"AMD FX-4300", "8", "DDR5", "350", "Windows 1 x64", "AMD Radeon RX 580"}
        };


        for (int i = 0; i < computerConfigs.length; i++) {
            String[] config = computerConfigs[i];
            String cpu = config[0];
            int ram = Integer.parseInt(config[1]);
            String ramType = config[2];
            int storage = Integer.parseInt(config[3]);
            String operatingSystem = config[4];

            PC myPC;

            if (config.length == 6) {
                String gpu = config[5];
                myPC = new PC(cpu, ram, ramType, storage, operatingSystem, gpu);
            } else {
                myPC = new PC(cpu, ram, ramType, storage, operatingSystem);
            }

            computerList.add(myPC);
        }

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Создать компьютер");
            System.out.println("2. Поиск компьютеров");
            System.out.println("3. Выйти");
            System.out.print("Выберите действие (1/2/3): ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.skip("\\R");
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода. Введите число от 1 до 3.");
                scanner.nextLine(); // Очистить буфер после ошибочного ввода
                continue;
            }

            switch (choice) {
                case 1:
                    // Создание компьютера и добавление в список
                    PC newPC = createPC(scanner);
                    computerList.add(newPC);
                    break;
                case 2:
                    // Поиск компьютеров
                    System.out.println("Введите критерий поиска (название процессора, видеокарты или операционной системы): ");
                    String searchCriteria = scanner.nextLine(); //критерий, toString() -> в строку

                    searchComputers(searchCriteria.toString(), computerList);
                    break;
                case 3:
                    // Выход из программы
                    scanner.close();
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неправильный выбор. Пожалуйста, выберите 1, 2 или 3.");
            }
        }
    }

    public static PC createPC(Scanner scanner) {
        System.out.println("Введите название процессора: ");
        String cpu = scanner.nextLine();

        System.out.println("Введите объем оперативной памяти (в ГБ): ");
        int ram = 0;

        try {
            ram = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода. Введите целое число.");
            return null;
        }

        // Введите остальные параметры конфигурации (ramType, storage, operatingSystem, gpu) аналогично.

        System.out.println("Введите тип оперативной памяти: ");
        String ramType = scanner.nextLine();

        scanner.nextLine();  //Этот вызов удалит символ переноса строки из буфера обмена (если не удалять символ переноса строки, то при появлении следующего ввода строки, она сразу же и введётся (т.е. будет пустой)

        System.out.println("Введите размер жёсткого диска (в ГБ): ");
        int storage = 0;
        try {
            storage = scanner.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода. Введите целое число.");
            return null;
        }

        System.out.println("Введите название операционной системы: ");
        String operatingSystem = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Введите название видеокарты: ");
        String gpu = scanner.nextLine();

        // Создание экземпляра класса PC
        PC myPC = new PC(cpu, ram, ramType, storage, operatingSystem, gpu);


        System.out.println("Конфигурация компьютера создана.");
        return myPC;
    }

    // Метод для поиска компьютеров по заданным критериям
    public static void searchComputers(String searchCriteria, List<PC> computerList) {
        List<PC> foundComputers = new ArrayList<>();

        for (PC computer : computerList) {
            if (computer.matchesCriteria(searchCriteria)) {
                foundComputers.add(computer);
            }
        }

        if (foundComputers.isEmpty()) {
            System.out.println("Компьютеры, соответствующие критериям поиска, не найдены.");
        } else {
            System.out.println("Найденные компьютеры:");
            for (PC computer : foundComputers) {
                computer.printConfiguration();
                System.out.println("______");
            }
        }

    }
}

//Класс Персональный Компьютер
class PC {
    private String cpu;
    private int ram;
    private String ramType;
    private int storage;
    private String operatingSystem;
    private String gpu;

    //геттеры и сеттеры свойств ↓
    public String getCpu(){return this.cpu;}
    public void setCpu(String newCpu){this.cpu = newCpu;}
    public int getRam(){return this.ram;}
    public void setRam(int newRam){this.ram = newRam;}
    public String getRamType(){return this.ramType;}
    public void setRamType(String newRamType){this.ramType = newRamType;}
    public int getStorage(){return this.storage;}
    public void setStorage(int newStorage){this.storage = newStorage;}
    public String getOperatingSystem(){return this.operatingSystem;}
    public void setOperatingSystem(String newOperatingSystem){this.operatingSystem = newOperatingSystem;}
    public String getGpu(){return this.gpu;}
    public void setGpu(String newGpu){this.gpu = newGpu;}

    // конструктор класса ПК
    public PC(String cpu, int ram, String ramType, int storage, String operatingSystem, String gpu) {
        this.cpu = cpu;
        this.ram = ram;
        this.ramType = ramType;
        this.storage = storage;
        this.operatingSystem = operatingSystem;
        this.gpu = gpu;
    }

    //Конструктор класса ПК без видеокарты
    public PC(String cpu, int ram, String ramType, int storage, String operatingSystem) {
        this.cpu = cpu;
        this.ram = ram;
        this.ramType = ramType;
        this.storage = storage;
        this.operatingSystem = operatingSystem;
        this.gpu = "Интегрированная графика";
    }

    //Метод обновления конфигурации ↓
    public void updateConfiguration(String newCpu, int newRam, String newRamType, int newStorage, String newOperatingSystem, String newGpu) {
        this.setCpu(newCpu);
        this.setRam(newRam);
        this.setRamType(newRamType);
        this.setStorage(newStorage);
        this.setOperatingSystem(newOperatingSystem);
        this.setGpu(newGpu);
        System.out.println("Конфигурация обновлена: " + LocalDate.now());
    }

    //Метод печати конфигурации ↓
    public void printConfiguration() {
        System.out.println("Процессор: " + this.getCpu());
        System.out.println("Оперативная память: " + this.getRam() + " ГБ " + this.getRamType());
        System.out.println("Жёсткий диск: " + this.getStorage() + " ГБ");
        System.out.println("Операционная система: " + this.getOperatingSystem());
        System.out.println("Видеокарта: " + this.getGpu());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = LocalDateTime.now().format(formatter);
        System.out.println("Конфигурация составлена: " + formattedDateTime);
    }


    public boolean matchesCriteria(String searchCriteria) {
        // Пример сравнения названия процессора без учета регистра:
        if (cpu != null && cpu.toLowerCase().contains(searchCriteria.toLowerCase())) {
            return true;
        }
        // Пример сравнения названия операционной системы без учета регистра:
        if (operatingSystem != null && operatingSystem.toLowerCase().contains(searchCriteria.toLowerCase())) {
            return true;
        }
        // Пример сравнения названия видеокарты без учета регистра:
        if (gpu != null && gpu.toLowerCase().contains(searchCriteria.toLowerCase())) {
            return true;
        }
        // Если ни один из критериев не соответствует, вернуть false.
        return false;
    }

}