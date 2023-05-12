package com.example.springmicroservice.orderservice.mapper;

import com.example.springmicroservice.orderservice.dto.OrderLineItemsDto;
import com.example.springmicroservice.orderservice.model.OrderLineItems;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderLineItems mapToOrderLineItems(OrderLineItemsDto orderLineItemsDto);
}
