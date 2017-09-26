package ch.notli.notli.db;

import java.util.List;

import ch.notli.notli.db.model.Grade;
import ch.notli.notli.db.model.Semester;
import ch.notli.notli.db.model.Subject;

public class MockNotliDatabaseHelper implements INotliDatabase {


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
}
