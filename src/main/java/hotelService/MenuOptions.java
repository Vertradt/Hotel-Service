package hotelService;

public enum MenuOptions {
    ALL_ROOMS(1),
    ALL_AVALIABLE_ROOMS(2),
    BOOKING(3),
    CLEANING(4),
    UNBOOKING(5),
    ENGAME(6);

    private final int optionNumber;


    MenuOptions(int optionNumber) {
        this.optionNumber = optionNumber;
    }

    public int getOptionNumber() {
        return optionNumber;
    }


}
