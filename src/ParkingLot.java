import java.util.*;

public class ParkingLot {
    private List<Floor> floors;
    private Scanner scanner;

    public ParkingLot(int totalFloors, int slotsPerFloor) {
        floors = new ArrayList<>();
        for (int i = 0; i < totalFloors; i++) {
            floors.add(new Floor(i + 1, slotsPerFloor));
        }
        scanner = new Scanner(System.in);
    }

    public void startSystem() {
        System.out.println("===== Smart Parking System =====");
        while (true) {
            System.out.println("1. Park Vehicle\n2. Unpark Vehicle\n3. Show Status\n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: parkVehicle(); break;
                case 2: unparkVehicle(); break;
                case 3: showStatus(); break;
                case 4: System.out.println("Exiting System"); return;
                default: System.out.println("Invalid Choice");
            }
        }
    }

    private void parkVehicle() {
        System.out.print("Enter Vehicle Type (car/bike/truck): ");
        String type = scanner.nextLine();
        System.out.print("Enter Vehicle Number: ");
        String number = scanner.nextLine();

        Vehicle vehicle;
        switch (type.toLowerCase()) {
            case "car": vehicle = new Car(number); break;
            case "bike": vehicle = new Bike(number); break;
            case "truck": vehicle = new Truck(number); break;
            default: System.out.println("Invalid vehicle type"); return;
        }

        for (Floor floor : floors) {
            Slot slot = floor.park(vehicle);
            if (slot != null) {
                Ticket ticket = new Ticket(vehicle, floor, slot);
                System.out.println("Parked Successfully! Ticket ID: " + ticket);
                return;
            }
        }
        System.out.println("Parking Full");
    }

    private void unparkVehicle() {
        System.out.print("Enter Floor Number: ");
        int floorNumber = scanner.nextInt();
        System.out.print("Enter Slot Number: ");
        int slotNumber = scanner.nextInt();
        scanner.nextLine();
        if (floorNumber <= floors.size()) {
            Floor floor = floors.get(floorNumber - 1);
            Vehicle vehicle = floor.unpark(slotNumber);
            if (vehicle != null) {
                Payment payment = new Payment(vehicle);
                double amount = PaymentCalculator.calculatePayment(vehicle);
                payment.makePayment(amount);
                System.out.println("Unparked Successfully. Payment Done: Rs." + amount);
            } else {
                System.out.println("Slot is already empty.");
            }
        } else {
            System.out.println("Invalid Floor Number.");
        }
    }

    private void showStatus() {
        for (Floor floor : floors) {
            floor.showSlots();
        }
    }
}
