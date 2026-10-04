package com.rescop.model;
public record OrderItem(String id, String supplier, String destination, String status, int parcels, String expectedDate, double value) {}
