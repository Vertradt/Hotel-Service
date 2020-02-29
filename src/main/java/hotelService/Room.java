package hotelService;

public class Room {
    private int id;
    private int numberOfBed;
    private boolean isBathroom;
    private boolean isAvaliable;

    public Room(int id, int numberOfBed) {
        this.id = id;
        this.numberOfBed = numberOfBed;
    }
}
