package rs.ac.bg.etf.knjizaraperce;

public class UserViewModel {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;

    private static UserViewModel instance = null;

    private UserViewModel() {
        username = "anjamarkovic";
        password = "123";
        firstName = "Anja";
        lastName = "Markovic";
        address = "Francuska 11";
        phone = "123-456-789";
    }

    public static UserViewModel getInstance() {
        if (instance == null)
            instance = new UserViewModel();
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
