package hotelService;

public class GuestAgeException extends RuntimeException {
    public GuestAgeException() {
        super("Żaden z gości nie ukończył 18 lat.");
    }
}
