package org.rntgroup.framework.business;

public class Employee {
    private String fullName;

    private String status;

    private String birthday;

    public Employee(String fullName, String status, String birthday){
        this.fullName = fullName;
        this.status = status;
        this.birthday = birthday;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return status;
    }

    public String getBirthday() {
        return birthday;
    }
}
