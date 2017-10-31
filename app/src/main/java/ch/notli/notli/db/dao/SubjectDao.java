package ch.notli.notli.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import ch.notli.notli.db.model.Subject;

@Dao
public interface SubjectDao {

    @Insert
    void insert(Subject... subjects);

    @Update
    void update(Subject... subjects);

    @Delete
    void delete(Subject... subjects);

}
