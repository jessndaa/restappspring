package com.developper.restapp.object;

/**
 * UserModel
 */
public class UserModel {

    String pseudo;
    String password;
    String id;
    public UserModel(){}
    public UserModel(String pseudo, String password) {
        this.password = pseudo;
        this.password = password;
    }
    public String getPseudo(){
        return pseudo;
    }
    public String getPassword(){
        return password;
    }
    public String getId(){
        return id;
    }

    @Override
    public String toString() {
        return this.pseudo + " is " + this.password;
    }

}