import java.util.*;

public class Floor {
    private int floorNumber;
    private List<Slot> slots;

    public Floor(int floorNumber, int totalSlots) {
        this.floorNumber = floorNumber;
        slots = new ArrayList<>();
        for (int i = 0; i < totalSlots; i++) {
            slots.add(new Slot(i + 1));
        }
    }

    public Slot park(Vehicle vehicle) {
        for (Slot slot : slots) {
            if (!slot.isOccupied()) {
                slot.park(vehicle);
                return slot;
            }
        }
        return null;
    }

    public Vehicle unpark(int slotNumber) {
        if (slotNumber > 0 && slotNumber <= slots.size()) {
            Slot slot = slots.get(slotNumber - 1);
            Vehicle vehicle = slot.unpark();
            return vehicle;
        }
        return null;
    }

    public void showSlots() {
        System.out.println("Floor " + floorNumber + ":");
        for (Slot slot : slots) {
            System.out.println("Slot " + slot.getSlotNumber() + " - " + (slot.isOccupied() ? slot.getVehicle().getNumber() : "Empty"));
        }
    }
}
