package com.company;

public class Student {
    private int _ID;
    private String _name;
    private double _scores;
    private String _avatar;
    private String _address;
    private String _note;

    public Student(int ID, String name, double scores, String avatar, String address, String note) {
        _ID = ID;
        _name = name;
        _scores = scores;
        _avatar = avatar;
        _address = address;
        _note = note;
    }

    public Student() {
        _ID = 0;
        _name = "No Name";
        _scores = 0.0;
        _avatar = "No Avatar";
        _address = "No Address";
        _note = "";
    }

    public int get_ID() {
        return _ID;
    }

    public String get_name() {
        return _name;
    }

    public double get_scores() {
        return _scores;
    }

    public String get_avatar() {
        return _avatar;
    }

    public String get_address() {
        return _address;
    }

    public String get_note() {
        return _note;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_scores(double _scores) {
        this._scores = _scores;
    }

    public void set_avatar(String _avatar) {
        this._avatar = _avatar;
    }

    public void set_address(String _address) {
        this._address = _address;
    }

    public void set_note(String _note) {
        this._note = _note;
    }

    @Override public String toString() {
        String result = "";
        result = Integer.toString(_ID) + ", " + _name + ", " + Double.toString(_scores) + ", " + _avatar + ", " + _address + ", " + _note;

        return result;
    }

    public String toShortString() {
        String result = "";
        result = Integer.toString(_ID) + ", " + _name + ", " + Double.toString(_scores);

        return result;
    }

}
