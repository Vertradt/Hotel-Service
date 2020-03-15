package hotelService;


public class HotelServiceDemo {
    public void startDemo() {
        Hotel hotel = new Hotel();
        HotelServieceController controller = new HotelServieceController(hotel, new UserService(hotel));
        controller.demonstrateFeature();


    }
}
