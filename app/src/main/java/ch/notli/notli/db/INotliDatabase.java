package ch.notli.notli.db;


import java.util.List;

import ch.notli.notli.db.model.Grade;
import ch.notli.notli.db.model.Semester;
import ch.notli.notli.db.model.Subject;

public interface INotliDatabase {

    void addGrade(Grade grade);

    void addSubject(Subject subject);

    void addSemester(Semester semester);

    List<Grade> getGrades(Semester semester);

    List<Grade> getGrades(Subject subject);

    List<Grade> getGrades(Semester semester, Subject subject);

    List<Subject> getSubjects();

    List<Subject> getSubjects(Semester semester);

    List<Semester> getSemesters();

    Semester getCurrentSemester();

}
