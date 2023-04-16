package models;

public class User {
    private int sourceId;
    private String full_name;
    private String phone;
    private String address;
    private String birthday;
    private String username;
    private String password;

    public User(int sourceId, String full_name, String phone, String address, String birthday, String username, String password) {
        this.sourceId = sourceId;
        this.full_name = full_name;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
        this.username = username;
        this.password = password;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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
}
