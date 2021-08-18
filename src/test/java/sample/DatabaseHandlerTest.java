package sample;

import DataAccess.DatabaseHandler;
import Model.Tour;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.jupiter.api.Assertions.*;

class DatabaseHandlerTest {


    @Test
    void testAddTour() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        DatabaseHandler d = new DatabaseHandler();
        Tour tour = new Tour("first", "last", "Rome", 12, "hotel", "trip", "shopping");

        d.addTour(tour);
        String expectedOutput = " first, last, Rome, 12, hotel, trip, shopping \n";

        assertEquals(expectedOutput, outContent.toString());
        d.deleteTour(tour);
    }

    @Test
    void testUpdateTour() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        DatabaseHandler d = new DatabaseHandler();
        Tour tour = new Tour("Gleb", "Ivanov", "St Petersburg", 1230, "Astoria", "None", "None");
        d.addTour(tour);
        Tour updateTour = new Tour("Gleb", "Ivanov", "St Petersburg", 1240, "Astoria", "Zoo", "None");
        d.updateTour(updateTour);
        String expectedOutput = " Gleb, Ivanov, St Petersburg, 1230, Astoria, None, None \n Gleb, Ivanov, St Petersburg, 1240, Astoria, Zoo, None \n";

        assertEquals(expectedOutput, outContent.toString());
        d.deleteTour(tour);
    }

    @Test
    void testDeleteTour() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        DatabaseHandler d = new DatabaseHandler();
        Tour tour = new Tour("Gleb", "Ivanov", "St Petersburg", 1230, "Astoria", "None", "None");
        d.addTour(tour);

        d.deleteTour(tour);
        String expectedOutput = " Gleb, Ivanov, St Petersburg, 1230, Astoria, None, None \n";

        assertEquals(expectedOutput, outContent.toString());
        d.deleteTour(tour);
    }


}