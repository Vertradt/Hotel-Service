package hotelService;

class BookingException extends HotelException{
    BookingException() {
        super("Pokój jest zajęty. Spróbuj zabookować inny pokój");
    }
}
