package com.clone;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnotherClass implements Cloneable {
    private String data;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
