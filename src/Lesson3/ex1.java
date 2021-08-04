package Lesson3;
//
//1. Дан массив из n элементов, начиная с 1. Каждый следующий элемент равен (предыдущий + 1). Но в массиве гарантированно 1 число пропущено. Необходимо вывести на экран пропущенное число.
//        Примеры:
//        [1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16] => 11
//        [1, 2, 4, 5, 6] => 3
//        [] => 1

public class ex1 {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16};
        int[] arr2 = {1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int[] arr3 = {1, 2, 4, 5, 6};
        int[] arr4 = {};
        int[] arr5 = {2, 3, 4};
        int[] arr6 = {1, 2, 3, 4, 6};

        System.out.println(searchPass(arr1));
        System.out.println(searchPass(arr2));
        System.out.println(searchPass(arr3));
        System.out.println(searchPass(arr4));
        System.out.println(searchPass(arr5));
        System.out.println(searchPass(arr6));
    }

    public static int searchPass(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int base;

        if (arr.length != 0) {
            if (arr[start] == 2) return 1;
        }

        while (end >= start) {
            base = (start + end) / 2;

//проверка на предпослений элемент
            if (end - start == 1) return arr[end] - 1;

            if (base == arr[base] - 1) {
                start = base;

            } else if (base - 1 == arr[base - 1] - 1) {
                return arr[base - 1] + 1;

            } else {
                end = base;
            }
        }
        return 1;
    }
}
