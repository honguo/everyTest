package com.example.test;

import java.math.BigDecimal;
import java.util.function.*;

public class FunctionInterfaceTest {

    public static void main(String[] args){
        //Predicate 判断真假
        Predicate<Integer> predicate = x-> x>185;
        Student student = new Student("jiahong",23,175);
        System.out.println("9龙的身高高于185吗？:"+predicate.test(student.getStature()));
        //Consumer消费消息
        Consumer<String> consumer = System.out::println;
        consumer.accept("要脸不");
        //Fuction映射（转换功能）
        Function<Student,String> function = Student::getName;
        System.out.println(function.apply(student));
        //Supplier生产消息
        Supplier<Integer> supplier = () -> Integer.valueOf(BigDecimal.TEN.toString());
        System.out.println(supplier.get());
        //UnaryOperator一元操作  什么用也没看出来？？？
        UnaryOperator<Boolean> unaryOperator = uglily -> !uglily;
        Boolean apply2 = unaryOperator.apply(true);
        System.out.println(apply2);
        //BinaryOperator二元操作
        BinaryOperator<Integer> operator = (x,y) -> x*y;
        System.out.println(operator.apply(3,6));



    }


}

class Student{
    private String name;

    private int age;

    private Integer stature;

    Student(String name,int age,Integer stature){
        this.name = name;
        this.age = age;
        this.stature = stature;
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

    public Integer getStature() {
        return stature;
    }

    public void setStature(Integer stature) {
        this.stature = stature;
    }
}
