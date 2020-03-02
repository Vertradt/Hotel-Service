package hotelService;

import java.util.ArrayList;
import java.util.List;

//    7. Dodaj klasę UserService która będzie służyć do obsługi hotelu. Na początek dodaj
//        funkcjonalności:
//        1. Pobierz listę wszystkich pokoi.
//        2. Pobierz listę wszystkich dostępnych pokoi.
//        3. Rezerwuj pokój (podaj nr pokoju i jeśli jest dostępny to go zarezerwuj).
//        4. Zwolnij pokój (podaj nr pokoju i jeśli jest zajęty to go zwolnij).
public class UserService {
    private Hotel hotel;

    public UserService(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Room> giveAllRooms() {
        return hotel.getRooms();
    }

    public List<Room> giveNotBooked() {
        List<Room> allRooms = hotel.getRooms();
        List<Room> notBookedRooms = new ArrayList<>();

        for (Room room : allRooms) {
            if (!room.isBooked()) {
                notBookedRooms.add(room);
            }
        }
        return notBookedRooms;
    }

    void booking(Room room) {
        room.setBooking(true);
    }

    void unbooking(Room room){
        if(room.isBooked()) {
            room.setBooking(false);
        }
    }






}
