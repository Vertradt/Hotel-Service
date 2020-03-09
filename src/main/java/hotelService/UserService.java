package hotelService;

import java.util.List;


public class UserService {
    private Hotel hotel;

    public UserService(Hotel hotel) {
        this.hotel = hotel;
    }

    void displayAllRooms() {
        List<Room> allRooms = hotel.getAllRooms();
        for (Room room : allRooms) {
            System.out.println(room);
        }

    }

    void avaliableRooms() {
        hotel.getAllAvaliableRooms();
    }


    void booking(int number) {
        Room room = hotel.findBy(number);

        room.book(true);
    }

    void unbooking(int number) {
        Room room = hotel.findBy(number);
        if (room.isBooked()) {
            room.book(false);
        }
    }


}
