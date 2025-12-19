package org.example.Animals;

public class Dog extends Animal {
    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;
    private static int count = 0;

    public Dog(String name){
        super(name);
        count ++;
    }

    public static int getCount(){
        return count;
    }

    @Override
    public void run(float distance) {
        if (distance <= MAX_RUN_DISTANCE)
            System.out.println(this.name + " пробежал " + distance + " м.");
        else
            System.out.println(this.name + " не может пробежать более " + MAX_RUN_DISTANCE + " м.!");

    }

    @Override
    public void swim(float distance) {
        if (distance <= MAX_SWIM_DISTANCE)
            System.out.println(this.name + " проплыл " + distance + " м.");
        else
            System.out.println(this.name + " не может проплыть более " + MAX_SWIM_DISTANCE + " м.!");
    }
}
