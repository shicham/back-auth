package com.crm.forms;

import com.crm.commun.forms.Form;
import lombok.Data;

@Data
public class Login extends Form {
    private String username;
    private String password;
    private String source;
}
