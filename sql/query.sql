//в
SELECT * FROM sms_client
WHERE registration_date BETWEEN
'01.01.2020' AND '30.01.2020';

SELECT sms_client.client_id, sms_client.contract_number, sms_client.client_name, contact_person.contact_person_name, credit_amount, credit_date, credit_status
FROM credit_history, debit_history, sms_client, contact_person
WHERE contact_person.contact_person_id = sms_client.client_id AND credit_history.client_id = sms_client.client_id AND debit_history.client_id = sms_client.client_id AND credit_history.credit_date BETWEEN '01.01.2020' AND '02.01.2020';

//кредитная история клиента
SELECT client_name credit_amount, debit_amount ,credit_date, credit_status
FROM credit_history INNER JOIN sms_client
                               ON credit_history.client_id = sms_client.client_id
                    INNER  JOIN debit_history
                                ON sms_client.client_id = debit_history.client_id
WHERE credit_history.credit_date BETWEEN '01.01.2020' AND '02.01.2020' AND sms_client.client_id = 1

//роли и права доступа
SELECT role.role_name, access_right.permission
FROM role INNER JOIN role_access
                     ON role.role_id = role_access.role_id
          INNER JOIN access_right
                     ON role_access.access_right_id = access_right.access_right_id

//недоставленные сообщения за период времени
SELECT delivery_status, sms_client.client_id,sms.sms_id, recipient_phone_number, sending_date
FROM sms INNER JOIN sms_client
                      ON sms.client_id = sms_client.client_id
WHERE delivery_status = false AND sms.client_id = 2
AND sms.sending_date  BETWEEN '01.01.2020' AND '02.01.2020'

//история авторизации
SELECT client_name, login, authorization_date, ip_address
FROM sms_client INNER JOIN authorization_history
                        ON sms_client.client_id = authorization_history.client_id
WHERE sms_client.client_id = 1
AND authorization_date BETWEEN '01.01.2020' AND '03.01.2020'


