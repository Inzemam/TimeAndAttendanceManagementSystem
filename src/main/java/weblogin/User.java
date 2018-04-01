package weblogin;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;

    String username;
    String password;
    String fullname;
    User() {}
    User(String f, String u, String p) {
        fullname = f;
        username = u;
        password = p;
    }
    public String toString() {
        return fullname + "(" + username + ")";
    }
    public String getFullName() { return fullname;}
}
