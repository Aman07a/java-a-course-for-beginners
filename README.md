# Java Programming for Complete Beginners
- Java Programming for Beginners to Java Object Oriented Programming.
- Core Java + REST API with Spring Boot. Java 8 to 16.

## Concurrency - Atomic & Collections

### Atomic

As we know, there is a race condition in threads and we use the synchronized keyword to solve it. <br/>
This is a somewhat expensive way, but it is not desired to be used much. That’s why atomic classes are used.

![image](https://github.com/Aman07a/java-a-course-for-beginners/assets/60389872/ed4db647-c2c3-4669-b2df-301949c70d34)

> The classes such as AtomicInteger do not use a lock; rather, they
internally use volatile variables and a low-level mechanism known as
Compare-And-Set (CAS). For this reason, using AtomicInteger and
related classes is faster than using locks using synchronized
keyword.

Let’s look at an example of how we can use the Atomic.

![image](https://github.com/Aman07a/java-a-course-for-beginners/assets/60389872/7c3f7778-3187-40e7-beb8-ca471c18f394)

```java
public class AtomicTest01 {
    public static void main(String[] args) {
        //There is no race condition for atomic
        AtomicInteger atomic = new AtomicInteger();
        atomic.set(10);
        atomic.getAndIncrement(); // c++;
        atomic.incrementAndGet();// ++c;

        System.out.println(atomic);
    }
}
```

```java

// to compare AtomicInteger and Integer example for race condition.
class Counter {
    public static Integer integer = new Integer(0);
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
}

public class AtomicTest02 {
    static class Incrementer extends Thread {
        public void run() {
            Counter.integer++;
            Counter.atomicInteger.incrementAndGet();
        }
    }

    static class Decrementer extends Thread {
        public void run() {
            Counter.integer--;
            Counter.atomicInteger.decrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread incremeterThread[] = new Incrementer[1000];
        Thread decrementerThread[] = new Decrementer[1000];

        for (int i = 0; i < 1000; i++) {
            incremeterThread[i] = new Incrementer();
            decrementerThread[i] = new Decrementer();
            incremeterThread[i].start();
            decrementerThread[i].start();
        }
        for (int i = 0; i < 1000; i++) {
            incremeterThread[i].join();
            decrementerThread[i].join();
        }
        System.out.printf("Integer value = %d AtomicInteger value = %d ", Counter.integer, Counter.atomicInteger.get());
    }
}
```