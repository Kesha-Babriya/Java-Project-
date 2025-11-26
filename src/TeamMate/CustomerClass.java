package TeamMate;
// package customerProfileManagement;

public class CustomerClass {
    private String id;
    private String name;
    private String dob;
    private String gender;
    private String email;
    private String contactNo;
    private String address;
    private String city;
    private String pinCode;
    private String state;

    public CustomerClass(String id, String name, String dob, String gender, String email,
                    String contactNo, String address, String city, String pinCode, String state) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.contactNo = contactNo;
        this.address = address;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDob() { return dob; }
    public String getGender() { return gender; }
    public String getEmail() { return email; }
    public String getContactNo() { return contactNo; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getPinCode() { return pinCode; }
    public String getState() { return state; }

    @Override
    public String toString() {
        return id + "," + name + "," + dob + "," + gender + "," + email + "," +
               contactNo + "," + address + "," + city + "," + pinCode + "," + state;
    }
}
