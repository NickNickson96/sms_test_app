package org.dpk.sms;

import org.dpk.sms.entity.*;
import org.dpk.sms.repository.AccessRightRepository;
import org.dpk.sms.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;



@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        /*
        1) getAll
        2) saveThis
        3) getThis
        4) getAll ПРОВЕРКА НАЛИЧИЯ этой записи В БД
        5) deleteThis
        6) getAll ПРОВЕРКА ОСТУТСТВИЯ этой записи В БД
        */

        SpringApplication.run(Main.class, args);

        //testMenu(0);
    }

    @Bean
    public SpringDataDialect springDataDialect() {
        return new SpringDataDialect();
    }


/*    public static int testMenu(int inArgument)
    {
        char ch;

        System.out.print ("Test:\n" +
                "1.AccessRight\n"+
                "2.AuthorizationHistory\n"+
                "3.ChangeHistory\n"+
                "4.Client\n"+
                "5.ClientsSubscribersGroup\n"+
                "6.ContactPerson\n"+
                "7.CreditHistory\n"+
                "8.DebitHistory\n"+
                "9.Role\n"+
                "10.Sms\n"+
                "11.SmsTemplate\n"+
                "12.Subscriber\n"+
                "13.Tariff\n"+
                "14.User\n");
        System.out.println("Input 0 to exit ");
        Scanner in = new Scanner(System.in);
        System.out.println("Input a number: ");
        int num = in.nextInt();

        String arg ="args";

        switch (num)
        {
            case 0:System.out.println("Ending..."); System.exit ( 0 ); break;
            case 1: accessRightServiceTest(arg); break;
            case 2:  break;
            case 3: break;
            case 4: break;
            case 5: break;
            case 6: break;
            case 7: break;
            case 8: break;
            case 9: break;
            case 10: break;
            case 11: break;
            case 12: break;
            case 13: tariffServiceTest(arg); break;
            case 14: userServiceTest(arg)break;
            default: System.out.println("Wrong input! Ending..."); System.exit ( 0 );
        }
        return 0;
    }
    //===================================ACCESS-RIGHT_SERVICE_TEST()==========================================================================
    public static void accessRightServiceTest(String args)
    {

    }
    //===================================AUTHORIZATION-HISTORY_SERVICE_TEST()==========================================================================
    public static void authorizationHistoryServiceTest(String args)
    {

    }
    //===================================CHANGE-HISTORY_SERVICE_TEST()==========================================================================
    //public static void changeHistoryServiceTest(String args)
    public static void changeHistorysSubscribersGroupServiceTest_getAllListPrint(List<ChangeHistoryEntity> entitiesList, ChangeHistoryService service)
    {
        if ( entitiesList.isEmpty() )
            System.out.println( "СПИСОК ЗАПИСЕЙ ДАННОЙ ТАБЛИЦЫ БД ПУСТ");
        else
        {
            System.out.println("ЕСТЬ ЗАПИСИ:");
            System.out.println(entitiesList.size());
            System.out.println( service.getAllChangeHistoryEntities() ); // равноценно System.out.println(entitiesList);
        }
    }
    public static void changeHistorysSubscribersGroupServiceTest(String args)
    {
        ChangeHistoryService service = SpringApplication.run(Main.class, args).getBean("changeHistorysSubscribersGroupService", ChangeHistoryService.class);
        ChangeHistoryEntity entity = new ChangeHistoryEntity();
        List<ChangeHistoryEntity> entitiesList ;
//===================================getAll()==========================================================================
        entitiesList = service.getAllChangeHistoryEntities();
        changeHistorysSubscribersGroupServiceTest_getAllListPrint( entitiesList, service);
//===================================saveThis()==========================================================================
        entity.setDate(LocalDate.parse("01.01.2001"));
        service.saveThisChangeHistoryEntity(entity);
        System.out.println( "СГЕНЕРИРОВАННЫЙ id:" + entity.getId() );
//===================================getThis()==========================================================================
        Long thisID = entity.getId();
        service.getThisChangeHistoryEntityById(thisID);
        System.out.println("ПОЛУЧЕННАЯ ИЗ БД ЗАПИСЬ:" + entity);
//===================================ПРОВЕРКА НАЛИЧИЯ В БД==========================================================================
        entitiesList = service.getAllChangeHistoryEntities();
        changeHistorysSubscribersGroupServiceTest_getAllListPrint( entitiesList, service);
//===================================deleteThis()==========================================================================
        thisID = entity.getId();
        service.deleteThisChangeHistoryEntityById(thisID);
        System.out.println("ИЗ БД УДАЛЕНА ЗАПИСЬ С id:" + thisID);
//===================================ПРОВЕРКА ОСТУТСТВИЯ В БД==========================================================================
        entitiesList = service.getAllChangeHistoryEntities();
        changeHistorysSubscribersGroupServiceTest_getAllListPrint( entitiesList, service);
    }

    //===================================CLIENT_SERVICE_TEST()==========================================================================
    public static void clientsSubscribersGroupServiceTest_getAllListPrint(List<ClientEntity> entitiesList, ClientService service)
    {
        if ( entitiesList.isEmpty() )
            System.out.println( "СПИСОК ЗАПИСЕЙ ДАННОЙ ТАБЛИЦЫ БД ПУСТ");
        else
        {
            System.out.println("ЕСТЬ ЗАПИСИ:");
            System.out.println(entitiesList.size());
            System.out.println( service.getAllClientEntities() ); // равноценно System.out.println(entitiesList);
        }
    }
    public static void clientsSubscribersGroupServiceTest(String args)
    {
        ClientService service = SpringApplication.run(Main.class, args).getBean("clientsSubscribersGroupService", ClientService.class);
        ClientEntity entity = new ClientEntity();
        List<ClientEntity> entitiesList ;
//===================================getAll()==========================================================================
        entitiesList = service.getAllClientEntities();
        clientsSubscribersGroupServiceTest_getAllListPrint( entitiesList, service);
//===================================saveThis()==========================================================================
        entity.setDate(LocalDate.parse("01.01.2001"));
        service.saveThisClientEntity(entity);
        System.out.println( "СГЕНЕРИРОВАННЫЙ id:" + entity.getId() );
//===================================getThis()==========================================================================
        Long thisID = entity.getId();
        service.getThisClientEntityById(thisID);
        System.out.println("ПОЛУЧЕННАЯ ИЗ БД ЗАПИСЬ:" + entity);
//===================================ПРОВЕРКА НАЛИЧИЯ В БД==========================================================================
        entitiesList = service.getAllClientEntities();
        clientsSubscribersGroupServiceTest_getAllListPrint( entitiesList, service);
//===================================deleteThis()==========================================================================
        thisID = entity.getId();
        service.deleteThisClientEntityById(thisID);
        System.out.println("ИЗ БД УДАЛЕНА ЗАПИСЬ С id:" + thisID);
//===================================ПРОВЕРКА ОСТУТСТВИЯ В БД==========================================================================
        entitiesList = service.getAllClientEntities();
        clientsSubscribersGroupServiceTest_getAllListPrint( entitiesList, service);
    }
    //===================================CLIENTS-SUBSCRIBERS-GROUP_SERVICE_TEST()==========================================================================
    public static void clientsSubscribersGroupServiceTest_getAllListPrint(List<ClientsSubscribersGroupEntity> entitiesList, ClientsSubscribersGroupService service)
    {
        if ( entitiesList.isEmpty() )
            System.out.println( "СПИСОК ЗАПИСЕЙ ДАННОЙ ТАБЛИЦЫ БД ПУСТ");
        else
        {
            System.out.println("ЕСТЬ ЗАПИСИ:");
            System.out.println(entitiesList.size());
            System.out.println( service.getAllClientsSubscribersGroupEntities() ); // равноценно System.out.println(entitiesList);
        }
    }
    public static void clientsSubscribersGroupServiceTest(String args)
    {
        ClientsSubscribersGroupService service = SpringApplication.run(Main.class, args).getBean("clientsSubscribersGroupService", ClientsSubscribersGroupService.class);
        ClientsSubscribersGroupEntity entity = new ClientsSubscribersGroupEntity();
        List<ClientsSubscribersGroupEntity> entitiesList ;
//===================================getAll()==========================================================================
        entitiesList = service.getAllClientsSubscribersGroupEntities();
        clientsSubscribersGroupServiceTest_getAllListPrint( entitiesList, service);
//===================================saveThis()==========================================================================
        entity.setDate(LocalDate.parse("01.01.2001"));
        service.saveThisClientsSubscribersGroupEntity(entity);
        System.out.println( "СГЕНЕРИРОВАННЫЙ id:" + entity.getId() );
//===================================getThis()==========================================================================
        Long thisID = entity.getId();
        service.getThisClientsSubscribersGroupEntityById(thisID);
        System.out.println("ПОЛУЧЕННАЯ ИЗ БД ЗАПИСЬ:" + entity);
//===================================ПРОВЕРКА НАЛИЧИЯ В БД==========================================================================
        entitiesList = service.getAllClientsSubscribersGroupEntities();
        clientsSubscribersGroupServiceTest_getAllListPrint( entitiesList, service);
//===================================deleteThis()==========================================================================
        thisID = entity.getId();
        service.deleteThisClientsSubscribersGroupEntityById(thisID);
        System.out.println("ИЗ БД УДАЛЕНА ЗАПИСЬ С id:" + thisID);
//===================================ПРОВЕРКА ОСТУТСТВИЯ В БД==========================================================================
        entitiesList = service.getAllClientsSubscribersGroupEntities();
        clientsSubscribersGroupServiceTest_getAllListPrint( entitiesList, service);
    }

    //===================================CONTACT-PERSON_SERVICE_TEST()==========================================================================
    public static void contactPersonServiceTest_getAllListPrint(List<ContactPersonEntity> entitiesList, ContactPersonService service)
    {
        if ( entitiesList.isEmpty() )
            System.out.println( "СПИСОК ЗАПИСЕЙ ДАННОЙ ТАБЛИЦЫ БД ПУСТ");
        else
        {
            System.out.println("ЕСТЬ ЗАПИСИ:");
            System.out.println(entitiesList.size());
            System.out.println( service.getAllContactPersonEntities() ); // равноценно System.out.println(entitiesList);
        }
    }
    public static void contactPersonServiceTest(String args)
    {
        ContactPersonService service = SpringApplication.run(Main.class, args).getBean("contactPersonService", ContactPersonService.class);
        ContactPersonEntity entity = new ContactPersonEntity();
        List<ContactPersonEntity> entitiesList ;
//===================================getAll()==========================================================================
        entitiesList = service.getAllContactPersonEntities();
        contactPersonServiceTest_getAllListPrint( entitiesList, service);
//===================================saveThis()==========================================================================
        entity.setDate(LocalDate.parse("01.01.2001"));
        service.saveThisContactPersonEntity(entity);
        System.out.println( "СГЕНЕРИРОВАННЫЙ id:" + entity.getId() );
//===================================getThis()==========================================================================
        Long thisID = entity.getId();
        service.getThisContactPersonEntityById(thisID);
        System.out.println("ПОЛУЧЕННАЯ ИЗ БД ЗАПИСЬ:" + entity);
//===================================ПРОВЕРКА НАЛИЧИЯ В БД==========================================================================
        entitiesList = service.getAllContactPersonEntities();
        contactPersonServiceTest_getAllListPrint( entitiesList, service);
//===================================deleteThis()==========================================================================
        thisID = entity.getId();
        service.deleteThisContactPersonEntityById(thisID);
        System.out.println("ИЗ БД УДАЛЕНА ЗАПИСЬ С id:" + thisID);
//===================================ПРОВЕРКА ОСТУТСТВИЯ В БД==========================================================================
        entitiesList = service.getAllContactPersonEntities();
        contactPersonServiceTest_getAllListPrint( entitiesList, service);
    }

    //===================================CREDIT-HISTORY_SERVICE_TEST()==========================================================================
    public static void creditHistoryServiceTest_getAllListPrint(List<CreditHistoryEntity> entitiesList, CreditHistoryService service)
    {
        if ( entitiesList.isEmpty() )
            System.out.println( "СПИСОК ЗАПИСЕЙ ДАННОЙ ТАБЛИЦЫ БД ПУСТ");
        else
        {
            System.out.println("ЕСТЬ ЗАПИСИ:");
            System.out.println(entitiesList.size());
            System.out.println( service.getAllCreditHistoryEntities() ); // равноценно System.out.println(entitiesList);
        }
    }
    public static void creditHistoryServiceTest(String args)
    {
        CreditHistoryService service = SpringApplication.run(Main.class, args).getBean("creditHistoryService", CreditHistoryService.class);
        CreditHistoryEntity entity = new CreditHistoryEntity();
        List<CreditHistoryEntity> entitiesList ;
//===================================getAll()==========================================================================
        entitiesList = service.getAllCreditHistoryEntities();
        creditHistoryServiceTest_getAllListPrint( entitiesList, service);
//===================================saveThis()==========================================================================
        entity.setDate(LocalDate.parse("01.01.2001"));
        service.saveThisCreditHistoryEntity(entity);
        System.out.println( "СГЕНЕРИРОВАННЫЙ id:" + entity.getId() );
//===================================getThis()==========================================================================
        Long thisID = entity.getId();
        service.getThisCreditHistoryEntityById(thisID);
        System.out.println("ПОЛУЧЕННАЯ ИЗ БД ЗАПИСЬ:" + entity);
//===================================ПРОВЕРКА НАЛИЧИЯ В БД==========================================================================
        entitiesList = service.getAllCreditHistoryEntities();
        creditHistoryServiceTest_getAllListPrint( entitiesList, service);
//===================================deleteThis()==========================================================================
        thisID = entity.getId();
        service.deleteThisCreditHistoryEntityById(thisID);
        System.out.println("ИЗ БД УДАЛЕНА ЗАПИСЬ С id:" + thisID);
//===================================ПРОВЕРКА ОСТУТСТВИЯ В БД==========================================================================
        entitiesList = service.getAllCreditHistoryEntities();
        creditHistoryServiceTest_getAllListPrint( entitiesList, service);
    }
    //===================================DEBIT-HISTORY_SERVICE_TEST()==========================================================================
    public static void debitHistoryServiceTest_getAllListPrint(List<DebitHistoryEntity> entitiesList, DebitHistoryService service)
    {
        if ( entitiesList.isEmpty() )
            System.out.println( "СПИСОК ЗАПИСЕЙ ДАННОЙ ТАБЛИЦЫ БД ПУСТ");
        else
        {
            System.out.println("ЕСТЬ ЗАПИСИ:");
            System.out.println(entitiesList.size());
            System.out.println( service.getAllDebitHistoryEntities() ); // равноценно System.out.println(entitiesList);
        }
    }
    public static void debitHistoryServiceTest(String args)
    {
        DebitHistoryService service = SpringApplication.run(Main.class, args).getBean("debitHistoryService", DebitHistoryService.class);
        DebitHistoryEntity entity = new DebitHistoryEntity();
        List<DebitHistoryEntity> entitiesList ;
//===================================getAll()==========================================================================
        entitiesList = service.getAllDebitHistoryEntities();
        debitHistoryServiceTest_getAllListPrint( entitiesList, service);
//===================================saveThis()==========================================================================
        entity.setDate(LocalDate.parse("01.01.2001"));
        service.saveThisDebitHistoryEntity(entity);
        System.out.println( "СГЕНЕРИРОВАННЫЙ id:" + entity.getId() );
//===================================getThis()==========================================================================
        Long thisID = entity.getId();
        service.getThisDebitHistoryEntityById(thisID);
        System.out.println("ПОЛУЧЕННАЯ ИЗ БД ЗАПИСЬ:" + entity);
//===================================ПРОВЕРКА НАЛИЧИЯ В БД==========================================================================
        entitiesList = service.getAllDebitHistoryEntities();
        debitHistoryServiceTest_getAllListPrint( entitiesList, service);
//===================================deleteThis()==========================================================================
        thisID = entity.getId();
        service.deleteThisDebitHistoryEntityById(thisID);
        System.out.println("ИЗ БД УДАЛЕНА ЗАПИСЬ С id:" + thisID);
//===================================ПРОВЕРКА ОСТУТСТВИЯ В БД==========================================================================
        entitiesList = service.getAllDebitHistoryEntities();
        debitHistoryServiceTest_getAllListPrint( entitiesList, service);
    }
    //===================================ROLE_SERVICE_TEST()==========================================================================
    public static void roleServiceTest_getAllListPrint(List<RoleEntity> entitiesList, RoleService service)
    {
        if ( entitiesList.isEmpty() )
            System.out.println( "СПИСОК ЗАПИСЕЙ ДАННОЙ ТАБЛИЦЫ БД ПУСТ");
        else
        {
            System.out.println("ЕСТЬ ЗАПИСИ:");
            System.out.println(entitiesList.size());
            System.out.println( service.getAllRoleEntities() ); // равноценно System.out.println(entitiesList);
        }
    }
    public static void roleServiceTest(String args)
    {
        RoleService service = SpringApplication.run(Main.class, args).getBean("roleService", RoleService.class);
        RoleEntity entity = new RoleEntity();
        List<RoleEntity> entitiesList ;
//===================================getAll()==========================================================================
        entitiesList = service.getAllRoleEntities();
        roleServiceTest_getAllListPrint( entitiesList, service);
//===================================saveThis()==========================================================================
        entity.setName("ИмяРоли");
        service.saveThisRoleEntity(entity);
        System.out.println( "СГЕНЕРИРОВАННЫЙ id:" + entity.getId() );
//===================================getThis()==========================================================================
        Long thisID = entity.getId();
        service.getThisRoleEntityById(thisID);
        System.out.println("ПОЛУЧЕННАЯ ИЗ БД ЗАПИСЬ:" + entity);
//===================================ПРОВЕРКА НАЛИЧИЯ В БД==========================================================================
        entitiesList = service.getAllRoleEntities();
        roleServiceTest_getAllListPrint( entitiesList, service);
//===================================deleteThis()==========================================================================
        thisID = entity.getId();
        service.deleteThisRoleEntityById(thisID);
        System.out.println("ИЗ БД УДАЛЕНА ЗАПИСЬ С id:" + thisID);
//===================================ПРОВЕРКА ОСТУТСТВИЯ В БД==========================================================================
        entitiesList = service.getAllRoleEntities();
        roleServiceTest_getAllListPrint( entitiesList, service);
    }
    //===================================SMS-TEMPLATE_SERVICE_TEST()==========================================================================
    public static void smsTemplateServiceTest_getAllListPrint(List<SmsTemplateEntity> entitiesList, SmsTemplateService service)
    {
        if ( entitiesList.isEmpty() )
            System.out.println( "СПИСОК ЗАПИСЕЙ ДАННОЙ ТАБЛИЦЫ БД ПУСТ");
        else
        {
            System.out.println("ЕСТЬ ЗАПИСИ:");
            System.out.println(entitiesList.size());
            System.out.println( service.getAllSmsTemplateEntities() ); // равноценно System.out.println(entitiesList);
        }
    }
    public static void smsTemplateServiceTest(String args)
    {
        SmsTemplateService service = SpringApplication.run(Main.class, args).getBean("smsTemplateService", SmsTemplateService.class);
        SmsTemplateEntity entity = new SmsTemplateEntity();
        List<SmsTemplateEntity> entitiesList ;
//===================================getAll()==========================================================================
        entitiesList = service.getAllSmsTemplateEntities();
        smsTemplateServiceTest_getAllListPrint( entitiesList, service);
//===================================saveThis()==========================================================================
        entity.setName("ИмяСМС-Шаблона");
        entity.setText("ыовпатыдпдыпыщшрпоц ыушщпежоукпроеурщо пжкщозепзущкепо, лжукщкужепщш кзщелукэешщуеплщлэукзхлуккуезщ");
        service.saveThisSmsTemplateEntity(entity);
        System.out.println( "СГЕНЕРИРОВАННЫЙ id:" + entity.getId() );
//===================================getThis()==========================================================================
        Long thisID = entity.getId();
        service.getThisSmsTemplateEntityById(thisID);
        System.out.println("ПОЛУЧЕННАЯ ИЗ БД ЗАПИСЬ:" + entity);
//===================================ПРОВЕРКА НАЛИЧИЯ В БД==========================================================================
        entitiesList = service.getAllSmsTemplateEntities();
        smsTemplateServiceTest_getAllListPrint( entitiesList, service);
//===================================deleteThis()==========================================================================
        thisID = entity.getId();
        service.deleteThisSmsTemplateEntityById(thisID);
        System.out.println("ИЗ БД УДАЛЕНА ЗАПИСЬ С id:" + thisID);
//===================================ПРОВЕРКА ОСТУТСТВИЯ В БД==========================================================================
        entitiesList = service.getAllSmsTemplateEntities();
        smsTemplateServiceTest_getAllListPrint( entitiesList, service);
    }

    //===================================SMS_SERVICE_TEST()==========================================================================
    public static void smsServiceTest_getAllListPrint(List<SmsEntity> entitiesList, SmsService service)
    {
        if ( entitiesList.isEmpty() )
            System.out.println( "СПИСОК ЗАПИСЕЙ ДАННОЙ ТАБЛИЦЫ БД ПУСТ");
        else
        {
            System.out.println("ЕСТЬ ЗАПИСИ:");
            System.out.println(entitiesList.size());
            System.out.println( service.getAllSmsEntities() ); // равноценно System.out.println(entitiesList);
        }
    }
    public static void smsServiceTest(String args)
    {
        SmsService service = SpringApplication.run(Main.class, args).getBean("smsService", SmsService.class);
        SmsEntity entity = new SmsEntity();
        List<SmsEntity> entitiesList ;
//===================================getAll()==========================================================================
        entitiesList = service.getAllSmsEntities();
        smsServiceTest_getAllListPrint( entitiesList, service);
//===================================saveThis()==========================================================================
        entity.setCost(0.99);
        entity.setRecipientPhoneNumber("+380716543210");
        service.saveThisSmsEntity(entity);
        System.out.println( "СГЕНЕРИРОВАННЫЙ id:" + entity.getId() );
//===================================getThis()==========================================================================
        Long thisID = entity.getId();
        service.getThisSmsEntityById(thisID);
        System.out.println("ПОЛУЧЕННАЯ ИЗ БД ЗАПИСЬ:" + entity);
//===================================ПРОВЕРКА НАЛИЧИЯ В БД==========================================================================
        entitiesList = service.getAllSmsEntities();
        smsServiceTest_getAllListPrint( entitiesList, service);
//===================================deleteThis()==========================================================================
        thisID = entity.getId();
        service.deleteThisSmsEntityById(thisID);
        System.out.println("ИЗ БД УДАЛЕНА ЗАПИСЬ С id:" + thisID);
//===================================ПРОВЕРКА ОСТУТСТВИЯ В БД==========================================================================
        entitiesList = service.getAllSmsEntities();
        smsServiceTest_getAllListPrint( entitiesList, service);
    }
    //===================================SMS-TEMPLATE_SERVICE_TEST()==========================================================================
    public static void smsTemplateServiceTest_getAllListPrint(List<SmsTemplateEntity> entitiesList, SmsTemplateService service)
    {
        if ( entitiesList.isEmpty() )
            System.out.println( "СПИСОК ЗАПИСЕЙ ДАННОЙ ТАБЛИЦЫ БД ПУСТ");
        else
        {
            System.out.println("ЕСТЬ ЗАПИСИ:");
            System.out.println(entitiesList.size());
            System.out.println( service.getAllSmsTemplateEntities() ); // равноценно System.out.println(entitiesList);
        }
    }
    public static void smsTemplateServiceTest(String args)
    {
        SmsTemplateService service = SpringApplication.run(Main.class, args).getBean("smsTemplateService", SmsTemplateService.class);
        SmsTemplateEntity entity = new SmsTemplateEntity();
        List<SmsTemplateEntity> entitiesList ;
//===================================getAll()==========================================================================
        entitiesList = service.getAllSmsTemplateEntities();
        smsTemplateServiceTest_getAllListPrint( entitiesList, service);
//===================================saveThis()==========================================================================
        entity.setName("ИмяСМС-Шаблона");
        entity.setText("ыовпатыдпдыпыщшрпоц ыушщпежоукпроеурщо пжкщозепзущкепо, лжукщкужепщш кзщелукэешщуеплщлэукзхлуккуезщ");
        service.saveThisSmsTemplateEntity(entity);
        System.out.println( "СГЕНЕРИРОВАННЫЙ id:" + entity.getId() );
//===================================getThis()==========================================================================
        Long thisID = entity.getId();
        service.getThisSmsTemplateEntityById(thisID);
        System.out.println("ПОЛУЧЕННАЯ ИЗ БД ЗАПИСЬ:" + entity);
//===================================ПРОВЕРКА НАЛИЧИЯ В БД==========================================================================
        entitiesList = service.getAllSmsTemplateEntities();
        smsTemplateServiceTest_getAllListPrint( entitiesList, service);
//===================================deleteThis()==========================================================================
        thisID = entity.getId();
        service.deleteThisSmsTemplateEntityById(thisID);
        System.out.println("ИЗ БД УДАЛЕНА ЗАПИСЬ С id:" + thisID);
//===================================ПРОВЕРКА ОСТУТСТВИЯ В БД==========================================================================
        entitiesList = service.getAllSmsTemplateEntities();
        smsTemplateServiceTest_getAllListPrint( entitiesList, service);
    }
    //===================================SUBSCRIBER_SERVICE_TEST()==========================================================================
        public static void subscriberServiceTest_getAllListPrint(List<SubscriberEntity> entitiesList, SubscriberService service)
        {
            if ( entitiesList.isEmpty() )
                System.out.println( "СПИСОК ЗАПИСЕЙ ДАННОЙ ТАБЛИЦЫ БД ПУСТ");
            else
            {
                System.out.println("ЕСТЬ ЗАПИСИ:");
                System.out.println(entitiesList.size());
                System.out.println( service.getAllSubscriberEntities() ); // равноценно System.out.println(entitiesList);
            }
        }
        public static void subscriberServiceTest(String args)
        {
            SubscriberService service = SpringApplication.run(Main.class, args).getBean("subscriberService", SubscriberService.class);
            SubscriberEntity entity = new SubscriberEntity();
            List<SubscriberEntity> entitiesList ;
//===================================getAll()==========================================================================
            entitiesList = service.getAllSubscriberEntities();
            subscriberServiceTest_getAllListPrint( entitiesList, service);
//===================================saveThis()==========================================================================
            entity.setName("ИмяАбонента");
            entity.setPhoneNumber("+380710123456");
            service.saveThisSubscriberEntity(entity);
            System.out.println( "СГЕНЕРИРОВАННЫЙ id:" + entity.getId() );
//===================================getThis()==========================================================================
            Long thisID = entity.getId();
            service.getThisSubscriberEntityById(thisID);
            System.out.println("ПОЛУЧЕННАЯ ИЗ БД ЗАПИСЬ:" + entity);
//===================================ПРОВЕРКА НАЛИЧИЯ В БД==========================================================================
            entitiesList = service.getAllSubscriberEntities();
            subscriberServiceTest_getAllListPrint( entitiesList, service);
//===================================deleteThis()==========================================================================
            thisID = entity.getId();
            service.deleteThisSubscriberEntityById(thisID);
            System.out.println("ИЗ БД УДАЛЕНА ЗАПИСЬ С id:" + thisID);
//===================================ПРОВЕРКА ОСТУТСТВИЯ В БД==========================================================================
            entitiesList = service.getAllSubscriberEntities();
            subscriberServiceTest_getAllListPrint( entitiesList, service);
        }
    //===================================TARIFF_SERVICE_TEST()==========================================================================
    public static void tariffServiceTest_getAllListPrint(List<TariffEntity> entitiesList, TariffService service)
    {
        if ( entitiesList.isEmpty() )
            System.out.println( "СПИСОК ЗАПИСЕЙ ДАННОЙ ТАБЛИЦЫ БД ПУСТ");
        else
        {
            System.out.println("ЕСТЬ ЗАПИСИ:");
            System.out.println(entitiesList.size());
            System.out.println( service.getAllTariffEntities() ); // равноценно System.out.println(entitiesList);
        }
    }
    public static void tariffServiceTest(String args)
    {
        TariffService service = SpringApplication.run(Main.class, args).getBean("tariffService", TariffService.class);
        TariffEntity entity = new TariffEntity();
        List<TariffEntity> entitiesList ;
//===================================getAll()==========================================================================
        entitiesList = service.getAllTariffEntities();
        tariffServiceTest_getAllListPrint( entitiesList, service);
//===================================saveThis()==========================================================================
        entity.setName("Тестовый тариф");
        entity.setOneSmsCost(10.0);
        service.saveThisTariffEntity(entity);
        System.out.println( "СГЕНЕРИРОВАННЫЙ id:" + entity.getId() );
//===================================getThis()==========================================================================
        Long thisID = entity.getId();
        service.getThisTariffEntityById(thisID);
        System.out.println("ПОЛУЧЕННАЯ ИЗ БД ЗАПИСЬ:" + entity);
//===================================ПРОВЕРКА НАЛИЧИЯ В БД==========================================================================
        entitiesList = service.getAllTariffEntities();
        tariffServiceTest_getAllListPrint( entitiesList, service);
//===================================deleteThis()==========================================================================
        thisID = entity.getId();
        service.deleteThisTariffEntityById(thisID);
        System.out.println("ИЗ БД УДАЛЕНА ЗАПИСЬ С id:" + thisID);
//===================================ПРОВЕРКА ОСТУТСТВИЯ В БД==========================================================================
        entitiesList = service.getAllTariffEntities();
        tariffServiceTest_getAllListPrint( entitiesList, service);
    }
    //===================================USER_SERVICE_TEST()==========================================================================
    public static void userServiceTest_getAllListPrint(List<UserEntity> entitiesList, UserService service)
    {
        if ( entitiesList.isEmpty() )
            System.out.println( "СПИСОК ЗАПИСЕЙ ДАННОЙ ТАБЛИЦЫ БД ПУСТ");
        else
        {
            System.out.println("ЕСТЬ ЗАПИСИ:");
            System.out.println(entitiesList.size());
            System.out.println( service.getAllUserEntities() ); // равноценно System.out.println(entitiesList);
        }
    }
    public static void userServiceTest(String args)
    {
        UserService service = SpringApplication.run(Main.class, args).getBean("userService", UserService.class);
        UserEntity entity = new UserEntity();
        List<UserEntity> entitiesList ;
//===================================getAll()==========================================================================
        entitiesList = service.getAllUserEntities();
        if ( entitiesList.isEmpty() )
            System.out.println( "СПИСОК ЗАПИСЕЙ ДАННОЙ ТАБЛИЦЫ БД ПУСТ");
        else
        {
            System.out.println("ЕСТЬ ЗАПИСИ:");
            System.out.println(entitiesList.size());
            System.out.println( service.getAllUserEntities() ); // равноценно System.out.println(entitiesList);
        }
//===================================saveThis()==========================================================================
        entity.setName("ИмяПользователя");
        entity.setOccupation("ДолжностьПользователя");
        service.saveThisUserEntity(entity);
        System.out.println( "СГЕНЕРИРОВАННЫЙ id:" + entity.getId() );
//===================================getThis()==========================================================================
        Long thisID = entity.getId();
        service.getThisUserEntityById(thisID);
        System.out.println("ПОЛУЧЕННАЯ ИЗ БД ЗАПИСЬ:" + entity);
//===================================ПРОВЕРКА НАЛИЧИЯ В БД==========================================================================
        entitiesList = service.getAllUserEntities();
        if ( entitiesList.isEmpty() )
            System.out.println( "СПИСОК ЗАПИСЕЙ ДАННОЙ ТАБЛИЦЫ БД ПУСТ");
        else
        {
            System.out.println("ЕСТЬ ЗАПИСИ:");
            System.out.println(entitiesList.size());
            System.out.println( service.getAllUserEntities() ); // равноценно System.out.println(entitiesList);
        }
//===================================deleteThis()==========================================================================
        thisID = entity.getId();
        service.deleteThisUserEntityById(thisID);
        System.out.println("ИЗ БД УДАЛЕНА ЗАПИСЬ С id:" + thisID);
//===================================ПРОВЕРКА ОСТУТСТВИЯ В БД==========================================================================
        entitiesList = service.getAllUserEntities();
        if ( entitiesList.isEmpty() )
            System.out.println( "СПИСОК ЗАПИСЕЙ ДАННОЙ ТАБЛИЦЫ БД ПУСТ");
        else
        {
            System.out.println("ЕСТЬ ЗАПИСИ:");
            System.out.println(entitiesList.size());
            System.out.println( service.getAllUserEntities() ); // равноценно System.out.println(entitiesList);
        }
        //==============================================================================================================
    }*/

}
//END Main CLASS

