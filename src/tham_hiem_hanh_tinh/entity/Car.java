package tham_hiem_hanh_tinh.entity;

public class Car extends Vehicle{
    private int resistance;

    public Car(String id, String brand, int year, String coordinator, int resistance) {
        super(id, brand, year, coordinator);
        this.resistance = resistance;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    @Override
    public String toCSVFile() {
        return super.getId() + "," + super.getBrand() + "," + super.getYear() + "," + super.getCoordinator() + "," + resistance;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", resistance='" + resistance + '\'' +
                '}';
    }
}
