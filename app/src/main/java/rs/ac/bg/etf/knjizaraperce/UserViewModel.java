package rs.ac.bg.etf.knjizaraperce;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserViewModel extends ViewModel {
    private MutableLiveData<String> username = new MutableLiveData<>("anjamarkovic");
    private MutableLiveData<String> password = new MutableLiveData<>("123");
    private MutableLiveData<String> firstName = new MutableLiveData<>("Anja");
    private MutableLiveData<String> lastName = new MutableLiveData<>("Markovic");
    private MutableLiveData<String> address = new MutableLiveData<>("Francuska 11");
    private MutableLiveData<String> phone = new MutableLiveData<>("123-456-789");

    public LiveData<String> getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username.setValue(username);
    }

    public LiveData<String> getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password.setValue(password);
    }

    public LiveData<String> getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.setValue(firstName);
    }

    public LiveData<String> getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.setValue(lastName);
    }

    public LiveData<String> getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address.setValue(address);
    }

    public LiveData<String> getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.setValue(phone);
    }
}
