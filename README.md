# -wretched-room-300

<h1 align="center" >BILLPAY :- Electricity Bill Payment System</h1>
<!-- <div align="center"><img src="https://github.com/abdulrashid06/shy-exchange-4248/assets/115461514/43ac6db6-a630-424e-af13-b2e5d886e0fd"></div> -->
<!-- ![BillPay](https://github.com/abdulrashid06/shy-exchange-4248/assets/115461514/c279eb49-98fb-4ce6-b43e-e3ec5e92bf36) -->


## Introduction

<p>BILLPAY :- Electricity Bill Payment System (EBPS) is a software which is used to provide a payment service to consumers so that they pay all their pending bills comfortably from home.</p>
<p>With the help of this software user can pay the bill, can see his all transactions, can also file complaints regarding the issues he is facing.</p>
<br>

## Key Features

<h4>Admin<h4>
<ul type="square">
    <li>Admin Login</li>
    <li>View All Consumers</li>
    <li>View the bill of the consumer by there Id</li>
    <li>View all the bills</li>
    <li>View all paid bills</li>
    <li>View all pending bills</li>
    <li>Delete Consumer</li>
    <li>Generate Consumers Bill</li>
    <li>Resolve Consumers Complaints</li>
</ul>
<h4>Consumer<h4>
<ul type="square">
    <li>Consumer Login</li>
    <li>Consumer Registration</li>
    <li>Consumer Forget Password</li>
    <li>To Pay Bills</li>
    <li>To View transaction history</li>
    <li>To File a Complaint</li>
</ul>
    
<br>
  
  ## Entity Classes

- Admin
- Consumer
- Bill
- Transaction
- Complaint

<br>
  
  ## Association Mapping

- One-to-many relationship between Consumer and Bill.
- One-to-many relationship between Consumer and Transaction.
- One-to-many relationship between Consumer and Complaint.
- Many-to-One relationship between Bill and Consumer.
- Many-to-One relationship between Transaction and Consumer.
- Many-to-One relationship between Complaint and Consumer.

<br>

## FLOW CHART
    
![FLOW-CHART](https://user-images.githubusercontent.com/111189783/229370551-5766affc-e9be-4efa-a5f1-f0f4983c8d9a.png)

<br>
    
## Technology & Tools used

- JAVA
- MySQL
- Hibernate
- STS
- Git
- Github

<br>
  
  ## Requirments

- ava 8 or higher
- MySQL database


<br>

## Installation

- Clone the repository using the command git clone https://github.com/yourusername/ElectricityBillPaymentSystem.git
- Import the project into Eclipse or IntelliJ as a Maven project.
- Create a MySQL database named electricitybillpayment.
- Run the project to access the application.


<br>

## ER Diagram
    
![ER-Diagram](https://user-images.githubusercontent.com/111189783/229363814-3af95128-cce3-40d5-a057-b9b3f6988bae.png)

<br>
        
## Feedback
Your valuable feedback is really appreciated. You can reach out to me via below platforms and share your feedbacks with me.

[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://abdulrashid.github.io/)

<!-- [![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/clrsurya11/) -->

<!-- [![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/clrsurya11) -->
    
    
## Authors

- [abdulrashid06](https://github.com/abdulrashid06)

## Acknowledgements

- [Masai School](https://www.masaischool.com/)
