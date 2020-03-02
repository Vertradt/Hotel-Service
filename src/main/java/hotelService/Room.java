package hotelService;

public class Room {
    private int id;
    private int numberOfBed;
    private boolean isBathroom;
    private boolean booked;

    public Room(int id, int numberOfBed, boolean isBathroom) {
        this.id = id;
        this.numberOfBed = numberOfBed;
        this.isBathroom = isBathroom;
    }

    public boolean isBooked() {
        return booked;
    }


    public void setBooking(boolean booked) {
        this.booked = booked;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pokój");
        sb.append(" numer: ").append(id);
        sb.append(". Ilość miejsc: ").append(numberOfBed);
        sb.append('.');
        return sb.toString();
    }
}
