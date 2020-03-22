package hotelService;


import java.time.LocalDate;
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
        do {
            menuHandling();
        }
        while (!gameOver);
    }

    private void menuHandling() {
        try {
            menu();
        } catch (ChoiceException | HotelException | GuestAgeException | BookingException | UnbookingException e) {
            System.out.println(e.getMessage());
        }
    }

    private void menu() {
        menuDisplaing();
        menuSwitcher();
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

    private void menuSwitcher() {
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
    }

    private MenuOptions choice() {
        int menu = scanner.nextInt();
        if (menu - 1 > MenuOptions.ENGAME.getOptionNumber()) {
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
        List<Room> rooms = userService.availableRooms();
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    private void bookingOption() {
        System.out.println("Rezerwacja.\nBy wykonać rezerwację wpisz numer danego pokoju.");
        showAvaliableRooms();
        System.out.print("Wybrany pokój:");
        int input = scanner.nextInt();
        List<Guest> guests = listOfGuest(input);
        userService.booking(input, guests);
        System.out.println("Zarezerwowano pokój");


    }

    private List<Guest> listOfGuest(int input) {
        List<Guest> guests = new ArrayList<>();
        int i = 0;
        do {
            Guest guest = addOneGuest();
            guests.add(guest);
            i++;
        } while (i < hotel.findBy(input).getNumberOfBed());

        return guests;
    }

    private Guest addOneGuest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź imie");
        String imie = scanner.nextLine();
        System.out.println("Wprowadź nazwisko:");
        String nazwisko = scanner.nextLine();
        System.out.println("Wprowadź datę urodzenia gościa (format: rok-miesiąc-dzień):");
        LocalDate localDate = LocalDate.parse(scanner.nextLine());

        return new Guest(imie, nazwisko, localDate);
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
