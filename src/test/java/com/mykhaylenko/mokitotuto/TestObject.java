package com.mykhaylenko.mokitotuto;

/**
 * Created by pavlo.mykhaylenko on 7/30/2015.
 */
public abstract class TestObject {

    abstract public String print();

    abstract public String print(String string);

    abstract public ReturnObject create(int id, String name);

    abstract public int sum(int a, int b);
}
