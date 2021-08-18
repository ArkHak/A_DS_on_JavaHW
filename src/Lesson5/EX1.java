package Lesson5;

public class EX1 {
    public static void main(String[] args) {
        ex1Pow(2, 4);
        ex1Pow(4, 8);
        ex1Pow(4, 0);
    }

    private static void ex1Pow(int base, int degree) {
        System.out.println(base + "^" + degree + "=" + pow(base, degree));
    }

    private static int pow(int base, int degree) {
        if (degree == 0)
            return 1;
        if (degree % 2 == 1)
            return pow (base, degree-1) * base;
        else {
            int b = pow (base, degree/2);
            return b * b;
        }
    }

}
