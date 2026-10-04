package com.rescop.service;
import com.rescop.model.OrderItem;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;
@Service
public class OperationsService {
  private final List<OrderItem> orders = new ArrayList<>(List.of(
    new OrderItem("ORD-1042","Northstar Components","Bengaluru","IN_TRANSIT",420,"2026-11-02",18200),
    new OrderItem("ORD-1043","BluePeak Packaging","Hyderabad","PROCESSING",180,"2026-11-03",7600),
    new OrderItem("ORD-1044","Aster Industrial Supply","Chennai","DELAYED",95,"2026-10-30",12400),
    new OrderItem("ORD-1045","Northstar Components","Pune","DELIVERED",310,"2026-10-27",15300),
    new OrderItem("ORD-1046","Cedar Freight Partners","Mumbai","IN_TRANSIT",265,"2026-11-01",9900),
    new OrderItem("ORD-1047","BluePeak Packaging","Delhi","PROCESSING",145,"2026-11-05",6100),
    new OrderItem("ORD-1048","Aster Industrial Supply","Kochi","DELAYED",72,"2026-10-29",8700)
  ));
  public Map<String,Object> summary() {
    Map<String,Long> byStatus = orders.stream().collect(Collectors.groupingBy(OrderItem::status, Collectors.counting()));
    int parcels = orders.stream().mapToInt(OrderItem::parcels).sum();
    double value = orders.stream().mapToDouble(OrderItem::value).sum();
    return Map.of("totalOrders", orders.size(), "totalParcels", parcels, "openOrders", orders.stream().filter(o -> !o.status().equals("DELIVERED")).count(), "delayedOrders", byStatus.getOrDefault("DELAYED",0L), "orderValue", value, "byStatus", byStatus);
  }
  public List<OrderItem> orders(String status, String search) {
    return orders.stream().filter(o -> status == null || status.isBlank() || o.status().equalsIgnoreCase(status))
      .filter(o -> search == null || search.isBlank() || (o.id()+" "+o.supplier()+" "+o.destination()).toLowerCase().contains(search.toLowerCase()))
      .toList();
  }
}
