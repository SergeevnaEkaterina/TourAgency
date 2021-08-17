package Logic;


public class PriceCounter {
    public static int generatePrice(int hotel, int tour, int shopping) {
        if (tour == 0) {
            tour = 1;
        }
        if (shopping == 0) {
            shopping = 1;
        }
        return hotel * tour * shopping * 20;
    }


}
