INSERT INTO sms_user_role (role_id,role_name)
VALUES (1,'main_admin'),(2,'admin'),(3,'moderator');
SELECT setval('sms_user_role_role_id_seq',3);

INSERT INTO access_right (access_right_id, the_right, right_alias)
VALUES
       (1, 'user-r',''),
       (2, 'user-w',''),
       (3, 'client-r',''),
        (4, 'client-w',''),
        (5, 'contact_person-r',''),
        (6, 'contact_person-w',''),
        (7, 'tariff-r',''),
        (8, 'tariff-w',''),
        (9, 'autorization_history-r',''),
        (10, 'autorization_history-w',''),
        (11, 'change_history-r',''),
        (12, 'change_history-w',''),
        (13, 'credit_history-r',''),
        (14, 'credit_history-w',''),
        (15, 'debit_history_r',''),
         (16, 'debit_history_w',''),
         (17, 'sms-r',''),
         (18, 'sms-w',''),
         (19, 'sms_template-r',''),
         (20, 'sms_template-w',''),
         (21, 'client_s_subscribers_group-r',''),
         (22, 'client_s_subscribers_group-w',''),
         (23, 'subscriber-r',''),
         (24, 'subscriber-w','');
SELECT setval('access_right_access_right_id_seq', 24);



INSERT INTO role_access (role_id,access_right_id)
VALUES 
(1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),
(1,8),(1,9),(1,11),(1,13),(1,15),(1,17),(1,18),
(2,3),(2,4),(2,5),(2,6),(2,7),(2,8),(2,17),
(3,9),(3,11),(3,13),(3,15),(3,17);

INSERT INTO "sms_user" (user_id, user_name, occupation, login, password, role_id)
VALUES 
 (1,'Stas','app_main_dev','stustper','qwerty123456',1),
 (2,'Moks','app_main_dev','mokssim','1kavo9neponyal',1),
 (3,'AdminI','tech_supp','adminsmsts01','IstatnikavIg',2),
 (4,'AdminV','tech_adm','tasms01','jjufhjgkej43',2),
 (5,'ModerIvan','main_moderator','ivan4k','ivanya1302',3),
 (6,'ModerNikita','moderator','otopredeleniya','anasenkovt',3);
SELECT setval('sms_user_user_id_seq',6);


INSERT INTO tariff (tariff_id, tariff_name, "one_sms_cost")
VALUES 
 (1, 'prostoy', 2.99),
 (2, 'business', 1.99),
 (3, 'extra mega super vip -50', 1.49);
SELECT setval('tariff_tariff_id_seq',3);

INSERT INTO sms_client (contract_number, client_name, login, password, tariff_id, address, balance, payment_account, message_sender_name, registration_date)
VALUES
       ('9384759218', 'JMX Airlines', 'JMX1488228', 'valera2281488', 1, 'г. Донецк ул. Жмышенко 14/88', 228, '4756345123', 'JMX_valera', '21.1.2020'),
       ('4758392746', 'Nike Sportage', 'Nike SMM', 'jkldsgfue222', 1, 'г. Донецк ул. Челюскинцев 33/22', 111, '9473629435', 'Nike Cheluskincev', '21.12.2019'),
       ('3728564039', 'Kulibyaka Store', 'K Store', 'galina22021968', 2, 'г. Шахтерск ул. Ленина 11/1', 100, '2345678987', 'Kulibyaka', '8.1.2020'),
       ('8563820483', 'Avon GMBH', 'Avon Kostroma', 'valera2281488', 2, 'г. Донецк ул. Ватутина 143/22', 500, '9876543212', 'Avon Donetsk', '10.1.2020'),
       ('3232947242', 'ALI Express Limited', 'ALI Oficial', 'valera2281488', 3, 'г. Донецк ул. Куприна 34/7', 600, '3456785432', 'Ali Express', '1.2.2020');

INSERT INTO contact_person (client_id, contact_person_name, phone_number, email)
VALUES 
 (1, 'Жмышенко Валерий Альбертович', '+380712281488', 'pazhiloy@hotline.com'),
 (2, 'Печенкина Галина Васильевна', '+380715432356', 'pechen1234@mail.ru'),
 (3, 'Кукуров Александр Павлович', '+380716457689', 'sanyazebest@gmail.com'),
 (4, 'Мекаэлян Евгений Петрович', '+380713214563', 'orel777@mail.ru'),
 (5, 'Старорусский Евкакий Евлапиевич', '+380717654534', 'xolopforever@mail.ru');

INSERT INTO credit_history (client_id, credit_amount, credit_date, credit_status, contract_number)
VALUES 
(1, 500, '01.01.2020', true, '9384759218'),
(2, 600, '02.01.2020', true, '4758392746'),
(3, 700, '03.01.2020', true, '3728564039'),
(4, 700, '04.01.2020', true, '8563820483'),
(5, 500, '05.01.2020', true, '3232947242');

INSERT INTO debit_history (client_id, debit_amount, debit_date, debit_status, contract_number)
VALUES 
(1, 100, '01.01.2020', true, '9384759218'),
(2, 100, '02.01.2020', true, '4758392746'),
(3, 100, '03.01.2020', true, '3728564039'),
(4, 100, '04.01.2020', true, '8563820483'),
(5, 100, '05.01.2020', true, '3232947242');

INSERT INTO "sms" (client_id, recipient_phone_number, sending_status, delivery_status, sending_date, delivery_date, "sms_text")
VALUES 
 ( 1, '+380712346545', true, true, '01.01.2020', '01.01.2020', 'Hello,World!'),
 ( 2, '+380718763256', true, false, '02.01.2020', null,  'Hello,World!'),
 ( 3, '+380712314598', true, false, '03.01.2020', null, 'Hello,World!'),
 ( 4, '+380718967645', true, true, '04.01.2020', '01.01.2020', 'Hello,World!'),
 ( 5, '+380715035923', true, true, '05.01.2020', '01.01.2020', 'Hello,World!');

INSERT INTO "client_s_subscribers_group" ("cs_group_id" ,  "client_id" , "cs_group_name" )
VALUES
(1,1,'default'),(2,2,'default'),(3,3,'default'),(4,4,'default'),
(5,5,'default'),(6,1,'хомячки для развода'),(7,1,'толстосумы'),(8,2,'отдел закупок ФК Заря');
SELECT setval('client_s_subscribers_group_cs_group_id_seq',8);

INSERT INTO "subscriber" ("cs_group_id" , "subscriber_name" ,"subscriber_phone_number"  )
VALUES
(6,'Галина Павлова','+380716667788'),
(7,'Вано олигарх','+380717777777'),
(8,'Сергей Веселов гл. менеждер','+38071'),
(6,'Галина Павлова','+380710101100'),
(6,'Сергей Астахов','+380711246429'),
(6,'Олег Смородин','+380713964597'),
(1,'Коровников Б.','+380712875498'),
(2,'Маргарита Коловецк','+380717592708'),
(3,'магазин Сурьями','+380718673685'),
(4,'поставщик кильки Денисенко','+380714962956'),
(5,'Ваганыч','+380713775337'),
(5,'Семёныч зелёнка','+380713857535'),
(5,'Марина Алексеевна завсклад','+380715872658'),
(5,'Валерий зам Марины','+380711234356');

INSERT INTO "authorization_history" ("client_id", "authorization_date", ip_address, "device")
VALUES
(1,'01.01.2020','111.111.111.111','iPhone 5s'),
(1,'01.02.2020','111.111.111.222','Windows 7 PC'),
(3,'08.02.2020','128.128.128.240','Windows 10 PC'),
(2,'16.02.2020','111.192.240.096','Windows 10 RT tablet'),
(4,'22.03.2019','192.111.111.222','Windows 7 PC'),
(3,'26.03.2019','111.132.111.222','Windows XP PC'),
(5,'26.03.2019','111.110.111.222','Windows 7 PC');
