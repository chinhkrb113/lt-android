package com.example.contactlist;

public class ContactModel {
    String name, tel, email;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    public char getFirstLetter(){
        char firstLetter=name.charAt(0);
        return firstLetter;

    }

}
