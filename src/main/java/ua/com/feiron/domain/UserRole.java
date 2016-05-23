package ua.com.feiron.domain;

import javax.persistence.*;

@Entity
@Table(name = "tbl_users_role")
public class UserRole {
    @Id
    @Column(name = "userid")
    @GeneratedValue
    private Integer userid;

    @Column(name = "rolename")
    String rolename;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer id) {
        this.userid = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
