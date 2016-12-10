package com.example.songezo.infoshareapp.factories;

import com.example.songezo.infoshareapp.domain.MyPatient;

import java.sql.Time;
import java.util.Date;
import java.util.Map;

/**
 * Created by Songezo on 2016-12-10.
 */
public class MyPatientFactory {

    MyPatient myPatient;

    public static MyPatientFactory myPatientFactories = null;

    public MyPatientFactory() {
    }

    public static MyPatientFactory getMyPatientFactories(){
        if (myPatientFactories == null){
            myPatientFactories = new MyPatientFactory();
        }
        return myPatientFactories;
    }

    public static MyPatient createMyPatient(Map<String, String> values, Date date, Time time){
        MyPatient myPatient1 = new MyPatient.Builder()
                                .time(time)
                                .location(values.get("The Location of patient"))
                                .name(values.get("Patient Name"))
                                .pDate(date)
                                .id(98765L)
                                .build();
        return myPatient1;
    }

    @Override
    public String toString() {
        return "MyPatientFactory{" +
                "myPatient=" + myPatient +
                '}';
    }
}
