package ir.maktab.todo.domain;

import ir.maktab.todo.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = User.TABLE_NAME)
public class User extends BaseEntity<Long> {

    public static final String TABLE_NAME = "users";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";

    @Column(name = FIRST_NAME)
    private String firstName;

    @Column(name = LAST_NAME)
    private String lastName;

    @Column(name = USERNAME)
    private String username;

    @Column(name = PASSWORD)
    private String password;

    @Column(name = EMAIL)
    private String email;

    public User() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
