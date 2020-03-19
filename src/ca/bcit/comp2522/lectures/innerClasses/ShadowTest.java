package ca.bcit.comp2522.lectures.innerClasses;

public class ShadowTest {

    public int x = 0;

    public static void main(String... args) {
        ShadowTest st = new ShadowTest();
        FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.x = " + ShadowTest.this.x);
            System.out.println("x = " + x);
        }
    }
}