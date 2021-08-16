package sample;

import java.util.*;

public class Message {


    public static void dialog() {

        List<String> choice = Arrays.asList("None", "Rome", "St Petersburg", "London", "Italian Holidays", "Grand Hotel Plaza",
                "Hotel Palazzo", "Astoria", "Angleterre", "Nevsky Forum", "Four Seasons", "Radisson", "Sky Point", "Zoo", "Museum",
                "Sightseeing", "Malls", "Vintage shops", "Local markets");

        int hotel = 0;
        String firstName;
        String lastName;
        int destination;
        int trip;
        int shopping;
        Scanner scanner = new Scanner(System.in);
        System.out.println("To add new user: 1, " + "To select an existing one: 2"+ "To delete an existing one: 3");
        String action = scanner.nextLine();
Tour user;
        switch (action) {
            case ("1"):

                System.out.println("Please, write your firstname\n");
                firstName = scanner.nextLine();
                System.out.println("Please, write your lastname\n");
                lastName = scanner.nextLine();
                System.out.println("Please, write your destination\n1 - Rome\n2 - St Petersburg\n3 - London");
                destination = scanner.nextInt();
                if (destination == 1) {

                    System.out.println("Please, write your hotel\n4 - Italian Holidays\n5 - Grand Hotel Plaza\n6 - Hotel Palazzo");
                    hotel = scanner.nextInt();
                } else if (destination == 2) {

                    System.out.println("Please, write your hotel\n7 - Astoria\n8 - Angleterre\n9 - Nevsky Forum");
                    hotel = scanner.nextInt();
                } else if (destination == 3) {

                    System.out.println("Please, write your hotel\n10 - Four Seasons\n11 - Radisson\n12 - Sky Point");
                    hotel = scanner.nextInt();
                }
                else{
                    System.out.println("Invalid destination");
                }


                System.out.println("Please, write excursion trip\n13 - Zoo\n14 - Museum\n15 - Sightseeing\n0 - None");
                trip = scanner.nextInt();
                System.out.println("Please, write type of shopping\n16 - Malls\n17 - Vintage shops\n18 - Local markets\n0 - None");
                shopping = scanner.nextInt();


                int cost = PriceCounter.generatePrice(hotel, trip, shopping);
                user = new Tour(firstName, lastName, choice.get(destination), cost, choice.get(hotel), choice.get(trip), choice.get(shopping));
                DatabaseHandler d = new DatabaseHandler();
                d.addUser(user);

                break;
            case ("2"):

                System.out.println("Please, write firstname");
                firstName = scanner.nextLine();
                System.out.println("Please, write lastname");
                lastName = scanner.nextLine();

                user = new Tour(firstName, lastName);
                DatabaseHandler data = new DatabaseHandler();
                 data.selectUser(user);

                break;
            case ("3"):

                System.out.println("Please, write your firstname\n");
                firstName = scanner.nextLine();
                System.out.println("Please, write your lastname\n");
                lastName = scanner.nextLine();
                System.out.println("Please, write your destination\n1 - Rome\n2 - St Petersburg\n3 - London");
                destination = scanner.nextInt();

                user = new Tour(firstName, lastName, choice.get(destination));
                DatabaseHandler dat = new DatabaseHandler();
                dat.deleteUser(user);

                break;
            default:
                System.out.println("Invalid input");
                break;

        }

        scanner.close();

    }

}