package com.example.ifsul_progmov1_acts_s4_2022;

import java.io.Serializable;

public class Actividad7_Estudiantes implements Serializable {
    private int idno;
    private String name;
    private String email;
    private String pwd;
    private String course;

    // Initialize variables via constructor:
    public Actividad7_Estudiantes(){
        this.idno = 0;
        this.name = "";
        this.email = "";
        this.pwd = "";
        this.course = "";
    }

    // Getters and setters

    public int getIdno() {
        return idno;
    }

    public void setIdno(int idno) {
        this.idno = idno;
    }

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
