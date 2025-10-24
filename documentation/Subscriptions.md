<p align="center">
    <img title="Flutterwave" height="200" src="https://flutterwave.com/images/logo/full.svg" width="50%"/>
</p>

# Subscriptions

We recommend reading the main README first to understand the requirements for using the library and how to integrate it into your application. This guide assumes you've read that.


##  Get all subscriptions


This describes how to get all subscriptions.

```java
ListResponse flwResponse = new Subscriptions()
        .getAllSubscriptions();
```

##  Activate a Subscription

This describes how to activate a subscription.

```java
Response flwResponse = new Subscriptions().
        activateSubscription(id);
```

##  Deactivate a Subscription

This describes how to deactivate a subscription.

```java
Response flwResponse = new Subscriptions().
        deactivateSubscription(id);
```
