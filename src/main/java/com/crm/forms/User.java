package com.crm.forms;

import java.util.*;
import lombok.Data;

@Data
public class User {

    private String username;

    private String password;

    private String email;

    private Date createdAt;

    private Date lastLogin;

    private Date expiredAt;

    private Date deletedAt;

    private Date activatedAt;

    private String activationKey;

    private String resetPasswordKey;

    Collection<GrantedAuthority> authorities = new ArrayList<>();

    public User(){
        super();
    }

    public User(String username,String password,Collection<GrantedAuthority> authorities){
        this.authorities = authorities;
        this.username = username;
        this.password = password;
    }
    

}
