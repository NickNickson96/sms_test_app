package org.dpk.sms.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "client_s_subscribers_group")
public class ClientsSubscribersGroupEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cs_group_id")
    private Long id;

    @Column(name = "cs_group_name")
    private String name;

    @OneToMany
    @JoinColumn(name = "cs_group_id")
    private List<SubscriberEntity> subscribers = new ArrayList<>();
}