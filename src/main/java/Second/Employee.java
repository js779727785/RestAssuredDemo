package Second;


import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * @JsonInclude annotation - Payload中忽略默认值字段
 * 在序列化时不想加入某一字段，加该注解，否则还是会序列化出来只不过值为null或0
 * 用于表明被注释的属性（某个字段，方法， 构造函数参数），
 * 或 被注释类的所有属性将要序列化。使用这个注释可以具体指定简单的排除规则来减少属性的输入。
 * **/
//@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Employee {

    // private variables or data members of pojo class
    private String firstName;
    private String lastName;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String gender;
    private int age;
    private double salary;
    private boolean married;

    // Getter and setter methods
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public boolean getMarried() {
        return married;
    }
    public void setMarried(boolean married) {
        this.married = married;
    }
}

