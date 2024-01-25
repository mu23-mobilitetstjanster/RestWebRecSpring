package com.example.restwebrecspring.controller;

import com.example.restwebrecspring.model.Payment;
import com.example.restwebrecspring.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

  @Autowired
  private PaymentService paymentService;

  @GetMapping("/greeting")
  public String greeting() {
    return "Hey batman";
  }

  @GetMapping("/")
  public ResponseEntity<List<Payment>> findPayments() {
    List<Payment> payments = paymentService.findAll();

    if(payments.isEmpty()) {
      return ResponseEntity.status(204).body(payments);
    } else {
      return ResponseEntity.status(200).body(payments);
    }
  }

  @GetMapping("/{index}")
  public ResponseEntity<Payment> findPayment(@PathVariable int index) {
    Payment payment = paymentService.findById(index);

    if(payment == null) {
      return ResponseEntity.status(204).build();
    } else {
      return ResponseEntity.status(200).body(payment);
    }
  }

  @DeleteMapping("/{index}")
  public ResponseEntity<String> deletePayment(@PathVariable int index) {
    paymentService.remove(index);

    return ResponseEntity.ok("Object removed");
  }


  @PostMapping("/")
  public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
    if(payment.getTitle() == null) {
      return ResponseEntity.status(400).body(payment);
    }

    paymentService.create(payment);
    return ResponseEntity.status(201).body(payment);
  }
}
