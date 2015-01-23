package com.bol.service.giftcard.controller;

import com.bol.service.giftcard.GiftCardService;
import com.bol.service.giftcard.proto.ProtoMessage;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GiftCardController implements GiftCardService {

    @Override
    @HystrixCommand(fallbackMethod = "getGiftCardFallback" )
    public ProtoMessage.GiftCards getGiftCard(String giftCardId) {
        ProtoMessage.GiftCard build = ProtoMessage.GiftCard.newBuilder().setGiftCardId(giftCardId).build();
        return ProtoMessage.GiftCards.newBuilder().addGiftCard(build).build();
        // v2
        // return ProtoMessage.GiftCard.newBuilder().setGiftCardId(giftCardId).setCampaignName("toet").build();
    }

    public ProtoMessage.GiftCard getGiftCardFallback(String giftCardId) {
        return null;
    }
}