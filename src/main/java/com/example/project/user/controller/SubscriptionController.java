package com.example.project.user.controller;

import com.example.project.user.model.Subscription;
import com.example.project.user.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<?> createSubscription(@RequestBody Subscription subscription) {
        subscriptionService.createSubscription(subscription);
        return ResponseEntity.ok("서비스 구독 완료");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subscription> getSubscription(@PathVariable Long id) {
        Subscription subscription = subscriptionService.getSubscriptionById(id);
        return ResponseEntity.ok(subscription);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSubscription(@PathVariable Long id, @RequestBody Subscription subscription) {
        subscriptionService.updateSubscription(id, subscription);
        return ResponseEntity.ok("서비스 기간 연장 완료");
    }
}
