package com.crm.domain;

import javax.persistence.*;
import lombok.Data;
@Entity
@Data
public class Authority {

    @Id
    private String id;

    private String name;

}
