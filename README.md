# Hotel Booking System

## Overview
A software is built in desktop environment for supervisor-side to manage the booking system for small-hotel businesses.

![overview gif](https://github.com/jtrinh21/HotelBookingSystem/blob/master/src/Image/hotelBookingSystem.gif)

## Set-up

* *Xampp*: PHP developer environment [download](https://www.apachefriends.org/index.html)

![SetUpXampp](https://github.com/jtrinh21/HotelBookingSystem/blob/master/build/classes/Image/SetupXampp.gif)

* *JDBC*: add libraries into the project (watch gif below)

![SetUpJDBC](https://github.com/jtrinh21/HotelBookingSystem/blob/master/build/classes/Image/SetUpJDBC.gif)

## Features


*	Verify the users using the login page by comparing the username and password stored in phpMyAdmin.
*	Display the users’ information with a selected profile picture, allow the users to change the profile picture as they wish.
*	Load existed customers’ information from CSV file into the database by adopting Object-oriented design.
*	Assign each customer a unique reservation ID and search for customers’ information using their assigned reservation ID.
*	Avoid double-booking the same room at the same time period.
*	Update and delete customers’ booking information as needed.



## Explore

1. Login Frame

   - Comparing the username and password the user inputs, the system pulls information from a database using phpMyAdmin administration tool.
   - Notify the user if the username or password is incorrect.
   - Display the information of the user including private background information and profile picture.
   - Depend on who logging in, the information and image are different.
   
![login gif](https://github.com/jtrinh21/HotelBookingSystem/blob/master/src/Image/LoginFeature.gif)

## New Features

1. Capture profile picture using webcame.
2. Face ID to login (comming soon)
