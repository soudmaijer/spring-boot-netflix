package com.bol.service.checkout;

import com.bol.service.checkout.proto.ProtoMessage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Define all the endpoint mappings on the Interface so we can use the FeignClient builder.
 */
@RestController
public interface CheckoutService {

    @RequestMapping(value = "/checkout/{order_candidate_id}", method = RequestMethod.GET)
    ProtoMessage.OrderCandidate getOrderCandidate(@PathVariable("order_candidate_id") String orderCandidateId);
}
