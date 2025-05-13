package common;

import controller.VehicleController;
import entity.Vehicle;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputDroneId() {
        String id;
        String regex = "^DRN-\\d{3}";
        Pattern pattern = Pattern.compile(regex);
        do {
            System.out.print("Nhập id (DRN-XXX): ");
            id = scanner.nextLine();
            Matcher matcher = pattern.matcher(id);
            if(matcher.matches()){
                return id;
            }
            System.out.println("Không hợp lệ");
        }while (true);
    }

    public static String inputCarId() {
        String id;
        String regex = "^XTT-\\d{3}";
        Pattern pattern = Pattern.compile(regex);
        do {
            System.out.print("Nhập id (XTT-XXX): ");
            id = scanner.nextLine();
            Matcher matcher = pattern.matcher(id);
            if(matcher.matches()){
                return id;
            }
            System.out.println("Không hợp lệ");
        }while (true);
    }

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

    public static int inputYear() {
        int year = 0;
        LocalDate localDate = LocalDate.now();
        do{
            System.out.print("Nhập năm sản xuất: ");
            year = Integer.parseInt(scanner.nextLine());
            if(localDate.getYear() < year){
                System.out.println("Không hợp lệ");
            }else{
                return year;
            }
        }while (true);
    }
}
