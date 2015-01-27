package com.bol.service.checkout.domain.mapper;

import com.bol.service.checkout.domain.order.OrderCandidate;
import com.bol.service.checkout.proto.ProtoMessage;
import com.bol.service.checkout.util.ProtoMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderCandidateProtoMapper implements ProtoMapper<OrderCandidate, ProtoMessage.OrderCandidate> {

    public OrderCandidate toDomain(ProtoMessage.OrderCandidate message) {
        return new OrderCandidate(message.getOrderId());
    }

    public ProtoMessage.OrderCandidate toProto(OrderCandidate domain) {
        ProtoMessage.OrderCandidate.Builder builder = ProtoMessage.OrderCandidate.newBuilder();
        builder.setOrderId(domain.getOrderId());
        if (domain.getGiftCards() != null) {
            for (com.bol.service.giftcard.proto.ProtoMessage.GiftCard giftCard : domain.getGiftCards()) {
                builder.setGiftcard(ProtoMessage.GiftCard.newBuilder().setGiftCardId(giftCard.getGiftCardId()));
            }
        }
        return builder.build();
    }

    public boolean supports(Class<?> clazz) {
        return OrderCandidate.class.isAssignableFrom(clazz) || ProtoMessage.OrderCandidate.class.isAssignableFrom(clazz);
    }
}