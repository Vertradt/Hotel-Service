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
    private boolean programOver;

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
        while (!programOver);
    }

    private void menuHandling() {
        try {
            menu();
        } catch (HotelException e) {
            out.println(e.getMessage());
        }
    }

    private void menu() {
        showMenu();
        menuSwitcher();
    }

    private List<String> menuPosition() {
        List<String> menu = new ArrayList<>();
        menu.add("1. Wyświetlanie wszystkich pokoi.");
        menu.add("2. Wszystkie dostępne pokoje.");
        menu.add("3. Bookowanie pokoju.");
        menu.add("4. Sprzątanie pokoju.");
        menu.add("5. Zajęte pokoje.");
        menu.add("6. Odbookowanie pokoju.");
        menu.add("7. Wyjście z programu.");

        return menu;
    }

    private void showMenu() {
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
            case BOOKING:
                bookingOption();
                break;
            case CLEANING:
                cleaningOption();
                break;
            case ALL_BOOKED_ROOMS:
                allBookedRoomsDisplaingOption();
                break;
            case UNBOOKING:
                unbookingOption();
                break;
            case ENDGAME:
                endProgramOption();
                break;
        }
    }

    private void allBookedRoomsDisplaingOption() {
        List<Room> list = hotel.getAllBookedRooms();
        for (Room room : list) {
            out.println(room.toString() + " Data wymeldowania: " + room.getUnbookingDate());
        }
    }

    private MenuOptions choice() {
        int userChoice = scanner.nextInt();
        if (userChoice - 1 > MenuOptions.ENDGAME.ordinal()) {
            throw new ChoiceException();
        }
        int optionIndex = userChoice - 1;
        return MenuOptions.values()[optionIndex]; //To chyba można zrobić lepiej. Ale nie wiem jak.
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

        LocalDate bookingDate = bookingDateAdding();
        LocalDate unbookingDate = unbookingDateAdding();

        userService.booking(room, guests, bookingDate, unbookingDate);
        out.println("Zarezerwowano pokój");


    }

    private LocalDate bookingDateAdding() {
        out.println("Wprowadź datę zameldowania");
        Scanner sc = new Scanner(System.in);   // bez napisania tego scannera pojawia mi się: java.time.format.DateTimeParseException: Text 'f' could not be parsed at index 0
        String string = sc.nextLine();// Możesz mi powiedzieć jak mogę go uniknąć?
        return LocalDate.parse(string);
    }

    private LocalDate unbookingDateAdding() {
        out.println("Wprowadź datę wymeldowania");
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        return LocalDate.parse(string);
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

    private void endProgramOption() {
        out.println("Wyjście z programu");
        programOver = true;
    }

}
