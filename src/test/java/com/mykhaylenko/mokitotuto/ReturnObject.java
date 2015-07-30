package com.mykhaylenko.mokitotuto;

/**
 * Created by pavlo.mykhaylenko on 7/30/2015.
 */
public class ReturnObject {

    private int id;
    private String name;

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        if (!(obj instanceof ReturnObject)) {
            return result;
        }

        ReturnObject obj1 = (ReturnObject) obj;
        if (this.getId() == obj1.getId() && this.name.equals( obj1.getName())) {
            result = true;
        }

        return result;
    }

    public ReturnObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
