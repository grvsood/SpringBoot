### Gettting started:

This package is a Spring boot application which interacts with local MySQL server

Steps to start: Mac => 

1) Install MySql 
```brew install mysql```
2) Start MySql Server ```brew services start mysql```
3) Login Using root user ```sudo mysql --password```
4) Create a database parkings ```create database parkings```
5) Build the spring boot application in Intellij
6) Start the application in Intellij

## Opertations: Using PostMan to test the application

Admin Controllers => 
   1) Add Parking Spot http://localhost:8080/admin/add/parkingspot
      1) Request Type Post
      2) Sample Request Body ```{
         "parkingSpot": {
         "parkingId": "34",
         "area": "checking",
         "pinCode": "123456",
         "latitude": "123.45",
         "longitude": "134.45"
         }
         }```

For other Operations, and the urls refer `AdminController` and `UserController` files.

## Spring boot have CRUDRespositories to interact with mySql servcer.
Refer Repositories dir for available repos.
