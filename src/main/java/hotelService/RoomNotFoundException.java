package hotelService;

class RoomNotFoundException extends HotelException {
    RoomNotFoundException() {
        super("Pokoju nie znaleziono.");
    }
}
