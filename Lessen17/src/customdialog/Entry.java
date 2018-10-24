package customdialog;

public class Entry {
    private String name;
    private String phone;

    public Entry(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return (this.name + ", " + this.phone);
    }

}
