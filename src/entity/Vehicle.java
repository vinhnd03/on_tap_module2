package entity;

public abstract class Vehicle {
    private String id;
    private String brand;
    private int year;
    private String coordinator;

    public Vehicle(String id, String brand, int year, String coordinator) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.coordinator = coordinator;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(String coordinator) {
        this.coordinator = coordinator;
    }

    public abstract String toCSVFile();

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                ", coordinator='" + coordinator + '\'';
    }
}
