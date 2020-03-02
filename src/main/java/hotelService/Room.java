package hotelService;

public class Room {
    private int number;
    private int numberOfBed;
    private boolean bathroom;
    private boolean booked;

    public Room(int number, int numberOfBed, boolean bathroom) {
        this.number = number;
        this.numberOfBed = numberOfBed;
        this.bathroom = bathroom;
    }

    public boolean isBooked() {
        return booked;
    }


    public void book(boolean booked) {
        this.booked = booked;
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pokój");
        sb.append(" numer: ").append(number);
        sb.append(". Ilość miejsc: ").append(numberOfBed);
        sb.append('.');
        return sb.toString();
    }
}
