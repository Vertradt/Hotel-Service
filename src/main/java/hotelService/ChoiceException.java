package hotelService;

public class ChoiceException extends RuntimeException{
    public ChoiceException() {
        super("Ta opcja nie istnieje. Wprowadź liczby z zakresu od 1 do 5.");
    }
}
