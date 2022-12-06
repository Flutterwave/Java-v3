<p align="center">
    <img title="Flutterwave" height="200" src="https://flutterwave.com/images/logo/full.svg" width="50%"/>
</p>

# BANKS

We recommend reading the main readme first, to understand the requirements for using the library and how to initiate this in your apps. This guide assumes you've read that.

### Get all banks

This describes how to get list of banks you can transfer to

```java

Response flwResponse = new Banks()
        .getBanks(country);
```

### Get bank branches

This describes how to get a list of bank branches
```java
Response flwResponse = new Banks()
        .getBankBranches(id)
```