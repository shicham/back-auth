package com.crm.forms;

import java.util.Set;
import java.util.Date;
import lombok.Data;

@Data
public class GrantedAuthority {

    private String authority;
    
    public GrantedAuthority(){
    }
    
    public GrantedAuthority(String authority){
        this.authority=authority;
    }

    

}
