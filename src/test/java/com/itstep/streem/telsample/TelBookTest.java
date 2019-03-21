package com.itstep.streem.telsample;

import com.itsrep.streem.telsample.Abonent;
import com.itsrep.streem.telsample.TelBook;
import com.itsrep.streem.telsample.UserAlreadyExistsException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TelBookTest {

    TelBook telBookTest = new TelBook();

    @Test
    public void addAbonentTest() throws UserAlreadyExistsException {


        //Given
        // Map<String, Abonent> telBook1 = new HashMap<String, Abonent>();

        Abonent abonent = new Abonent("n1", "f1", "n1f1@mail.ru");
        Abonent.PhoneNumber abonentPhone = abonent.new PhoneNumber();
        abonent.obtainPhoneNumber(abonentPhone.generateNumber(), abonentPhone.generateNumber(), abonentPhone.generateNumber(), abonentPhone.generateNumber());

        telBookTest.addAbonent(abonent);
        System.out.println(telBookTest.getTelBook().keySet());
        System.out.println(abonent.getPhoneNumber());

        Assert.assertEquals(abonent.getName(), telBookTest.searchTelContakt("n1").getName());
        Assert.assertEquals(abonent.getPhoneNumber(), telBookTest.searchTelContakt("n1").getPhoneNumber());
        Assert.assertEquals(abonent.getEmail(), telBookTest.searchTelContakt("n1").getEmail());
        Assert.assertEquals(abonent.getSurname(), telBookTest.searchTelContakt("n1").getSurname());
    }


    @Test
    public void createNewFileTest() throws IOException {

        telBookTest.createNewFile("telbook.txt");
    }

    @Test
    public void writeAbonentTest() {
        // Abonent abonent, String fileName
        Abonent abonent = new Abonent("n1", "f1", "n1f1@mail.ru");
        Abonent.PhoneNumber abonentPhone = abonent .new PhoneNumber();
        abonent.obtainPhoneNumber(abonentPhone.generateNumber(), abonentPhone.generateNumber(), abonentPhone.generateNumber(), abonentPhone.generateNumber());
        // String fullname=  telBookTest.NewFileFullName("telbook1.txt");

        telBookTest.writeAbonent(abonent, "telbook.txt");

        Abonent abonent2 = new Abonent("n2", "f2", "n2f2@mail.ru");
        Abonent.PhoneNumber abonentPhone2 =abonent2 .new PhoneNumber();
        abonent.obtainPhoneNumber(abonentPhone.generateNumber(), abonentPhone.generateNumber(), abonentPhone.generateNumber(), abonentPhone.generateNumber());

        telBookTest.writeAbonent(abonent2, "telbook.txt");

    }


    @Test
    public void readAbonent() {

        Abonent abonent = new Abonent("n1", "f1", "n1f1@mail.ru");
        Abonent.PhoneNumber abonentPhone = abonent.new PhoneNumber();
        abonent.obtainPhoneNumber(abonentPhone.generateNumber(), abonentPhone.generateNumber(), abonentPhone.generateNumber(), abonentPhone.generateNumber());

        telBookTest.writeAbonent(abonent, "telbook.txt");
        telBookTest.readAbonent("telbook.txt");

        Assert.assertTrue(telBookTest.readAbonent1
                ("telbook.txt") instanceof Abonent);

        telBookTest.readAbonent1("telbook.txt");
        Assert.assertEquals(abonent.getName(), telBookTest.readAbonent1("telbook.txt").getName());
        Assert.assertEquals(abonent.getPhoneNumber(), telBookTest.readAbonent1("telbook.txt").getPhoneNumber());
        Assert.assertEquals(abonent.getEmail(), telBookTest.readAbonent1("telbook.txt").getEmail());
        Assert.assertEquals(abonent.getSurname(), telBookTest.readAbonent1("telbook.txt").getSurname());
    }

    @Test
    public void writeTelBookTest() {// падает ???


        telBookTest.setTelBook(new HashMap<String, Abonent>());

        Abonent abonent = new Abonent("n1", "f1", "n1f1@mail.ru");
                Abonent.PhoneNumber abonentPhone = abonent.new PhoneNumber();
        abonent.obtainPhoneNumber(abonentPhone.generateNumber(), abonentPhone.generateNumber(), abonentPhone.generateNumber(), abonentPhone.generateNumber());
        // String fullname=  telBookTest.NewFileFullName("telbook1.txt");

        Abonent abonent2 = new Abonent("n2", "f2", "n2f2@mail.ru");
        Abonent.PhoneNumber abonentPhone2 = abonent2.new PhoneNumber();
        abonent.obtainPhoneNumber(abonentPhone.generateNumber(), abonentPhone.generateNumber(), abonentPhone.generateNumber(), abonentPhone.generateNumber());

        Abonent abonent3 = new Abonent("n3", "f3", "n3f2@mail.ru");
        Abonent.PhoneNumber abonentPhone3 =abonent3 .new PhoneNumber();
        abonent.obtainPhoneNumber(abonentPhone.generateNumber(), abonentPhone.generateNumber(), abonentPhone.generateNumber(), abonentPhone.generateNumber());


        try {
            telBookTest.addAbonent(abonent);
            telBookTest.addAbonent(abonent2);
            telBookTest.addAbonent(abonent3);
        } catch (UserAlreadyExistsException ex) {}

 finally {
            telBookTest.writeTelBook("telbook.txt");


        }


    }
}








