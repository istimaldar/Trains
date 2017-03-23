package utils;

import java.util.ArrayList;

import static utils.Constants.READER;

/**
 * Created by istimaldar on 23.03.2017.
 */
public class MenuUtils {
    public static int printMenu(String header, String [] variants) {
        System.out.println(header);
        for (int i = 0; i < variants.length; i++) {
            System.out.println((i + 1) + ". " + variants[i]);
        }
        return READER.nextInt() - 1;
    }

    public static <T> String[] toStringArray(ArrayList<T> list) {
        String [] result = new String[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i).toString();
        }
        return result;
    }
}
