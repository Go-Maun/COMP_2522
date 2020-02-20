package ca.bcit.comp2522.lectures.week05.exceptions;

class YetAnotherException extends Exception {

    private int i;

    public YetAnotherException() {
    }

    public YetAnotherException(String msg) {
        super(msg);
    }

    public YetAnotherException(String msg, int x) {
        super(msg);
        i = x;
    }

    public int val() {
        return i;
    }
}

public class ExtraFeatures {
    public static void f() throws YetAnotherException {
        System.out.println("Throwing MyException2 from glisten()");
        throw new YetAnotherException();
    }

    public static void g() throws YetAnotherException {
        System.out.println("Throwing MyException2 from crack()");
        throw new YetAnotherException("Originated in crack()");
    }

    public static void h() throws YetAnotherException {
        System.out.println("Throwing YetAnotherException from h()");
        throw new YetAnotherException("Originated in h()", 47);
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (YetAnotherException e) {
            e.printStackTrace(System.err);
        }
        try {
            g();
        } catch (YetAnotherException e) {
            e.printStackTrace(System.err);
        }
        try {
            h();
        } catch (YetAnotherException e) {
            e.printStackTrace(System.err);
            System.err.println("e.val() = " + e.val());
        }
    }
}