package com.bol.service.checkout.giftcard;


import com.bol.service.giftcard.GiftCardService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GiftCardServiceClient {

    private final GiftCardService giftCardService;

    @Autowired
    public GiftCardServiceClient(GiftCardService giftCardService) {
        this.giftCardService = giftCardService;
    }

    @HystrixCommand(fallbackMethod = "getGiftCardFallback")
    public com.bol.service.giftcard.proto.ProtoMessage.GiftCard getGiftCard(String orderCandidateId) {
        return giftCardService.getGiftCard(orderCandidateId);
    }

    public com.bol.service.giftcard.proto.ProtoMessage.GiftCard getGiftCardFallback(String orderCandidateId) {
        System.err.println("getGiftCardFallback fallback fired!");
        return null;
    }
}
