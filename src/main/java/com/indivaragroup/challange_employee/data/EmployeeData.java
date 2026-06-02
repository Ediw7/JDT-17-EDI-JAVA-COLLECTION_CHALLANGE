package com.indivaragroup.challange_employee.data;

import com.indivaragroup.challange_employee.dto.EmployeeDto;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {
    public static List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> listEmployee = new ArrayList<>();

        listEmployee.add(new EmployeeDto("Edi", 8000000, "Batang", 'L'));
        listEmployee.add(new EmployeeDto("Anis", 7000000, "Semarang", 'P'));
        listEmployee.add(new EmployeeDto("Budi", 6000000, "Jakarta", 'L'));
        listEmployee.add(new EmployeeDto("Siti", 9000000, "Bandung", 'P'));
        listEmployee.add(new EmployeeDto("Joko", 2000000, "Batang", 'L'));
        listEmployee.add(new EmployeeDto("Rina", 5000000, "Jakarta", 'P'));
        listEmployee.add(new EmployeeDto("Andi", 8000000, "Semarang", 'L'));
        listEmployee.add(new EmployeeDto("Dewi", 9000000, "Bandung", 'P'));
        listEmployee.add(new EmployeeDto("Eko", 7000000, "Surabaya", 'L'));
        listEmployee.add(new EmployeeDto("Fitri", 1000000, "Semarang", 'P'));

        return listEmployee;
    }
}
