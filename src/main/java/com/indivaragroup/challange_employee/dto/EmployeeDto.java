package com.indivaragroup.challange_employee.dto;

public class EmployeeDto {
    private String name;
    private double salary;
    private String address;
    private char gender;

    public EmployeeDto(String name, double salary, String address, char gender) {
        this.name = name;
        this.salary = salary;
        this.address = address;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getAddress() {
        return address;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                '}';
    }
}
