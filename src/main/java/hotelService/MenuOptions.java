package hotelService;

public enum MenuOptions {
    ALL_ROOMS(1),
    ALL_AVALIABLE_ROOMS(2),
    BOOKING(3),
    UNBOOKING(4),
    ENGAME(5);

    private final int optionNumber;

    MenuOptions(int optionNumber) {
        this.optionNumber = optionNumber;
    }

    public int getOptionNumber() {
        return optionNumber;
    }







}
