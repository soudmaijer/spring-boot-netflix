package com.bol.service.checkout.controller;


import com.bol.service.checkout.proto.ProtoMessage;
import com.bol.service.giftcard.GiftCardService;
import com.bol.service.giftcard.proto.ProtoMessage.GiftCard;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class CheckoutController {

    private final GiftCardService giftCardService;

    @Inject
    public CheckoutController(final GiftCardService giftCardService) {
        this.giftCardService = giftCardService;
    }

    @RequestMapping(value = "/checkout/{order_candidate_id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "getOrderCandidateFallback")
    public ProtoMessage.OrderCandidate getOrderCandidate(@PathVariable("order_candidate_id") String orderCandidateId) {
        GiftCard giftCard = giftCardService.getGiftCard(orderCandidateId);

        return ProtoMessage.OrderCandidate.newBuilder()
                .setOrderId(orderCandidateId)
                .setGiftcard(ProtoMessage.GiftCard.newBuilder().setGiftCardId(giftCard.getGiftCardId()))
                .build();
    }

    public ProtoMessage.OrderCandidate getOrderCandidateFallback(String orderCandidateId) {
        System.err.println("getOrderCandidateFallback failed.");
        return ProtoMessage.OrderCandidate.newBuilder().setOrderId(orderCandidateId).build();
    }
}