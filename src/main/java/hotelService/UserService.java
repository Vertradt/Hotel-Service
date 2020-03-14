package hotelService;

import java.util.List;

//    7. Dodaj klasę UserService która będzie służyć do obsługi hotelu. Na początek dodaj
//        funkcjonalności:
//        1. Pobierz listę wszystkich pokoi.
//        2. Pobierz listę wszystkich dostępnych pokoi.
//        3. Rezerwuj pokój (podaj nr pokoju i jeśli jest dostępny to go zarezerwuj).
//        4. Zwolnij pokój (podaj nr pokoju i jeśli jest zajęty to go zwolnij).
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

    List<Room> allBooked() {
        return hotel.getAllBookedRooms();
    }


    void bookingProcedure(int number) {
        do {
            bookingHandling(number);
        } while (!hotel.findBy(number).isBooked());
    }

    private void bookingHandling(int number) {
        try {
            booking(number);
        } catch (BookingException e) {
            System.out.println(e.getMessage());
        }
    }

    private void booking(int number) throws BookingException {
        Room room = hotel.findBy(number);
        if (room.isBooked()) {
            throw new BookingException();
        }
        room.book(true);

    }

    void unbookingProcedure(int number) {
        do {
            unbookingHandling(number);
        } while (hotel.findBy(number).isBooked());
    }


    private void unbookingHandling(int number) {
        try {
            unbooking(number);
        } catch (UnbookingException e) {
            System.out.println(e.getMessage());
        }
    }


    private void unbooking(int number) throws UnbookingException {
        Room room = hotel.findBy(number);
        if (room.isBooked()) {
            room.book(false);
        } else {
            throw new UnbookingException();
        }
    }
    boolean empty(){
        return hotel.roomsAreEmpty();
    }
}
