package com.ostk.poc.controller;

import com.ostk.poc.model.Shipping;
import com.ostk.poc.repository.ShippingInfoRepository;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.Operation;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trackingInfo")
@Tag(name = "Tracking Api", description = "The Ostk Shipping Tracking API")
public class MainController {
  @Autowired
  private ShippingInfoRepository shippingInfoRepository;

  /**
   * Get shipping info list by trackingId
   * @param trackingId
   * @return shipping info list
   */
  @Operation(summary = "Get Shipping Tracking Info by TrackingId", description = "Returns the shipping info")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "successful operation",
                  content = @Content(array = @ArraySchema(schema = @Schema(implementation = Shipping.class)))) })
  @GetMapping("/tracking/{trackingId}")
  public List<Shipping> getShipingInfosByTrackingId(@PathVariable String trackingId) {
    return shippingInfoRepository.findAllByTrackingId(trackingId);
  }


  /**
   * Get shipping info list by orderId
   * @param orderId
   * @return shipping info list
   */
  @Operation(summary = "Get Shipping Tracking Info by OrderId", description = "Returns the shipping info")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "successful operation",
                  content = @Content(array = @ArraySchema(schema = @Schema(implementation = Shipping.class)))) })
  @GetMapping("/order/{orderId}")
  public List<Shipping> getShippingInfosByOrderId(@PathVariable String orderId) {
    return shippingInfoRepository.findAllByOrderId(orderId);
  }
}
