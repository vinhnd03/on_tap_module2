package view;

import common.InputValidation;
import controller.VehicleController;
import entity.Brand;
import entity.Car;
import entity.Drone;
import entity.Vehicle;

import java.util.List;
import java.util.Scanner;

public class View {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        VehicleController.displayMenu();
    }
    public static Drone inputDrone() {
        String id = InputValidation.inputDroneId();
        String brand = InputValidation.inputBrand();
//        System.out.print("Nhập năm sản xuất: ");
//        int year = Integer.parseInt(scanner.nextLine());
        int year = InputValidation.inputYear();
        System.out.print("Nhập người điều phối: ");
        String coordinator = scanner.nextLine();
        System.out.print("Nhập tầm bay tối đa: ");
        Double flyRange = Double.parseDouble(scanner.nextLine());
        return new Drone(id, brand, year,coordinator, flyRange);
    }

    public static Car inputCar() {
        System.out.print("Nhập id: ");
        String id = scanner.nextLine();
        System.out.print("Nhập hãng: ");
        String brand = scanner.nextLine();
        System.out.print("Nhập năm sản xuất: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập người điều phối: ");
        String coordinator = scanner.nextLine();
        System.out.print("Nhập khả năng chống bức xạ: ");
        int resistance = Integer.parseInt(scanner.nextLine());
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
