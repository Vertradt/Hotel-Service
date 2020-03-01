package hotelService;

public class Room {
    private int id;
    private int numberOfBed;
    private boolean isBathroom;
    private boolean isBusy;

    public Room(int id, int numberOfBed, boolean isBathroom) {
        this.id = id;
        this.numberOfBed = numberOfBed;
        this.isBathroom = isBathroom;
        this.isBusy = false;
    }

    public boolean isBusy() {
        return isBusy;
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
