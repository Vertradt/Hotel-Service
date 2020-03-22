package hotelService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Guest {
    private static final LocalDate LOCAL_DATE = LocalDate.now();
    private String name;
    private String surname;
    //    private DateFormat birthDate;
    private LocalDate birthDate;

    Guest(String name, String surname, LocalDate age) {
        this.name = name;
        this.surname = surname;
        this.birthDate = age;
    }

    LocalDate getBirthDate() {
        return birthDate;
    }

    public long validateAge() {
        return Math.abs(ChronoUnit.YEARS.between(LOCAL_DATE, birthDate));
    }


    @Override
    public String toString() {
        return "Gość: " + name +
                " " + surname +
                ", w wieku " +
                "lat: " + birthDate;
    }
}
