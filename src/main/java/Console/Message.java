package Console;

import DataAccess.DatabaseHandler;
import Logic.PriceCounter;
import Model.Tour;

import java.util.*;

public class Message {


    public static void dialog() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("To add new user: 1\n" + "To select an existing one: 2\n" + "To delete an existing one: 3\n" + "To update an existing one: 4\n");
        String action = scanner.nextLine();
        Tour user;
        switch (action) {
            case ("1"):

                user = generateTour(1);
                DatabaseHandler d = new DatabaseHandler();
                d.addUser(user);

                break;
            case ("2"):


                user = generateTour(2);
                DatabaseHandler data = new DatabaseHandler();
                data.selectUser(user);

                break;
            case ("3"):


                user = generateTour(3);
                DatabaseHandler dat = new DatabaseHandler();
                dat.deleteUser(user);

                break;
            case ("4"):

                user = generateTour(4);
                DatabaseHandler da = new DatabaseHandler();
                da.updateUser(user);

                break;
            default:
                System.out.println("Invalid input");
                break;

        }

        scanner.close();

    }

    public static Tour generateTour(int flag) {
        List<String> choice = Arrays.asList("None", "Rome", "St Petersburg", "London", "Italian Holidays", "Grand Hotel Plaza",
                "Hotel Palazzo", "Astoria", "Angleterre", "Nevsky Forum", "Four Seasons", "Radisson", "Sky Point", "Zoo", "Museum",
                "Sightseeing", "Malls", "Vintage shops", "Local markets");
        Scanner scanner = new Scanner(System.in);
        String firstName;
        String lastName;
        int destination;
        int hotel = 0;
        int trip;
        int shopping;

        System.out.println("Please, write your firstname\n");
        firstName = scanner.nextLine();
        System.out.println("Please, write your lastname\n");
        lastName = scanner.nextLine();
        if (flag == 2) {
            return new Tour(firstName, lastName);

        } else {
            System.out.println("Please, write your destination\n1 - Rome\n2 - St Petersburg\n3 - London");
            destination = scanner.nextInt();
            if (flag == 3) {
                return new Tour(firstName, lastName, choice.get(destination));
            } else {
                if (destination == 1) {

                    System.out.println("Please, write your hotel\n4 - Italian Holidays\n5 - Grand Hotel Plaza\n6 - Hotel Palazzo");
                    hotel = scanner.nextInt();
                } else if (destination == 2) {

                    System.out.println("Please, write your hotel\n7 - Astoria\n8 - Angleterre\n9 - Nevsky Forum");
                    hotel = scanner.nextInt();
                } else if (destination == 3) {

                    System.out.println("Please, write your hotel\n10 - Four Seasons\n11 - Radisson\n12 - Sky Point");
                    hotel = scanner.nextInt();
                } else {
                    System.out.println("Invalid destination");
                }


                System.out.println("Please, write excursion trip\n13 - Zoo\n14 - Museum\n15 - Sightseeing\n0 - None");
                trip = scanner.nextInt();
                System.out.println("Please, write type of shopping\n16 - Malls\n17 - Vintage shops\n18 - Local markets\n0 - None");
                shopping = scanner.nextInt();


                int cost = PriceCounter.generatePrice(hotel, trip, shopping);
                return new Tour(firstName, lastName, choice.get(destination), cost, choice.get(hotel), choice.get(trip), choice.get(shopping));
            }
        }
    }
}