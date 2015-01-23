package com.bol.service.giftcard;

import com.bol.service.giftcard.proto.ProtoMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(value = "giftcard", loadbalance = true)
@RestController
public interface GiftCardService {

    @RequestMapping(value="/giftcard/{gift_card_id}", method = RequestMethod.GET)
    public ProtoMessage.GiftCard getGiftCard(@PathVariable("gift_card_id") String giftCardId);
}