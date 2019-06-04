# Hotel Booking System

## Demo

![overview gif](https://github.com/jtrinh21/HotelBookingSystem/blob/master/src/Image/hotelBookingSystem.gif)

## Overview

A software is built in desktop environment for supervisor-side to manage the booking system for small-hotel businesses.

## Set-up

* *Xampp*: PHP developer environment [download](https://www.apachefriends.org/index.html)

![SetUpXampp](https://github.com/jtrinh21/HotelBookingSystem/blob/master/build/classes/Image/SetupXampp.gif)

* *JDBC*: add libraries into the project (watch gif below)

![SetUpJDBC](https://github.com/jtrinh21/HotelBookingSystem/blob/master/build/classes/Image/SetUpJDBC.gif)

## Features


*	Load existed customers’ information from CSV file into the database by adopting Object-oriented design.
*	Secure login credentials using the phpMyAdmin administration tool.
*	Display information with a selected profile picture, allow to change.
*  Capture profile picture using webcam.
*	Assign each booking a unique reservation ID and search for information using the assigned reservation ID.
*	Avoid double-booking the same room at the same time period.
*	Update and delete customers’ booking information as needed.


## Explore

#### Login Frame

   - Comparing the username and password the user inputs, the system pulls information from a database using phpMyAdmin administration tool.
   - Notify the user if the username or password is incorrect.
   - Display the information of the user including private background information and profile picture.
   - Depend on who logging in, the information and image are different.
   
![login gif](https://github.com/jtrinh21/HotelBookingSystem/blob/master/src/Image/LoginFeature.gif)

#### Take a picture and Choose profile picture features

   - Capture profile picture using webcam.
   - Allow the users to change the profile picture.
   
![takapic gif](https://github.com/jtrinh21/HotelBookingSystem/blob/master/src/Image/TakeAPic.gif)
   
## Coming Soon
* Real-time computer vision to take profile picture.
* Face ID to login.
