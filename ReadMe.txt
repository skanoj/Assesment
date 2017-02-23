The campaign management assignment, with 4 different end points.
This is a spring boot application, can run on its own, with embedded Tomcat instance.
No deployment required for this application.

The application base URI is http://localhost:8080/


The application is a .jar file which could be executed at command prompt as 

> java -jar 

The API calls are as below:

1> Create an Ad campaign via HTTP POST

URI : http://localhost:8080/ad

payload sample:

{
"partnerId": 726,
"duration": 2000,
"adContent": "Mobile sale - buy one and get one"
}


2> Get only one active campaign for a partner  HTTP GET method

URI:  http://localhost:8080/ad/{Partner_id}



3> Get all the campaigns in the system.  HTTP GET method

URI:  http://localhost:8080/ad/campaign/all


4> Get all the campaigns for a partner.  HTTP GET method


URI:  http://localhost:8080/ad/campaign/{partner_id}


