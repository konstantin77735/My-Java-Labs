package stepanyan.konstantin.lab_8_15.rewriteWords;
import stepanyan.konstantin.lab_8_15.CreateFile;

import java.io.*;
import java.util.Scanner;

public class RewriteWords {
    public static void main(String[] args) throws IOException {
        String dir = "src/stepanyan/konstantin/lab_8_15/rewriteWords/";
        String inputFile = dir + "f.txt";
        String outputFile = dir + "g.txt";

        Scanner scanner = new Scanner(System.in);

        File input = new File(inputFile);
        if (!input.exists()){new CreateFile(input);}

        File output = new File(outputFile);
        if (!output.exists()){output.createNewFile();}



        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // разбиваем строку на слова по пробелам
                for (String word : words) {
                    if (word.length() > 1) { // если длина слова больше 1 символа
                        char lastChar = word.charAt(word.length() - 1); // запоминаем последний символ
                        String newWord = lastChar + word.substring(0, word.length() - 1); // создаем новое слово с перенесенной последней буквой
                        writer.write(newWord + " "); // записываем слово в выходной файл с пробелом в конце
                    } else {
                        writer.write(word + " "); // записываем слово без изменений в выходной файл с пробелом в конце
                    }
                }
                writer.newLine(); // переходим на новую строку в выходном файле
            }
            System.out.println("Файл " + output.getName() + " успешно создан.");

        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}