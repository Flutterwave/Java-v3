package com.flutterwave.controller;

import com.flutterwave.enums.SubscriptionStatus;
import java.util.Date;

public class Subscriptions {

    private String email;
    private int id;
    private int transactionID;
    private int planID;
    private Date subscribed_from;
    private Date subscribed_to;
    private Date next_due_from;
    private Date next_due_to;
    private String page;
    private SubscriptionStatus subscriptionStatus;

    Subscriptions(String email, String page){
        this.email = email;
        this.page = page;
    }

    Subscriptions(int transactionID, String page){
        this.transactionID = transactionID;
        this.page = page;
    }

    Subscriptions(int planID, Date subscribed_from, Date subscribed_to, Date next_due_from, Date next_due_to, String page){
        this.planID = planID;
        this.subscribed_from = subscribed_from;
        this.subscribed_to = subscribed_to;
        this.next_due_from = next_due_from;
        this.next_due_to = next_due_to;
        this.page = page;
    }

    Subscriptions(SubscriptionStatus subscriptionStatus, Date subscribed_from, Date subscribed_to, Date next_due_from, Date next_due_to, String page){
        this.subscriptionStatus = subscriptionStatus;
        this.subscribed_from = subscribed_from;
        this.subscribed_to = subscribed_to;
        this.next_due_from = next_due_from;
        this.next_due_to = next_due_to;
        this.page = page;
    }

    Subscriptions(int id){
        this.id = id;
    }

    public String get(){
        return null;
    }

    public String activate(){
        return null;
    }

    public String deActivate(){
        return null;
    }
}
