package ch.notli.notli.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.List;

import ch.notli.notli.db.model.Grade;
import ch.notli.notli.db.model.Semester;
import ch.notli.notli.db.model.Subject;

public class NotliDatabaseHelper extends SQLiteOpenHelper implements INotliDatabase {

    private static final String TAG = NotliDatabaseHelper.class.getSimpleName();
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "Notli.db";

    private static final String SQL_CREATE_DATABASE =
            "CREATE TABLE semester (" +
                    " id INTEGER PRIMARY KEY NOT NULL," +
                    " name TEXT NOT NULL," +
                    " startDate DATE NOT NULL," +
                    " endDate DATE NOT NULL);" +

                    "CREATE TABLE subject (" +
                    " id INTEGER PRIMARY KEY," +
                    " name TEXT NOT NULL," +
                    " counts BOOLEAN NOT NULL);" +

                    "CREATE TABLE grade(" +
                    "id INTEGER PRIMARY KEY," +
                    "name TEXT NOT NULL," +
                    "weight DOUBLE NOT NULL," +
                    "grade DOUBLE NOT NULL," +
                    "subject INTEGER NOT NULL," +
                    "semester INTEGER NOT NULL," +
                    "FOREIGN KEY (subject) references subject.id ON DELETE CASCADE," +
                    "FOREIGN KEY (semester) references semester.id ON DELETE CASCADE);";

    private static final String SQL_DROP_DATABASE = "";

    public NotliDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.d(TAG, "NotliDatabaseHelper: constructor");
    }

    @Override
    public void closeDatabase() {
        getWritableDatabase().close();
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            // Enable foreign key constraints
            db.execSQL("PRAGMA foreign_keys=TRUE;");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate: DB created");
        db.execSQL(SQL_CREATE_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_DATABASE);
    }

    @Override
    public void addGrade(Grade grade) {
        SQLiteDatabase db = getWritableDatabase();
    }

    @Override
    public void addSubject(Subject subject) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", subject.getId());
        values.put("name", subject.getName());
        values.put("counts", subject.isCountTowardsAverage());
        db.insert("subject", null, values);
    }

    @Override
    public void addSemester(Semester semester) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", semester.getId());
        values.put("name", semester.getName());
        //values.put("startDate", semester.getStart());
        //values.put("endDate", semester.getEnd())
        db.insert("semester", null, values);
    }

    @Override
    public void updateGrade(Grade grade) {

    }

    @Override
    public void updateSubject(Subject subject) {

    }

    @Override
    public void updateSemester(Semester semester) {

    }

    @Override
    public void deleteGrade(Grade grade) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = {Integer.toString(grade.getId())};
        db.delete("grade", "id = ?", params);
        db.close();
    }

    @Override
    public void deleteSubject(Subject subject) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = {Integer.toString(subject.getId())};
        db.delete("subject", "id = ?", params);
        db.close();
    }

    @Override
    public void deleteSemester(Semester semester) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = {Integer.toString(semester.getId())};
        db.delete("semester", "id = ?", params);
        db.close();
    }

    @Override
    public List<Grade> getGrades(Semester semester) {
        return null;
    }

    @Override
    public List<Grade> getGrades(Subject subject) {
        return null;
    }

    @Override
    public List<Grade> getGrades(Semester semester, Subject subject) {
        return null;
    }

    @Override
    public List<Subject> getSubjects() {

        return null;
    }

    @Override
    public List<Subject> getSubjects(Semester semester) {
        return null;
    }

    @Override
    public List<Semester> getSemesters() {
        return null;
    }

    @Override
    public Semester getCurrentSemester() {
        return null;
    }

    @Override
    public Semester getSemester(int id) {
        return null;
    }

    @Override
    public Grade getGrade(int id) {
        return null;
    }

    @Override
    public Subject getSubject(int id) {
        return null;
    }


}
