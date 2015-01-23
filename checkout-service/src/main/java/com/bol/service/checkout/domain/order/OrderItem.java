package com.bol.service.checkout.domain.order;

import com.bol.service.checkout.domain.deliveryoption.DeliveryOption;
import com.bol.service.checkout.domain.payment.PaymentGroup;
import com.bol.service.checkout.domain.payment.Promotion;
import com.bol.service.checkout.domain.shipping.ShippingGroup;

import java.util.Set;

public class OrderItem {

    private Set<OrderItem> subItems;
    private Promotion promotion;
    private PaymentGroup paymentGroup;
    private DeliveryOption deliveryOption;
    private ShippingGroup shippingGroup;
    private Offer offer;

    public Set<OrderItem> getSubItems() {
        return subItems;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public PaymentGroup getPaymentGroup() {
        return paymentGroup;
    }

    public DeliveryOption getDeliveryOption() {
        return deliveryOption;
    }

    public ShippingGroup getShippingGroup() {
        return shippingGroup;
    }

    public Offer getOffer() {
        return offer;
    }
}
