package com.melbrisade.project.controllers;

import com.melbrisade.project.dtos.OrderGetDto;
import com.melbrisade.project.dtos.OrderPostDto;
import com.melbrisade.project.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderGetDto> createOrder(@RequestBody OrderPostDto orderPostDto) {

        OrderGetDto orderGetDto = orderService.createOrder(orderPostDto);



        return ResponseEntity.ok(orderGetDto);
    }
}
