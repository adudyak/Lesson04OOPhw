package runner;

import student.StudentPedin;
import java.util.ArrayList;

public class Runner {

    /**
     * Add some student to DB
     *
     * @param args
     */
    public static void main(String[] args) {

        // Create instance of student
        StudentPedin studentPedin = new StudentPedin();

        // Imagine that GUI opens
        studentPedin.openGui();

        // Parse data
        ArrayList<String> student = studentPedin.getArrayListFromFile("src/MSSQL-DB.txt");
        System.out.println(student);

        // Write data
        studentPedin.writeToDb(student);
    }
}