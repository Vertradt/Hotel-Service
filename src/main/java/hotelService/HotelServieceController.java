package hotelService;
//       8. W klasie main utwórz proste menu do obsługi hotelu, przykłady implementacji (prosta pętla
//        do…while + switch):
//        1. https://stackoverflow.com/a/13536215/5877109
//        2. http://chronicles.blog.ryanrampersad.com/2011/03/text-based-menu-in-java/
//        9. Do menu dodaj funkcję:
//        1. Wyświetl listę pokoi wraz z ich statusem (wolny-zajęty) korzystając z HotelService.
//        2. Wyświetl listę tylko dostępnych pokoi.
//        3. Zarezerwuj pokój.
//        4. Zwolnij pokój.
//        10. Zapisz i zrób commit na nowej gałęzi a następnie wykonaj merge swojej gałęzi z developem i
//        usuń gałąź. Jeśli aplikacja działa bez

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelServieceController {
    private final static int ALL_ROOMS = 1;
    private final static int ALL_AVALIABLE_ROOMS = 2;
    private final static int BOOKING = 3;
    private final static int UNBOOKING = 4;
    private final static int ENGAME = 5;
    private Hotel hotel;

    public void start() {
        Hotel hotel = giveRepositoryOfGame();
        demonstrateFeature(hotel);
    }

    private void demonstrateFeature(Hotel hotel) {
        UserService us = new UserService(hotel);

        menuManager(us);


    }

    private void menuManager(UserService us) {
        Scanner scanner = new Scanner(System.in);


        boolean gameOver = false;
        int menu ;

        do {
            menuDisplaing();
            menu = scanner.nextInt();
            switch (menu) {
                case ALL_ROOMS:
                    System.out.println("Wszystkie pokoje:");
                    us.displayAllRooms();
                    break;
                case ALL_AVALIABLE_ROOMS:
                    System.out.println("Wszystkie dostępne pokoje:");
                    us.displayAvaliableRooms();
                    break;
                case BOOKING:
                    System.out.println("Rezerwacja.\nBy wykonać rezerwację wpisz numer danego pokoju.");
                    int input1 = scanner.nextInt();
                    us.booking(input1);
                    break;
                case UNBOOKING:
                    System.out.println("Odprawa.\nBy odbukować pokój wpisz numer danego pokoju.");
                    int input2 = scanner.nextInt();
                    us.unbooking(input2);
                    break;
                case ENGAME:
                    System.out.println("Wyjście z programu");
                    gameOver = true;
            }
        }
        while (!gameOver);
    }


    void menuDisplaing() {
        for (String s : menuPosition()) {
            System.out.println(s);
        }

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


    private Hotel giveRepositoryOfGame() {
        return new Hotel();
    }


}
