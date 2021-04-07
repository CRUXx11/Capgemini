package assignments.assignment9.classes;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SonBean {

    private String name;
    private Integer age;

    public SonBean() {
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

    @PostConstruct
    public void initSon(){
        System.out.println("---------Inside sonBean.initSon()----------");
        System.out.println("Setting variable values");
        this.setName("Thiago Messi");
        this.setAge(15);
        System.out.println(this.toString());
    }

    @PreDestroy
    public void destroySon(){
        System.out.println("--------Inside sonBean.destroySon()-----------");
        System.out.println("Destroying sonBean .. inside sonBean.destroyBean()");
    }

    @Override
    public String toString() {
        return "SonBean{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
