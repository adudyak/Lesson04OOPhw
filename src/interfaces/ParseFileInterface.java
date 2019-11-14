package interfaces;

import java.util.ArrayList;

public interface ParseFileInterface {
    //В пекедж с интерфейсами добавляем новый интерфейс ParseFileInterface с методом который принимает параметр строку pathToFile и возвращает ArrayList.

    /**
     * Gets Array List from file
     * @param pathToFile
     * @return Array List
     */
    ArrayList<String> getArrayListFromFile(String pathToFile);
}
