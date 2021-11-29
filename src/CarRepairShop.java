import java.util.ArrayList;

public class CarRepairShop <T extends Car> {
    private ArrayList<T> carsInShop = new ArrayList<>();
    private final int maxCars;
    private int carCounter = 0;

    public CarRepairShop(int maxCars) {
        this.maxCars = maxCars;
    }

    public CarRepairShop() {
        this(50);
    }


    public void receiveCars(CarTransporterTruck<T> transporter) {
        if (maxCars > carCounter) {
            for (T car : transporter.getCarsTransported()) {
                if (car != null)
                    carsInShop.add(car);
                else
                    return;
            }
        } else
            System.out.println("The car repair shop is full and cannot receive more cars");
    }


    public Vehicle retrieveCar() {
        return carsInShop.remove(0);
    }
}
        






