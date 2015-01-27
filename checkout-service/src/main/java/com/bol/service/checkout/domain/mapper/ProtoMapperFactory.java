package com.bol.service.checkout.domain.mapper;

import com.bol.service.checkout.util.ProtoMapper;
import com.google.protobuf.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProtoMapperFactory {

    private final List<ProtoMapper> protoMapperList;

    @Autowired
    public ProtoMapperFactory(List<ProtoMapper> protoMapperList) {
        this.protoMapperList = protoMapperList;
    }

    public <T extends Message> T toProto(Object domain) {
        ProtoMapper mapper = getProtoMapperForType(domain.getClass());
        if (mapper == null) {
            return null;
        }
        return (T)getProtoMapperForType(domain.getClass()).toProto(domain);
    }

    private ProtoMapper getProtoMapperForType(Class clazz) {
        if (protoMapperList != null) {
            for (ProtoMapper mapper : protoMapperList) {
                if (mapper.supports(clazz)) {
                    return mapper;
                }
            }
        }
        return null;
    }
}
