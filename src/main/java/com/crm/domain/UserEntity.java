package com.crm.domain;

import java.time.LocalDate;
import java.util.Set;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserEntity {

    @Id
    @Column(updatable = false, nullable = false)
    private String username;

    private String password;

    private String email;

    private Date createdAt;

    private Date lastLogin;

    private LocalDate expiredAt;

    private Date deletedAt;

    private Date activatedAt;

    @Column(name = "activationkey")
    private String activationKey;

    @Column(name = "resetpasswordkey")
    private String resetPasswordKey;

    @ManyToMany
    @JoinTable(name = "user_authority", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "authority"))
    private Set<AuthorityEntity> authorities;

    

}