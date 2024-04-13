package com.clone;

public class TestCloneMain {
    public static void main(String[] args) throws CloneNotSupportedException {


        AnotherClass anotherClass = new AnotherClass("data");
        MyClass original = new MyClass(1, anotherClass);

        MyClass cloned = (MyClass) original.clone();
        cloned.setX(2);
        cloned.getAnotherClass().setData("changed");
        System.out.println(original);
        System.out.println("Clone");
        System.out.println(cloned);
    }
}
