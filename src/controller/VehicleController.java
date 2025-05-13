package controller;

import common.NotFoundVehicleException;
import entity.Brand;
import entity.Car;
import entity.Drone;
import entity.Vehicle;
import service.IBrandService;
import service.ICarService;
import service.IDroneService;
import service.IVehicleService;
import service.impl.BrandService;
import service.impl.CarService;
import service.impl.DroneService;
import service.impl.VehicleService;
import view.View;

import java.util.List;
import java.util.Scanner;

public class VehicleController {
    private static Scanner scanner = new Scanner(System.in);
    private static IVehicleService vehicleService = new VehicleService();
    private static ICarService carService = new CarService();
    private static IDroneService droneService = new DroneService();
    private static IBrandService brandService = new BrandService();

    public static void displayMenu() {
        do {
            System.out.println("===============[MENU]==============");
            System.out.println("1. Thêm mới phương tiện");
            System.out.println("2. Hiển thị danh sách phương tiện");
            System.out.println("3. Tìm kiếm phương tiện");
            System.out.println("4. Xóa phương tiện");
            System.out.println("5. Thoát chương trình");
            System.out.println("===================================");
            System.out.print("Lựa chọn: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("1. Thêm mới phương tiện");
                        add();
                        break;
                    case 2:
                        System.out.println("2. Hiển thị danh sách phương tiện");
                        display();
                        break;
                    case 3:
                        System.out.println("3. Tìm kiếm phương tiện");
                        search();
                        break;
                    case 4:
                        System.out.println("4. Xóa phương tiện");
                        delete();
                        break;
                    case 5:
                        System.out.println("Tạm biệt");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Không hợp lệ");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng số");
            }
        } while (true);
    }

    private static void delete() {
        String id = View.inputId();
        try {
            Vehicle vehicle = vehicleService.findById(id);
            boolean confirm = View.confirmDelete();
            if(confirm){
                vehicleService.deleteById(id);
                System.out.println("Xóa thành công");
            }
        }catch (NotFoundVehicleException e){
            System.out.println(e.getMessage());
        }

    }


    private static void search() {
        boolean flag = true;
        do {
            System.out.println("=====[Tìm kiếm]=====");
            System.out.println("1.  Theo số hiệu");
            System.out.println("2.  Tên người điều phối");
            System.out.println("3.  Trờ về");
            System.out.println("====================");
            System.out.print("Lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    String id = View.inputId();
                    try {
                        Vehicle vehicle = vehicleService.findById(id);
                        View.displayVehicleInfo(vehicle);
                    } catch (NotFoundVehicleException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    String coordinator = View.inputCoordinator();
                    Vehicle vehicle2 = vehicleService.findByCoordinator(coordinator);
                    if(vehicle2 == null){
                        System.out.println("Không tìm thấy");
                        return;
                    }
                    View.displayVehicleInfo(vehicle2);
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Không hợp lệ");
                    break;
            }
        }while (flag);
    }

    private static void display() {
        boolean flag = true;
        do {
            System.out.println("=====[Hiển thị]=====");
            System.out.println("1.  Drone bay");
            System.out.println("2.  Xe tuần tra");
            System.out.println("3.  Trờ về");
            System.out.println("====================");
            System.out.print("Lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    List<Drone> drones = droneService.findAll();
                    View.displayDroneList(drones);
                    break;
                case 2:
                    List<Car> cars = carService.findAll();
                    View.displayCarList(cars);
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Không hợp lệ");
                    break;
            }
        }while (flag);
    }

    private static void add() {
        boolean flag = true;
        do {
            System.out.println("=====[Thêm mới]=====");
            System.out.println("1.  Drone bay");
            System.out.println("2.  Xe tuần tra");
            System.out.println("3.  Trờ về");
            System.out.println("====================");
            System.out.print("Lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    Drone drone = View.inputDrone();
                    droneService.add(drone);
                    System.out.println("Thêm mới thành công");
                    break;
                case 2:
                    Car car = View.inputCar();
                    carService.add(car);
                    System.out.println("Thêm mới thành công");
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Không hợp lệ");
                    break;
            }
        }while (flag);
    }

    public static void displayBrandList() {
        List<Brand> brands = brandService.findAll();
        View.displayBrandList(brands);
    }

    public static boolean checkBrandId(String id) {
        if(brandService.findById(id) != null){
            return true;
        }
        return false;
    }
}
