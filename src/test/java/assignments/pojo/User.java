package assignments.pojo;

public class User {
    private String firstName;
    private String lastName;
    private String password;
    private Integer userStatus;
    private String phone;
    private Integer id;
    private String email;
    private String username;

    public User() {
    }

    public User(String firstName, String lastName, String password, Integer userStatus, String phone, Integer id, String email, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userStatus = userStatus;
        this.phone = phone;
        this.id = id;
        this.email = email;
        this.username = username;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getPassword(){
        return password;
    }

    public Integer getUserStatus(){
        return userStatus;
    }

    public String getPhone(){
        return phone;
    }

    public Integer getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    public String getUsername(){
        return username;
    }

    @Override
    public String toString(){
        return
                "Response{" +
                        "firstName = '" + firstName + '\'' +
                        ",lastName = '" + lastName + '\'' +
                        ",password = '" + password + '\'' +
                        ",userStatus = '" + userStatus + '\'' +
                        ",phone = '" + phone + '\'' +
                        ",id = '" + id + '\'' +
                        ",email = '" + email + '\'' +
                        ",username = '" + username + '\'' +
                        "}";
    }
}
