package ch.notli.notli.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

import ch.notli.notli.db.model.Grade;
import ch.notli.notli.db.model.Semester;
import ch.notli.notli.db.model.Subject;

public class NotliDatabaseHelper extends SQLiteOpenHelper implements INotliDatabase {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "Notli.db";

    private static final String SQL_CREATE_DATABASE = "";
    private static final String SQL_DROP_DATABASE = "";

    public NotliDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_DATABASE);
    }

    @Override
    public void addGrade(Grade grade) {

    }

    @Override
    public void addSubject(Subject subject) {

    }

    @Override
    public void addSemester(Semester semester) {

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

    }

    @Override
    public void deleteSubject(Subject subject) {

    }

    @Override
    public void deleteSemester(Semester semester) {

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
