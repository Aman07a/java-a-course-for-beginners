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

- We added for loops to increment/decrement the integer value.
- When we run the application, we will see that IntegerValue is changeable because  of the race condition. But AtomicInteger value is a constant and true result.

```java
Integer value = 2 AtomicInteger value = 0
```

### Concurrent Collections

- The java.util.concurrent package provides a number of classes that are thread-safe equivalents of the ones provided in the collections framework classes in the java.util package.
- For example, java.util.concurrent.ConcurrentHashMap is a concurrent equivalent to java.util.HashMap.
- The main difference between these two containers is that you need to explicitly synchronize insertions and deletions with HashMap,
whereas such synchronization is built into the ConcurrentHashMap.
- It is better to use a concurrent collection class anytime that we are going to have multiple threads modify a collection object outside a synchronized block or method, even if you don’t expect a concurrency problem.

There is a bad approach to working with collections,

```java
public class ConcurrentCollectionsTest01ZooManagerBadApproach {
    private Map<String, Object> foodData = new HashMap<String, Object>();

    public synchronized void put(String key, String value) {
        foodData.put(key, value);
    }

    public synchronized Object get(String key) {
        return foodData.get(key);
    }
}
```

Because it is better approach using ConcurrentHashMap rather than synchronized.

```java
public class ConcurrentCollectionsTest02ZooManagerGoodApproach {
    //ConcurrentHashMap provides higher performance under high read-write operations compared to similar data structures.
    private Map<String, String> foodData = new ConcurrentHashMap<>();

    // its better approach to use ConcurrentHashMap rather than  synchronized
    //These methods are thread-safe.
    public void put(String key, String value) {
        foodData.put(key, value);
    }

    public String get(String key) {
        return foodData.get(key);
    }
}
```

> ConcurrentHashMap provides higher performance under high read-write operations compared to similar data structures.

Let’s look at another example;
If we want to add a new item while reading the Array or something.

```java
public class ConcurrentCollectionTest03ModifyList {
    public static void main(String[] args) {
        List<String> aList = new ArrayList<>();
        aList.add("one");
        aList.add("two");
        aList.add("three");
        Iterator<String> listIter = aList.iterator();
      
        while(listIter.hasNext()) {
            System.out.println(listIter.next());
            aList.add("four");
            // java.util.ConcurrentModificationException
        }
    }
}
```

- When we run this application, we will get an error.
- ArrayList is fail-fast. That’s why we get an error java.util.ConcurrentModificationException
- We can use -> new CopyOnWriteArrayList<>(); rather than ArrayList.

```java
public class ConcurrentCollectionTest04COWList {
    public static void main(String[] args) {
        List<String> aList = new CopyOnWriteArrayList<>();
        aList.add("one");
        aList.add("two");
        aList.add("three");
        Iterator<String> listIter = aList.iterator();
        while (listIter.hasNext()) {
            System.out.println(listIter.next());
            aList.add("four");
        }

        System.out.println(aList);
    }
}
```

> CopyOnWriteArrayList is commonly used in multi-threaded environment situations where reads far more than writes.

```shell
Output:
one
two
three
[one, two, three, four, four, four]
```

### Synchronized Collections

#### When Can we use these methods?

- If we know at the time of creation that your object requires synchronization, then you should use one of the concurrent collection classes listed.

- On the other hand, if we are given an existing collection that is not a concurrent class and needs to access it among multiple threads, you can wrap it using the methods. (SynchronizedCollection,List,Map..)

- While the methods in (SynchronizedCollection,List,Map..)

- They do not synchronize access on any iterators that you synchronize may create from the synchronized collection. Therefore, it is imperative that we use a synchronization block. If we need to iterate over any of the returned collections is synchronized collection methods.

```java
public class SynchronizedCollectionsTest01 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> scynchronizedList = Collections.synchronizedList(numbers);

    }
}
```

#### What is the difference between Collections.synchronizedList and Concurrent Collection?

When we use the synchronized keyword like the below,

```java
       synchronized(this) {
         numbers.add(....);
       }
```

- One thread works in the method. So, just method is blocked.
- But when we use Collections.synchronizedList, all collections will be locked.

> For Concurrent Collection
More than 1 thread may work on the same collection.
Lock mechanism is not on all collection.
The logic here is that more than one thread cannot run/work on the same element/index.