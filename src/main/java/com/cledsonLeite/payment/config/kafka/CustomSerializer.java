package com.cledsonLeite.payment.config.kafka;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import com.cledsonLeite.payment.adapter.out.message.SaleMessage;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomSerializer implements Serializer<SaleMessage> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String string, SaleMessage saleMessage) {
        try {
            if (saleMessage == null){
                return null;
            }
            return objectMapper.writeValueAsBytes(saleMessage);
        } catch (Exception error) {
            throw new SerializationException("Erro ao serializar SaleMessage para byte[]");
        }
    }


}
