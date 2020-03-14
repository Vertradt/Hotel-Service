package hotelService;

class UnbookingException extends RuntimeException {
    UnbookingException() {
        super("Ten pokój jest wolny. Zwolnij inny pokój.");
    }
}
