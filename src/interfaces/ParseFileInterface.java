package interfaces;

import java.util.ArrayList;

public interface ParseFileInterface {
    //В пекедж с интерфейсами добавляем новый интерфейс ParseFileInterface с методом который принимает параметр строку pathToFile и возвращает ArrayList.

    /**
     * Adds each line from text file to Array List
     *
     * @param pathToFile
     * @return ArrayList<String>
     */
    ArrayList<String> getArrayListFromFile(String pathToFile);
}
