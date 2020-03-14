package hotelService;

public class Room {
    private int number;
    private int numberOfBed;
    private boolean bathroom;
    private boolean booked;

    Room(int number, int numberOfBed, boolean bathroom) {
        this.number = number;
        this.numberOfBed = numberOfBed;
        this.bathroom = bathroom;
    }

    int getNumber() {
        return this.number;
    }

    boolean isBooked() {
        return booked;
    }

    void book(boolean booked) {
        this.booked = booked;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pokój");
        sb.append(" numer: ").append(number);
        sb.append(". Ilość miejsc: ").append(numberOfBed);
        sb.append(". Status: ");
        if (!booked) {
            sb.append("wolny.");
        } else {
            sb.append("zajęty.");
        }
        return sb.toString();
    }
}
