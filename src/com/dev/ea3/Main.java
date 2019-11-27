package com.dev.ea3;

import java.util.*;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 39);
        Employee andres = new Employee("Andres Parra", 23);
        Employee emilio = new Employee("Emilio Araos", 36);
        Employee carlos = new Employee("Carlos Lucoa", 36);


        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(andres);
        employees.add(emilio);
        employees.add(carlos);

        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        String lastName = getLastName.apply(employees.get(2));
//        System.out.println(lastName);

        Function <Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };

        Random random1 = new Random();
        for(Employee employee : employees){
            if(random1.nextBoolean()){
                System.out.println(getAName(getFirstName, employee));
            }else{
                System.out.println(getAName(getLastName, employee));
            }
        }

    }

    private static String getAName(Function<Employee, String> getName, Employee employee){
        return getName.apply(employee);
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2 ){
        return uc.upperAndConcat(s1, s2);
    }
}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat {

    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {

    public String doSomething(){

        UpperConcat uc = (s1, s2) -> {
            System.out.println("The Lambdas's expression class is " + getClass().getSimpleName());
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };
        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String1", "String2");

    }
}











