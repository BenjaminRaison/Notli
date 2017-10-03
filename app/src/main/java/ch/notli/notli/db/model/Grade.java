package ch.notli.notli.db.model;

import java.util.Date;

public class Grade {

    private int id;
    private String name;
    private Date date;
    private double weight;
    private double grade;
    private Subject subject;
    private Semester semester;

    public Grade(String name, Date date, double weight, double grade, Subject subject,
                 Semester semester) {
        this.name = name;
        this.date = date;
        this.weight = weight;
        this.grade = grade;
        this.subject = subject;
        this.semester = semester;
    }

    public Grade(int id, String name, Date date, double weight, double grade, Subject subject,
                 Semester semester) {

        this.id = id;
        this.name = name;
        this.date = date;
        this.weight = weight;
        this.grade = grade;
        this.subject = subject;
        this.semester = semester;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}
