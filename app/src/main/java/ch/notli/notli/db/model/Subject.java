package ch.notli.notli.db.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Subject {
    @PrimaryKey
    private int id;
    @ColumnInfo
    private String name;
    @ColumnInfo
    private boolean counts;

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

    public boolean isCounts() {
        return counts;
    }

    public void setCounts(boolean counts) {
        this.counts = counts;
    }
}
