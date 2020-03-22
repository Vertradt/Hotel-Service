package hotelService;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int number;
    private int numberOfBed;
    private boolean bathroom;
    private boolean booked;
    private List<Guest> guests = new ArrayList<>();

    Room(int number, int numberOfBed, boolean bathroom) {
        this.number = number;
        this.numberOfBed = numberOfBed;
        this.bathroom = bathroom;

    }

    int getNumber() {
        return this.number;
    }

    int getNumberOfBed() {
        return numberOfBed;
    }

    boolean isBooked() {
        return booked;
    }

    void book() {
        booked = true;
    }

    void unbook() {
        booked = false;
    }


    void addGuest(List<Guest> newGuests) {
        guests.addAll(newGuests);
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
