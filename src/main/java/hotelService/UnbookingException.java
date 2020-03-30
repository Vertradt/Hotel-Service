package hotelService;

class UnbookingException extends HotelException{
    UnbookingException() {
        super("Ten pokój jest wolny. Zwolnij inny pokój.");
    }
}
