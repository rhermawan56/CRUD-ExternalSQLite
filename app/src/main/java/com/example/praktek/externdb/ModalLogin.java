package com.example.praktek.externdb;

public class ModalLogin {
    private static String _id, _nama, _email, _pass;

    public ModalLogin(){}

    public ModalLogin(String _id, String _nama,String _email, String _pass){
        this._id = _id;
        this._nama = _nama;
        this._email = _email;
        this._pass = _pass;
    }

    public void set_id (String _id){
        this._id = _id;
    }

    public void set_nama (String _nama){
        this._nama = _nama;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public void set_pass(String _pass) {
        this._pass = _pass;
    }

    public static String get_id(){ return _id; }

    public static String get_nama(){return _nama;}

    public static String get_email(){
        return _email;
    }

    public static String get_pass() {
        return _pass;
    }
}
