package hotelService;


public class HotelServieceController {
    public void start() {
        Hotel hotel = giveRepositoryOfGame();
        services(hotel);
    }

    private void services(Hotel hotel) {
        UserService us = new UserService(hotel);
        System.out.println("Wszystkie:");
        for (Room allAvaliableRoom : hotel.getAllAvaliableRooms()) {
            System.out.println(allAvaliableRoom);
        }
        System.out.println("Po zabukowaniu:");
        us.booking(3);
        us.booking(4);
        us.booking(5);
        us.booking(6);
        hotel.getAllAvaliableRooms();
        for (Room allAvaliableRoom : hotel.getAllAvaliableRooms()) {
            System.out.println(allAvaliableRoom);
        }
        System.out.println("Po odbukowaniu:");
        us.unbooking(3);
        us.unbooking(4);
        us.unbooking(5);
        us.unbooking(6);
        hotel.getAllAvaliableRooms();
        for (Room allAvaliableRoom : hotel.getAllAvaliableRooms()) {
            System.out.println(allAvaliableRoom);
        }


    }

    private Hotel giveRepositoryOfGame() {
        return new Hotel();
    }


}
