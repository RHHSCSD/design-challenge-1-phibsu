/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package designprojectone;
import java.util.*;
import java.lang.Math;
/***************************************************
*
*  Program: Tech Fair Cost Calculator
*  Author: Phoebe Su
*  Date: 2024 March 7
*  Description: Calculate cost per student for the science fair
****************************************************/

/**************** IPO CHART ************************
*INPUT:
* number of students each choosing Arduino, Raspberry PI, and VR projects
*
*PROCESSING:
* calculate total number of students
* calculate total cost per type of project, add them, and divide by total 
*
*OUTPUT:
* cost per student
*
***************************************************/
  
/**************** TEST CASES ************************
*Test           Input      Desired Ouput
*zero           0 0 0        0.00
*negative       -5 -3 15     retry       
*below discount 14 15 6     63.86
* at discount   15 20 15    65.00
*above discount 18 25 7     62.04
*more than 100  25 61 54    62.05
*
***************************************************/
public class DesignProjectOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   //Write Pseudocode FIRST as comments and THEN write the code
   
  //CONSTANTS
  double BASE_DISCOUNT = 0.95;
  int BASE_PRICE = 50;
  int ARDUINO_PRICE = 10;
  int ARDUINO_DISCOUNT = 9;
  int RASPBERRY_PRICE = 15;
  int RASPBERRY_DISCOUNT = 12;
  int VR_PRICE = 20;
  
  //VARIABLES

  int arduinoNum;
  int raspberryNum;
  int vrNum;
  int totalNum;
  double initialCost;
  int arduinoCost;
  int raspberryCost;
  int vrCost;
  double averageCost;
  
  //CODE
  // INITIALIZE SCANNER
  Scanner kb = new Scanner(System.in);
  
  // ASK FOR ALL INPUTS
  System.out.println("Enter number of students doing Arduino project: ");
  arduinoNum = kb.nextInt();
  System.out.println("Enter number of students doing Raspberry PI project: ");
  raspberryNum = kb.nextInt();
  System.out.println("Enter number of students doing VR project: ");
  vrNum = kb.nextInt();
  
  // PREVENT DIVISION BY ZERO AND NEGATIVE NUMBERS
  totalNum = arduinoNum + raspberryNum + vrNum;
  if ((arduinoNum < 0) || (raspberryNum < 0) || (vrNum < 0)){
        System.out.println("Please enter positive numbers!");
        return;
    }
  else if (totalNum == 0){
      System.out.println("$0.00");
      return;
  }
  
  // CALCULATE BASE COST
  initialCost = totalNum * BASE_PRICE;
  
  // APPLY DISCOUNT TO BASE COST
  if (totalNum > 100){
      initialCost = initialCost * BASE_DISCOUNT;
  }
  
  // CALCULATE TOTAL COST FOR ARDUINO PROJECTS
  if (arduinoNum <= 15){
      arduinoCost = arduinoNum * ARDUINO_PRICE;
  }
  else{
      arduinoCost = arduinoNum * ARDUINO_DISCOUNT;
  }
  
  // CALCULATE TOTAL COST FOR RASPBERRY PI PROJECTS
  if (raspberryNum <= 20){
      raspberryCost = raspberryNum * RASPBERRY_PRICE;
  }
  else{
      raspberryCost = raspberryNum * RASPBERRY_DISCOUNT;
  }
  
  // CALCULATE TOTAL COST FOR VR PROJECTS
  vrCost = vrNum * VR_PRICE;
  
  // CALCULATE FINAL TOTAL AND AVERAGE
  averageCost = Math.round((vrCost+arduinoCost+raspberryCost+initialCost)/totalNum*100)/100.0;
  
  // OUTPUT AVERAGE
      System.out.println("$"+averageCost);
    }
    
}
