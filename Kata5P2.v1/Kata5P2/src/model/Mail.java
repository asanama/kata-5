package model;
public class Mail {
    public String getDomain(String mail){ 
        return ((mail.contains("@")) ? mail.split("@")[1] :"" );
    }
}
