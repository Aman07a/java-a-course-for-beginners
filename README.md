# Java Programming for Complete Beginners
- Java Programming for Beginners to Java Object Oriented Programming. 
- Core Java + REST API with Spring Boot. Java 8 to 16.

## Functional Programming in Java
Java functional programming comes into existence after Java 8th version onwards. Functional programming means a fundamental change in the approach of problem-solving. Functional programming allowing programming with expressions (declaring functions), passing functions as arguments and also used functions as statements.

**Types of Functional Programming**
- Streams functional Programming
- Lambda Expressions functional Programming
- Method Reference functional Programming

### How does Functional programming work in Java?

Before we get into the functional programming concept, let’s see the difference between Functional and Structure programming. Structured programming gives importance to logical structure or process, whereas Functional programming mainly focuses on data. Structured programming follows a top-down approach, whereas Functional programming follows bottom to top.

Structured programming divided small units or functions, whereas Functional programming divided into small run-time entities called objects. Structured programming less secure, whereas Functional programming highly secure. Structured programming can’t handle complex problems, whereas Functional programming handles any level of a complex problem.

### Examples of Functional Programming in Java

> __Note__: Given below are the examples mentioned:

#### **Example #1: Streams Functional Programming**

**Syntax:**

```java
objectName.stream();
```

**Code:**

Animal.java

```java
package com.streams;
public class Animal {
    String name;
    String color;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Animal(String name, String color) {
        super();
        this.name = name;
        this.color = color;
    }
}
```

AnimalNames.java

```java
package com.streams; // creating package
// importing required packages to the code
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class AnimalNames {
    public static void main(String[] args) {
        getMyDogNames(); // calling the method
    }
    private static void getMyDogNames() {
        Animal a1 = new Animal("Puppy", "black"); // creating a object for animal class
        Animal a2 = new Animal("Tommy", "brown"); // creating a object for animal class
        Animal a3 = new Animal("Zimmy", "white"); // creating a object for animal class
        List < Animal > persons = Arrays.asList(a1, a2, a3); // passing object references to list
        String dogName = persons.stream() // covert all elements into stream
            .filter(name - > "Puppy".equals(name.getName())) // filtering given elements from persons class
            .map(Animal::getName) // persons elements iterate over map
            .findAny() // find out the given element passed from filter
            .orElse(""); // 
        System.out.println("Dog Name :" + dogName); // print the dog name
        List < String > collect = persons.stream()
            .map(Animal::getName)
            .collect(Collectors.toList()); // collecting all names from list
        System.out.println("All Dog names");
        collect.forEach(System.out::println); // iterating collection with for each loop
    }
}
```

**Output:**

**Explanation:**

- In the Java class, we are generating setters and getters.
- In the Java class, we are writing the main code for printing dog names.
- In the code itself, mention each line purpose in the comment.
- If we write same code in the structured programming, we need to write ore lines for each method like filter(), collector(), findAny(), map(), etc. So, most of the development of functional programming is preferred over structured programming.

#### **Example #2: Lambda Expressions**

- Lambda expression used to represent a method interface with an expression.
- It helps to iterate, filtering and extracting data from collections.
- Lambda expression interface implementation is a [functional interface](https:// www.educba.com/functional-interface-in-java/).
- It reduces a lot of code.
- Lambda expression treated as a function so java compiler can’t create .class

**Syntax:**

```shell
(arguments) ->
{
// code for implementation
}
Arguments:  argument-list can be have values or no values
Example: arguments1, arguments2, arguments3,……
->: Joins code implementation and arguments.
```

##### **a. Lambda expression with a single argument**

**Syntax:**

```shell
(argument1) ->
{
// code for implementation
}
```

**Code:**

```java
package com.lambda; // creating a package
interface Square { // creating interface for quare
    public int getArea(int side); // create a method for get area
}
public class AreaOfSquare { // As we are working with Lambda expression so no need to implement interface of square
    public static void main(String[] args) {
        Square area = (side) - > { // Lambda expression with only one argument.
            Return side * side; // returning area
        };
        System.out.println(“Area of Square => ”+area.getArea(10)); // printing area by calling interface getArea method
    }
}
```

##### **b.  Lambda expression without argument**

**Syntax:**

```shell
() ->
{
// code for implementation
}
```

**Code:**

```java
package com.lambda; // creating a package
interface Name { // creating interface for Name
    public String getMyName(); // create a method for get name
}
public class MyNameString { // As we are working with Lambda expression so no need to implement interface of Name
    public static void main(String[] args) {
        Name name = () - > { // Lambda expression with out argument.
            return "Hi, Amardeep!"; // returning name
        };
        System.out.println(name.getMyName()); // printing name by calling interface getMyName method
    }
}
```

#### **Example #3: Method Reference**

- Method reference used to refer to a method of functional interface.
- It is one more easy form of a lambda expression.
- If you use every time lambda expression to point a method, we can use method reference in place of method reference.

**Syntax:**

```shell
Class-Name:: static method name
```

**Code:**

```java
package method.reference; // creating package
interface RectangleArea { // creating RectangleArea interface
    public int getArea(int l, int b); // creating method getArea in interface
}
public class StaticMethodReference { // creating a classs
    public static int showRectangleArea(int length, int breadth) { // creating method for getting rectangle area
        return length * breadth;
    }
    public static void main(String[] args) {
        // Referring static method
        RectangleArea area = StaticMethodReference::showRectangleArea; // calling class name with method name
        // Calling interface method
        int outArea = area.getArea(10, 20);
        System.out.println("Area of rectangle :" + outArea); // printing area
    }
}
```

### Conclusion
Functional programming achieved with streams, lambda expressions, and method references. It reduces lines of code and improves performance.