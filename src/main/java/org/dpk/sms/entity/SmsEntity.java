package org.dpk.sms.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "sms")
public class SmsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sms_id")
    private Long id;

    @Column(name = "recipient_phone_number")
    private String recipientPhoneNumber;

    @Column(name = "sending_status")
    private Boolean sendingStatus;

    @Column(name = "delivery_status")
    private Boolean deliveryStatus;

    @Column(name = "sending_date")
    private LocalDate sendingDate;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @Column(name = "sms_text")
    private String smsText;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "client_id")
    private Long clientId;
}
