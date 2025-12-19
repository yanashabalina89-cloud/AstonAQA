package org.example.Animals;

public class Cat extends Animal {
    private static final int MAX_RUN_DISTANCE = 200;
    private static int count = 0;
    private boolean satiety;

    public Cat(String name){
        super(name);
        this.satiety = false;
        count ++;
    }

    public boolean getSatiety() {
        return satiety;
    }

    private void setSatiety(boolean satiety) {
        this.satiety = satiety;
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
        System.out.println("Коты не умеют плавать!");
    }

    public void eat(int food, Bowl bowl){
        if (!this.getSatiety())
            this.setSatiety(bowl.eatFood(food));
    }
}
