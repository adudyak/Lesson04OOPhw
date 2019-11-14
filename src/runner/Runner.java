package runner;

import student.StudentPedin;
import java.util.ArrayList;

public class Runner {

    /**
     * Add some student to DBs
     *
     * @param args
     */
    public static void main(String[] args) {

        // Create instance of student
        StudentPedin studentPedin = new StudentPedin();

        // Imagine that GUI opens

        studentPedin.openGui();

        // Parse data
        ArrayList<String> student = studentPedin.getArrayListFromFile("c:\\Users\\AlexD\\IdeaProjects\\Lesson04OOPhw\\src\\MSSQL-DB.txt");
        System.out.println(student);

        //Verify and write data
        if (studentPedin.isStudentOk(student)) studentPedin.writeToDb(student);
    }
}