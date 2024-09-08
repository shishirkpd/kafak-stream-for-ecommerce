package com.skp;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    private String orderId;
    private String product;
    private int quantity;
    private double price;
}