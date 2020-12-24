package com.crm.domain;

import javax.persistence.*;
import lombok.Data;
@Entity
@Data
public class AuthorityEntity {

    @Id
    private String id;
    private String name;

}
