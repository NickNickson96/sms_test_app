package org.dpk.sms.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "sms_user_role")
public class RoleEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role_name")
    private String name;

    @ManyToMany
    @JoinTable(name = "role_access",
            joinColumns = { @JoinColumn(name = "role_id") },
            inverseJoinColumns =  { @JoinColumn(name = "access_right_id") })
    private List<AccessRightEntity> rights = new ArrayList<>();
}