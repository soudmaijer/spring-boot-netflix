package com.bol.service.checkout.domain.order;

import com.bol.service.checkout.domain.address.BillingAddress;
import com.bol.service.checkout.domain.payment.PaymentGroup;
import com.bol.service.checkout.domain.payment.Promotion;

import java.util.Set;

public class OrderCandidate {

    private Long id;
    private Set<OrderItem> orderItems;
    private Set<Promotion> promotions;
    private Set<PaymentGroup> paymentGroups;
    private BillingAddress billingAddress;

    public OrderCandidate(Long id) {
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Set<Promotion> getPromotions() {
        return promotions;
    }

    public Set<PaymentGroup> getPaymentGroups() {
        return paymentGroups;
    }
}
