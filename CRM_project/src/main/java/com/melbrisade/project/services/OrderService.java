package com.melbrisade.project.services;

import com.melbrisade.project.dtos.OrderGetDto;
import com.melbrisade.project.dtos.OrderPostDto;
import com.melbrisade.project.entities.OrderEntities;
import com.melbrisade.project.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public OrderGetDto createOrder(OrderPostDto orderPostDto) {
        OrderEntities orderEntities= this.mapPostDtoToEntity(orderPostDto);
        OrderEntities saveOrderEntities = orderRepository.save(orderEntities);

        OrderGetDto orderGetDto = this.mapEntityToGetDto(saveOrderEntities);

        return orderGetDto;
    }

    private OrderEntities mapPostDtoToEntity(OrderPostDto orderPostDto) {
        OrderEntities orderEntities = new OrderEntities();
        orderEntities.setPromotion(orderPostDto.getPromotion());
        orderEntities.setDiscount(orderPostDto.getDiscount());
        return orderEntities;
    }

    private OrderGetDto mapEntityToGetDto(OrderEntities orderEntities){
        OrderGetDto orderGetDto = new OrderGetDto();
        orderGetDto.setPromotion(orderEntities.getPromotion());
        orderGetDto.setDiscount(orderEntities.getDiscount());
        return orderGetDto;
    }
}
