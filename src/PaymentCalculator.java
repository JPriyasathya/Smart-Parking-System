public class PaymentCalculator {
    public static double calculatePayment(Vehicle vehicle) {
        if (vehicle instanceof Bike) return 20;
        else if (vehicle instanceof Car) return 50;
        else if (vehicle instanceof Truck) return 100;
        return 0;
    }
}