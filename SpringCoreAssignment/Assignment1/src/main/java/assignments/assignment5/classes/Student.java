package assignments.assignment5.classes;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import javax.inject.Inject;

@Component("student1")
public class Student {

    private Integer studentRollNumber;
    private String studentName;

    @Inject
    @Qualifier("subject1")
    private Subject subject;

    @Resource(name="teacher1")
    private Teacher teacher;

    public Integer getStudentRollNumber() {
        return studentRollNumber;
    }

    @Value("11704058")
    public void setStudentRollNumber(Integer studentRollNumber) {
        this.studentRollNumber = studentRollNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    @Value("Prathamesh Kathade")
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Subject getSubject() {
        return subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
