package stepanyan.konstantin.lab_8_15.FileIOExample;
import java.io.*; import java.util.ArrayList; import java.util.List; import java.util.Scanner;

public class FileIOExample {
    private static final String DIR = "src/stepanyan/konstantin/lab_8_15/FileIOExample/";
    private static final String FILE_NAME = "data.txt";
    private static final String FILE_PATH = DIR+FILE_NAME;

    public static void main(String[] args) {
        List<String> collection = new ArrayList<>();

        //если файл коллекции data.txt существует,
        //то коллекция изначально загружается из него
        collection = loadCollectionFromFile();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Посмотреть элементы коллекции");
            System.out.println("2. Добавить элемент в коллекцию");
            System.out.println("3. Сохранить коллекцию в файл");
            System.out.println("4. Загрузить коллекцию из файла");
            System.out.println("0. Выйти");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if(collection.size()==0){System.out.println("Коллекция пустая.");}
                    else{
                        System.out.println("Коллекция:");
                        for (int i = 0; i<collection.size(); i++) {
                            int number = i+1;
                            String element = collection.get(i);
                            System.out.println(number+"-й элемент: "+element);}
                    }
                    break;
                case 2:
                    System.out.print("Введите элемент: ");
                    String element = scanner.next();
                    collection.add(element);
                    break;
                case 3:
                    saveCollectionToFile(collection);
                    break;
                case 4:
                    collection = loadCollectionFromFile();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }

            System.out.println();
        }
    }

    private static void saveCollectionToFile(List<String> collection) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH);

             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            //
            for (String element : collection) {
                bufferedWriter.write(element);
                bufferedWriter.newLine();
            }
            bufferedWriter.close(); //в IntellijIdea не сразу отображается файл, а в проводнике сразу
            System.out.println("Коллекция сохранена в файл " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении коллекции в файл.");
        }
        System.out.println("_____");
    }

    private static List<String> loadCollectionFromFile() {
        List<String> collection = new ArrayList<>();

        try (FileReader fileReader = new FileReader(FILE_PATH);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                collection.add(line);
            }
            System.out.println("Коллекция загружена из файла " + FILE_NAME);
        } catch (FileNotFoundException e) {
            System.out.println("Файл коллекции не найден.");
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке коллекции из файла.");
        }
        System.out.println("_____");

        return collection;
    }
}