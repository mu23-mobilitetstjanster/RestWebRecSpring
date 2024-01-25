package com.example.restwebrecspring.service;

import com.example.restwebrecspring.model.Payment;
import com.example.restwebrecspring.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

  @Autowired
  private PaymentRepository paymentRepository;

  public List<Payment> findAll() {
    return paymentRepository.findAll();
  }

  public Payment findById(int index) {
    return paymentRepository.findById(index);
  }

  public void remove(int index) {
    paymentRepository.remove(index);
  }

  public void replace(int index, Payment payment) {
    paymentRepository.replace(index, payment);
  }

  public void create(Payment payment) {
    paymentRepository.create(payment);
  }
}
