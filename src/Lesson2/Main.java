package Lesson2;
// Условия дз.
//      1. Отсортировать массив, состоящий из экземпляров класса Notebook в количестве 5000 штук.
//        Условия для сортировки:
//          1) по цене. От 500 до 1000 долларов с шагом в 100
//        если цена равная, то
//          2) по кол-ву оперативной памяти (от 4 до 12 с шагом 4)
//        если памяти тоже равное количество, то
//          3) по производителю:
//        Lenuvo > Asos > MacNote > Eser > Xamiou
//        Добиваться максимально оптимальной сложности О-большая
public class Main {

    public static void main(String[] args) {
        final int DEF_SIZE = 5000;

        Notebook[] noteArr = Notebook.getArray(DEF_SIZE);

//        более компактное исполнение с применением встроенных механизмов
        System.out.println("Исходный массив: ");
        display(noteArr);
        System.out.println();
        System.out.println("(через встроенный sort+compareTo)Сортированный массив: ");
        SortArr.sortDef(noteArr);
        display(noteArr);
        System.out.println();

        Notebook[] noteArrDef = Notebook.getArray(DEF_SIZE);

        System.out.println("Исходный массив: ");
        display(noteArrDef);
        System.out.println();
        System.out.println("(через собственную sort)Сортированный массив: ");
        SortArr.sortMy(noteArrDef);
        display(noteArrDef);
    }

    public static void display(Notebook[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].getId() + ": " + arr[i].getManufacturer() + " "
                    + arr[i].getRAM() + " " + arr[i].getPrice());
        }
    }
}