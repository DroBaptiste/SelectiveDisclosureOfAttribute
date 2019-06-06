package utils;

public class Account {
    private String address;
    private String password;
    private boolean adult;
    private boolean driver;

    public Account(String address, String password, boolean adult, boolean driver) {
        this.address = address;
        this.password = password;
        this.adult = adult;
        this.driver = driver;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public boolean isDriver() {
        return driver;
    }

    public void setDriver(boolean driver) {
        this.driver = driver;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }
}
