package ch.notli.notli.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ch.notli.notli.db.model.Grade;
import ch.notli.notli.db.model.Semester;
import ch.notli.notli.db.model.Subject;

public class NotliDatabaseHelper extends SQLiteOpenHelper implements INotliDatabase {

    private static final String TAG = NotliDatabaseHelper.class.getSimpleName();
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "Notli.db";

    private static final String SQL_CREATE_DATABASE =
            "CREATE TABLE semester (" + " id INTEGER PRIMARY KEY NOT NULL," +
            " name TEXT NOT NULL," + " startDate DATE NOT NULL," + " endDate DATE NOT NULL);" +

            "CREATE TABLE subject (" + " id INTEGER PRIMARY KEY," + " name TEXT NOT NULL," +
            " counts BOOLEAN NOT NULL);" +

            "CREATE TABLE semester_subject (" + "semester int NOT NULL ON DELETE CASCADE," +
            "subject int NOT NULL ON DELETE CASCADE," + "PRIMARY KEY (semester, subject)," +
            "FOREIGN KEY (semester) references semester.id," +
            "FOREIGN KEY (subject) references subject.id);" +

            "CREATE TABLE grade(" + "id INTEGER PRIMARY KEY," + "name TEXT NOT NULL," +
            "date LONG NOT NULL" + "weight DOUBLE NOT NULL," + "grade DOUBLE NOT NULL," +
            "subject INTEGER NOT NULL," + "semester INTEGER NOT NULL," +
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
        ContentValues values = new ContentValues();
        values.put("name", grade.getName());
        values.put("date", grade.getDate().getTime());
        values.put("weight", grade.getWeight());
        values.put("grade", grade.getGrade());
        values.put("subject", grade.getSubject().getId());
        values.put("semester", grade.getSemester().getId());
        db.insert("grade", null, values);
    }

    @Override
    public void addSubject(Subject subject) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", subject.getName());
        values.put("counts", subject.isCountTowardsAverage());
        db.insert("subject", null, values);
    }

    @Override
    public void addSemester(Semester semester) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", semester.getName());
        values.put("startDate", semester.getStart().getTime());
        values.put("endDate", semester.getEnd().getTime());
        db.insert("semester", null, values);
    }

    @Override
    public void updateGrade(Grade grade) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", grade.getName());
        values.put("date", grade.getDate().getTime());
        values.put("weight", grade.getWeight());
        values.put("grade", grade.getGrade());
        values.put("subject", grade.getSubject().getId());
        values.put("semester", grade.getSemester().getId());
        String[] params = { Integer.toString(grade.getId()) };
        db.update("grade", values, "id = ?", params);
    }

    @Override
    public void updateSubject(Subject subject) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", subject.getName());
        values.put("counts", subject.isCountTowardsAverage());
        String[] params = { Integer.toString(subject.getId()) };
        db.update("subject", values, "id = ?", params);
    }

    @Override
    public void updateSemester(Semester semester) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", semester.getName());
        values.put("startDate", semester.getStart().getTime());
        values.put("endDate", semester.getEnd().getTime());
        String[] params = { Integer.toString(semester.getId()) };
        db.update("semester", values, "id = ?", params);
    }

    @Override
    public void deleteGrade(Grade grade) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = { Integer.toString(grade.getId()) };
        db.delete("grade", "id = ?", params);
    }

    @Override
    public void deleteSubject(Subject subject) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = { Integer.toString(subject.getId()) };
        db.delete("subject", "id = ?", params);
    }

    @Override
    public void deleteSemester(Semester semester) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = { Integer.toString(semester.getId()) };
        db.delete("semester", "id = ?", params);
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
        SQLiteDatabase db = getReadableDatabase();

        String[] columns = { "id", "name", "counts" };
        String sortBy = "name DESC";

        Cursor cursor = db.query("subject", columns, null, null, null, null, sortBy);
        int columnId = cursor.getColumnIndex(columns[0]);
        int columnName = cursor.getColumnIndex(columns[1]);
        int columnCounts = cursor.getColumnIndex(columns[2]);
        List<Subject> subjects = new ArrayList<>();
        if (cursor.moveToNext()) {
            boolean counts = true;
            if (cursor.getInt(columnCounts) == 0) {
                counts = false;
            }
            Subject subject =
                    new Subject(cursor.getInt(columnId), cursor.getString(columnName), counts);
            subjects.add(subject);
        }
        cursor.close();
        return subjects;
    }

    @Override
    public List<Subject> getSubjects(Semester semester) {
        SQLiteDatabase db = getReadableDatabase();

        String[] columns = { "id", "name", "counts" };
        String sortBy = "name DESC";
        // FIXME
        Cursor cursor = db.query("subject", columns, null, null, null, null, sortBy);
        int columnId = cursor.getColumnIndex(columns[0]);
        int columnName = cursor.getColumnIndex(columns[1]);
        int columnCounts = cursor.getColumnIndex(columns[2]);
        List<Subject> subjects = new ArrayList<>();
        if (cursor.moveToNext()) {
            boolean counts = true;
            if (cursor.getInt(columnCounts) == 0) {
                counts = false;
            }
            Subject subject =
                    new Subject(cursor.getInt(columnId), cursor.getString(columnName), counts);
            subjects.add(subject);
        }
        cursor.close();
        return subjects;
    }

    @Override
    public List<Semester> getSemesters() {
        SQLiteDatabase db = getReadableDatabase();

        String[] columns = { "id", "name", "startDate", "endDate" };
        String sortBy = "startDate DESC";

        Cursor cursor = db.query("semester", columns, null, null, null, null, sortBy);
        int columnId = cursor.getColumnIndex(columns[0]);
        int columnName = cursor.getColumnIndex(columns[1]);
        int columnStartDate = cursor.getColumnIndex(columns[2]);
        int columnEndDate = cursor.getColumnIndex(columns[3]);
        List<Semester> semesters = new ArrayList<>();
        if (cursor.moveToNext()) {
            Semester semester = new Semester(cursor.getInt(columnId), cursor.getString(columnName),
                                             new Date(cursor.getLong(columnStartDate)),
                                             new Date(cursor.getLong(columnEndDate)), null);
            semester.setSubjects(getSubjects(semester));
            semesters.add(semester);
        }
        cursor.close();
        return semesters;
    }

    @Override
    public Semester getCurrentSemester() {
        return null;
    }

    @Override
    public Semester getSemester(int id) {
        SQLiteDatabase db = getReadableDatabase();

        String[] columns = { "id", "name", "startDate", "endDate" };
        String where = "id = ?";
        String[] whereArgs = { Integer.toString(id) };
        String sortBy = "id DESC";

        Cursor cursor = db.query("semester", columns, where, whereArgs, null, null, sortBy);
        int columnId = cursor.getColumnIndex(columns[0]);
        int columnName = cursor.getColumnIndex(columns[1]);
        int columnStartDate = cursor.getColumnIndex(columns[2]);
        int columnEndDate = cursor.getColumnIndex(columns[3]);
        Semester semester = null;
        if (cursor.moveToNext()) {
            semester = new Semester(cursor.getInt(columnId), cursor.getString(columnName),
                                    new Date(cursor.getLong(columnStartDate)),
                                    new Date(cursor.getLong(columnEndDate)), null);
            semester.setSubjects(getSubjects(semester));
        }
        cursor.close();
        return semester;
    }

    @Override
    public Grade getGrade(int id) {
        SQLiteDatabase db = getReadableDatabase();

        String[] columns = { "id", "name", "date", "weight", "grade", "subject", "semester" };
        String where = "id = ?";
        String[] whereArgs = { Integer.toString(id) };
        String sortBy = "id DESC";

        Cursor cursor = db.query("grade", columns, where, whereArgs, null, null, sortBy);
        int columnId = cursor.getColumnIndex(columns[0]);
        int columnName = cursor.getColumnIndex(columns[1]);
        int columnDate = cursor.getColumnIndex(columns[2]);
        int columnWeight = cursor.getColumnIndex(columns[3]);
        int columnGrade = cursor.getColumnIndex(columns[4]);
        int columnSubject = cursor.getColumnIndex(columns[5]);
        int columnSemester = cursor.getColumnIndex(columns[6]);
        Grade grade = null;
        if (cursor.moveToNext()) {
            grade = new Grade(cursor.getInt(columnId), cursor.getString(columnName),
                              new Date(cursor.getLong(columnDate)), cursor.getDouble(columnWeight),
                              cursor.getDouble(columnGrade),
                              getSubject(cursor.getInt(columnSubject)),
                              getSemester(cursor.getInt(cursor.getInt(columnSemester))));
        }
        cursor.close();
        return grade;
    }

    @Override
    public Subject getSubject(int id) {
        SQLiteDatabase db = getReadableDatabase();

        String[] columns = { "id", "name", "counts" };
        String sortBy = "name DESC";
        String where = "id = ?";
        String[] whereArgs = { Integer.toString(id) };
        Cursor cursor = db.query("subject", columns, where, whereArgs, null, null, sortBy);
        int columnId = cursor.getColumnIndex(columns[0]);
        int columnName = cursor.getColumnIndex(columns[1]);
        int columnCounts = cursor.getColumnIndex(columns[2]);
        Subject subject = null;
        if (cursor.moveToNext()) {
            boolean counts = true;
            if (cursor.getInt(columnCounts) == 0) {
                counts = false;
            }
            subject = new Subject(cursor.getInt(columnId), cursor.getString(columnName), counts);
        }
        cursor.close();
        return subject;
    }

    @Override
    public double getAverage(Semester semester) {
        return 0;
    }

    @Override
    public double getAverage(Semester semester, Subject subject) {
        return 0;
    }

    @Override
    public double getAverage(Subject subject) {
        return 0;
    }


}
