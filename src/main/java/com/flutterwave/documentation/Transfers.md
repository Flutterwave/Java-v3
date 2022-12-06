<p align="center">
    <img title="Flutterwave" height="200" src="https://flutterwave.com/images/logo/full.svg" width="50%"/>
</p>

# TRANSFERS

We recommend reading the main readme first, to understand the requirements for using the library and how to initiate this in your apps. This guide assumes you've read that.


## Create a transfer
This describes how to initiate a transfer

For more info about the payload parameteres definition, check  [here](https://developer.flutterwave.com/reference#create-a-transfer)

```java
Response flwResponse = new Transfer()
        .runTransaction(new TransferRequest("https://www.flutterwave.com/ng/",
        "akhlm-pstmnpyt-rfxx007_PMCKDU_1",
        "NGN",
        "044",
        "0690000040",
        "Akhlm Pstmn Trnsfr xx007",
        new BigDecimal("10"),
        "NGN"));
```

## Retry a Transfer

This describes how to retry a transfer

```java
Response flwResponse = new Transfer().retry(id);
```

## Create a Bulk transfer

This describes how to create a bulk transfer

```java
List<TransferRequest> transferRequestList = new ArrayList<>();
        transferRequestList.add(transferRequest);
        
Response flwResponse = new Transfer()
        .runBulkTransaction(transferRequestList);
```

## Get Transfer fees

This describes how to get a transfer fee

```java
Response flwResponse = new Transfer()
        .getFee(new BigDecimal("200"));
```

## Get all Transfers

This describes how to get all transfers

```java
Response flwResponse = new Transfer()
        .getAllTransfers(Optional.page, 
        Optional.status);
```

## Fetch a Transfer

This describes how to get all transfers

```java
Response flwResponse = new Transfer().getTransfer(id);
```

## Get Transfer Rates

This describes how to get transfer rates

```java
Response flwResponse = new Transfer()
        .getTransferRate(new BigDecimal("200"),
        "USD", "NGN");
```