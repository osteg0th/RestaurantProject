package dao.entities;

public class Administrator {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String password;

    public Administrator(Integer id, String name, String surname, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
}
