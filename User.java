package com.example.parkkaro;

public class User {
    private String Username;
    private String Emailaddress;
    private String Password;
    private String UPhoneno;
    private String Gender;

    public User(){

    }

    public User(String username, String emailaddress, String password, String uphoneno, String gender) {

        this.Username = username;
        this.Emailaddress = emailaddress;
        this.Password = password;
        this.UPhoneno = uphoneno;
        this.Gender = gender;
     }


    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmailaddress() {
        return Emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        Emailaddress = emailaddress;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUPhoneno() {
        return UPhoneno;
    }

    public void setUPhoneno(String UPhoneno) {
        this.UPhoneno = UPhoneno;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
