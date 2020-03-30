package hotelService;

public class GuestAgeException extends HotelException {
    public GuestAgeException() {
        super("Żaden z gości nie ukończył 18 lat.");
    }
}
