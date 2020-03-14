package hotelService;

class BookingException extends RuntimeException{
    BookingException() {
        super("Pokój jest zajęty. Spróbuj zabookować inny pokój");
    }
}
