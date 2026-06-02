package com.indivaragroup.challange_employee.employee_clean;

import com.indivaragroup.challange_employee.data.EmployeeData;
import com.indivaragroup.challange_employee.dto.EmployeeDto;

import java.util.*;

public class EmployeeLogicClean {
    public static void sortName(List<EmployeeDto> list){
        list.sort(Comparator.comparing(EmployeeDto::getName, String.CASE_INSENSITIVE_ORDER));
        printList(list);
    }

    public static void countGender(List<EmployeeDto> list){
        int totalLaki = 0;
        int totalPerempuan = 0;

        for (EmployeeDto e : list) {
            if (Character.toUpperCase(e.getGender()) == 'L') {
                totalLaki++;
            } else if (Character.toUpperCase(e.getGender()) == 'P') {
                totalPerempuan++;
            }
        }

        System.out.println("Total Laki-laki = " + totalLaki);
        System.out.println("Total Perempuan = " + totalPerempuan);
        System.out.println("Total Pegawai   = " + (totalLaki + totalPerempuan));
        System.out.println();
    }



    public static void sortAddress(List<EmployeeDto> list){
        Map<String, Integer> cityMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (EmployeeDto e : list) {
            String city = e.getAddress();
            cityMap.put(city, cityMap.getOrDefault(city, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : cityMap.entrySet()) {
            System.out.println("- " + entry.getKey() + " : " + entry.getValue() + " pegawai");
        }
        System.out.println();
    }

    public static void sortSalary(List<EmployeeDto> list){
        list.sort(Comparator.comparingDouble(EmployeeDto::getSalary).reversed());
        printList(list);
    }

    private static void printList(List<EmployeeDto> list) {
        list.forEach(System.out::println);
        System.out.println();
    }

    public static void main(String[] args) {
        List<EmployeeDto> listEmployee = EmployeeData.getAllEmployees();

        System.out.println("SORTING NAMA (A-Z)");
        sortName(new ArrayList<>(listEmployee));

        System.out.println("HITUNG GENDER");
        countGender(listEmployee);

        System.out.println("HITUNG KOTA");
        sortAddress(listEmployee);

        System.out.println("SORTING GAJI (TERBESAR KE TERKECIL)");
        sortSalary(new ArrayList<>(listEmployee));
    }
}
