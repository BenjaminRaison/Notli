package ch.notli.notli.db;


import java.util.List;

import ch.notli.notli.db.model.Grade;
import ch.notli.notli.db.model.Semester;
import ch.notli.notli.db.model.Subject;

public interface INotliDatabase {

    void addGrade(Grade grade);

    void addSubject(Subject subject);

    void addSemester(Semester semester);

    void updateGrade(Grade grade);

    void updateSubject(Subject subject);

    void updateSemester(Semester semester);

    void deleteGrade(Grade grade);

    void deleteSubject(Subject subject);

    void deleteSemester(Semester semester);

    List<Grade> getGrades(Semester semester);

    List<Grade> getGrades(Subject subject);

    List<Grade> getGrades(Semester semester, Subject subject);

    List<Subject> getSubjects();

    List<Subject> getSubjects(Semester semester);

    List<Semester> getSemesters();

    Semester getCurrentSemester();

    Semester getSemester(int id);

    Grade getGrade(int id);

    Subject getSubject(int id);

}
