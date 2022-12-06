<p align="center">
    <img title="Flutterwave" height="200" src="https://flutterwave.com/images/logo/full.svg" width="50%"/>
</p>

# SubAccounts

We recommend reading the main readme first, to understand the requirements for using the library and how to initiate this in your apps. This guide assumes you've read that.


##  Create Collection Subaccounts

This describes how to create a collection subaccount

```java
Response flwResponse = new SubAccounts()
        .runCreateSubAccounts(
            new CollectionsSubAccountRequest("044",
                "0690000037",
                "Eternal Blue",
                "petya@stux.net",
                "Anonymous",
                "090890382",
                "09087930450",
                "NG",
                Optional.empty(),
                "percentage",
                new BigDecimal("0.5")),
        Optional.empty(),
        COLLECTION);
```

##  Create Payout Subaccounts

This describes how to create a payout subaccount

```java
Response flwResponse = new SubAccounts()
        .runCreateSubAccounts(payoutSubAccountRequest,
        Optional.empty(),
        PAYOUT);
```


##  Fetch collection subaccounts

This describes how to create a fetch collection subaccounts

```java
Response flwResponse = new SubAccounts()
            .runGetSubAccounts(Optional.account_bank,
                Optional.account_number,
                Optional.bank_name,
                Optional.page,
                COLLECTION
        );
```

##  Fetch payout subaccounts

This describes how to create a fetch payout subaccounts

```java
Response flwResponse = new SubAccounts()
            .runGetSubAccounts(Optional.empty(),,
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                        PAYOUT
        );
```

##  Fetch a collection subaccount

This describes how to create a fetch a collection subaccount

```java
Response flwResponse = new SubAccounts()
        .runGetSubAccount(id,
            Optional.account_reference,
            Optional.empty(),
            COLLECTION
        );
```

##  Update a collection subaccount

This describes how to create a fetch a collection subaccount

```java
Response flwResponse = new SubAccounts()
            .updateSubAccount(id,
                updateCollectionSubAccountRequest,
                Optional.empty(),
                Optional.empty(),
                COLLECTION
        );
```

##  Delete a subaccount

This describes how to create a delete a collection subaccount

```java
Response flwResponse = new SubAccounts()
        .runDeleteCollectionSubAccounts(18504);
```