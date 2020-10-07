package com.ifmo.jjd.lesson7;

public class Unit {
    protected int healthPoints;
    protected int agilityPoints;

    protected int maxHealth;

    public Unit(int healthPoints, int agilityPoints) {
        if (healthPoints <= 0 || agilityPoints <= 0)
            throw new IllegalArgumentException("healthPoints < 0 || agilityPoints < 0");
        maxHealth = healthPoints;
        this.healthPoints = healthPoints;
        this.agilityPoints = agilityPoints;
    }

    public void plusHealth(int points) {
        if (isAlive()) {
            healthPoints += points;
            if (healthPoints > maxHealth) healthPoints = maxHealth;
        }
    }

    public void minusHealth(int points){
        if (isAlive()) {
            healthPoints -= points;
            if (!isAlive()) healthPoints = 0;
        }
    }

    public boolean isAlive(){
        return healthPoints > 0;
    }
}
