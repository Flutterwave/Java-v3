<p align="center">
    <img title="Flutterwave" height="200" src="https://flutterwave.com/images/logo/full.svg" width="50%"/>
</p>

# Flutterwave v3 Java Library
[![Build Status](https://github.com/Flutterwave/Java/workflows/Java%20CI%20with%20Maven/badge.svg)](https://github.com/Flutterwave/Java) 
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT) 
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.flutterwave/f4b-java/badge.svg)](https://mvnrepository.com/artifact/com.flutterwave/f4b-java)

## Introduction

The Java library provides easy access to Flutterwave for Business (F4B) v3 APIs for your Java codebase. It abstracts the complexity involved in direct integration and allows you to make quick calls to the APIs.

Available features include:

- Collections: Card, Account, Mobile money, Bank Transfers, USSD, Barter, NQR.
- Payouts and Beneficiaries.
- Recurring payments: Tokenization and Subscriptions.
- Split payments
- Card issuing
- Transactions dispute management: Refunds and Chargebacks.
- Transaction reporting: Collections, Payouts, Settlements, Refunds and Chargebacks.
- Bill payments: Airtime, Data bundle, Cable, Power, Toll, E-bills, and Remitta.
- Identity verification: Resolve bank account, resolve BVN information and generate OTP.

# Heads Up!
This Library cannot be used on a project with a file named "base.properties" in project path.


## Table of Content

1. [Requirements](#requirements)
2. [Installation](#installation)
3. [Initialization](#initialization)
4. [Usage](#usage)
5. [Testing](#testing)
6. [Debugging Errors](#debugging-errors)
7. [Support](#support)
8. [Contribution guidelines](#contribution-guidelines)
9. [License](#license)
10. Changelog

## Requirements

1. Flutterwave for business [API Keys](https://developer.flutterwave.com/docs/integration-guides/authentication)
2. Java


## Installation

## Maven users
Add this dependency to your project's POM: 

```java
<dependency>
 <groupId>com.flutterwave</groupId>
    <artifactId>f4b-java</artifactId>
    <version>3.0</version>
</dependency>
```

## Gradle users
Add this dependency to your project's build file:

```java
compile("com.flutterwave:f4b-java:3.0")
```


## Environment Variables
The foloowing environment variables need to be set before calling any method

```java
  Environment.setSecretKey("FLWSECK_TEST-92e*******-X");
  Environment.setPublicKey("FLWSECK_TEST-92e*******-X");
  Environment.setEncryptionKey("FLWSECK_TE********c1f2");
```

For staging, Use TEST API Keys and for production, use LIVE API KEYS.
You can get your keys from the Flutterwave dashboard.

Read the [requirement section](#requirements) for more information on how to get your API keys.

## Usage
1. [Collections](documentation/Collections.md)
2. [Tokenization](documentation/Tokenization.md)
3. [Split payments](documentation/SubAccounts.md)
4. [Scheduled payments](documentation/ScheduledPayments.md)
5. [Transfers](documentation/Transfers.md)
6. [Card Issuing](documentation/CardIssuing.md)
7. [Virtual Account](documentation/VirtualAccount.md)
8. [Bill payments](documentation/Bills.md)
9. [Transactions and reporting](documentation/Transactions.md)
10. [Beneficiaries](documentation/Beneficiary.md)
11. [Banks](documentation/Banks.md)
12. [Settlements](documentation/Settlements.md)
13. [OTP](documentation/OTP.md)
14. [Misc](documentation/Misc.md)
15. [Subscriptions](documentation/Subscriptions.md)
16. [PaymentPlans](documentation/PaymentPlans.md)


## Debugging Errors

We understand that you may run into some errors while integrating our library. You can read more about our error messages [here](https://developer.flutterwave.com/docs/integration-guides/errors).

For `authorization` and `validation` error responses, double-check your API keys and request. If you get a `server` error, kindly engage the team for support.


## Support

For additional assistance using this library, contact the developer experience (DX) team via [email](mailto:developers@flutterwavego.com) or on [slack](https://bit.ly/34Vkzcg).

You can also follow us [@FlutterwaveEng](https://twitter.com/FlutterwaveEng) and let us know what you think 😊.


## Contribution guidelines
Read more about our community contribution guidelines [here](/CONTRIBUTING.md)


## License

By contributing to this library, you agree that your contributions will be licensed under its [MIT license](/LICENSE).

Copyright (c) Flutterwave Inc.
