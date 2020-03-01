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
        List<Room> rooms = us.giveNotBusyRooms();
        for (Room room : rooms) {
            System.out.println(room);
        }

    }

    private Hotel giveRepositoryOfGame() {
        return new Hotel();
    }


}
