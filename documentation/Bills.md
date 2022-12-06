<p align="center">
    <img title="Flutterwave" height="200" src="https://flutterwave.com/images/logo/full.svg" width="50%"/>
</p>

# Bills

We recommend reading the main readme first, to understand the requirements for using the library and how to initiate this in your apps. This guide assumes you've read that.


##  Get Bill Categories

This describes how to get bill categories

```java
new Bills().getCategories(Optional.airtime,
        Optional.data_bundle, 
        Optional.power, 
        Optional.internet, 
        Optional.toll,
        Optional.cable, 
        Optional.biller_code);
```

##  Create a bill payment

This describes how to create a bill payment

```java
Response response = new Bills()
        .runTransaction(new BillRequest("NG",
        "+23490803840303",
        new BigDecimal("'500'"),
        Optional.of(ONCE),
        Optional.empty()));
```

##  Validate a bill service

This describes how to validate a bill service

```java
Response response = new Bills().validateBillService("AT099",
        "BIL099", "+2348109328188");
```

##  Create bulk bills

This describes how to create bulk bills

```java
List<BillRequest> billRequestList = new ArrayList<>();
        billRequestList.add(billRequest);
        
Response response = new Bills()
        .runBulkTransaction("billRequestList);
```

##  Get bill payments

This describes how to get bill payments

```java
Response response = new Bills()
        .getBills(from, to);
```

##  Get status of a bill payment

This describes how to get status of a bill payment

```java
Response response = new Bills().getStatus(id);
```