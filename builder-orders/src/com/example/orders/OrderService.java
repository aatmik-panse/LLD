package com.example.orders;

import java.util.List;

public class OrderService {

    public Order createOrder(String id, String email, List<OrderLine> lines, Integer discount, boolean expedited, String notes) {
        Order.Builder builder = Order.builder()
                .id(id)
                .customerEmail(email)
                .discountPercent(discount)
                .expedited(expedited)
                .notes(notes);
        
        if (lines != null) {
            for (OrderLine line : lines) {
                builder.addLine(line);
            }
        }
        
        return builder.build();
    }
}
