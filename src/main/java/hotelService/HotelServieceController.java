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
        us.booking(hotel.getRooms().get(2));
        List<Room> rooms2 = us.giveNotBooked();
        for (Room room : rooms2) {
            System.out.println(room);
        }
    }

    private Hotel giveRepositoryOfGame() {
        return new Hotel();
    }


}
