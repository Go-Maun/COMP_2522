package ca.bcit.comp2522.lectures.innerClasses;

interface Counter {
    int next();
}

public class LocalInnerClass {
    private int count = 0;

    public static void main(String[] args) {
        LocalInnerClass lic = new LocalInnerClass();
        Counter c1 = lic.getCounter("Local inner ");
        Counter c2 = lic.getCounter2("Anonymous inner ");
        for (int i = 0; i < 5; i++)
            System.out.print(c1.next() + " ");
        for (int i = 0; i < 5; i++)
            System.out.print(c2.next() + " ");
    }

    Counter getCounter(final String name) {

        /* Wow a local inner class! */
        class LocalCounter implements Counter {
            public LocalCounter() {
                // Local inner class can have a constructor
                System.out.println("LocalCounter()");
            }

            public int next() {
                System.out.println(name); // Access local final
                return count++;
            }
        }
        return new LocalCounter();
    }

    // The same thing with an anonymous inner class:
    Counter getCounter2(final String name) {
        return new Counter() {

            // Anonymous inner class cannot have a named
            // constructor, only an "instance initializer":
            {
                System.out.println("Counter()");
            }

            public int next() {
                System.out.println(name); // Access local final
                return count++;
            }
        };
    }
}
