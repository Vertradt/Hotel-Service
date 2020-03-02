package hotelService;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Room> rooms = new ArrayList<>();

    public Hotel() {
        rooms.add(new Room(1, 1, true));
        rooms.add(new Room(2, 2, false));
        rooms.add(new Room(3, 3, false));
        rooms.add(new Room(4, 4, true));
        rooms.add(new Room(5, 1, true));
        rooms.add(new Room(6, 2, true));
        rooms.add(new Room(7, 3, false));
        rooms.add(new Room(8, 4, true));
        rooms.add(new Room(9, 2, false));
        rooms.add(new Room(10, 3, false));
    }

    public List<Room> getRooms() {
        return rooms;
    }
}