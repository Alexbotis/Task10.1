package com.itstep.streem.telsample;

import com.itsrep.streem.telsample.Abonent;
import org.junit.Assert;
import org.junit.Test;

public class AbonentTest  {
    Abonent abonent = new Abonent("n1","f1","n1f1@mail.ru");

    @Test
    public void obtainPhoneNumberTest(){
        //(int worktel, int hometel, int mobiltel, int fax)

        //Given
        Abonent.PhoneNumber abonentPhone= new Abonent("n1","f1","n1f1@mail.ru").new PhoneNumber();
        abonent.obtainPhoneNumber( abonentPhone.generateNumber(),abonentPhone.generateNumber(),abonentPhone.generateNumber(),abonentPhone.generateNumber());
        abonent.getPhoneNumber();

       // abonentPhone=new Abonent.PhoneNumber();



        Assert.assertTrue(abonent!=null);
        Assert.assertTrue(abonentPhone!=null);
        Assert.assertTrue(abonent.getName()=="n1");
    }





}
