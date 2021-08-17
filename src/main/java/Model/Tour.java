package Model;

import java.util.Objects;

public class Tour {
    private String firstName;
    private String lastName;
    private String destination;
    private int price;
    private String hotel;
    private String trip;
    private String shopping;

    public Tour(String firstName, String lastName, String destination, int price, String hotel, String trip, String shopping) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.destination = destination;
        this.price = price;
        this.hotel = hotel;
        this.trip = trip;
        this.shopping = shopping;
    }

    public Tour() {
    }

    public Tour(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Tour(String firstName, String lastName, String destination) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.destination = destination;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getTrip() {
        return trip;
    }

    public void setTrip(String trip) {
        this.trip = trip;
    }

    public String getShopping() {
        return shopping;
    }

    public void setShopping(String shopping) {
        this.shopping = shopping;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return price == tour.price && firstName.equals(tour.firstName) && lastName.equals(tour.lastName) && destination.equals(tour.destination) && hotel.equals(tour.hotel) && trip.equals(tour.trip) && shopping.equals(tour.shopping);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, destination, price, hotel, trip, shopping);
    }

    @Override
    public String toString() {
        return "Tour{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", destination='" + destination + '\'' +
                ", price='" + price + '\'' +
                ", hotel='" + hotel + '\'' +
                ", trip='" + trip + '\'' +
                ", shopping='" + shopping + '\'' +
                '}';
    }
}
