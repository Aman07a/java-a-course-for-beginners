# Spring Boot Embedded Servers

### How do you deploy your application

- Step 1: Install Java

- Step 2: Install Web/Application Server

  - Tomcat/WebSphere/WebLogic etc

- Step 3: Deploy the application WAR (Web Archive)
  - This is the OLD **WAR** Approach
  - Complex to setup!

### **Embedded Server** - Simpler alternative

- Step 1: Install Java

- Step 2: Run JAR file

- **Make JAR not WAR**

- Embedded Server **Examples**:

  - spring-boot-starter-tomcat

  - spring-boot-starter-jetty

  - spring-boot-starter-undertow

### Run As Maven build...

```shell
clean install
```

### How to run Tomcat?

```shell
java -jar JAR_NAME.jar
```

OR

```shell
java -jar learn-spring-boot-0.0.1-SNAPSHOT.jar
```
