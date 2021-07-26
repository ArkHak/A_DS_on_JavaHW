package Lesson2;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//QuickSort глупое применнеие
public class SortArr {
    public static List<Notebook> quickSortPrice(List<Notebook> arr) {

        if (arr.isEmpty()) {
            return arr;
        }

        Notebook base = arr.get(0);

        List<Notebook> left = new LinkedList<>();
        List<Notebook> middle = new LinkedList<>();
        List<Notebook> right = new LinkedList<>();

        for (Notebook note : arr) {
            if (note.getPrice() == base.getPrice()) {
                middle.add(note);
            } else if (note.getPrice() > base.getPrice()) {
                right.add(note);
            } else {
                left.add(note);
            }
        }

        left = quickSortPrice(left);
        right = quickSortPrice(right);

        left.addAll(middle);
        left.addAll(right);

        return left;
    }

    public static List<Notebook> quickSortRAM(List<Notebook> arr) {

        if (arr.isEmpty()) {
            return arr;
        }

        Notebook base = arr.get(0);

        List<Notebook> left = new LinkedList<>();
        List<Notebook> middle = new LinkedList<>();
        List<Notebook> right = new LinkedList<>();

        for (Notebook note : arr) {
            if (note.getRAM() == base.getRAM()) {
                middle.add(note);
            } else if (note.getRAM() > base.getRAM()) {
                right.add(note);
            } else {
                left.add(note);
            }
        }

        left = quickSortRAM(left);
        right = quickSortRAM(right);

        left.addAll(middle);
        left.addAll(right);

        return left;
    }

    public static List<Notebook> quickSortManID(List<Notebook> arr) {

        if (arr.isEmpty()) {
            return arr;
        }

        Notebook base = arr.get(0);

        List<Notebook> left = new LinkedList<>();
        List<Notebook> middle = new LinkedList<>();
        List<Notebook> right = new LinkedList<>();

        for (Notebook note : arr) {
            if (note.getManufacturerID() == base.getManufacturerID()) {
                middle.add(note);
            } else if (note.getManufacturerID() > base.getManufacturerID()) {
                right.add(note);
            } else {
                left.add(note);
            }
        }

        left = quickSortManID(left);
        right = quickSortManID(right);

        left.addAll(middle);
        left.addAll(right);

        return left;
    }

    public static void sortMy(Notebook[] arr) {
        List<Notebook> list = Arrays.asList(arr);

        quickSortManID(list).toArray(arr);
        quickSortRAM(list).toArray(arr);
        quickSortPrice(list).toArray(arr);
    }

    public static void sortDef(Notebook[] arr) {
        List<Notebook> list = Arrays.asList(arr);
        Collections.sort(list);
    }
}
