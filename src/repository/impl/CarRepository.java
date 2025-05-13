package repository.impl;

import common.ReadAndWriteFile;
import entity.Car;
import entity.Drone;
import repository.ICarRepository;

import java.util.ArrayList;
import java.util.List;

public class CarRepository implements ICarRepository {
    private static final String PATH = "src/data/car.csv";

    private List<String> toStringList(List<Car> cars){
        List<String> stringList = new ArrayList<>();
        for (Car car : cars){
            stringList.add(car.toCSVFile());
        }
        return stringList;
    }
    @Override
    public void add(Car car) {
        List<String> stringList = new ArrayList<>();
        stringList.add(car.toCSVFile());
        ReadAndWriteFile.writeFileCSV(PATH, stringList, true);
    }

    @Override
    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        List<String> stringList = ReadAndWriteFile.readFileCSV(PATH);
        for (String s : stringList){
            String[] array = s.split("\\s*,\\s*");
            cars.add(new Car(array[0], array[1], Integer.parseInt(array[2]), array[3], Integer.parseInt(array[4])));
        }
        return cars;
    }

    @Override
    public void deleteById(String id) {
        List<Car> cars = findAll();
        for(int i = 0; i < cars.size(); i++){
            if(cars.get(i).getId().equals(id)){
                cars.remove(i);
                break;
            }
        }
        List<String> stringList = toStringList(cars);
        ReadAndWriteFile.writeFileCSV(PATH, stringList, false);
    }
}
