package com.example.exer4cionchristine;

public class Student {
    String fullname;
    String studnum;
    String midt;
    String fint;
    String fing;
    String equi;
    String descri;

    public Student(String fullname, String studnum, String midt, String fint, String fing, String equi, String descri) {
        this.fullname = fullname;
        this.studnum = studnum;
        this.midt = midt;
        this.fint = fint;
        this.fing = fing;
        this.equi = equi;
        this.descri = descri;
    }

    public String getFullname() {
        return fullname;
    }

    public String getStudnum() {
        return studnum;
    }

    public String getMidt() {
        return midt;
    }

    public String getFint() {
        return fint;
    }

    public String getFing() {
        return fing;
    }

    public String getEqui() {
        return equi;
    }

    public String getDescri() {
        return descri;
    }

}
