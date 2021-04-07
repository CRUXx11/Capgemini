package assignments.assignment9.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class FatherBean {

    private String name;
    private Integer age;
    @Autowired
    @Qualifier("sonBean")
    private SonBean son;

    public FatherBean() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public SonBean getSon() {
        return son;
    }

    public void setSon(SonBean son) {
        this.son = son;
    }


    public void initFather(){
        System.out.println("---------Inside fatherBean.initFather()----------");
        System.out.println("Setting variable values");
        this.setName("Lionel Messi");
        this.setAge(45);
    }


    public void destroyFather(){
        System.out.println("--------Inside sonFather.destroyFather()-----------");
        System.out.println("Destroying fatherBean .. inside fatherBean.destroyBean()");
    }

    @Override
    public String toString() {
        return "FatherBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", son=" + son +
                '}';
    }
}
