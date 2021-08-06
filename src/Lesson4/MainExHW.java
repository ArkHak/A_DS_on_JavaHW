package Lesson4;

public class MainExHW {
    public static void main(String[] args) {
        SimpleLinkedListImplEx1<String> linkedList = new SimpleLinkedListImplEx1<>();

        linkedList.insertFirst("Oleg");
        linkedList.insertFirst("Ivan");
        linkedList.insertFirst("Tim");
        linkedList.insertFirst("Igor");

//        linkedList.display();

        linkedList.forEach();

    }
}
