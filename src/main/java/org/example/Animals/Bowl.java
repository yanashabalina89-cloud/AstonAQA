package org.example.Animals;

public class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = food;
    }

    private int getFood() {
        return food;
    }

    private void setFood(int food) {
        this.food = food;
    }

    public void addFood(int food){
        this.setFood(this.getFood() + food);
    }

    public boolean eatFood(int food){
        if (this.getFood() >= food){
            this.setFood(this.getFood() - food);
            return true;
        }
        return false;
    }
}
