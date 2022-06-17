<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medicare Dashboard</title>
<link rel="stylesheet" href="css/bootstrap.css">
<script src="js/jquery-3.4.1.js"></script>
<script src="js/bootstrap.js"></script>
<style>
body{
background-image:url(images/bg2.jpg);
background-size:100% 100%;
min-height:100vh;
}
</style>
</head>
<body>
<h5 class="float-left m-2">Role : ${sessionScope.role }</h5>
<h5 class="float-right m-2">Welcome ${sessionScope.uname }</h5>
<div class="jumbotron p-5 bg-transparent text-center mb-0 rounded-0 border-bottom">
	<h5>Welcome to Medicare Billing System Portal</h5>
</div>
<div class="container-fluid">
<div class="row">
	<div class="col-sm-2 p-0">
		<div class="list-group">
		<c:if test="${sessionScope.role =='Admin' }">
		
		  <a href="/frontdesks" class="list-group-item list-group-item-action">Front Desk Staff</a>
		  <a href="/viewtickets" class="list-group-item list-group-item-action">View tickets</a>
		   <a href="/viewreviews" class="list-group-item list-group-item-action">View reviews</a>
		 
	    </c:if>
	    <c:if test="${sessionScope.role =='FrontDesk' }">
		  <a href="/patientregbyfd" class="list-group-item list-group-item-action">Patient Registration</a>	
		  <a href="/patientbilling" class="list-group-item list-group-item-action">Patient Billing</a>	
		  <a href="/viewrooms" class="list-group-item list-group-item-action">View Rooms</a>	
		  <a href="/viewmedicines" class="list-group-item list-group-item-action">View Medications</a>	  
		   <a href="/viewconsultancies" class="list-group-item list-group-item-action">View Consultancies</a>	  
		   
		  <a href="/viewservices" class="list-group-item list-group-item-action">View services</a>
		  <a href="/viewfronttdesk" class="list-group-item list-group-item-action">Patients</a>		
		    
	    </c:if>
	    <c:if test="${sessionScope.role =='User' }">
	     <a href="/viewpatientsbyuser" class="list-group-item list-group-item-action">Patients</a>	
	    <a href="/patientregbyuser" class="list-group-item list-group-item-action">Patient Registration</a>	
		  <a href="/patientbill" class="list-group-item list-group-item-action">View Patient Bill</a>	
		 <a href="/viewticketsbyuser" class="list-group-item list-group-item-action">View your tickets</a>
		  <a href="/viewreviewsbyuser" class="list-group-item list-group-item-action">View your reviews</a>
	  </c:if>
		  <a href="/logout" class="list-group-item list-group-item-action">Logout</a>
		</div>
	</div>
	<div class="col-sm-10">