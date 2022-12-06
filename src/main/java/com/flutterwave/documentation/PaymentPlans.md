<p align="center">
    <img title="Flutterwave" height="200" src="https://flutterwave.com/images/logo/full.svg" width="50%"/>
</p>

# Payment plans

We recommend reading the main readme first, to understand the requirements for using the library and how to initiate this in your apps. This guide assumes you've read that.


##  Create Payment Plan


This describes how to create a payment plan

```java
Response flwResponse = new PaymentPlan()
        .runCreatePlan(new PaymentPlanRequest(new BigDecimal("5000"),
        "the akhlm postman plan 2",
        MONTHLY,
        40));
```

##  Get payment plans

This describes how to get payment plans

```java
ListResponse flwResponse = new PaymentPlan()
        .getPlans();
```

##  Get a Payment Plan

This describes how to get a payment plan

```java
ListResponse flwResponse = new PaymentPlan()
        .getPlan(id);
```

##  Update a Payment Plan

This describes how to update a payment plan

```java
ListResponse flwResponse = new PaymentPlan()
        .updatePlan(id, new UpdatePaymentPlanRequest("January neighbourhood contribution",
        "active"));
```

##  Cancel a Payment Plan

This describes how to cancel a payment plan

```java
ListResponse flwResponse = new PaymentPlan()
        .cancelPlan(id);
```