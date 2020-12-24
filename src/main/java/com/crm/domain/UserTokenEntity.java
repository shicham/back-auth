package com.crm.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class UserTokenEntity {

    @Id
    private Long id;
    private String username;
    private String token;
    private Date expireAt;

}
