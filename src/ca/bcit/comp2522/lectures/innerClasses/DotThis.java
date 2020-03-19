package ca.bcit.comp2522.lectures.innerClasses;

public class DotThis {
    public static void main(String[] args) {
        DotThis dt = new DotThis();
        Inner dti = dt.inner();
        dti.outer().f();
    }

    void f() {
        System.out.println("DotThis.glisten()");
    }

    public Inner inner() {
        return new Inner();
    }

    public class Inner {
        public DotThis outer() {
            return DotThis.this;
            // A plain "this" would be Inner's "this"
        }
    }
}
