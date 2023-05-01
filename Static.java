import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeZoneConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a date and time (yyyy-MM-dd HH:mm:ss): ");
        String input = scanner.nextLine();

        LocalDateTime localDateTime = LocalDateTime.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        System.out.print("Enter the source time zone (e.g. America/New_York): ");
        String sourceTimeZoneId = scanner.nextLine();

        ZonedDateTime sourceZonedDateTime = localDateTime.atZone(ZoneId.of(sourceTimeZoneId));

        System.out.print("Enter the target time zone (e.g. Europe/London): ");
        String targetTimeZoneId = scanner.nextLine();

        ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(ZoneId.of(targetTimeZoneId));

        String output = targetZonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        System.out.println("Converted time: " + output);
    }

}
