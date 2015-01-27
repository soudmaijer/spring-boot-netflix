package com.bol.service.giftcard.domain;

import com.bol.service.giftcard.proto.ProtoMessage;
import com.bol.service.giftcard.util.ProtoMapper;
import org.springframework.stereotype.Component;

@Component
public class GiftCardConverter implements ProtoMapper<GiftCard, ProtoMessage.GiftCard> {

    public GiftCard toDomain(ProtoMessage.GiftCard message) {
        return new GiftCard(message.getGiftCardId());
    }

    public ProtoMessage.GiftCard toProtobuf(GiftCard domain) {
        return ProtoMessage.GiftCard.newBuilder().setGiftCardId(domain.getId()).build();
    }

    public boolean supports(Class<?> clazz) {
        return GiftCard.class.isAssignableFrom(clazz) || ProtoMessage.GiftCard.class.isAssignableFrom(clazz);
    }
}