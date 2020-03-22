package hotelService;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

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
        } catch (ChoiceException | HotelException | GuestAgeException | BookingException | CleanlinessException | UnbookingException e) {
            out.println(e.getMessage());
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
        menu.add("4. Sprzątanie pokoju.");
        menu.add("5. Odbookowanie pokoju.");
        menu.add("6. Wyjście z programu.");

        return menu;
    }

    private void menuDisplaing() {
        for (String s : menuPosition()) {
            out.println(s);
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
            case CLEANING:
                cleaningOption();
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
        out.println("Wszystkie pokoje:");
        showAllRooms();
    }

    private void showAllRooms() {
        List<Room> rooms = userService.allRooms();
        for (Room room : rooms) {
            out.println(room);
        }
    }

    private void allAvaliableRoomsDisplaingOption() {
        out.println("Wszystkie dostępne pokoje:");
        showAvaliableRooms();
    }

    private void showAvaliableRooms() {
        List<Room> rooms = userService.availableRooms();
        for (Room room : rooms) {
            out.println(room);
        }
    }

    private void bookingOption() {
        out.println("Rezerwacja.\nBy wykonać rezerwację wpisz numer danego pokoju.");
        showAvaliableRooms();
        Room room = chosenRoom();
        List<Guest> guests = listOfGuest(room);
        userService.booking(room, guests);
        out.println("Zarezerwowano pokój");


    }

    private Room chosenRoom() {
        out.print("Wybrany pokój:");
        int input = scanner.nextInt();
        Room room = userService.findRoom(input);
        userService.validateCleanliness(room);
        return room;
    }

    private List<Guest> listOfGuest(Room room) {
        List<Guest> guests = new ArrayList<>();
        int i = 0;
        do {
            Guest guest = addOneGuest();
            guests.add(guest);
            i++;
        } while (i < room.getNumberOfBed());

        return guests;
    }

    private Guest addOneGuest() {
        Scanner scanner = new Scanner(System.in);
        out.println("Wprowadź imie");
        String imie = scanner.nextLine();
        out.println("Wprowadź nazwisko:");
        String nazwisko = scanner.nextLine();
        out.println("Wprowadź datę urodzenia gościa (format: rok-miesiąc-dzień):");
        LocalDate localDate = LocalDate.parse(scanner.nextLine());

        return new Guest(imie, nazwisko, localDate);
    }

    private void cleaningOption() {
        out.println("Wybrano sprządnie.");
        List<Room> rooms = hotel.uncleanRooms();
        if (rooms.isEmpty()) {
            out.println("Wszystkie pokoje są czyste.");
            return;
        }
        showDiryRooms(rooms);

        roomCleaning();
    }

    private void showDiryRooms(List<Room> rooms) {

        out.println("Brudne pokoje:");
        for (Room room : rooms) {
            out.println(room);
        }

    }

    private void roomCleaning() {
        out.println("Wprowadź numer pokoju, który chcesz posprzątać.");
        Room room = hotel.findBy(scanner.nextInt());
        hotel.cleaning(room);
    }

    private void unbookingOption() {
        showBookedRooms();
        if (hotel.getAllBookedRooms().isEmpty()) {
            return;
        }
        out.println("By odbukować pokój wpisz numer danego pokoju.");
        int input = scanner.nextInt();
        userService.unbooking(input);
    }


    private void showBookedRooms() {
        List<Room> rooms = hotel.getAllBookedRooms();
        out.println("Wolne pokoje:");
        for (Room room : rooms) {
            out.println(room);
        }
        if (rooms.isEmpty()) {
            out.println("Wszystkie pokoje są wolne.");
        }
    }

    private void endGameOption() {
        out.println("Wyjście z programu");
        gameOver = true;
    }

}
