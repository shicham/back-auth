package com.crm.domain;

import javax.persistence.*;
import lombok.Data;
@Entity
@Data
public class Services {

    @Id
    private String id;

    private String name;

    

}
