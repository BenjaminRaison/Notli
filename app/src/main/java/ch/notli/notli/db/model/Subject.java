package ch.notli.notli.db.model;

public class Subject {

    private int id;
    private String name;
    private boolean countTowardsAverage;

    public Subject(int id, String name, boolean countTowardsAverage) {

        this.id = id;
        this.name = name;
        this.countTowardsAverage = countTowardsAverage;
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

    public boolean isCountTowardsAverage() {
        return countTowardsAverage;
    }

    public void setCountTowardsAverage(boolean countTowardsAverage) {
        this.countTowardsAverage = countTowardsAverage;
    }
}
