package org.example.Animals;

public abstract class Animal {
    private static int count = 0;
    protected String name;

    public Animal(String name){
        this.name = name;
        count ++;
    }

    public static int getCount(){
        return count;
    }

    public String getName() {
        return name;
    }

    protected abstract void run(float distance);
    protected abstract void swim(float distance);
}
