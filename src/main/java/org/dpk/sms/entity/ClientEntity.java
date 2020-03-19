package org.dpk.sms.entity;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "sms_client")
public class ClientEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;

    @Column(name = "contract_number")
    private String contractNumber;

    @Column(name = "client_name")
    private String name;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "payment_account")
    private String paymentAccount;

    @Column(name = "message_sender_name")
    private String messageSenderName;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "tariff_id")
    private TariffEntity tariff;

    @OneToMany//(fetch = FetchType.EAGER)
    //@LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "client_id")
    private List<SmsTemplateEntity> templates;

    @OneToMany//(fetch = FetchType.EAGER)
    //@LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "client_id")
    private List<AuthorizationHistoryEntity> authorizations;

    @OneToMany//(fetch = FetchType.EAGER)
    //@LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "client_id")
    private List<ChangeHistoryEntity> changes;

    @OneToMany//(fetch = FetchType.EAGER)
    //@LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "client_id")
    private List<CreditHistoryEntity> credits = new ArrayList<>();

    @OneToMany//(fetch = FetchType.EAGER)
    //@LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "client_id")
    private List<DebitHistoryEntity> debits = new ArrayList<>();

    @OneToMany//(fetch = FetchType.EAGER)
    //@LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "client_id")
    private List<SmsEntity> messages;

    @OneToMany//(fetch = FetchType.EAGER)
    //@LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "client_id")
    private List<ClientsSubscribersGroupEntity> groups;

    @OneToMany//(fetch = FetchType.EAGER)
    //@LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "client_id")
    private List<ContactPersonEntity> persons;

}