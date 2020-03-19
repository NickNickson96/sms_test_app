package org.dpk.sms.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "change_history")
public class ChangeHistoryEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "change_history_id")
    private Long id;

    @Column(name = "change_date")
    private LocalDate date;
    @Column(name = "action")
    private String action;
    @Column(name = "client_id")
    private Long clientId;
}
