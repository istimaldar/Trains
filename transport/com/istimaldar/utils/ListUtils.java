package com.istimaldar.utils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.ListIterator;

/**
 * Created by istimaldar on 20.03.2017.
 */
public class ListUtils {

    public static void serializeObject(Object object, String name) {
        try (ObjectOutputStream oos =
                      new ObjectOutputStream(new FileOutputStream(name))) {
            oos.writeObject(object);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Object deserialzeObject(String name) {
        try (ObjectInputStream ois
                     = new ObjectInputStream(new FileInputStream(name))) {
            return ois.readObject();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
