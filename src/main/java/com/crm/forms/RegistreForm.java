package com.crm.forms;

import com.crm.commun.forms.Form;
import lombok.Data;

import java.util.Set;

@Data
public class RegistreForm extends Form {
    private String username;
    private String password;
    private String source;
}
