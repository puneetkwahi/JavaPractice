package com.clone;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyClass implements Cloneable {
    private int x;
    private AnotherClass anotherClass;

    @Override
    public Object clone() throws CloneNotSupportedException {
        MyClass cloned = (MyClass) super.clone();
        cloned.anotherClass = (AnotherClass) anotherClass.clone();
        return cloned;
    }
}
