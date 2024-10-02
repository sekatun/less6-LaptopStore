package less6;
import java.util.*;

public class Laptop {
    private String brand;
    private int ram; // ОЗУ (в ГБ)
    private int storage; // Объем ЖД (в ГБ)
    private String os; // Операционная система
    private String color; // Цвет

    public Laptop(String brand, int ram, int storage, String os, String color) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                "GB, storage=" + storage +
                "GB, os='" + os + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
