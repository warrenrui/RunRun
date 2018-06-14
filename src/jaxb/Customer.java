package jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Customer")
@XmlType(name = "Customer", propOrder = {"id", "age", "name", "sex", "isAudlt"})
public class Customer {
    @XmlAttribute
    int id;
    @XmlElement
    String name;
    @XmlElement
    int age;
    @XmlElement(required = true)
    String sex;
    @XmlAttribute
    boolean isAudlt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isAudlt() {
        return isAudlt;
    }

    public void setAudlt(boolean isAudlt) {
        this.isAudlt = isAudlt;
    }

}