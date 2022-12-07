<p align="center">
    <img title="Flutterwave" height="200" src="https://flutterwave.com/images/logo/full.svg" width="50%"/>
</p>

# Card Issuing

We recommend reading the main readme first, to understand the requirements for using the library and how to initiate this in your apps. This guide assumes you've read that.


## VIRTUAL CARDS

## Create virtual card

This describes how to create a new virtual card

```java
Response flwResponse = new VirtualCard()
        .runCreateVirtualCard(new VirtualCardRequest("USD",
            new BigDecimal("5"),
            "NGN",
            "Example User.",
            "333, Fremont Street",
            "San Francisco",
            "CA",
            "94105",
            "US",
            "Example",
            "User",
            "1996/12/30",
            "userg@example.com",
            "07030000000",
            "MR",
            "M",
            "https://webhook.site/b67965fa-e57c-4dda-84ce-0f8d6739b8a5"));
```

## Get All Virtual Cards

This describes how to get all virtual cards

```java
ListResponse flwResponse = new VirtualCard()
        .runGetAllVirtualCards();
```

## Get A Virtual Card

This describes how to get a virtual cards

```java
Response flwResponse = new VirtualCard()
        .runGetVirtualCard(id);
```

## Fund A Virtual Card

This describes how to fund a virtual cards

```java
Response flwResponse = new VirtualCard()
        .runFundVirtualCard(
                id,
                new FundVirtualCardRequest(
                "USD",
                new BigDecimal("500"))
        );
```

## Withdraw From A Virtual Card

This describes how to wihdraw from a virtual card

```java
ListResponse flwResponse = new VirtualCard()
        .runWithdrawVirtualCard("", new BigDecimal("200"));
```

## Block/Unblock Virtual Card

This describes how to block/unblock a virtual card

```java
Response flwResponse = new VirtualCard()
        .runStatusVirtualCard("", BLOCK);
```

## Terminate A Virtual Card

This describes how to terminate a virtual card

```java
Response flwResponse = new VirtualCard()
        .runTerminateVirtualCard("");
```

## Get A Virtual Card's Transactions

This describes how to get a virtual cards' transaction

```java
ListResponse flwResponse = new VirtualCard()
        .runTerminateVirtualCard("");
```