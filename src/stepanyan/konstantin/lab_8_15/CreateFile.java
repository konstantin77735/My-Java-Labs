package stepanyan.konstantin.lab_8_15;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CreateFile {
    public CreateFile(File file) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Файл " + file.getName() + " не существует.");
        System.out.println("Сколько элементов будет в " + file.getName() + "? (Ответ в int)");
        int file_length = scanner.nextInt();
        file.createNewFile();
        BufferedWriter writer_input = new BufferedWriter(new FileWriter(file));

        for (int i = 0; i < file_length; i++) {
            int num = i + 1;
            System.out.println("Введите " + num + "-й элемент:"); //(double числа через точку)
            String elem = scanner.next();
            writer_input.write(elem);
            writer_input.newLine();
        }
        writer_input.close();
    }
}
