package ch.notli.notli.db.dao;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import ch.notli.notli.db.model.Semester;

public interface SemesterDao {

    @Insert
    void insert(Semester... semesters);

    @Update
    void update(Semester... semesters);

    @Delete
    void delete(Semester... semesters);

}
