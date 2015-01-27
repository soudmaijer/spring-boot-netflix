package com.bol.service.checkout.controller;


import com.bol.service.checkout.CheckoutService;
import com.bol.service.checkout.giftcard.GiftCardServiceClient;
import com.bol.service.checkout.domain.mapper.ProtoMapperFactory;
import com.bol.service.checkout.domain.order.OrderCandidate;
import com.bol.service.checkout.proto.ProtoMessage;
import com.bol.service.giftcard.proto.ProtoMessage.GiftCard;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Arrays;

@RestController
public class CheckoutController implements CheckoutService {

    private final GiftCardServiceClient giftCardService;
    private final ProtoMapperFactory mapperFactory;

    @Inject
    public CheckoutController(final GiftCardServiceClient giftCardService, ProtoMapperFactory mapperFactory) {
        this.giftCardService = giftCardService;
        this.mapperFactory = mapperFactory;
    }

    @Override
    public ProtoMessage.OrderCandidate getOrderCandidate(@PathVariable("order_candidate_id") String orderCandidateId) {
        OrderCandidate orderCandidate = new OrderCandidate(orderCandidateId);
        GiftCard giftCard = giftCardService.getGiftCard(orderCandidateId);
        if (giftCard != null) {
            orderCandidate.setGiftCards(Arrays.asList(giftCard));
        }
        return mapperFactory.toProto(orderCandidate);
    }
}