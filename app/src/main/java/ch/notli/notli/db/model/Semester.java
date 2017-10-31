package ch.notli.notli.db.model;

import java.util.Date;
import java.util.List;

public class Semester {

    private int id;
    private String name;
    private Date start;
    private Date end;
    private List<Subject> subjects;

    public Semester(int id, String name, Date start, Date end, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
        this.subjects = subjects;
    }

    public Semester(String name, Date start, Date end, List<Subject> subjects) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.subjects = subjects;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

}
