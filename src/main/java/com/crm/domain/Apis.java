package com.crm.domain;

import javax.persistence.*;

@Entity
public class Apis {

    @Id
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
