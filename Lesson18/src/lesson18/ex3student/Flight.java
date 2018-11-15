package ex3student;

import java.time.LocalDateTime;

/**
 * Models a flight with an airline between airports.
 */
public class Flight {
//    private String flightNumber;
//    private String destination;
//    private LocalDateTime departure;
//    private LocalDateTime arrival;
//    private final ArrayList<Passenger> passengers = new ArrayList<>();

    /**
     * Initializes a new flight.<br/>
     * Pre: flightNumber is not empty, destination is not empty.
     */
    public Flight(String flightNumber, String destination) {
        // TODO
    }

    /**
     * Returns the destination.
     */
    // TODO

    /**
     * Returns the flight number.
     */
    // TODO

    /**
     * Returns the date and time of departure.<br/>
     */
    // TODO

    /**
     * Sets the date and time of departure.<br>
     */
    public void setDeparture(LocalDateTime departure) {
        // TODO
    }

    /**
     * Returns the local date and time of arrival.<br/>
     */
    // TODO

    /**
     * Sets the date and time of arrival.<br/>
     * Pre: Departure date and time is set, and
     *      arrival date and time is after departure date and time.
     */
    public void setArrival(LocalDateTime arrival) {
        // TODO
    }
    /**
     * Returns a copy of the passenger list.
     */
    // TODO

    /**
     * Creates and returns a passenger added to the passenger list.<br/>
     * Pre: name is not empty, age >= 0.
     */
    public Passenger addPassenger(String name, int age) {
        // TODO
        return null;
    }

    /**
     * Removes a named passenger from the passenger list.<br/>
     * Returns true, if the passenger is removed from the passenger list.<br/>
     * Pre: name is not empty.
     */
    public boolean removePassenger(String name) {
        // TODO
        return false;
    }

    /**
     * The duration of the flight measured in hours.<br/>
     * Pre: The departure and arrival date and time are set.
     */
    public double durationInHours() {
        // TODO
        return 0.0;
    }

    /**
     * Returns true if the flight time overlaps
     * midnight of the day of departure.<br/>
     * Pre: Departure and arrival date and time are set.
     */
    public boolean midnightFlight() {
        // TODO
        return false;
    }

    /**
     * Returns the average age of all the passengers.<br/>
     * Pre: The passenger list is not empty.
     */
    public double averagePassengerAge() {
        // TODO
        return 0.0;
    }

}
