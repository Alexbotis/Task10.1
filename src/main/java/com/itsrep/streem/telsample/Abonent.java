package com.itsrep.streem.telsample;

import java.io.Serializable;

public class Abonent implements Serializable {

    private String name;
    private String surname;
    private String email;
    private PhoneNumber phoneNumber;

    public Abonent(String name, String surname, String email) {

        this.name = name;
        this.surname = surname;
        this.email = email;

    }

    public class PhoneNumber implements Serializable {
// внутренний класс
        private int worktel;
        private int hometel;
        private int mobiltel;
        private int fax;

        public void setWorktel(int worktel) {
            this.worktel = worktel;
        }

        public int getWorktel() {
            return worktel;
        }

        public int getHometel() {
            return hometel;
        }

        public void setHometel(int hometel) {
            this.hometel = hometel;
        }

        public int getMobiltel() {
            return mobiltel;
        }

        public void setMobiltel(int mobiltel) {
            this.mobiltel = mobiltel;
        }

        public int getFax() {
            return fax;
        }

        public void setFax(int fax) {
            this.fax = fax;
        }

        public int generateNumber() {
// метод для генерации телефонов
            return new java.util.Random().nextInt(1000000);

        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

  //  public PhoneNumber getPhoneNumber() {
   //     return phoneNumber;
    //}

    public void setPhoneNumbers(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void obtainPhoneNumber(int worktel, int hometel, int mobiltel, int fax) {
//
        this.phoneNumber = new PhoneNumber();
// создаем объект внутреннего класса new PhoneNumber()
// и set телефоны
        phoneNumber.setWorktel(worktel);
        phoneNumber.setHometel(hometel);
        phoneNumber.setMobiltel(mobiltel);
        phoneNumber.setFax(fax);

    }

    public String getPhoneNumber() {

        StringBuilder s= new StringBuilder(100);
        if (phoneNumber != null) {

            s.append("Worktel   "+ phoneNumber.getWorktel()+":\n");
            s.append("Hometel   "+ phoneNumber.getHometel()+":\n");
            s.append("Mobiltel   "+ phoneNumber.getMobiltel()+":\n");
            s.append("Fax   "+ phoneNumber.getFax()+":\n");

return s.toString();
        }else{

            return ("phoneNumber is empty");
        }


    }



}
