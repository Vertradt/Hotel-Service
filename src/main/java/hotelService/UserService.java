package hotelService;

import java.util.List;

class UserService {
    private Hotel hotel;

    UserService(Hotel hotel) {
        this.hotel = hotel;
    }

    List<Room> allRooms() {
        return hotel.getAllRooms();
    }

    List<Room> avaliableRooms() {
        return hotel.getAllAvaliableRooms();
    }

    void booking(int number) {
        Room room = hotel.findBy(number);
        if (room.isBooked()) {
            throw new BookingException();
        }
        room.book();

    }

    void unbooking(int number) {
        Room room = hotel.findBy(number);
        if (room.isBooked()) {
            room.unbook();
        } else {
            throw new UnbookingException();
        }
    }

}
