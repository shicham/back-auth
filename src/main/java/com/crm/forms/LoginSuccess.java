package com.crm.forms;

import com.crm.commun.forms.Form;
import lombok.Data;

import java.util.Set;

@Data
public class LoginSuccess extends Form {
    private String username;
    private String token;
    private String expireAt;
    private String redirection;
    private Set<String> roles;
    private Set<String> profiles;


}
