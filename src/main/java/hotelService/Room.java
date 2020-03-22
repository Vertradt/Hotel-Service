package hotelService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private int number;
    private int numberOfBed;
    private boolean bathroom;
    private boolean booked;
    private boolean clean;
    private LocalDate bookingDate;
    private LocalDate unbookingDate;
    private List<Guest> guests = new ArrayList<>();


    Room(int number, int numberOfBed, boolean bathroom) {
        this.number = number;
        this.numberOfBed = numberOfBed;
        this.bathroom = bathroom;
        this.clean = true;
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

    boolean isClean() {
        return !clean;
    }

    void unClean() {
        clean = false;
    }

    void reClean() {
        clean = true;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDate getUnbookingDate() {
        return unbookingDate;
    }

    public void setUnbookingDate(LocalDate unbookingDate) {
        this.unbookingDate = unbookingDate;
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
//        sb.append(" Data zwolnienia ").append(unbookingDate);
        return sb.toString();
    }



}
