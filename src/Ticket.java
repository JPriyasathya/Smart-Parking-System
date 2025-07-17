public class Ticket {
    private Vehicle vehicle;
    private Floor floor;
    private Slot slot;

    public Ticket(Vehicle vehicle, Floor floor, Slot slot) {
        this.vehicle = vehicle;
        this.floor = floor;
        this.slot = slot;
    }

    @Override
    public String toString() {
        return "[Floor: " + floor + ", Slot: " + slot.getSlotNumber() + ", Vehicle: " + vehicle.getNumber() + "]";
    }
}