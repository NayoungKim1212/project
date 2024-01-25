package com.example.project.user.service;

import com.example.project.user.entity.Subscription;
import com.example.project.user.mapper.SubscriptionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionMapper subscriptionMapper;

    public void createSubscription(Subscription subscription) {
        subscriptionMapper.insertSubscription(subscription);
    }

    public Subscription getSubscriptionById(Long id) {
        return subscriptionMapper.getSubscriptionById(id);
    }

    public void updateSubscription(Long id, Subscription updatedData) {

        Subscription existingSubscription = subscriptionMapper.getSubscriptionById(id);

        if (existingSubscription == null) {
            throw new IllegalArgumentException("id를 찾을 수 없습니다. " + id);
        }

        Subscription updatedSubscription = existingSubscription.updateWith(updatedData);
        subscriptionMapper.updateSubscription(updatedSubscription);
    }

}
