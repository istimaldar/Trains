package com.istimaldar.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

class ListUtils {

    static <T> void serializeList(List<T> list, String name) {
        try (ObjectOutputStream oos =
                      new ObjectOutputStream(new FileOutputStream(name))) {
            oos.writeObject(list);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    static <T> List<T> deserialzeList(List<T> list, String name) {
        List<?> temporaryList;
        try (ObjectInputStream ois
                     = new ObjectInputStream(new FileInputStream(name))) {
            temporaryList = (List<?>) ois.readObject();
            list.clear();
            for (Object element : temporaryList) {
                if (element != null) {
                    try {
                        list.add((T) element);
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

}
