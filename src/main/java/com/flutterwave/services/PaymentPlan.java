package com.flutterwave.services;

import com.flutterwave.bean.ListResponse;
import com.flutterwave.bean.PaymentPlanRequest;
import com.flutterwave.bean.Response;
import com.flutterwave.bean.UpdatePaymentPlanRequest;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.PAYMENT_PLAN;
import static com.flutterwave.client.Utility.*;
import static com.flutterwave.utility.Properties.getProperty;

/**
 * Create and manage payment plans.
 * @author Cleopatra Douglas
 */
public class PaymentPlan {

    /**
     * Create a payment plan with Flutterwave.
     * @param paymentPlanRequest bean
     * @return Response
     */
    public Response runCreatePlan(PaymentPlanRequest paymentPlanRequest){
        return Optional.of(post(getProperty("PAYMENT_PLAN_BASE"), paymentPlanRequest.toString(),
                        PAYMENT_PLAN, null))
                .map(Response::toResponse).orElseThrow();
    }

    /**
     * Fetch all payment plans on your account.
     * @return ListResponse
     */
    public ListResponse getPlans(){
        return Optional.of(get(getProperty("PAYMENT_PLAN_BASE"),
                        PAYMENT_PLAN, null))
                .map(ListResponse::toListResponse).orElseThrow();
    }

    /**
     * Get a single payment plan
     * @param id int This is the unique id of the payment plan you want to fetch. It is returned in the call to create a payment plan as data.id
     * @return Response
     */
    public Response getPlan(int id){
        return Optional.of(get(getProperty("PAYMENT_PLAN_BASE")+"/"+id,
                        PAYMENT_PLAN, null))
                .map(Response::toResponse).orElseThrow();
    }

    /**
     * Cancel an existing payment plan.
     * @param id int This is the unique id of the payment plan you want to cancel
     * @return Response
     */
    public Response cancelPlan(int id){
        return Optional.of(put(getProperty("PAYMENT_PLAN_BASE")+"/"+id+"/cancel", null,
                        PAYMENT_PLAN, null))
                .map(Response::toResponse).orElseThrow();
    }

    /**
     * Update an existing payment plan.
     * @param id int This is the unique id of the payment plan you want to fetch. It is returned in the call to create a payment plan as data.id
     * @param UpdatePaymentPlanRequest bean
     * @return Response
     */
    public Response updatePlan(int id, UpdatePaymentPlanRequest UpdatePaymentPlanRequest){
        return Optional.of(put(getProperty("PAYMENT_PLAN_BASE")+"/"+id, UpdatePaymentPlanRequest.toString(),
                        PAYMENT_PLAN, null))
                .map(Response::toResponse).orElseThrow();
    }

}
