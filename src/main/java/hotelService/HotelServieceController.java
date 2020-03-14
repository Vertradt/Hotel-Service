package hotelService;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelServieceController {
    private final static int ALL_ROOMS = 1;
    private final static int ALL_AVALIABLE_ROOMS = 2;
    private final static int BOOKING = 3;
    private final static int UNBOOKING = 4;
    private final static int ENGAME = 5;
    private Scanner scanner;
    private Hotel hotel;
    private UserService userService;

    HotelServieceController(Scanner scanner, Hotel hotel, UserService userService) {
        this.scanner = scanner;
        this.hotel = hotel;
        this.userService = userService;
    }

    void start() {
        demonstrateFeature();
    }

    private void demonstrateFeature() {
        menuManager();
    }

    private void menuManager() {
        boolean gameOver;
        do {
            gameOver = menuHandling();
        }
        while (!gameOver);
    }

    private boolean menuHandling() {
        boolean gameOver = false;
        try {
            gameOver = menu();
        } catch (HotelException e) {
            System.out.println(e.getMessage());
        }
        return gameOver;
    }

    private boolean menu() {
        menuDisplaing();
        boolean gameOver = false;
        int menu = scanner.nextInt();
        switch (menu) {
            case ALL_ROOMS:
                allRoomsDisplaingOption();
                break;
            case ALL_AVALIABLE_ROOMS:
                allAvaliableRoomsDisplaingOption();
                break;
            case BOOKING:
                bookingOption();
                break;
            case UNBOOKING:
                unbookingOption();
                break;
            case ENGAME:
                gameOver = endGameOption();
                break;
        }
        return gameOver;
    }

    private List<String> menuPosition() {
        List<String> menu = new ArrayList<>();
        menu.add("1. Wyświetlanie wszystkich pokoi.");
        menu.add("2. Wszystkie dostępne pokoje.");
        menu.add("3. Bookowanie pokoju.");
        menu.add("4. Odbookowanie pokoju.");
        menu.add("5. Wyjście z programu.");

        return menu;
    }

    private void menuDisplaing() {
        for (String s : menuPosition()) {
            System.out.println(s);
        }
    }

    private void allRoomsDisplaingOption() {
        System.out.println("Wszystkie pokoje:");
        showAllRooms();
    }

    private void showAllRooms() {
        List<Room> rooms = userService.allRooms();
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    private void allAvaliableRoomsDisplaingOption() {
        System.out.println("Wszystkie dostępne pokoje:");
        showAvaliableRooms();
    }

    private void showAvaliableRooms() {
        List<Room> rooms = userService.avaliableRooms();
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    private void bookingOption() {
        System.out.println("Rezerwacja.\nBy wykonać rezerwację wpisz numer danego pokoju.");
        showAvaliableRooms();
        System.out.print("Wybrany pokój:");
        int input1 = scanner.nextInt();
        userService.bookingProcedure(input1);
    }


    private void unbookingOption() {
        System.out.println("Odprawa.\nBy odbukować pokój wpisz numer danego pokoju.");
        int listSize = bookedRoomHandling();
        if (listSize == 0) { //Pomyślałem, że dobrze by było od razu zatrzymać wykonywanie metody gdy zostanie rzucony wyjątek
            // , mówiący o tym, że wszystkie pokoje są wolne.
            return;
        }
        int input2 = scanner.nextInt();
        userService.unbookingProcedure(input2);
    }

    private int bookedRoomHandling() {
        int size = 0;
        try {
            size = showBookedRooms().size();
        } catch (UnbookedRoomException e) {
            System.out.println(e.getMessage());
        }
        return size;


    }

    private List<Room> showBookedRooms() {
        List<Room> rooms = hotel.getAllBookedRooms();
        if (rooms.size() == 0) {
            throw new UnbookedRoomException();
        }
        for (Room room : rooms) {
            System.out.println(room);
        }
        return rooms;
    }

    private boolean endGameOption() {
        System.out.println("Wyjście z programu");
        return true;
    }

}
