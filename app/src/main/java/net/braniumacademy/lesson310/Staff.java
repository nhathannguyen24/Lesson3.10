package net.braniumacademy.lesson310;

import androidx.annotation.NonNull;

import java.util.Date;

public class Staff {
    private String staffId;
    private String firstName;
    private String lastName;
    private String midName;
    private Date birthDate;
    private long salary;

    public Staff(String staffId, String fullName, String birthDate, long salary) {
        setStaffId(staffId);
        setBirthDate(birthDate);
        setFullName(fullName);
        setSalary(salary);
    }

    private void setFullName(String fullName) {
        String[] names = fullName.split("\\s+");
        String first = "";
        String last = "";
        StringBuilder midName = new StringBuilder();
        if (names.length == 1) {
            first = names[0];
        } else if (names.length == 2) {
            first = names[1];
            last = names[0];
        } else if (names.length > 2) {
            first = names[names.length - 1];
            last = names[0];
            for (int i = 1; i < names.length - 1; i++) {
                midName.append(names[i]).append(" ");
            }
        }
        setFirstName(first);
        setLastName(last);
        setMidName(midName.toString().trim());
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public void setBirthDate(String dateStr) {
        this.birthDate = Utils.stringToDate(dateStr);
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @NonNull
    @Override
    public String toString() {
        return staffId + " - " + lastName + " " + midName + " " + firstName +
                " - " + Utils.dateToString(birthDate) + " - " + salary;
    }
}
