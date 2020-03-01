package hotelService;


import java.util.List;

public class HotelServieceController {
    public void start() {
        Hotel hotel = giveRepositoryOfGame();
        services(hotel);
    }

    private void services(Hotel hotel) {
        UserService us = new UserService(hotel);
        us.giveAllRooms();
        List<Room> rooms2 = us.giveNotBooked();

    }

    private Hotel giveRepositoryOfGame() {
        return new Hotel();
    }


}
