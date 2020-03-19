package org.dpk.sms.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "credit_history")
public class CreditHistoryEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credit_id")
    private Long id;

    @Column(name = "credit_amount")
    private Double amount;

    @Column(name = "credit_date")
    private LocalDate date;

    @Column(name = "credit_author")
    private String author;

    @Column(name = "credit_status")
    private boolean status;

    @Column(name = "contract_number")
    private String contractNumber;

    @Column(name = "client_id")
    private Long clientId;
}
