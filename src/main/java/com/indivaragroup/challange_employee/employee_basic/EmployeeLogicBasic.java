package com.indivaragroup.challange_employee.employee_basic;

import com.indivaragroup.challange_employee.data.EmployeeData;
import com.indivaragroup.challange_employee.dto.EmployeeDto;

import java.util.ArrayList;
import java.util.List;

public class EmployeeLogicBasic {
    public static void sortName(List<EmployeeDto> list){
        int nameTotal = list.size();

        for (int i = 0; i < nameTotal - 1; i++){
            for (int j = 0; j < nameTotal-1; j++){
                if (list.get(j).getName().compareToIgnoreCase(list.get(j+1).getName()) > 0){
                    EmployeeDto temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        printList(list);
    }


    public static void countGender(List<EmployeeDto> list){
        int totalGenderL = 0;
        int totalGenderP = 0;

        for (EmployeeDto e : list){
            if (e.getGender() == 'L' || e.getGender() == 'l'){
                totalGenderL++;

            } else if (e.getGender() == 'P' || e.getGender() == 'p'){
                totalGenderP++;
            }

        }

        int total = totalGenderL + totalGenderP;

        System.out.println("total jens kelamin laki laki = " + totalGenderL);
        System.out.println("total jenis kelamin perempuan = " + totalGenderP);
        System.out.println("total orangnya = " + total);
        System.out.println();

    }
    public static void sortAddress(List<EmployeeDto> list){
        if (list == null || list.isEmpty()) return;

        int adress = list.size();
        for (int i = 0; i < adress - 1; i++) {
            for (int j = 0; j < adress - i - 1; j++) {
                if (list.get(j).getAddress().compareToIgnoreCase(list.get(j + 1).getAddress()) > 0) {
                    EmployeeDto temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        String cityNow = list.get(0).getAddress();
        int count = 1;

        for (int i = 1; i < adress; i++) {
            String cityPeople = list.get(i).getAddress();

            if (cityPeople.equalsIgnoreCase(cityNow)) {
                count++;
            } else {
                System.out.println("- " + cityNow + " : " + count + " pegawai");
                cityNow = cityPeople;
                count = 1;
            }
        }

        System.out.println("- " + cityNow + " : " + count + " pegawai");
        System.out.println();

    }

    public static void sortSalary(List<EmployeeDto> list){
        int salary = list.size();

        for (int i = 0; i < salary - 1; i++){
            for (int j = 0; j < salary-1; j++){
                if (list.get(j).getSalary() < (list.get(j).getSalary())){
                    EmployeeDto temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        printList(list);
    }

    private static void printList(List<EmployeeDto> list) {
        for (EmployeeDto e : list) {
            System.out.println(e.toString());
        }
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
