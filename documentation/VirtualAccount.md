<p align="center">
    <img title="Flutterwave" height="200" src="https://flutterwave.com/images/logo/full.svg" width="50%"/>
</p>

# VIRTUAL ACCOUNT NUMBERS

We recommend reading the main README first to understand the requirements for using the library and how to integrate it into your application. This guide assumes you've read that.


## Create a virtual account number

This describes how to create a virtual account number.

Note: BVN is required for creating static account numbers in the Live Environment, i.e, if the value of is_permanent is True.
Kindly visit our API section found [here](https://developer.flutterwave.com/v3.0.0/reference/create-a-virtual-account-number-1) for more information.

```java
Response flwResponse =  new VirtualAccount()
        .runTransaction(new VirtualAccountRequest("developers@flutterwavego.com",
        Optional.of("12345678901"),
        Optional.of(new BigDecimal("10")),
        "VA12",
        Optional.of(true),
        "Angela"));
```

## Get a virtual account number

This describes how to fetch a virtual account number using the order reference.

```java
Response flwResponse = new VirtualAccount()
        .getVirtualAccount(reference);
```

## update BVN

This describes how to update the BVN linked to a virtual account number.

```java
Response flwResponse = new VirtualAccount()
        .updateBVN(reference, bvn);
```
