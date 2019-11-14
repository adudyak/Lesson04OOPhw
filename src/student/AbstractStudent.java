package student;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class AbstractStudent {

    /**
     * Parse data from GUI
     *
     * @return list with student data
     */
    public List<String> parseData() {
        List<String> data = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter name of student:");
        String name = scanner.nextLine();
        if (isLineNotEmpty(name)) {
            data.add(name);
        }

        System.out.println("Please enter age of student:");
        String age = scanner.nextLine();
        if (isLineNotEmpty(age)) {
            data.add(age);
        }

        System.out.println("Please enter sex of student:");
        String sex = scanner.nextLine();
        if (isLineNotEmpty(sex)) {
            data.add(sex);
        }

        return data;
    }

    /**
     * Opens GUI
     */
    public void openGui() {
        System.out.println("Opened GUI");
    }

    /**
     * Verify if ArrayList with student is OK
     *
     * @param list
     * @return true/false
     */
    public boolean isStudentOk(List<String> list) {
        String nameSurnameRegExpString = "^[a-zA-Z'-]+$";
        String maleFemaleRegExpString = "^(male|female)$";
        if (Pattern.compile(nameSurnameRegExpString).matcher(list.get(0)).find()
                && Pattern.compile(nameSurnameRegExpString).matcher(list.get(1)).find()
                && Integer.parseInt(list.get(2)) > 16
                && Integer.parseInt(list.get(2)) < 26
                && Pattern.compile(maleFemaleRegExpString).matcher(list.get(3).toLowerCase()).find())
        {
            System.out.println("Student is OK");
            return true;
        }
        System.out.println("Student NOT OK");
        return false;
    }

    /**
     * Verify that string is not empty
     *
     * @param line
     * @return
     */
    private boolean isLineNotEmpty(String line) {
        if (!line.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Get date
     *
     * @return string that represents current date and time
     */
    public String getDate() {
        return new SimpleDateFormat("YYYY-MM-dd HH:mm:ss")
                .format(Calendar.getInstance().getTime());
    }


}
