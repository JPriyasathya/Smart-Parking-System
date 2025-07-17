public class Slot {
    private int slotNumber;
    private Vehicle vehicle;

    public Slot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.vehicle = null;
    }

    public boolean isOccupied() { return vehicle != null; }

    public void park(Vehicle vehicle) { this.vehicle = vehicle; }

    public Vehicle unpark() {
        Vehicle temp = this.vehicle;
        this.vehicle = null;
        return temp;
    }

    public int getSlotNumber() { return slotNumber; }
    public Vehicle getVehicle() { return vehicle; }
}
