create database vehicle_insurance;

use database vehicle_insurance;

create table customer_registration
(
	userID int(5) primary key AUTO_INCREMENT,
	userFirstName char (40),
	userLastName char (40),
	userGender char(6),
	userDOB char(10),
	userContactNo char(10),
	userAddress char(50),
	userCountry char(20),
	userState char(20),
	userCity char(20),
	userPincode char(6),
	userEmail char(20),
	userPassword char(10)
);

update customer_registration SET userEmail='VIM' where userID=5;

create table vehicle_registration
(
	policyID int(8) primary key AUTO_INCREMENT,
	vehicleFirstName char(40),
	vehicleLastName char(40),
	vehicleState char(20),
	vehicleClass char(20),
	vehicleType char(20),
	vehicleManufacturer char(20),
	vehicleModel char(20),
	vehicleEngineNo char(20),
	vehicleYear char(10),
	vehicleLocation char(20),
	vehiclePrice char(20),
	vehicleDOP char(10),
	vehiclePremium char(20),
	vehiclePremiumDate char(20),
	vehicleClaim char(20),
	vehicleClaimDate char(20)
);
ALTER TABLE vehicle_registration
ADD vehicleClaimDate char(20);

insert into vehicle_registration
(vehicleFirstName, vehicleLastName, vehicleState, vehicleClass, vehicleType, vehicleManufacturer, 
vehicleModel, vehicleEngineNo, vehicleYear, vehicleLocation, vehiclePrice, vehicleDOP) 
values ('SS', 'Saha', 'West Bengal', 'Private', 'Two Wheeler', 'TVS', 'Activa', '123', '2015', 'Kolkata', '40000', '03/03');

create table claim_accidental
(
	claimID int(8) primary key AUTO_INCREMENT,
	policyID int(8), 
	vehicleFirstName char(40), 
	vehicleLastName char(40), 
	vehicleClaim char(20),
	vehicleClaimDate char(20),
	accidentType char(40),
	weightage int(10),
	FOREIGN KEY (policyID) REFERENCES vehicle_registration(policyID)
);

create table claim_theft
(
	claimID int(8) primary key AUTO_INCREMENT,
	policyID int(8), 
	vehicleFirstName char(40), 
	vehicleLastName char(40), 
	vehicleClaim char(20),
	vehicleClaimDate char(20),
	dateOfTheft char(10),
	dateOfComplaint char(10),
	firNo char(10),
	psBranch char(20),
	FOREIGN KEY (policyID) REFERENCES vehicle_registration(policyID)
);	
	
create table pay_direct
(
	paymentID int(8) primary key AUTO_INCREMENT,
	policyID int(8), 
	policyPremium char(10),
	policyPremiumDate timestamp DEFAULT CURRENT_TIMESTAMP(),
	policyPaymentMode char(20),
	policyContactNo char(10),
	FOREIGN KEY (policyID) REFERENCES vehicle_registration(policyID)
);

create table pay_registered
(
	paymentID int(8) primary key AUTO_INCREMENT,
	policyID int(8), 
	policyState char(20),
	policyVehicleType char(20),
	policyVehicleModel char(20),
	payPremium char(20),
	payPremiumDate char(20),
	paymentMode char(20),
	payConatctNo char(10),
	policyPremiumDate timestamp DEFAULT CURRENT_TIMESTAMP(),
	FOREIGN KEY (policyID) REFERENCES vehicle_registration(policyID)	
);

create table cancel_policy
(
	cancelID int(8) primary key AUTO_INCREMENT,
	cancelPolicyDate timestamp DEFAULT CURRENT_TIMESTAMP(),
	policyID int(8)
);