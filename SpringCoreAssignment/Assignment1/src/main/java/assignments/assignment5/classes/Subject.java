package assignments.assignment5.classes;


import org.springframework.beans.factory.annotation.Required;

public class Subject {

    private String subjectName;
    private Integer subjectMarks;

    public Subject(String subjectName, Integer subjectMarks) {
        this.subjectName = subjectName;
        this.subjectMarks = subjectMarks;
    }

    public Subject() {
        super();
    }

    public String getSubjectName() {
        return subjectName;
    }

//////// Demonstrating @Required :- Name & Marks Required . Without setting Name and Marks , Bean cannot be initialized
    @Required
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getSubjectMarks() {
        return subjectMarks;
    }

    @Required
    public void setSubjectMarks(Integer subjectMarks) {
        this.subjectMarks = subjectMarks;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectName='" + subjectName + '\'' +
                ", subjectMarks=" + subjectMarks +
                '}';
    }
}
