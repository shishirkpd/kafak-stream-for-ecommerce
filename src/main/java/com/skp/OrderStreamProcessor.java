package com.skp;

import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@EnableKafkaStreams
@Configuration
public class OrderStreamProcessor {

    @Bean
    public KStream<String, String> kStream(StreamsBuilder streamsBuilder) {
        KStream<String, String> orderStream = streamsBuilder.stream("orders");
        // Process Orders Stream
        orderStream
            .peek((key, value) -> System.out.println("Received Order: " + value))
            .mapValues(this::processOrder)
            .to("processed-orders");
        // Update Inventory
        orderStream
            .peek((key, value) -> updateInventory(value))
            .to("inventory-updated");
        // Send Notifications
        orderStream
            .peek((key, value) -> sendNotification(value))
            .to("notifications");
        return orderStream;
    }
    private String processOrder(String order) {
        // Simulate processing order
        return order + " [Processed]";
    }
    private void updateInventory(String order) {
        // Simulate inventory update
        System.out.println("Inventory updated for order: " + order);
    }
    private void sendNotification(String order) {
        // Simulate sending notification
        System.out.println("Notification sent for order: " + order);
    }
}