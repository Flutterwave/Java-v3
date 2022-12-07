<p align="center">
    <img title="Flutterwave" height="200" src="https://flutterwave.com/images/logo/full.svg" width="50%"/>
</p>

# SETTLEMENTS

We recommend reading the main readme first, to understand the requirements for using the library and how to initiate this in your apps. This guide assumes you've read that.


## Get all settlements

This describes how to fetch all settlements

```java
ListResponse flwResponse = new Settlements()
        .runGetAllSettlements(Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
```

## Get a settlement

This describes how to get a settlement

```java
ListResponse flwResponse = new Settlements()
        .runGetSettlement(id,
            Optional.empty(),
            Optional.empty());
```