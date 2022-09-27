package Second;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

class MSE_EmployeePojo {

    private String firstName;
    private String lastName;
    private String gender;

    private int age;
    private double salary;
    private boolean isMarried;

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

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean isMarried) {
        this.isMarried = isMarried;
    }
}

public class UsageOfMSE_EmployeePojo {
    public static void main(String[] args) throws IOException {

        MSE_EmployeePojo mse_EmployeePojo = new MSE_EmployeePojo();
        mse_EmployeePojo.setFirstName("SKevin2");
        mse_EmployeePojo.setLastName("Zhang");
        mse_EmployeePojo.setAge(19);
        mse_EmployeePojo.setSalary(20987.77);
        mse_EmployeePojo.setMarried(false);
        mse_EmployeePojo.setGender("M");

        ObjectMapper objectMapper = new ObjectMapper();
        String convertedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mse_EmployeePojo);
        System.out.println(convertedJson);

        String userDir = System.getProperty("user.dir");
        System.out.println("user dir: " + userDir);
        File outputJsonFile = new File(userDir+"/src/test/java/resources/EmployeePayload.json");
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(outputJsonFile, mse_EmployeePojo);
    }
}

