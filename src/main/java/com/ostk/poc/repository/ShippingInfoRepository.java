package com.ostk.poc.repository;

import com.ostk.poc.model.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShippingInfoRepository extends JpaRepository<Shipping, Long> {

    @Query("select s from Shipping s where s.trackingId = :trackingId")
    List<Shipping> findAllByTrackingId(@Param("trackingId") String trackingId);

    @Query("select s from Shipping s where s.orderId = :orderId")
    List<Shipping> findAllByOrderId(@Param("orderId") String orderId);
}
