package com.lyy.boot.bean;

/**
 * @program: boot-1-helloworld
 * @description:
 * @author: ly
 * @create: 2021-11-22 14:20
 **/

public class Pet {

    private String name;

    public Pet() {

    }

    public Pet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }
}
