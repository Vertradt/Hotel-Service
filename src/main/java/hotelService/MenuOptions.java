package hotelService;

public enum MenuOptions {
    ALL_ROOMS(1),
    ALL_AVALIABLE_ROOMS(2),
    BOOKING(3),
    CLEANING(4),
    ALL_BOOKED_ROOMS(5),
    UNBOOKING(6),
    ENGAME(7);

    private final int optionNumber;


    MenuOptions(int optionNumber) {
        this.optionNumber = optionNumber;
    }

    public int getOptionNumber() {
        return optionNumber;
    }


}
