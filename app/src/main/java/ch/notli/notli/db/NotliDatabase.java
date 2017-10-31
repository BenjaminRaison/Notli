package ch.notli.notli.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import ch.notli.notli.db.dao.GradeDao;
import ch.notli.notli.db.dao.SemesterDao;
import ch.notli.notli.db.dao.SubjectDao;
import ch.notli.notli.db.model.Grade;
import ch.notli.notli.db.model.Semester;
import ch.notli.notli.db.model.Subject;


@Database(entities = { Grade.class, Semester.class,
        Subject.class }, version = 1, exportSchema = false)
@TypeConverters({ Converter.class })
public abstract class NotliDatabase extends RoomDatabase {

    private static NotliDatabase instance;

    public static NotliDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), NotliDatabase.class,
                                            "notli-database").build();
        }
        return instance;
    }

    public static void destroyInstance() {
        instance = null;
    }


    public abstract GradeDao expenseDao();

    public abstract SemesterDao semesterDao();

    public abstract SubjectDao subjectDao();
}
