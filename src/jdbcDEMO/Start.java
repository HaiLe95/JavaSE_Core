package jdbcDEMO;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Start {


    public static void writeTextToFile(String s) {
        try {
            Writer fileWriter = new FileWriter("result.txt");
            fileWriter.write(s);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public static void main(String[] args) {
        try {
            StringBuilder builder = new StringBuilder();
            Scanner scan = new Scanner(new FileInputStream("sql.txt"), "UTF-8");

            String dbPath = scan.nextLine();

            System.out.println("База данных:" + dbPath);

            if (!new File(dbPath).exists()) {
                System.out.println("Файл базы данных не найден");
                return;
            }

            DBUtils.openConnection(dbPath);

//            DBUtils.showPrepStatement();

            try {
                while (scan.hasNextLine()) {
                    builder.append(scan.nextLine());
                }
            } finally {
                scan.close();
            }

            String[] sql = builder.toString().split(";");

            StringBuilder result = new StringBuilder();

            for (String sqlString : sql) {
                result.append("Запрос: " + sqlString + "\n");
                result.append("Результат: " + "\n");
                ArrayList<SprObject> list = DBUtils.getResultList(sqlString);

                for (SprObject sprObject : list) {
                    result.append(sprObject.getId() + ", " + sprObject.getName_en() + ", " + sprObject.getName_ru() + "\n");
                }
                result.append("\n");
            }

            System.out.println(result.toString());

            writeTextToFile(result.toString());

            DBUtils.closeConnection();


        } catch (Exception e) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, e);
        }


    }
}

