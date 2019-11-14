package student;

import interfaces.ParseFileInterface;
import interfaces.WriteToDbInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentPedin extends Student implements ParseFileInterface, WriteToDbInterface {
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
     * Write student data to database if student is OK
     *
     * @param data in List
     */
    @Override
    public void writeToDb(List<String> data) {
        if (isStudentOk(data))
            System.out.println("Written to DB!");
        else System.out.println("NOT written to DB!");
    }
}
