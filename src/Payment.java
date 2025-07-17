public class Payment {
    private Vehicle vehicle;
    public Payment(Vehicle vehicle) { this.vehicle = vehicle; }
    public void makePayment(double amount) {
        System.out.println("Payment successful for " + vehicle.getNumber() + " : Rs." + amount);
    }
}