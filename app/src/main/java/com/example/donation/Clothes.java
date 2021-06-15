package com.example.donation;

public class Clothes{

    //    private final customer_active Boolean;
    // variables for storing our data.
    private String customer_uid, customer_name, customer_address, customer_clothType, customer_pickupDate, customer_Time, customer_Quantity;
    private  Boolean customer_active;
    public Clothes() {
        // empty constructor
        // required for Firebase.
    }

    public Clothes(String customer_name, String customer_address,
                   String customer_clothType, String customer_pickupDate, String customer_Time,String customer_Quantity
    ) {
        this.customer_uid = customer_uid;
        this.customer_name = customer_name;
        this.customer_address= customer_address;
        this.customer_clothType= customer_clothType;
        this.customer_pickupDate = customer_pickupDate;
        this.customer_Time= customer_Time;
        this.customer_Quantity = customer_Quantity;

    }


    // getter methods for all variables.
    public String getCustomer_uid() {
        return customer_uid;
    }

    public void setCustomer_uid(String customer_uid) {
        this.customer_uid = customer_uid;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_clothType() {
        return customer_clothType;
    }

    public void setCustomer_clothType(String customer_contact) {
        this.customer_clothType = customer_clothType;
    }

    public String getCustomer_pickupDate() {
        return customer_pickupDate;
    }

    public void setCustomer_pickupDate(String customer_mobile_brand) {
        this.customer_pickupDate = customer_pickupDate;
    }

    public String getCustomer_Time() {
        return customer_Time;
    }

    public void setCustomer_Time(String customer_payment) {
        this.customer_Time = customer_Time;
    }

    public String getCustomer_Quantity() {
        return customer_Quantity;
    }

    public void setCustomer_Quantity(String customer_loan) {
        this.customer_Quantity = customer_Quantity;
    }


}