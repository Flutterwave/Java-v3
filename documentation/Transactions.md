<p align="center">
    <img title="Flutterwave" height="200" src="https://flutterwave.com/images/logo/full.svg" width="50%"/>
</p>

# Transactions

We recommend reading the [main README](../README.md) first to understand the requirements for using the library and how to integrate it into your application. This guide assumes you've read that.

## Verify a transaction

This describes how to verify a transaction.

```java

Response flwResponse = new Transactions()
        .runVerifyTransaction(id);
```

## Create a Refund

This describes how to create a refund.

```java

Response flwResponse = new Transactions()
        .new Refunds().runRefund(id,
        Optional.amount);
```

## Get multiple Transactions

This describes how to get multiple transactions.

```java

ListResponse flwResponse = new Transactions()
        .runGetTransactions();
```

## Get multiple refund transactions

This describes how to get multiple refund transactions.

```java

ListResponse flwResponse = new Transactions()
        .new Refunds().runGet(id,
        Optional.amount);
```

## Get refund details

This describes how to get refund details.

```java

Response flwResponse = new Transactions()
        .new Refunds().runGetDetails(id);
```

## Get transactions fees (Collections)

This describes how to get the transaction fee.

```java

Response flwResponse = new Transactions()
        .runGetTransactionsFees(new BigDecimal("10"),
        "NGN");
```

## Resend failed Webhooks

This describes how to resend failed webhooks.

```java

Response flwResponse = new Transactions()
        .runResendWebhook(0,
        Optional.empty());
```

## View transaction timeline

This describes how to view the transaction timeline.

```java

Response flwResponse = new Transactions().runViewTimeline(id);
```
