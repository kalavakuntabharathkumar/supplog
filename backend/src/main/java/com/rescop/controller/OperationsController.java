package com.rescop.controller;
import com.rescop.model.OrderItem;
import com.rescop.service.OperationsService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/operations")
@CrossOrigin(origins = "*")
public class OperationsController {
  private final OperationsService service;
  public OperationsController(OperationsService service) { this.service = service; }
  @GetMapping("/summary") public Map<String,Object> summary() { return service.summary(); }
  @GetMapping("/orders") public List<OrderItem> orders(@RequestParam(required=false) String status, @RequestParam(required=false) String search) { return service.orders(status, search); }
}
