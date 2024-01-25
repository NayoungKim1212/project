package com.example.project.user.mapper;

import com.example.project.user.model.Subscription;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubscriptionMapper {
    void insertSubscription(Subscription subscription);
    Subscription getSubscriptionById(Long id);
    void updateSubscription(Subscription subscription);

}
