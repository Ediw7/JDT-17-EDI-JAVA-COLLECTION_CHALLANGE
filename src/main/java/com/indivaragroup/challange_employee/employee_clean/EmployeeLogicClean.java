package com.indivaragroup.challange_employee.employee_clean;

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
        for (EmployeeDto e : list) {
            System.out.println(e.toString());
        }
        System.out.println();
    }

    public static void main(String[] args) {
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
