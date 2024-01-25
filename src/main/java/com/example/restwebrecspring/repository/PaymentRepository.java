package com.example.restwebrecspring.repository;

import com.example.restwebrecspring.model.Payment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository {

  private List<Payment> payments = new ArrayList<>() {{
      add(new Payment("Apple", 20));
      add(new Payment("Egg", 3));
      add(new Payment("Orange", 5));
      add(new Payment("Oats", 15));
  }};

  public List<Payment> findAll() {
    return payments;
  }

  public Payment findById(int index) {
    if(index > payments.size() - 1) {
      return null;
    }

    return payments.get(index);
  }

  public void remove(int index) {
    if(index < payments.size()) {
      payments.remove(index);
    }
  }

  public void replace(int index, Payment payment) {
    payments.set(index, payment);
  }

  public void create(Payment payment) {
    payments.add(payment);
  }

}
