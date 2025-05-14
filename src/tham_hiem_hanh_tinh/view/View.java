package tham_hiem_hanh_tinh.view;

import tham_hiem_hanh_tinh.common.InputValidation;
import tham_hiem_hanh_tinh.controller.VehicleController;
import tham_hiem_hanh_tinh.entity.Brand;
import tham_hiem_hanh_tinh.entity.Car;
import tham_hiem_hanh_tinh.entity.Drone;
import tham_hiem_hanh_tinh.entity.Vehicle;

import java.util.List;
import java.util.Scanner;

public class View {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        VehicleController.displayMenu();
    }
    public static Drone inputDrone() {
        System.out.print("Nhập số hiệu: ");
        String id = InputValidation.validateString("^DRN-\\d{3}$", "Số hiệu không hợp lệ");
        String brand = InputValidation.inputBrand();
//        System.out.print("Nhập năm sản xuất: ");
//        int year = Integer.parseInt(scanner.nextLine());
        int year = InputValidation.inputYear();
        System.out.print("Nhập người điều phối: ");
        String coordinator = InputValidation.validateString("^([A-Z][a-z]*)\\s([A-Z][a-z]*\\s)*([A-Z][a-z]*)$", "Tên không hợp lệ");
        System.out.print("Nhập tầm bay tối đa: ");
        Double flyRange = InputValidation.validateDouble(0, Double.MAX_VALUE, "Tầm bay không hợp lệ");
        return new Drone(id, brand, year,coordinator, flyRange);
    }

    public static Car inputCar() {
        System.out.print("Nhập số hiệu: ");
        String id = InputValidation.validateString("^XTT-\\d{3}$", "Số hiệu không hợp lệ");
        String brand = InputValidation.inputBrand();
        int year = InputValidation.inputYear();
        System.out.print("Nhập người điều phối: ");
        String coordinator = InputValidation.validateString("^([A-Z][a-z]*)\\s([A-Z][a-z]*\\s)*([A-Z][a-z]*)$", "Tên không hợp lệ");
        System.out.print("Nhập khả năng chống bức xạ (1 -> 10): ");
        int resistance = InputValidation.validateInteger(1, 10, "Dữ liệu không hợp lệ");
        return new Car(id, brand, year,coordinator, resistance);
    }

    public static void displayDroneList(List<Drone> drones) {
        for (Drone vehicle : drones){
            System.out.println(vehicle);
        }
    }

    public static void displayCarList(List<Car> cars) {
        for (Car vehicle : cars){
            System.out.println(vehicle);
        }
    }

    public static String inputId() {
        System.out.print("Nhập số hiệu phương tiện muốn tìm / xóa: ");
        return scanner.nextLine();
    }

    public static String inputCoordinator() {
        System.out.print("Nhập tên người điều phối phương tiện muốn tìm: ");
        return scanner.nextLine();
    }

    public static void displayVehicleInfo(Vehicle vehicle) {
        System.out.println(vehicle);
    }

    public static boolean confirmDelete() {
        do {
            System.out.print("Bạn có muốn xóa phương tiện này (yes / no): ");
            String input = scanner.nextLine();
            if(input.equals("yes")){
                return true;
            }else if(input.equals("no")){
                return false;
            } else {
                System.out.println("Không hợp lệ");
                return false;
            }
        }while (true);
    }

    public static void displayBrandList(List<Brand> brands) {
        for (Brand brand : brands){
            System.out.println(brand);
        }
    }
}
