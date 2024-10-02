package less6;
import java.util.*;

public class LaptopStore {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Dell", 16, 512, "Windows", "Black"));
        laptops.add(new Laptop("Apple", 8, 256, "macOS", "Silver"));
        laptops.add(new Laptop("HP", 16, 1024, "Windows", "Black"));
        laptops.add(new Laptop("Asus", 32, 512, "Linux", "Gray"));
        laptops.add(new Laptop("Lenovo", 8, 512, "Windows", "White"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1 - Фильтровать ноутбуки");
            System.out.println("2 - Выйти");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                filterLaptops(laptops);
            } else if (choice.equals("2")) {
                System.out.println("Завершение программы.");
                break;
            } else {
                System.out.println("Некорректный ввод. Попробуйте снова.");
            }
        }
    }


    public static void filterLaptops(Set<Laptop> laptops) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Object> filterCriteria = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        System.out.println("5 - Бренд");

        String[] criteria = scanner.nextLine().split(",");
        for (String criterion : criteria) {
            switch (criterion.trim()) {
                case "1":
                    System.out.println("Введите минимальный объем ОЗУ (в ГБ): ");
                    int ram = scanner.nextInt();
                    filterCriteria.put("ram", ram);
                    break;
                case "2":
                    System.out.println("Введите минимальный объем ЖД (в ГБ): ");
                    int storage = scanner.nextInt();
                    filterCriteria.put("storage", storage);
                    break;
                case "3":
                    System.out.println("Введите необходимую операционную систему их списка (Windows, macOS, Linux): ");
                    String os = scanner.nextLine();
                    filterCriteria.put("os", os);
                    break;
                case "4":
                    System.out.println("Введите необходимый цвет из списка (Black, Silver, Gray, White): ");
                    String color = scanner.nextLine();
                    filterCriteria.put("color", color);
                case "5":
                    System.out.println("Введите необходимый бренд из списка (Dell, Apple, HP, Asus, Lenovo): ");
                    String brand = scanner.nextLine();
                    filterCriteria.put("brand", brand);
                    break;
                default:
                    System.out.println("Неверный ввод.");
                    break;
            }
        }
        Set<Laptop> filteredLaptops = new HashSet<>(laptops);
        for (Laptop laptop : laptops) {
            if (filterCriteria.containsKey("ram") && laptop.getRam() < (int) filterCriteria.get("ram")) {
                filteredLaptops.remove(laptop);
            }
            if (filterCriteria.containsKey("storage") && laptop.getStorage() < (int) filterCriteria.get("storage")) {
                filteredLaptops.remove(laptop);
            }
            if (filterCriteria.containsKey("os") && !laptop.getOs().equalsIgnoreCase((String) filterCriteria.get("os"))) {
                filteredLaptops.remove(laptop);
            }
            if (filterCriteria.containsKey("color") && !laptop.getColor().equalsIgnoreCase((String) filterCriteria.get("color"))) {
                filteredLaptops.remove(laptop);}
            if (filterCriteria.containsKey("brand") && !laptop.getBrand().equalsIgnoreCase((String) filterCriteria.get("brand"))) {
                filteredLaptops.remove(laptop);}
        }
        if (filteredLaptops.isEmpty()) {
            System.out.println("Ноутбуки, удовлетворяющие критериям, не найдены.");
        } else {
            System.out.println("Найденные ноутбуки:");
            for (Laptop laptop : filteredLaptops) {
                System.out.println(laptop);
            }
        }
    }
}