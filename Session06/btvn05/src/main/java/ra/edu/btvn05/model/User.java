package ra.edu.btvn05.model;

import java.util.Date;

public class User {
    private String name;
    private int age;
    private Date birthday;
    private String email;
    private String phone;

    public User() {
    }

    public User(String name, int age, Date birthday, String email, String phone) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
    }

    // Getter + Setter
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
