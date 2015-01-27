package com.bol.service.giftcard.controller;

import com.bol.service.giftcard.GiftCardService;
import com.bol.service.giftcard.proto.ProtoMessage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GiftCardController implements GiftCardService {

    @Override
    public ProtoMessage.GiftCards getGiftCard(@PathVariable("gift_card_id") String giftCardId) {
        ProtoMessage.GiftCard build = ProtoMessage.GiftCard.newBuilder().setGiftCardId(giftCardId).build();
        return ProtoMessage.GiftCards.newBuilder().addGiftCard(build).build();
    }
}