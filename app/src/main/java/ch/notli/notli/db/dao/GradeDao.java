package ch.notli.notli.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import ch.notli.notli.db.model.Grade;

@Dao
public interface GradeDao {

    @Insert
    void insert(Grade... grades);

    @Update
    void update(Grade... grades);

    @Delete
    void delete(Grade... grades);

}
