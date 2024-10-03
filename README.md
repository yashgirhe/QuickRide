# QuickRide - Ride booking application
QuickRide is an online ride booking application that allows users to seamlessly book rides to their destinations. Whether you are a rider who wants to book a ride or you are a driver 
looking for customers, the platform is open for all.
It saves your time to manually search for the cab and provides optimal ride fare for you.

## Key Features:
* Multi-user support: You can be the application user both as a rider as well as driver(either at given time).
* Request ride: Byproviding pick-up and drop off location rider can request for a ride.
* Cancel ride: If the ride has not started yet rider can still cancel the ride.
* Request for driver: Rider can request to become a driver.
* Payment: Currently the application hold 2 payment methods that are cash and wallet and the rider can choose any of those.

## Technologies Used:
* Back-End: Java, Spring Boot, Spring Security, Spring Data JPA
* Database: PostgreSQL with PostGIS support
* Authentication: JWT, Spring Security

## UML Diagram
![uber_ER](https://github.com/user-attachments/assets/60789dee-6c4c-4e0e-b96a-67c5e0823152)

## APIs

### Rider endpoints
* /riders/requestRide - Rider can request for a new ride by passing pickup location, drop location and payment method.
* /riders/cancelRide/{rideId} - Rider can cancel ride unless the ride status is ongoing.
* /riders/rateDriver - Rider can rate the driver after the ride.
* /riders/getMyProfile - Rider can get his/her profile details.
* /riders/getMyRides - Rider can get all his/her attended rides.

### Driver endpoints
* /drivers/acceptRide/{rideRequestId} - Driver can accept the ride.
* /drivers/startRide/{rideRequestId} - Driver can start the ride.
* /drivers/cancelRide/{rideId} - Driver can cancel ride unless the ride status is ongoing.
* /drivers/rateRider - Driver can rate the driver after the ride.
* /drivers/getMyRides - Driver can get all his/her attended rides.
* /drivers/getMyProfile - Driver can get his/her profile details.

### Authentication endpoints
* /auth/signup - New user can sign up.
* /auth/login - Driver can start the ride.
* /auth/onBoardNewDriver/{userId} - Admin can onboard a new driver if the user make a request.
* /auth/refresh - Refresh the access token if it expires.
