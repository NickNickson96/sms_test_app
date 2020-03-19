package org.dpk.sms.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "debit_history")
public class DebitHistoryEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "debit_id")
    private Long id;

    @Column(name = "debit_amount")
    private Double amount;

    @Column(name = "debit_date")
    private LocalDate date;

    @Column(name = "debit_author")
    private String author;

    @Column(name = "debit_status")
    private boolean status;

    @Column(name = "contract_number")
    private String contractNumber;

    @Column(name = "client_id")
    private Long clientId;
}
