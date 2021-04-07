package assignments.assignment5.classes;

import org.springframework.beans.factory.annotation.Required;

public class Teacher {

    private String teacherName;
    private Integer teacherId;

    public Teacher() {
        super();
    }

    public String getTeacherName() {
        return teacherName;
    }

//////// Demonstrating @Required :- Name & Marks Required . Without setting Name and Marks , Bean cannot be initialized
    @Required
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    @Required
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherName='" + teacherName + '\'' +
                ", teacherId=" + teacherId +
                '}';
    }
}
