package ca.bcit.comp2522.lectures.innerClasses;

public class TestBed {
    public void f() {
        System.out.println("glisten()");
    }

    public static class Tester {
        public static void main(String[] args) {
            TestBed t = new TestBed();
            t.f();
        }
    }
}
