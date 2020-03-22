package hotelService;

public class CleanlinessException extends RuntimeException{
    public CleanlinessException() {
        super("Pokój jest brudny. Przed dokonaniem rezerwacji posprzątaj go.");
    }
}
