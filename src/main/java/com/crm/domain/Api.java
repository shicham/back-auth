package com.crm.domain;

import javax.persistence.*;
import lombok.Data;
@Entity
@Data
public class Apis {

    @Id
    private String id;

	private String name;

    @ManyToMany
    @JoinTable(name = "api_service", joinColumns = @JoinColumn(name = "api"), inverseJoinColumns = @JoinColumn(name = "service"))
    private Set<Authority> services;

}
