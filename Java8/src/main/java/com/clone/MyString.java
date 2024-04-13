package com.clone;

public class MyString {
    public static void main(String[] args) {
        String str = "puneet";
        StringBuilder sb = new StringBuilder("puneet");
        System.out.println(sb.equals(str));
        System.out.println(str.equals(sb.toString()));
    }
}
