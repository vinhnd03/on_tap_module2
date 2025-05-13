package repository.impl;

import common.ReadAndWriteFile;
import entity.Car;
import entity.Drone;
import repository.IDroneRepository;

import java.util.ArrayList;
import java.util.List;

public class DroneRepository implements IDroneRepository {
    private static final String PATH = "src/data/drone.csv";

    private List<String> toStringList(List<Drone> drones){
        List<String> stringList = new ArrayList<>();
        for (Drone drone : drones){
            stringList.add(drone.toCSVFile());
        }
        return stringList;
    }
    @Override
    public void add(Drone drone) {
        List<String> stringList = new ArrayList<>();
        stringList.add(drone.toCSVFile());
        ReadAndWriteFile.writeFileCSV(PATH, stringList, true);
    }

    @Override
    public List<Drone> findAll() {
        List<Drone> drones = new ArrayList<>();
        List<String> stringList = ReadAndWriteFile.readFileCSV(PATH);
        for (String s : stringList){
            String[] array = s.split("\\s*,\\s*");
            drones.add(new Drone(array[0], array[1], Integer.parseInt(array[2]), array[3], Double.parseDouble(array[4])));
        }
        return drones;
    }

    @Override
    public void deleteById(String id) {
        List<Drone> drones = findAll();
        for(int i = 0; i < drones.size(); i++){
            if(drones.get(i).getId().equals(id)){
                drones.remove(i);
                break;
            }
        }
        List<String> stringList = toStringList(drones);
        ReadAndWriteFile.writeFileCSV(PATH, stringList, false);
    }
}
