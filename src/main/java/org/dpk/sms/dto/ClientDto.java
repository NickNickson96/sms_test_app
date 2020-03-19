package org.dpk.sms.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientDto {

    private Long id;
    private String contractNumber;
    private String name;
    private String login;
    private String password;
    private String address;
    private Double balance;
    private String paymentAccount;
    private String messageSenderName;
    private LocalDate registrationDate;

    private Long userId;
    private Long tariffId;

}
