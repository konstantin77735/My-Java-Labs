package stepanyan.konstantin.lab_8_15;

import java.io.*;
import java.util.Scanner;

public class SumPairs {

    public static void createFile(File file) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Файл " + file + " не существует.");
        System.out.println("Сколько элементов будет в " + file.getName() + "?");
        int file_length = scanner.nextInt();
        file.createNewFile();
        BufferedWriter writer_input = new BufferedWriter(new FileWriter(file));

        for (int i = 0; i < file_length; i++) {
            int num = i + 1;
            System.out.println("Введите " + num + "-й элемент:");
            int elem = scanner.nextInt();
            writer_input.write(Integer.toString(elem));
            writer_input.newLine();
        }
        writer_input.close();
    }

    public static void main(String[] args) {
        String dir = "src/stepanyan/konstantin/lab_8_15/";
        String inputFile1 = dir+"input1.txt";
        String inputFile2 = dir+"input2.txt";
        String outputFile = dir+"output.txt";

        Scanner scanner = new Scanner(System.in);
        try {
             // Проверка наличия файлов и создание новых файлов при необходимости
             File file1 = new File(inputFile1);
             if (!file1.exists()) {
                createFile(file1);
             }
 
             File file2 = new File(inputFile2);
             if (!file2.exists()) {
                 createFile(file2);
             }

             File file3 = new File(outputFile);
             if (!file1.exists()) {file3.createNewFile();}


            // Чтение первого файла
            BufferedReader reader1 = new BufferedReader(new FileReader(inputFile1));
            String reader1_line;
            int reader1_count = 0;
            while ((reader1_line = reader1.readLine()) != null) {
                reader1_count++;
                //System.out.println("txt1: "+reader1_line);
            }
            reader1.close();

            // Чтение второго файла
            BufferedReader reader2 = new BufferedReader(new FileReader(inputFile2));
            String reader2_line;
            int reader2_count = 0;
            while ((reader2_line = reader2.readLine()) != null) {
                reader2_count++;
                //System.out.println("txt2: "+reader2_line);
            }
            reader2.close();

            // Открытие третьего файла для записи
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            
            // Чтение обоих файлов и запись попарных сумм в третий файл
            BufferedReader reader3 = new BufferedReader(new FileReader(inputFile1));
            BufferedReader reader4 = new BufferedReader(new FileReader(inputFile2));
            String reader3_count, reader4_count;
            int minCount = Math.min(reader1_count, reader2_count);
            for (int i = 0; i < minCount; i++) {
                reader3_count = reader3.readLine();
                reader4_count = reader4.readLine();
                int num1 = Integer.parseInt(reader3_count);
                int num2 = Integer.parseInt(reader4_count);
                int sum = num1 + num2;
                //System.out.println("num1: " + num1 + "; num2: " + num2 + "; sum: "+sum);
                writer.write(Integer.toString(sum));
                writer.newLine();
            }
            reader3.close();
            reader4.close();

            // Запись числа элементов из короткого файла
            writer.write("Число элементов в коротком файле: "+Integer.toString(Math.min(reader1_count, reader2_count)));
            writer.newLine();


            // Закрытие третьего файла
            writer.close();

            System.out.println("Попарные суммы записаны в файл " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    
}