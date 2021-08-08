package ir.maktab.todo.service.dto;

public class CreateUserDTO {
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public CreateUserDTO(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }
}
