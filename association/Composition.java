package association;

class Room {
    private String name;

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class House {
    private String address;
    private Room room;  // Composition: House owns Room

    public House(String address, String roomName) {
        this.address = address;
        this.room = new Room(roomName); // Room is created when House is created
    }

    public void showDetails() {
        System.out.println("House at " + address + " has a " + room.getName() + " room.");
    }
}

public class Composition {
    public static void main(String[] args) {
        House house = new House("123 Main St.", "Living");
        house.showDetails();
    }
}

