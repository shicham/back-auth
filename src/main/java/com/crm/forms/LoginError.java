package com.crm.forms;

import com.crm.commun.forms.Form;
import lombok.Data;

import java.util.Set;

@Data
public class LoginError extends Form {
    private String username;
    private Set<String> messages;
    public LoginError(){
        super();
    }
    public LoginError(Set<String> messages){
        super();
        this.messages = messages;
    }
    public LoginError(String username,Set<String> messages){
        super();
        this.messages = messages;
        this.username = username;
    }
}
