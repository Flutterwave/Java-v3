<p align="center">
    <img title="Flutterwave" height="200" src="https://flutterwave.com/images/logo/full.svg" width="50%"/>
</p>

# BENEFICIARIES

We recommend reading the main readme first, to understand the requirements for using the library and how to initiate this in your apps. This guide assumes you've read that.



## Create a beneficiary

This describes how to create a transfer beneficiary
```java
Response flwResponse = new Beneficiaries()
        .runCreateBeneficiary(new BeneficiaryRequest("0690000034",
            "044",
            "Ade Bond",
            Optional.empty(),
            Optional.empty()));
```

## List all Transfer Beneficiaries

This describes how to list all transfer beneficiaries
```java
ListResponse flwResponse = new Beneficiaries()
        .runGetAllBeneficiaries(Optional.page);
```

## Fetch a Transfer Beneficiary

This describes how to fetch a transfer beneficiary
```java
Response flwResponse = new Beneficiaries()
        .runGetBeneficiary(Optional.id);
```

## Delete a Transfer Beneficiary

This describes how to delete a transfer beneficiary
```java
Response flwResponse = new Beneficiaries()
        .runDeleteBeneficiary(Optional.id);
```