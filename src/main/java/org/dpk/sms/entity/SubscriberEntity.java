package org.dpk.sms.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "subscriber")
public class SubscriberEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscriber_id")
    private Long id;

    @Column(name = "subscriber_name")
    private String name;

    @Column(name = "subscriber_phone_number")
    private String phoneNumber;
}
