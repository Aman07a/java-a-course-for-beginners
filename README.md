# Java Programming for Complete Beginners
- Java Programming for Beginners to Java Object Oriented Programming. 
- Core Java + REST API with Spring Boot. Java 8 to 16.

## Java Generics
In this tutorial, we will learn about Java Generics, how to create generics class and methods and its advantages with the help of examples.

Java Generics allows us to create a single class, interface, and method that can be used with different types of data (objects).

### This helps us to reuse our code.

>__Note__: Generics does not work with primitive types (int, float, char, etc).

### Java Generics Class
We can create a class that can be used with any type of data. Such a class is known as Generics Class.

#### Here's is how we can create a generics class in Java:

```java
class Main {
  public static void main(String[] args) {

    // initialize generic class
    // with Integer data
    GenericsClass<Integer> intObj = new GenericsClass<>(5);
    System.out.println("Generic Class returns: " + intObj.getData());

    // initialize generic class
    // with String data
    GenericsClass<String> stringObj = new GenericsClass<>("Java Programming");
    System.out.println("Generic Class returns: " + stringObj.getData());
  }
}

// create a generics class
class GenericsClass<T> {

  // variable of T type
  private T data;

  public GenericsClass(T data) {
    this.data = data;
  }

  // method that return T type variable
  public T getData() {
    return this.data;
  }
}
```

#### Output

```shell
Generic Class returns: 5
Generic Class returns: Java Programming
```

In the above example, we have created a generic class named GenericsClass. This class can be used to work with any type of data.

```java
class GenericsClass<T> {...}
```

Here, `T` used inside the angle bracket `<>` indicates the **type parameter**. Inside the `Main` class, we have created two objects of `GenericsClass`

- `intObj` - Here, the type parameter `T` is replaced by `Integer`. Now, the `GenericsClass` works with integer data.
- `stringObj` - Here, the type parameter `T` is replaced by `String`. Now, the `GenericsClass` works with string data.

### Java Generics Method

Similar to the generics class, we can also create a method that can be used with any type of data. Such a class is known as Generics Method.

Here's is how we can create a generics method in Java:

#### Example: Create a Generics Method

```java
class Main {
  public static void main(String[] args) {

    // initialize the class with Integer data
    DemoClass demo = new DemoClass();

    // generics method working with String
    demo.<String>genericsMethod("Java Programming");

    // generics method working with integer
    demo.<Integer>genericsMethod(25);
  }
}

class DemoClass {

  // creae a generics method
  public <T> void genericsMethod(T data) {
    System.out.println("Generics Method:");
    System.out.println("Data Passed: " + data);
  }
}
```

#### Output

```shell
Generics Method:
Data Passed: Java Programming
Generics Method:
Data Passed: 25
```

In the above example, we have created a generic method named `genericsMethod`.

```java
public <T> void genericMethod(T data) {...}
```

Here, the type parameter `<T>` is inserted after the modifier `public` and before the return type `void`.

We can call the generics method by placing the actual type `<String>` and `<Integer>` inside the bracket before the method name.

```
demo.<String>genericMethod("Java Programming");

demo.<Integer>genericMethod(25);
```

>
> __Note__: We can call the generics method without including the type parameter. For example, 
> ```java
> demo.genericsMethod("Java Programming");
> ``` 
> In this case, the compiler can match the type parameter based on the value passed to the method.
>

### Bounded Types

In general, the **type parameter** can accept any data types (except primitive types).

However, if we want to use generics for some specific types (such as accept data of number types) only, then we can use bounded types.

In the case of bound types, we use the `extends` keyword. For example,

```java
<T extends A>
```

This means `T` can only accept data that are subtypes of `A`.

#### Example: Bounded Types

```java
class GenericsClass <T extends Number> {

  public void display() {
    System.out.println("This is a bounded type generics class.");
  }
}

class Main {
  public static void main(String[] args) {

    // create an object of GenericsClass
    GenericsClass<String> obj = new GenericsClass<>();
  }
}
```

In the above example, we have created a class named GenericsClass. Notice the expression, notice the expression

```java
<T extends Number> 
```

Here, `GenericsClass` is created with bounded type. <br/> 
This means `GenericsClass` can only work with data types that are children of `Number` (`Integer`, `Double`, and so on).

However, we have created an object of the generics class with `String`. <br/> 
In this case, we will get the following error.

```java
GenericsClass<String> obj = new GenericsClass<>();
                                                 ^
    reason: inference variable T has incompatible bounds
      equality constraints: String
      lower bounds: Number
  where T is a type-variable:
    T extends Number declared in class GenericsClass
``` 