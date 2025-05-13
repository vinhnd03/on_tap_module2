package common;

import controller.VehicleController;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputBrand() {
        String brand;
        do {
            VehicleController.displayBrandList();
            System.out.print("Nhập mã hãng: ");
            brand = scanner.nextLine();
            if(VehicleController.checkBrandId(brand)){
                return brand;
            }
            System.out.println("Không hợp lệ");
        }while (true);
    }

    public static String validateDate(String pattern, String message){
        String date;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        do{
            try {
                date = scanner.nextLine();
                if(!checkEmpty(date)){
                    continue;
                }
                LocalDate.parse(date, formatter);
                return date;
            }catch (DateTimeException e){
                System.out.println(message);
                System.out.print("Nhập lại: ");
            }
        }while (true);
    }

    public static int inputYear() {
        int year = 0;
        LocalDate localDate = LocalDate.now();
        do{
            System.out.print("Nhập năm sản xuất: ");
            year = Integer.parseInt(scanner.nextLine());
            if(localDate.getYear() < year){
                System.out.println("Năm không hợp lệ");
            }else{
                return year;
            }
        }while (true);
    }



    public static String validateString(String regex, String message){
        String returnString;
        Pattern pattern = Pattern.compile(regex);
        do {
            returnString = scanner.nextLine();
            Matcher matcher = pattern.matcher(returnString);
            if(!checkEmpty(returnString)){
                continue;
            }
            if(matcher.matches()){
                return returnString;
            }
            System.out.println(message);
            System.out.print("Nhập lại: ");
        }while (true);
    }

    public static int validateInteger(int min, int max, String message){
        int number;
        do{
            number = Integer.parseInt(scanner.nextLine());
            if(!checkEmpty(String.valueOf(number))){
                continue;
            }

            if(number > 0 && number >= min && number <= max){
                return number;
            }
            System.out.println(message);
            System.out.print("Nhập lại: ");
        }while (true);
    }

    public static double validateDouble(double min, double max, String message){
        double number;
        do{
            number = Double.parseDouble(scanner.nextLine());
            if(!checkEmpty(String.valueOf(number))){
                continue;
            }

            if(number > 0 && number >= min && number <= max){
                return number;
            }
            System.out.println(message);
            System.out.print("Nhập lại: ");
        }while (true);
    }


    private static boolean checkEmpty(String string){
        if (string == null || string.trim().isEmpty()) {
            System.out.println("Không được để trống");
            System.out.print("Nhập lại: ");
            return false;
        }
        return true;
    }
}
