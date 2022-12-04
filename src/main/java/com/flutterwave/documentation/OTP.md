<p align="center">
    <img title="Flutterwave" height="200" src="https://flutterwave.com/images/logo/full.svg" width="50%"/>
</p>

# OTPS

We recommend reading the main readme first, to understand the requirements for using the library and how to initiate this in your apps. This guide assumes you've read that.


###  Create Otp

This describes how to create an otp

```java
List<Medium> mediumList = new ArrayList<>();
        mediumList.add(SMS);
        
ListResponse flwResponse = new OTP().runcreateOTP(new OTPRequest(new Customer(
        "Flutterwave Developers",
        "developers@flutterwavego.com",
        "2348000000000"),
        "Flutterwave Inc.",
        true,
        7,
        Optional.of(3),
        mediumList));
```

###  Validate Otp

This describes how to validate an otp

```java
Response flwResponse = new OTP().runvalidateOTP(
        "CF-BARTER-20221203111843688560", 
        "6834919"); 
```