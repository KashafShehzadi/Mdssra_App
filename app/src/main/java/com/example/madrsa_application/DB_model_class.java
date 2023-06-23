package com.example.madrsa_application;

public class DB_model_class {

        int id,ClassName,Start,End,sbqi,mnzil;
    String NAME,roll;
public int get_className(){
    return ClassName;
    }
    public int get_sbqi(){
        return sbqi;
    }
    public int get_mnzil(){
        return mnzil;
    }
    public String get_verse(){
       String ans=Start+"-"+End;
        return ans;
    }
    public String get_Roll(){
    return roll;
    }
    public String get_Name(){
        return NAME;
    }
}
