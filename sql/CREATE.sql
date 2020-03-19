CREATE TABLE "sms_client" (
                          "client_id" SERIAL PRIMARY KEY,
                          "contract_number" varchar(50) UNIQUE,
                          "client_name" varchar(50),
                          "login" varchar(15) UNIQUE,
                          "password" varchar(15),
                          "tariff_id" int,
                          "address" varchar(50),
                          "balance" float,
                          "payment_account" varchar(50) UNIQUE,
                          "message_sender_name" varchar(25),
                          "registration_date" date,
                          "user_id" int
);

CREATE TABLE "contact_person" (
                                  "contact_person_id" SERIAL PRIMARY KEY,
                                  "client_id" int,
                                  "contact_person_name" varchar(50),
                                  "phone_number" varchar(13) UNIQUE,
                                  "email" varchar(30) UNIQUE
);
CREATE TABLE "authorization_history" (
                                         "authorization_history_id" SERIAL PRIMARY KEY,
                                         "client_id" int,
                                         "authorization_date" date,
                                         "ip_address" varchar(15),
                                         "device" varchar(20)
);
CREATE TABLE "change_history" (
                                  "change_history_id" SERIAL PRIMARY KEY,
                                  "client_id" int,
                                  "change_date" date,
                                  "action" varchar(20)
);
CREATE TABLE "credit_history" (
                                  "credit_id" SERIAL PRIMARY KEY,
                                  "client_id" int,
                                  "credit_amount" float,
                                  "credit_date" date,
                                  "credit_author" varchar(50),
                                  "credit_status" boolean,
                                  "contract_number" varchar(50)
);
CREATE TABLE "debit_history" (
                                 "debit_id" SERIAL PRIMARY KEY,
                                 "client_id" int,
                                 "debit_amount" float,
                                 "debit_date" date,
                                 "debit_author" varchar(50),
                                 "debit_status" boolean,
                                 "debit_number" varchar(50),
                                  "contract_number" varchar(50)
);
CREATE TABLE "tariff" (
                          "tariff_id" SERIAL PRIMARY KEY,
                          "tariff_name" varchar(25),
                          "one_sms_cost" float
);
CREATE TABLE "sms" (
                       "sms_id" SERIAL PRIMARY KEY,
                       "client_id" int,
                       "recipient_phone_number" varchar(13),
                       "sending_status" boolean,
                       "delivery_status" boolean,
                       "sending_date" date,
                       "delivery_date" date,
                       "sms_text" text,
                       "cost" float
);
CREATE TABLE "sms_template" (
                                "sms_template_id" SERIAL PRIMARY KEY,
                                "client_id" int,
                                "template_name" varchar(25),
                                "template_text" text
);
CREATE TABLE "client_s_subscribers_group" (
                                              "cs_group_id" SERIAL PRIMARY KEY,
                                              "client_id" int,
                                              "cs_group_name" varchar(25)
);
CREATE TABLE "subscriber" (
                              "subscriber_id" SERIAL PRIMARY KEY,
                              "cs_group_id" int,
                              "subscriber_name" varchar(50),
                              "subscriber_phone_number" varchar(13)
);
CREATE TABLE "sms_user" (
                        "user_id" SERIAL PRIMARY KEY,
                        "user_name" varchar(50),
                        "occupation" varchar(30),
                        "login" varchar(15) UNIQUE,
                        "password" varchar(16),
                        "role_id" int
);
CREATE TABLE "sms_user_role" (
                        "role_id" SERIAL PRIMARY KEY,
                        "role_name" varchar(20)
);
CREATE TABLE "role_access" (
                               "role_id" int,
                               "access_right_id" int
);
CREATE TABLE "access_right" (
                                "access_right_id" SERIAL PRIMARY KEY,
                                "the_right" varchar(50),
                                "right_alias" text
);