package student;

import interfaces.ParseFileInterface;
import interfaces.WriteToDbInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentPedin extends Student implements ParseFileInterface, WriteToDbInterface {
    private FileWriter fileWriter;
    private PrintWriter printWriter;

    /**
     * Parses file to ArrayList<String>
     *
     * @param pathToFile
     * @return ArrayList
     */
    @Override
    public ArrayList<String> getArrayListFromFile(String pathToFile) {
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File(pathToFile);
        Scanner sc = new Scanner(System.in);
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc.hasNextLine()) {
            arrayList.add(sc.nextLine());
        }
        return arrayList;
    }

    /**
     * Open connection to MSSQL DB
     */
    private void openConnectionToDb() throws IOException {
        String path = "src/MSSQL-DB.txt";
        fileWriter = new FileWriter(path);
        printWriter = new PrintWriter(fileWriter);
    }

    /**
     * Write student data to database if student is OK
     *
     * @param data in List
     */
    @Override
    public void writeToDb(List<String> data) {
        try {
            openConnectionToDb();
            if (isStudentOk(data)) {
                for (String datum : data) {
                    printWriter.println(getDate() + " - " + datum);
                }
                System.out.println("Written to DB!");
                closeConnectionToDb();
            } else System.out.println("NOT written to DB!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Close connection to MSSQL db
     *
     * @throws IOException
     */
    private void closeConnectionToDb() throws IOException {
        printWriter.close();
        fileWriter.close();
        System.out.println("Close connection to MSSQL DB");
    }
}
