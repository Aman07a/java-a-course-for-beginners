# Java Programming for Complete Beginners

- Java Programming for Beginners to Java Object Oriented Programming.
- Core Java + REST API with Spring Boot. Java 8 to 16.

## Modularization in Java: What Is It?

![JavaModular-1024x536](https://github.com/Aman07a/java-a-course-for-beginners/assets/60389872/da4a02a0-7a1b-40a6-b0fa-848648a9b2f2)

In general, modularization means to construct something in different parts or modules. The primary reason for modularization is to make things manageable and get better control over them.

The same concept is applied in application development. Designing a Java application in different modules, instead of as a single, monolithic design is what we call modularization in Java.

### Why do we need modularization?

Modularity enables developers to independently work on their areas of application like testing or engaging in parallel development in projects to remain time efficient. A standardized interface is then used to connect the modules for communication. It helps developers in minimizing coupling and optimizing the application development process by reducing the complexity.

### Modularization in Java

The [Java programming language](https://docs.oracle.com/javase/8/docs/technotes/guides/language/index.html) was not designed keeping modularization in mind, but it was later introduced in Java 9 considering the following three core ideas to benefit Java developers:

- To be able to leverage strong encapsulation (thanks to OOP) in your code.
- For establishing well-defined interfaces for modules communication.
- For defining explicit dependencies.

### What is a module?

A module is a component of a Java code that acts as an intermediatory between packages and class loaders. It was an exciting addition to Java because now, the resources and packages can be encapsulated from other modules in different levels, which was not an option before. Modularization in Java adds another level of aggregation above packages. It is uniquely named like classes and methods and it can consist of a reusable group of related packages, or maybe even resources like images or XML files.

##### A module always has a descriptor that consists of all its specifications. It includes:

- the name of the module,
- the dependencies, if any, on other modules or vice versa,
- all its packages (if required) are explicitly made available to any other modules.
- All the services that it offers as well as the services that it requires.

We will be further discussing these descriptors of a module to explain how they perfectly utilize the modularity in Java.

#### · Name

The declaration of a module is specified with a unique name just like a class or a method. See this example of valid module declaration:

```java
module md1 {

}
```

“md1” is a valid module name, but it is a good programming practice to include the name of the root Java package in the name of the module in which the module is present. Ultimately, a module name is comprised of one or more Java identifiers separated by single or multiple “.” tokens. This is an example of a recommended name for a Java module:

```java
module com.proj.md01 {

}
```

#### · Dependencies

Module dependencies can be classes, archives, libraries or any other resources that your module refers to and requires to be used. A dependency is what is expressed by a “required” directive. For instance, the following code shows that the “com.proj.md01” module has a direct dependency on another module called “com.proj.md07”.

```java
module com.proj.md01 {

requires com.proj.md07;

}
```

Another directive called “requires static” can also be used to indicate that a module is required at compile-time, but it is an optional dependency.

Keep in mind that Circular Dependencies between modules is not allowed in java. For example, if module A requires module B, then module B cannot require module A.

#### · Exported Packages

A Java module must export all packages that are made explicitly available for other modules. A Java package can only be exported by a single Java module at runtime. It is to be noted that it is not allowed in modularization in Java to export the same package from multiple modules at the same time. It is termed a “split package” because it results in the total content of the package being divided between multiple modules. The Java Virtual Machine will throw a “ResolutionException” as a result of such an attempt.

Here is an example of a simple and valid export declaration:

```java
module com.proj.md01 {

exports com.proj.md03;

}
```

While exporting a package, the sub-packages present in that package will not be exported with it so if a command like the one mentioned below is an attempt to export a sub-package called “until,” it won’t work,

```shell
line com.Proj.md03.util.
```

#### · Used Services

To use a service, it will first require a service interface module, for example, JPA and a service implementation module like Hibernate. Now, finally, to use a service in a modular way, you will need an interface module, for example, com.proj.service. It also requires the use of the keyword “uses” for implementation. See the following example demonstrating the code:

```java
module com.proj.md01 {

requires com.proj.service;

uses com.proj.service.myService;

}
```

You can observe; there is no requirement for declaring the implementation module which allows you to exchange the implementation module without disrupting the client’s code. It is up to the developers to decide which service implementation is needed during the assembly of the application. The service client module can also easily look up the service interface implementation at run-time using this statement:

```java
ServiceLoader<GenerationService> load = ServiceLoader.load(GenerationService.class);
```

### Modularization in Java: Code Implementation

#### · How to Compile a Java Module?

To compile a Java module, you need to use the javac command that comes with the Java SDK. You will be needing Java 9 or a later version to compile a Java module.

```shell
javac -d out --module-source-path src/main/java --module com.proj.md01
```

You can also replace the javac part in the command above with the full path where the javac command is located, see this command below:

```shell
"C:\Program Files\Java\jdk-9.0.4\bin\javac" -d out --module-source-path src/main/java --module com.proj.md01
```

The compiled result is always saved in the directory specified after the -d argument. The –module-source-path direct to the source root directory is usually one level up from the module root directory.

Lastly, the –module argument specifies which Java module is to be compiled. You can also specify multiple modules to be compiled by separating the module names with a comma like:

```shell
... --module com.proj.md01, com.proj.md02
```

#### · How to run a Java Module?

To run the main class of a Java module you need to use the java command,

```shell
java --module-path out --module com.proj.md01/ com.proj.md01.Main
```

Here, the –module argument points out what module to run with the main class. The module name and main class name are needed to be separated by a slash “/” character.

### Advantages of modularity in Java

If the application development process follows a proper modular design, modularization in Java can offer several advantages both in the long and short run, other than just being easy to manage.

##### Following are some of the most prominent advantages of modularity in Java:

#### · Reusability

As all the individual modules can be used independently, it leverages reusability. Some or even all components can be reused in any other java program. Considering that, modularization in Java can save significant time in multiple projects development by just designing the modules to be easily reused.

#### · Increase in Readability

A modular code is relatively more readable and manageable than a monolithic code.

#### · Easy to Customize

It is easier to maintain and upgrade the code because individual components have separate concerns and changing one would not affect other components as it would do in a monolithic code. Thanks to modularity in Java, it is now a straightforward process to make any necessary changes in a module, keeping the rippled changes to other modules as minimal as possible.

#### · Testing and Debugging

Modular programs are also comparatively easy to debug and test because of their decoupled nature. All individual components can be easily selected for individual testing. It will also be easier to keep an error localized and it can be rectified at an early stage.

```shell
See Also: ClassNotFoundException Vs. NoClassDefFoundError In Java
```

### Conclusion
Before modularization in Java, JAR files were somewhat close to modules, but there were too many errors and limitations in it. Modularization in Java has not only made the work easier for developers, but it has also advanced the application development process as a whole. We covered all the basics of modularization in Java from concepts to code implementation. This flagship feature is a must to learn for every Java developer as it has rejuvenated the core of Java and paved a path for the innovative product development, deployment, and packaging process we use today.
