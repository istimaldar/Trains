package com.istimaldar.utils;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by istimaldar on 23.03.2017.
 */
public class MenuUtils {
    public static int printMenu(String header, String [] variants) {
        int selected = 0;
        try(Scanner reader = new Scanner(System.in)) {
            System.out.println(header);
            for (int i = 0; i < variants.length; i++) {
                System.out.println((i + 1) + ". " + variants[i]);
            }
            selected = reader.nextInt() - 1;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return selected;
    }

    public static <T> String[] toStringArray(ArrayList<T> list) {
        String [] result = new String[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i).toString();
        }
        return result;
    }
}
