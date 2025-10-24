<p align="center">
    <img title="Flutterwave" height="200" src="https://flutterwave.com/images/logo/full.svg" width="50%"/>
</p>

# Collections

We recommend reading the main README first to understand the requirements for using the library and how to integrate it into your application. This guide assumes you've read that.


Collect payments from your users via any of these methods:

1. [Cards](#card-collections)
2. [Bank transfers](#bank-transfers)
3. [Direct debit (Nigerian bank accounts)](#direct-debit-nigerian-bank-account)
4. [Direct debit (UK bank accounts)](#direct-debit-uk-bank-account)
5. [ACH payment](#ach-payment)
6. [Mpesa](#mpesa)
7. [Ghana Mobile Money](#ghana-mobile-money)
8. [Uganda Mobile Money](#uganda-mobile-money)
9. [Rwanda Mobile Money](#rwanda-mobile-money)
10. [Zambia Mobile Money](#zambia-mobile-money)
11. [Francophone Mobile Money (for Senegal, Côte d'Ivoire, Mali, and Cameroon)](#francophone-mobile-money).
12. [USSD](#ussd)
13. [Apple Pay](#applepay)
14. [Google Pay](#googlepay)
15. [PayPal](#paypal)
16. [Fawrypay](fawrypay)

There are three steps involved in collecting payments from your users:

- Initiating the transaction.
- Authorizing the transaction.
- Verifying the transaction.

Read more about the steps [here](https://developer.flutterwave.com/v3.0.0/docs/direct-card-charge#payment-flow).

## Card Collections

This section describes how you can collect card payments in the SDK. You can learn more about the payment.
method [here](https://developer.flutterwave.com/v3.0.0/docs/direct-card-charge).

```java
Optional.ofNullable(new CardCharge()
        .runTransaction(
                new CardRequest("5531886652142950",
                "564",
                "09",
                "32",
                "NGN",
                new BigDecimal("100"),
                "Yolande Aglaé Colbert",
                "stefan.wexler@hotmail.eu",
                "MC-3243e8",
                "https://www,flutterwave.ng",
                null)
        )).map(response->{
                switch(response.getMeta().getAuthorization().getMode()){
                    case PIN -> cardRequest.setAuthorization(new Authorization().pinAuthorization("3306"));
                    case AUS_NOAUTH -> cardRequest.setAuthorization(new Authorization().avsAuthorization(
                            city,
                            address,
                            state,
                            country,
                            zipcode
                    ));
                    case REDIRECT-> {
                    //redirect user
                    }
                }
        Response authorizeResponse=new CardCharge().runTransaction(cardRequest);

        //validate
        validateTransaction(authorizeResponse.getData().getFlw_ref());

        //verify
        return verifyTransaction(authorizeResponse.getData().getId());
        });
```

## Preauth Collections

This section describes how you can collect card preauth payments in the SDK. You can learn more about the payment
method [here](https://developer.flutterwave.com/v3.0.0/docs/preauthorization).

```java
Response flwResponse=new PreAuthorization(
        new PreAuthorizationRequest("5531886652142950",
                "157",
                "5",
                "25",
                new BigDecimal("20"),
                "Flutterwave Developers",
                "sample-ref",
                "NGN",
                "NG",
                "developers@flutterwavego.com",
                "https://www.flutterwave.com/ng/",
        Optional.empty()));
```

## Bank Transfers

This section covers how you can collect payments made via bank transfers. We go into more detail on the payment flow.
itself [here](https://developer.flutterwave.com/v3.0.0/docs/bank-transfer-1).

```java
Response flwResponse=new BanKTransfer()
        .runTransaction(new BanKTransferRequest(Optional.empty(),
                "ref001",
                Optional.of(new BigDecimal("10")),
                "stefan.wexler@hotmail.eu",
                Optional.empty(),
                "NGN",
                "154.123.220.1",
                "62wd23423rq324323qew1",
                "FlW Devs",
        Optional.empty()));
```

## Direct debit (Nigerian bank account)

```java
Response flwResponse=new BankAccount()
        .runTransaction(new BankAccountRequest("MC-1585230ew9v5050e8",
                new BigDecimal("100"),
                "058",
                "0690000032",
                "NGN",
                "stefan.wexler@hotmail.eu",
                "0902620185",
                "Yolande Aglaé Colbert"
        ));
```

## Direct debit (UK bank account)

```java
Response flwResponse=new BankAccount()
        .runTransaction(new BankAccountRequest("MC-1585230ew9v5050e8",
                new BigDecimal("100"),
                "044",
                "0690000032",
                "GBP",
                "stefan.wexler@hotmail.eu",
                "0902620185",
                "Yolande Aglaé Colbert")
        );
```

## ACH Payment

This shows you how to accept ZAR and USD ACH charges from your customers. Read more about ACH
payments [here](https://developer.flutterwave.com/v3.0.0/docs/ach-payment).

```java
Response flwResponse=new ACH()
        .runTransaction(new ACHRequest("MC-1585230ew9v5050e8",
                new BigDecimal("100"),
                "stefan.wexler@hotmail.eu",
                "0902620185",
                "USD",
                "US",
                "154.123.220.1",
                "Yolande Aglaé Colbert",
                "https://www.flutterwave.com/us/",
                "62wd23423rq324323qew1",
                Optional.empty())
        );
```

## USSD

This describes how to collect payments via USSD.

```java
Response flwResponse=new USSD().runTransaction(new USSDRequest("MC-15852309v5050e8y",
                "057",
                new BigDecimal("10"),
                "NGN",
                "stefan.wexler@hotmail.eu",
                "054709929220",
                "Yolande Aglaé Colbert"
        ));
```

## Mpesa

This describes how to collect payments via M-Pesa. Read more about M-Pesa.
payments [here](https://developer.flutterwave.com/v3.0.0/docs/m-pesa).

```java
Response flwResponse=new MobileMoney().runMpesaTransaction(new MpesaRequest("MC-15852113s09v5050e8",
                new BigDecimal("10"),
                "KES",
                "stefan.wexler@hotmail.eu",
                "25454709929220",
                "Yolande Aglaé Colbert"
        ));
```

## Ghana mobile money

This describes how to collect payments via Ghana mobile money.

```java
Response flwResponse=new MobileMoney().runGhanaMobileMoneyTransaction(new GhanaMobileMoneyRequestRequest("MC-158523s09v5050e8",
                new BigDecimal("150"),
                "GHS",
                "143256743",
                "MTN",
                "stefan.wexler@hotmail.eu",
                "054709929220",
                "Yolande Aglaé Colbert",
                "154.123.220.1",
                "62wd23423rq324323qew1",
                Optional.empty()
        ))
```

Sample Response

```json
{
  "actions": "success",
  "message": "Charge initiated",
  "meta": {
    "authorization": {
      "redirect": "https://ravemodal-dev.herokuapp.com/captcha/verify/74679:470de2fca78619f91e5c12067fa0aca8",
      "mode": "redirect"
    }
  }
}
```

**Redirect your customer to the redirect link returned in the charge initiation response.**
**NB: OTP on staging (TEST MODE) is `123456`**

## Rwanda mobile money

This describes how to collect payments via Rwanda mobile money.

```java
Response flwResponse=new MobileMoney()
            .runRwandaMobileMoneyTransaction(
                new RwandaMobileMoneyRequestRequest("MC-15852113s09v5050e8",
                    new BigDecimal("10"),
                    "KES",
                    "stefan.wexler@hotmail.eu",
                    "25454709929220",
                    "Yolande Aglaé Colbert"
        ));
```

## Uganda mobile money

This describes how to collect payments via Uganda mobile money.

```java
Response flwResponse=new MobileMoney()
                .runUgandaMobileMoneyTransaction(new UgandaMobileMoneyRequestRequest("MC-158523s09v5050e8",
                new BigDecimal("150"),
                "UGX",
                "143256743",
                "MTN",
                "stefan.wexler@hotmail.eu",
                "054709929220",
                "Yolande Aglaé Colbert",
                "154.123.220.1",
                "62wd23423rq324323qew1",
                Optional.empty()
        ));
```

## Francophone mobile money

This describes how to collect payments via mobile money for Franc.

```java
Response flwResponse=new MobileMoney()
                .runFrancophoneMobileMoneyTransaction(new FrancophoneMobileMoneyRequestRequest("MC-15852113s09v5050e8",
                new BigDecimal("10"),
                "CM",
                "XAF",
                "stefan.wexler@hotmail.eu",
                "25454709929220",
                "Yolande Aglaé Colbert"
        ));
```

## Zambia mobile money

This describes how to collect payments via Zambia mobile money.

```java
Response flwResponse=new MobileMoney()
                .runZambiaMobileMoneyTransaction(new ZambiaMobileMoneyRequestRequest("MC-158523s09v5050e8",
                new BigDecimal("150"),
                "UGX",
                "143256743",
                "MTN",
                "stefan.wexler@hotmail.eu",
                "054709929220",
                "Yolande Aglaé Colbert",
                "154.123.220.1",
                "62wd23423rq324323qew1",
                Optional.empty()
        ));
```

## Applepay

This describes how to collect payments via Apple Pay.

```java
Response flwResponse=new ApplePay().runTransaction(new ApplePayRequest("MC-TEST-123456",
                new BigDecimal("10"),
                "stefan.wexler@hotmail.eu",
                "09012345678",
                "USD",
                "192.168.0.1",
                "gdgdhdh738bhshsjs",
                "15101",
                "allison park",
                "3563 Huntertown Rd",
                "Pennsylvania",
                "US",
                "Test payment",
                Optional.empty()
        ));
```

## Googlepay

This describes how to collect payments via Google Pay.

```java
Response flwResponse=new GooglePay().runTransaction(new GooglePayRequest("MC-TEST-123456",
                new BigDecimal("10"),
                "stefan.wexler@hotmail.eu",
                "09012345678",
                "USD",
                "192.168.0.1",
                "gdgdhdh738bhshsjs",
                "15101",
                "allison park",
                "3563 Huntertown Rd",
                "Pennsylvania",
                "US",
                "Test payment",
                Optional.empty()
        ));
```

## Paypal

This describes how to collect payments via PayPal.

```java
Response flwResponse=new Paypal().runTransaction(new PaypalRequest(
                "John Madakin",
                "Robert K Gagne",
                "1010  Woodrow Way",
                "Lufkin",
                "75904",
                "Texas",
                "US",
                "PayPalv3Test03",
                new BigDecimal("10"),
                "dovedom221@vss6.com",
                "054222234847",
                "USD",
                "154.123.220.1",
                "62wd23423rq324323qew1",
                "15101",
                "Allison park",
                "3563 Huntertown Rd",
                "Pensylvannia",
                "US",
                "http://johnmadakin.com/u/payment-completed",
                Optional.empty()
        ));
```

## Fawrypay

This describes how to collect payments via Fawrypay.

```java
Response flwResponse=new FawryPay().runTransaction(new FawryPayRequest("fawrySample1",
                new BigDecimal("10"),
                "user@flw.com",
                "EGP",
                "09012345678",
                "https://www.flutterwave.com",
                Optional.empty()
        ));
```
