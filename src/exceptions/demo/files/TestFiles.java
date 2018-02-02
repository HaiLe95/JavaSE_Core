package exceptions.demo.files;

import java.io.*;
import java.util.logging.Logger;

public class TestFiles {

    public static void main(String[] args) {
        writeTextToFile();
        readTextFromFile();
    }

    private static void writeTextToFile() {
        System.out.println("Запись текстовых данных в файл");
        try {
            Writer writer = new FileWriter("C:\\Java\\tempo\\file.txt");
            writer.write("test string1\n");
            writer.write("test string2");
            writer.flush(); // без этого метода, файл не запишется
            writer.close(); // всегда нужно закрывать связь с ресурсом
        } catch (IOException e) {
            //Logger
            e.printStackTrace();
        }
    }

    private static void readTextFromFile() {
        try {
            System.out.println("Чтение текстовых данных из файла");
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Java\\tempo\\file.txt"));
            String str;
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readBytesFromFile() {
        System.out.println("Чтение данных из файла по байтам");
        BufferedInputStream bufferedInputStream = null;
        byte[] buffer = new byte[10];
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream("C\\Java\\tempo\\file.txt"));
            int readBytes = 0;
            while ((readBytes = bufferedInputStream.read(buffer)) != -1) {
                String str = new String(buffer);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
