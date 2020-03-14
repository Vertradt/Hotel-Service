package hotelService;

import java.util.Scanner;

public class Launcher {
    public void startProgram() {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();
        HotelServieceController controller = new HotelServieceController(scanner, hotel, new UserService(hotel));
        controller.start();


    }
}
