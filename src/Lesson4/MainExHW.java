package Lesson4;

public class MainExHW {
    public static void main(String[] args) {

//        ex1();
        ex2();

    }

    private static void ex1() {
        SimpleLinkedListImplEx1<String> linkedList = new SimpleLinkedListImplEx1<>();
        linkedList.insertFirst("Oleg");
        linkedList.insertFirst("Ivan");
        linkedList.insertFirst("Tim");
        linkedList.insertFirst("Igor");

//        linkedList.display();

        linkedList.forEach();
    }

    private static void ex2() {
//        TwoSideLinkedListImplEx2<String> twoSideLinkedList = new TwoSideLinkedListImplEx2<>();
//        twoSideLinkedList.insertFirst("Oleg");
//        twoSideLinkedList.insertLast("Ivan");
//        twoSideLinkedList.insertFirst("Tim");
//        twoSideLinkedList.insertLast("Igor");
//        twoSideLinkedList.insertLast("Julia");
//
//        twoSideLinkedList.display();

        TwoSideLinkedListImplEx2.DequeListEx2 list = new TwoSideLinkedListImplEx2.DequeListEx2();

        list.pushFront("Oleg");
        list.pushBack("Ivan");
        list.pushFront("Tim");
        list.pushBack("Igor");
        list.pushBack("Julia");

        list.display();

        list.popBack();

        list.display();


    }
}
