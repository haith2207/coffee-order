package models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Huy Trinh on 0020/20/02/2016.
 */
public class Accounts implements Serializable {
//    @Id
//    @Column(name = "id", nullable = false)
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column(name = "academic_id")
//    private Long academicId;
//
//    @Column(name = "name", length = 255, nullable = false)
//    private String name;
    @Id
    @Column(name ="ID",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "Username", nullable = false,unique = true, length = 40)
    private String username;
    @Column(name = "Password", nullable = false,length = 40)
    private String password;
    @Column(name = "Role", nullable = false,length = 40)
    private String role;
    @Column(name = "Status", nullable = false,length = 15)
    private String status;
    @Column(name = "IsDelete",nullable = false)
    private boolean isDelete;

    public Accounts() {
        super();
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
