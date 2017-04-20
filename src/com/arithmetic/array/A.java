package com.arithmetic.array;

import java.lang.reflect.Field;

public class A {
    private B b;

    public A() {
        System.out.println("****** A is load");
    }

    public void print() {
        System.out.println("A success！！！");
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException,
            SecurityException {
        A a = A.class.newInstance();
        B b = B.class.newInstance();
        Field a_b = a.getClass().getDeclaredField("b");
        a_b.set(a, b);

        Field b_a = b.getClass().getDeclaredField("a");
        Field.setAccessible(new Field[] { b_a }, true);
        b_a.set(b, a);
    }
}
