package com.vlad;

public class Dog {

    private final String name;

    public Dog(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public final boolean equals(Object obj){
        // if you put final class can not be override
        if(this == obj){
            return true;
        }

        if(obj instanceof Dog){
            String objName = ((Dog) obj).getName();
            return this.name.equals(objName);
        }

        return false;
    }
}
