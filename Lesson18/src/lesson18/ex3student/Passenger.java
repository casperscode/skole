package ex3student;

/**
 * Models a passenger for a flight.
 */
public class Passenger {
    private String name;
    private int age;

    /**
     * Initializes a new passenger.<br/>
     * Pre: name is not empty, age >= 0.
     */
    public Passenger(String name, int age) {
        assert name != null && !name.isEmpty();
        assert age >= 0;
        this.name = name;
        this.age = age;
    }

    /**
     * Returns the name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name.<br/>
     * Pre: name is not empty.
     */
    public void setName(String name) {
        assert name != null && !name.isEmpty();
        this.name = name;
    }

    /**
     * Returns the age.
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Sets the age.<br/>
     * Pre: age >= 0;
     */
    public void setAge(int age) {
        assert age >= 0;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }

}
