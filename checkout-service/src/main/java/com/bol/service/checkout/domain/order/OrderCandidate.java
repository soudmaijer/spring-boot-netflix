package com.bol.service.checkout.domain.order;

import com.bol.service.checkout.domain.address.BillingAddress;
import com.bol.service.checkout.domain.payment.PaymentGroup;
import com.bol.service.checkout.domain.payment.Promotion;
import com.bol.service.giftcard.proto.ProtoMessage;

import java.util.List;
import java.util.Set;

public class OrderCandidate {

    private String orderId;
    private Set<OrderItem> orderItems;
    private Set<Promotion> promotions;
    private Set<PaymentGroup> paymentGroups;
    private BillingAddress billingAddress;
    private List<ProtoMessage.GiftCard> giftCards;

    public OrderCandidate(String orderId) {
        this.orderId = orderId;
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

    public void setGiftCards(List<ProtoMessage.GiftCard> giftCards) {
        this.giftCards = giftCards;
    }

    public List<ProtoMessage.GiftCard> getGiftCards() {
        return giftCards;
    }

    public String getOrderId() {
        return orderId;
    }
}
