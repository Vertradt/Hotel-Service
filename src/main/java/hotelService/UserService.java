package hotelService;

import java.util.List;

class UserService {
    private Hotel hotel;

    public UserService(Hotel hotel) {
        this.hotel = hotel;
    }

    List<Room> allRooms() {
        return hotel.getAllRooms();
    }

    List<Room> availableRooms() {
        return hotel.getAllAvaliableRooms();
    }

    void booking(int number, List<Guest> guests) {
        validateGuestAge(guests);
        Room room = findRoom(number);
        room.addGuest(guests);
        room.book();
    }

    private void validateGuestAge(List<Guest> guests) {
        int i = 0;
        for (Guest guest : guests) {
            if (guest.validateAge() < 18) {
                i++;
            }
        }
        if (i == guests.size()) {
            throw new GuestAgeException();
        }
    }

    private Room findRoom(int number) {
        Room room = hotel.findBy(number);
        if (room.isBooked()) {
            throw new BookingException();
        }
        return room;
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
