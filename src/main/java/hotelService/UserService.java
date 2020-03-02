package hotelService;

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

    void booking(int number) {
        Room room = hotel.findBy(number-1);
        room.book(true);
    }

    void unbooking(int number) {
        Room room = hotel.findBy(number-1);
        if (room.isBooked()) {
            room.book(false);
        }
    }


}
