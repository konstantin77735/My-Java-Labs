package stepanyan.konstantin.coursework;
import konstantin.stepanyan.coursework.PC;

import java.util.InputMismatchException; //импорт класса для обработки исключений, связанных с неправильным вводом данных, когда программа ожидает один тип данных, но получает другой.
import java.util.Scanner; //импорт класса Scanner, который предназначен для считывания ввода данных
import java.time.LocalDate; //импорт класса LocalDate, который предоставляет методы для работы с датой и временем.
import java.util.ArrayList;
import java.util.List;

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
