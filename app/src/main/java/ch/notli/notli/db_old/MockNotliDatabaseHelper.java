package ch.notli.notli.db_old;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ch.notli.notli.db_old.model.Grade;
import ch.notli.notli.db_old.model.Semester;
import ch.notli.notli.db_old.model.Subject;

/**
 * HOW TO USE: INotliDatabase db = new MockNotliDatabaseHelper();
 * Data my be inconsistent
 */
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
        List<Grade> list = new ArrayList<>();
        list.add(new Grade(1, "Test 1", 1, 4.5, getSubjects().get(0), getSemesters().get(0)));
        list.add(new Grade(1, "Test 2", 1, 5, getSubjects().get(1), getSemesters().get(0)));
        list.add(new Grade(1, "Test 3", 1, 4, getSubjects().get(5), getSemesters().get(1)));
        return list;
    }

    @Override
    public List<Grade> getGrades(Subject subject) {
        List<Grade> list = new ArrayList<>();
        list.add(new Grade(1, "Test 1", 1, 4.5, getSubjects().get(0), getSemesters().get(0)));
        list.add(new Grade(1, "Test 4", 1, 5, getSubjects().get(0), getSemesters().get(0)));
        list.add(new Grade(1, "Test 5", 1, 4, getSubjects().get(0), getSemesters().get(1)));
        return list;
    }

    @Override
    public List<Grade> getGrades(Semester semester, Subject subject) {
        List<Grade> list = new ArrayList<>();
        list.add(new Grade(1, "Test 1", 1, 4.5, getSubjects().get(0), getSemesters().get(0)));
        list.add(new Grade(1, "Test 2", 1, 5, getSubjects().get(1), getSemesters().get(0)));
        list.add(new Grade(1, "Test 3", 1, 4, getSubjects().get(5), getSemesters().get(1)));
        return list;
    }

    @Override
    public List<Subject> getSubjects() {
        List<Subject> list = new ArrayList<>();
        list.add(new Subject(1, "Deutsch", true));
        list.add(new Subject(2, "Französisch", true));
        list.add(new Subject(3, "Englisch", true));
        list.add(new Subject(4, "Mathematik", true));
        list.add(new Subject(5, "Technik & Umwelt", true));
        return list;
    }

    @Override
    public List<Subject> getSubjects(Semester semester) {
        return getSubjects();
    }

    @Override
    public List<Semester> getSemesters() {
        List<Semester> list = new ArrayList<>();
        list.add(new Semester(1, "Semester 1", new Date(1452211200L), new Date(1464825600L),
                              getSubjects()));
        return list;
    }

    @Override
    public Semester getCurrentSemester() {
        return getSemesters().get(0);
    }

    @Override
    public Semester getSemester(int id) {
        return getSemesters().get(0);
    }

    @Override
    public Grade getGrade(int id) {
        return getGrades(getSemesters().get(0)).get(0);
    }

    @Override
    public Subject getSubject(int id) {
        return getSubjects().get(0);
    }
}
