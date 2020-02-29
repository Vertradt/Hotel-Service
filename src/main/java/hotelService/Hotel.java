package hotelService;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Room> rooms = new ArrayList<>();

    public Hotel() {
        rooms.add(new Room(1, 1));
        rooms.add(new Room(2, 2));
        rooms.add(new Room(3, 3));
        rooms.add(new Room(4, 4));
        rooms.add(new Room(5, 1));
        rooms.add(new Room(6, 2));
        rooms.add(new Room(7, 3));
        rooms.add(new Room(8, 4));
        rooms.add(new Room(9, 2));
        rooms.add(new Room(10, 3));
    }
}
