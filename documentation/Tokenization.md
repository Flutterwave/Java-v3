<p align="center">
    <img title="Flutterwave" height="200" src="https://flutterwave.com/images/logo/full.svg" width="50%"/>
</p>

# Tokenization

We recommend reading the main readme first, to understand the requirements for using the library and how to initiate this in your apps. This guide assumes you've read that.

## Create a Tokenized Charge

This describes how to create a tokenized charge

```java

Response flwResponse = new TokenizedCharge()
        .runTransaction(new TokenizedChargeRequest("flw-t1nf-f9b3bf384cd30d6fca42b6df9d27bd2f-m03k",
        "NGN",
        "NG",
        new BigDecimal("2000"),
        "developers@flutterwavego.com",
        "Flutterwave",
        "Developers",
        "123.876.0997.9",
        "Sample tokenized charge",
        "tokenized-c-001"));
```

## Create bulk Tokenized Charges

This describes how to create a bulk tokenized charge

```java
List<TokenizedChargeRequest> tokenizedChargeRequestList= new ArrayList<>();
        tokenizedChargeRequestList.add(tokenizedChargeRequest);

Response flwResponse = new TokenizedCharge()
        .runBulkTransaction(tokenizedChargeRequestList);
```

## Get bulk Tokenized Charges

This describes how to get bulk tokenized charge

```java
ListResponse flwResponse = new TokenizedCharge()
        .runGetBulkTransaction(id);
```

## Get status of bulk Tokenized Charges

This describes how to get bulk tokenized charge

```java
Response flwResponse = new TokenizedCharge()
        .runGetBulkTransactionStatus(id);
```

## Update Card token

This describes how to update card token

```java
Response flwResponse = new TokenizedCharge()
        .runUpdateToken(token, 
        new UpdateTokenRequest("user@example.com",
        "Kendrick Graham",
        "0813XXXXXXX"));
```