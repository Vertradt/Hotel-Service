package hotelService;

import java.time.LocalDate;
import java.util.List;

class UserService {
    private Hotel hotel;

    UserService(Hotel hotel) {
        this.hotel = hotel;
    }

    List<Room> allRooms() {
        return hotel.getAllRooms();
    }

    List<Room> availableRooms() {
        return hotel.getAllAvaliableRooms();
    }

    void booking(Room room, List<Guest> guests, LocalDate bookingDate, LocalDate unbookingDate) {
        validateGuestAge(guests);
        room.addGuest(guests);
        room.setBookingDate(bookingDate);
        room.setUnbookingDate(unbookingDate);
        room.book();
    }


    void validateCleanliness(Room room) {
        if (room.isClean()) {
            throw new CleanlinessException();
        }
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

    Room findRoom(int number) {
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
            room.unClean();
        } else {
            throw new UnbookingException();
        }
    }
}
