package com.itsrep.streem.telsample;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TelBook {

    private Map<String, Abonent> telBook = new HashMap<String, Abonent>();
// телефонная книга в мапе как вспомогательное средство
    public TelBook() {
    }

    ;

    public Map<String, Abonent> getTelBook() {
        return telBook;
    }

    public void setTelBook(Map<String, Abonent> telBook) {
        this.telBook = telBook;
    }


    public void addAbonent(Abonent abonent)  throws UserAlreadyExistsException {
// добавить в мапу abonent
        String nickName = abonent.getName();
        Abonent abonent1 = telBook.get(nickName);
        if (abonent1 != null) {
            throw new UserAlreadyExistsException();
        }
        telBook.put(nickName, abonent);
    }

    public Abonent[] getAllAbonent() {

        return telBook.values().toArray(new Abonent[telBook.size()]);
    }

    public Abonent searchTelContakt(String name) throws UserAlreadyExistsException {
// поиск телефона в мапе по имени
        if (telBook.get(name) == null) {

            throw new UserAlreadyExistsException();
        }

        return telBook.get(name);
    }

    public  void createNewFile(String fileName) throws IOException {
// создаем файл для записи
        //String fileName = "telbook.txt";
        String fullName = "";
        String dirName = System.getProperty("user.dir");
        fullName = dirName + File.separator + fileName;
        File file = new File(fullName);
System.out.println(fullName);

        if (!file.exists()) {

            if (file.createNewFile())
                System.out.println("File created");
            else
                System.out.println("Something Wrong!");
            throw new IOException();


        }

    }


    public String NewFileFullName(String fileName) throws IOException {
// можно получить полное имя файла
        //String fileName = "telbook.txt";
        String fullName = "";
        String dirName = System.getProperty("user.dir");
        fullName = dirName + File.separator + fileName;
        File file = new File(fullName);
        System.out.println(fullName);

        if (!file.exists()) {

            if (file.createNewFile())
                System.out.println("File created");
            else
                System.out.println("Something Wrong!");
            throw new IOException();


        }
return fullName;
    }

    public  void readAbonent(String fileName) {
// читаем абонента с файла
        FileInputStream fis = null;
        Abonent abonent = null;
        try {

            fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            abonent = (Abonent) ois.readObject();
            fis.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            System.err.println("Input/Output error");
            ex.printStackTrace();
        } finally {
            try {
                fis.close();

            } catch (IOException ex) {

                ex.printStackTrace();
            }
        }


    }
    public  Abonent readAbonent1(String fileName) {
// возвращаем прочитанного абонента
        FileInputStream fis = null;
        Abonent abonent = null;
        try {

            fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            abonent = (Abonent) ois.readObject();
            fis.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            System.err.println("Input/Output error");
            ex.printStackTrace();
        } finally {
            try {
                fis.close();

            } catch (IOException ex) {

                ex.printStackTrace();
            }
        }

return abonent;
    }


    public  void writeAbonent(Abonent abonent, String fileName) {
// пишем абонента в файл
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(new File(fileName));
            //fos= new FileOutputStream(fileName);

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(abonent);
            fos.close();
        } catch (IOException ex) {
            System.err.println("Input/Output error");
            ex.printStackTrace();
        } finally {
            try {
                fos.close();

            } catch (IOException ex) {

                ex.printStackTrace();
            }
        }

    }
    public  void writeAbonentInEnd (Abonent abonent, String fileName) {
// добавляем абонента в конец файла
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(new File(fileName), true);
            //fos= new FileOutputStream(fileName);

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(abonent);
            fos.close();
        } catch (IOException ex) {
            System.err.println("Input/Output error");
            ex.printStackTrace();
        } finally {
            try {
                fos.close();

            } catch (IOException ex) {

                ex.printStackTrace();
            }
        }

    }

    public void writeTelBook(String fileName) {
// записываем всю мапу в файл
        for (Abonent abonent : telBook.values()) {

           writeAbonentInEnd(abonent, fileName);


        }
    }
}



