<p align="center">
    <img title="Flutterwave" height="200" src="https://flutterwave.com/images/logo/full.svg" width="50%"/>
</p>

# MISC

We recommend reading the main readme first, to understand the requirements for using the library and how to initiate this in your apps. This guide assumes you've read that.

### Resolve account details

This describes how to resolve a bank account to get the account holder's details

```java
Response flwResponse = new  ResolveAccount()
        .runTransaction(new AccountResolveRequest(
        "0690000032",
        "044",
        Optional.empty(),
        Optional.empty()
        ));
```

### Resolve bvn details

This describes how to fetch bvn information

```java
Response flwResponse =  new ResolveBVN().
        runTransaction("123456789010");
```