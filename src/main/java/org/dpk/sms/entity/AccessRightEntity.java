package org.dpk.sms.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "access_right")
public class AccessRightEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "access_right_id")
    private Long id;

    @Column(name = "the_right")
    private String theRight;

    @Column(name = "right_alias")
    private String alias;
}
