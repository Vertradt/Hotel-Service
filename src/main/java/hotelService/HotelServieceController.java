package hotelService;

public class HotelServieceController {
    public void start() {
        Hotel hotel = giveRepositoryOfGame();
        services(hotel);
    }

    private void services(Hotel hotel) {
        UserService us = new UserService(hotel);
        us.giveAllRooms();


    }

    private Hotel giveRepositoryOfGame() {
        return new Hotel();
    }


}
