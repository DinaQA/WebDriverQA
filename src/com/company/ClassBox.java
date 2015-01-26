package com.company;

import org.openqa.selenium.By;

/**
 * Created by dina.knyr on 23.01.2015.
 */
public class ClassBox {
    private String boxName = "Box";

    public void Name(){
        //new class
        System.out.println(boxName);
    }
    public void rename(String newName){

        boxName=newName;
    }

}
