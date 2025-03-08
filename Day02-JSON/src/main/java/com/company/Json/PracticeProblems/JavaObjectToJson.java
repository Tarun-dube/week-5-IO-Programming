package com.company.Json.PracticeProblems;

import com.fasterxml.jackson.databind.ObjectMapper;

class Car{
    public String name;
    public String color;
    public String company;
    public int price;

   public Car(String name, String color, String company, int price) {
        this.name = name;
        this.color = color;
        this.company = company;
        this.price = price;
    }
}
public class JavaObjectToJson {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            Car car = new Car("Rangerover", "black", "tata", 8000000);

            String jsonString = mapper.writeValueAsString(car);
            System.out.println(jsonString);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
