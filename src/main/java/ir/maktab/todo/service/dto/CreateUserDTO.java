package ir.maktab.todo.service.dto;

public class CreateUserDTO {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;

    public CreateUserDTO(String firstName, String lastName, String username, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
