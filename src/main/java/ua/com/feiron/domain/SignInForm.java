package ua.com.feiron.domain;


import javax.persistence.*;

@Entity
@Table(name = "TBL_USER")
public class SignInForm {

    public SignInForm() {
       super();
    }

    public SignInForm(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "doublepassword")
    private String doublepassword;
    @Column(name = "email")
    private String email;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDoublepassword() {
        return doublepassword;
    }

    public void setDoublepassword(String doublepassword) {
        this.doublepassword = doublepassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
