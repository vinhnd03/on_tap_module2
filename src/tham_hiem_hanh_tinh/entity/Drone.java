package tham_hiem_hanh_tinh.entity;

public class Drone extends Vehicle{
    private double flyRange;

    public Drone(String id, String brand, int year, String coordinator, double flyRange) {
        super(id, brand, year, coordinator);
        this.flyRange = flyRange;
    }

    public double getFlyRange() {
        return flyRange;
    }

    public void setFlyRange(double flyRange) {
        this.flyRange = flyRange;
    }

    @Override
    public String toCSVFile() {
        return super.getId() + "," + super.getBrand() + "," + super.getYear() + "," + super.getCoordinator() + "," + flyRange;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", flyRange='" + flyRange + '\'' +
                '}';
    }
}
