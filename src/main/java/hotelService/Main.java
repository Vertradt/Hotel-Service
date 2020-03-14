package hotelService;
//        1. Utwórz nowe repozytorium HotelService a następnie wypchnij na nie pusty projekt (maven
//        project z archetypu maven-archetype-quickstart). Pamiętaj o zignorowaniu niepotrzebnych
//        plików.
//        2. Utwórz gałąź develop.
//        3. Wszystkie nowe funkcjonalności wprowadzaj na nowych gałęziach (najlepiej feature).
//        4. Dodaj klasę Room reprezentującą pojedynczy pokój (nr pokoju, ilu osobowy, czy w pokoju jest
//        łazienka - true/false oraz czy pokój jest dostępny - true/false).
//        5. Dodaj klasę Hotel która będzie zawierała listę pokoi.
//        6. W konstruktorze klasy Hotel utwórz kilka obiektów klasy Room i dodaj je do listy (np. 10-15),
//        dzięki temu podczas tworzenia instancji obiektu hotel, automatycznie generowana będzie lista
//        pokoi.
//

public class Main {

    public static void main(String[] args) {
        HotelServiceDemo hotelServiceDemo = new HotelServiceDemo();
        hotelServiceDemo.startDemo();
        //main tworzy lanczer, lanczer tworzy kontroler a kontroler tworzy user service i hotel, nie do końca rozumiem podział obowiązków
        // na tym etapie projektu wystarczyłaby klasa "UserServiceDemo" w której jest main a w nim tworzysz sobie hotel, dajesz go userservisowi przez konstruktor
        // i testujesz czy wszystkie 4 funkcjonalności działają poprawnie wywołując je i udowadniając w konsoli wydrukiem że zwróciły prawidłowe listy albo
        // zmieniły właściwie stan pokoju
    }
}
