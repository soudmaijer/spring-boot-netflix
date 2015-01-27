package com.bol.service.giftcard.util;

import com.google.protobuf.Message;

/**
 * Interface to be implemented by Mapper implementations.
 *
 * @param <D> Domain Object type
 * @param <P> Protobuf Message type
 */
public interface ProtoMapper<D, P extends Message> {

    /**
     * If the Mapper supports a given Domain or proto Message.
     * @param clazz the type to be converted
     * @return true if supported, otherwise false
     */
    boolean supports(Class<?> clazz);

    /**
     * Convert a given protobuf Message to the domain object of type D
     * @param message protobuf Message
     * @return a newly constructed domain object
     */
    D toDomain(P message);


    /**
     * Convert a given domain Object to the protobuf Message of type P
     * @param domain the domain Object
     * @return a newly constructed proto Message object
     */
    P toProtobuf(D domain);
}