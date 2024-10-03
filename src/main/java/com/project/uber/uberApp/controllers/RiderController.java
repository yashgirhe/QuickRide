package com.project.uber.uberApp.controllers;

import com.project.uber.uberApp.dto.*;
import com.project.uber.uberApp.services.RiderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/riders")
@Secured("ROLE_RIDER")
@Tag(name = "Rider APIs")
public class RiderController {

    private final RiderService riderService;

    @Operation(
            summary = "Request a new ride"
    )
    @PostMapping("/requestRide")
    public ResponseEntity<RideRequestDto> requestRide(@RequestBody RideRequestDto rideRequestDto){
        return ResponseEntity.ok(riderService.requestRide(rideRequestDto));
    }

    @Operation(
            summary = "Cancel the ride by rider"
    )
    @PostMapping("/cancelRide/{rideId}")
    public ResponseEntity<RideDto> cancelRide(@PathVariable Long rideId){
        return ResponseEntity.ok(riderService.cancelRide(rideId));
    }

    @Operation(
            summary = "Rate the driver"
    )
    @PostMapping("/rateDriver")
    public ResponseEntity<DriverDto> rateDriver(@RequestBody RatingDto ratingDto){
        return ResponseEntity.ok(riderService.rateDriver(ratingDto.getRideId(), ratingDto.getRating()));
    }

    @Operation(
            summary = "Get rider profile"
    )
    @GetMapping("/getMyProfile")
    public ResponseEntity<RiderDto> getMyProfile(){
        return ResponseEntity.ok(riderService.getMyProfile());
    }

    @Operation(
            summary = "Get all rides of rider"
    )
    @GetMapping("/getMyRides")
    public ResponseEntity<Page<RideDto>> getAllMyRides(@RequestParam(defaultValue = "0") Integer pageOffset,
                                                       @RequestParam(defaultValue = "10", required = false) Integer pageSize){
        PageRequest pageRequest = PageRequest.of(pageOffset, pageSize,
                Sort.by(Sort.Direction.DESC, "createdTime", "id"));
        return ResponseEntity.ok(riderService.getAllMyRides(pageRequest));
    }
}
