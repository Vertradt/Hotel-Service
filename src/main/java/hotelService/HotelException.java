package hotelService;

class HotelException extends RuntimeException {
    HotelException() {
        super("Pokoju nie znaleziono.");
    }
}
