package hotelService;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelServieceController {
    private Scanner scanner = new Scanner(System.in);
    private Hotel hotel;
    private UserService userService;
    private boolean gameOver;

    HotelServieceController(Hotel hotel, UserService userService) {
        this.hotel = hotel;
        this.userService = userService;
    }


    void demonstrateFeature() {
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
        } catch (ChoiceException | HotelException | BookingException | UnbookingException e) {
            System.out.println(e.getMessage());
        }
        return gameOver;
    }

    private boolean menu() {
        menuDisplaing();
        return menuSwitcher();
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

    private boolean menuSwitcher() {
        switch (choice()) {
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
                endGameOption();
                break;
        }
        return this.gameOver;
    }

    private MenuOptions choice() {
        int menu = scanner.nextInt();
        if (menu > MenuOptions.values().length) {
            throw new ChoiceException();
        }
        return MenuOptions.values()[menu - 1]; //To chyba można zrobić lepiej. Ale nie wiem jak.
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
        int input = scanner.nextInt();
        userService.booking(input);
    }


    private void unbookingOption() {
        showBookedRooms();
        if (hotel.getAllBookedRooms().isEmpty()) {
            return;
        }
        System.out.println("By odbukować pokój wpisz numer danego pokoju.");
        int input = scanner.nextInt();
        userService.unbooking(input);
    }


    private void showBookedRooms() {
        List<Room> rooms = hotel.getAllBookedRooms();
        System.out.println("Wolne pokoje:");
        for (Room room : rooms) {
            System.out.println(room);
        }
        if (rooms.isEmpty()) {
            System.out.println("Wszystkie pokoje są wolne.");
        }
    }

    private void endGameOption() {
        System.out.println("Wyjście z programu");
        gameOver = true;
    }

}
