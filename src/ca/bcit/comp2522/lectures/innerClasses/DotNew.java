package ca.bcit.comp2522.lectures.innerClasses;

public class DotNew {
    public static void main(String[] args) {
        DotNew dn = new DotNew();
        Inner dni = dn.new Inner();
    }

    public class Inner {
    }
}
