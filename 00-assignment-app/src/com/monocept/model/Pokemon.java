package com.monocept.model;

import java.io.Serializable;

public class Pokemon implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int berryCount;
    private int stars;
    private int totalStars;
    private int remainingStars;

    public Pokemon(String name, int stars, int totalStars) {
        this.name = name;
        this.berryCount = 0;
        this.stars = stars;
        this.totalStars = totalStars;
        this.remainingStars = totalStars - stars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBerryCount() {
        return berryCount;
    }

    public void setBerryCount(int berryCount) {
        this.berryCount = berryCount;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
        this.remainingStars = totalStars - stars;
    }

    public int getTotalStars() {
        return totalStars;
    }

    public void setTotalStars(int totalStars) {
        this.totalStars = totalStars;
    }

    public int getRemainingStars() {
        return remainingStars;
    }

    public void setRemainingStars(int remainingStars) {
        this.remainingStars = remainingStars;
    }

    public void incrementStars(int stars) {
        this.stars += stars;
        this.remainingStars = totalStars - this.stars;
    }

    public void incrementBerryCount() {
        if (berryCount < 8) {
            berryCount++;
        }
    }

    public void resetDailyStats() {
        berryCount = 0;
    }

    @Override
    public String toString() {
        return "{" +
                "\n    Name: '" + name + '\'' +
                "\n    today stars: " + berryCount +
                "\n    Stars: " + stars +
                "\n    Total Stars: " + totalStars +
                "\n    Remaining Stars: " + remainingStars +
                "\n}";
    }

}
