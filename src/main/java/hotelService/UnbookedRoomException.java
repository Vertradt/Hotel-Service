package hotelService;

public class UnbookedRoomException extends RuntimeException{
    public UnbookedRoomException() {
        super("Wszystkie pokoje są wolne.");
    }
}
