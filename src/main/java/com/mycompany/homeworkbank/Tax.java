/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.homeworkbank;

/**
 *
 * @author jorozco
 */
public class Tax {
  private static double value;
  
  public static  double calularTax(String op,double monto){
      value = 0;
      if(op.equals("R")){
         if(monto>1000){
             value = (monto * 15)/100;
             value = value+ 200;
         }else{
             value = 200;
         }
      }else{
          value=100;
      }
      return value;
  }
}
