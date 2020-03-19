package org.dpk.sms.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sms_template")
public class SmsTemplateEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sms_template_id")
    private Long id;

    @Column(name = "template_name")
    private String name;

    @Column(name = "template_text")
    private String text;
}
