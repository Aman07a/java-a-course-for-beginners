# Java Programming for Complete Beginners
- Java Programming for Beginners to Java Object Oriented Programming. 
- Core Java + REST API with Spring Boot. Java 8 to 16.

## Sectie 18: Introduction to Threads And Concurrency in Java

Java Concurrency is the capability of the Java platform to run multiple operations simultaneously. The operations could be multiple Java programs or parts of a single Java program. Java Concurrency relies on two essential components such as threads and processes. Of the two components, threads play a significant role. With Java Concurrency or using multiple threads, you can enhance the performance of processors. You don’t need multiple processors for running concurrent programs in Java; instead, you can use a single multi-core processor. Know that a multi-core processor will have many cores in a single CPU. All these multiple cores can run many programs or parts of a program simultaneously.

We have designed this tutorial for you to learn more about Java Concurrency. In the way ahead, you will quickly learn about processes and threads, thread objects, Java Concurrency models, synchronization, liveliness, immutable objects, and high-level concurrency. Let’s dive into the topics.

### What is Concurrency Software?
Software that can run multiple operations simultaneously is referred to as concurrency software. In other words, the software can run many programs or sections of the same program in parallel. You can consider a word processor if you want to relate the concept of concurrency software with a real-time example. A word processor can format texts, respond to mouse and keyboard operations, and print documents simultaneously. Similarly, an audio streaming application is another example of concurrency because audio applications can read the digital audio from networks, playback, decompress it, and update the display – notably, all at the same time.

### What is Java Concurrency?
As you know, Java is one of the popular programming languages. It supports concurrency with its Java class libraries and high-level concurrency APIs. Package Java .util.concurrent is the package used for concurrent programming in Java. This package consists of classes with useful functionalities, standardised small and extensible frameworks, and many more. Additionally, Java comes with packages such as Package Java.util.concurrent.locks and Java.util.concurrent.atomic packages. With these frameworks, packages, and classes, you can run long and complex Java programs using threads. Or, in other words, you can run concurrent programs. As a result, you can save time and increase throughput significantly by running a program using Java Concurrency.

### What are Processes and Threads?
Processes and Threads are the essential elements of Java Concurrency. Mainly, they support creating an advanced execution environment in Java. In a way, it is a self-contained environment.

Let’s look at them in detail below:

1. **Processes**: A process is nothing but a complete and private set of runtime resources. Each process has its own memory. Pipes and sockets help to communicate between processes in a system. Not only that, they encourage communication between different systems as well. Note that pipes and sockets are known as inter-process communication elements.
2. **Threads**: They are the core of Java Concurrency and exist inside a process. Every process will have at least one thread. In a way, a thread is a virtual CPU where you can run Java codes. An application can have many threads and run them concurrently. Generally, threads follow the priority. So, the thread that has high-priority runs first. Know that threads use the same resources used by processes. The resources may be memory or open files, or any other. Besides, creating a thread requires fewer resources than creating a process.

![output-onlinepngtools (1)](https://github.com/Aman07a/java-a-course-for-beginners/assets/60389872/43558af3-9574-4e3b-adc1-abd112ab1028)

### What are Thread Objects?
Know that each thread is connected with an instance of the Thread class. Java Concurrency offers two methods through which you can create concurrency in applications with thread objects. If you want to control thread creation and management directly, you have to instantiate the Thread class whenever the application requires initiating an asynchronous task. Similarly, if you want to abstract the thread creation and management from the rest of the application, you must pass the applications' tasks to executors.

Let’s discuss the use of thread objects below:

1. **Starting and Pausing Threads:** Applications can create instances of Threads and run codes in the threads. It is achieved in two ways – providing a Runnable object and using a subclass Thread. When it comes to pausing threads, the Thread.sleep object is used to suspend the current thread's execution for a defined period. During this pause period, other threads can use processors. Even other applications can use the processors during this pause period.
2. **Interrupts and Joins:** In Java Concurrency, you can apply interrupts to stop the operations of threads and direct them to perform other tasks. When an interrupt is applied, it enables an interrupt flag to communicate the interrupt status. Here, the object Thread.interrupt is used to set the flag. If you want to clear the flag status, you need to invoke Thread.interrupted, which is a static method. Similarly, isInterrupted is the non-static method used by one thread to query the interrupt status of another thread. Moreover, you can use the join method to make one thread wait for another until it completes its task.

### What are the Different Java Concurrency Models?
Essentially, concurrency models describe the different ways of communication that can be taken place between threads. There are three basic models used in Java Concurrency, as discussed below:

1. Parallel Workers Model

   In this model, the main program is divided into many subprograms. These subprograms will run across different threads or workers of the model in parallel. Here, each thread or worker will run a different task. The main thing about this model is that it doesn't allow a single thread or worker to be idle. In other words, every thread or worker will be running a part of a program.

   ![output-onlinepngtools (2)](https://github.com/Aman07a/java-a-course-for-beginners/assets/60389872/adc161fb-50ca-418e-b65f-e9450bcfcf26)

2. Assembly Line Model

   This model is also known as a Reactive or Event-driven model. In this model, you can run tasks across the different threads in the assembly line. Every thread or worker in the assembly line will have a different task but run sequentially in one direction. Once a task is completed by a thread, it will be moved to the following thread. Know that this model uses non-blocking I/O. According to this model, the CPU doesn’t waste time running the I/O operation. Note that you must use multiple assembly lines to execute a complete program.

   ![output-onlinepngtools (3)](https://github.com/Aman07a/java-a-course-for-beginners/assets/60389872/aa21a88b-2d22-45e1-9ccc-d1cd38b98ec6)

3. Functional Parallelism
   This model uses multiple CPUs to run multiple tasks simultaneously. It is accomplished by using function calls. Here, every function call runs independently. It means that function calls are executed in separate CPUs.

### What is Synchronization in Java Concurrency?

Generally, threads communicate by sharing access to fields and the content that object reference fields refer to. But, it creates two types of errors: thread interference and memory consistency. Synchronization is the tool that helps to overcome these errors.

At first, let’s discuss thread interference and memory consistency errors as below:

 - **Thread Interference:** It is a simple but vital note that this error occurs because of interleaving. It means that two operations in two different threads act on the same data. In other words, this error occurs when sequences of steps in two threads overlap with each other.
 - **Memory Consistency Error:** This error occurs when threads have inconsistent views about what must be the ‘same data’. In fact, the causes for this error are complex. And this error can be overcome by understanding the ‘happens-before’ relationship. This relationship ensures that memory writes done by one statement are visible to another. Know that synchronization is one of the actions that create ‘happens-before’ relationships. That’s why it is used to overcome memory consistency errors.

If you are wondering how to overcome these errors, read the following. Here, we will see synchronized methods and how they prevent the above-said errors.

In Java Concurrency, synchronized methods help to prevent thread interference and memory inconsistency error. When you make reads and writes of an object’s variables through synchronized methods, you can make the object visible to more than one thread. As a result, you can overcome the errors mentioned effectively.

Atomic access is one of the crucial aspects of synchronization. Let’s see now what atomic access is.

In Java Concurrency, atomic action occurs either entirely or not at all. You cannot see any side effects of atomic action until it is entirely run. For instance, reads and writes are atomic actions for reference and primitive variables except for long and double variables. Similarly, reads and writes are atomic actions for all volatile variables, including long and double variables.

