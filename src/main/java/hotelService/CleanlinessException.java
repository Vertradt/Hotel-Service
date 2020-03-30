package hotelService;

public class CleanlinessException extends HotelException{
    public CleanlinessException() {
        super("Pokój jest brudny. Przed dokonaniem rezerwacji posprzątaj go.");
    }
}
