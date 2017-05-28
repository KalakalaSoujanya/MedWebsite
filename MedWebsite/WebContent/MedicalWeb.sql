drop TABLE TestResults;
drop TABLE Test;
drop TABLE Appointment;
drop TABLE Connector;
drop TABLE Message;
drop TABLE Patient;
drop TABLE Doctor;


CREATE TABLE Doctor(doctorId int PRIMARY KEY,FirstName varchar(30),LastName varchar(30),Title varchar(30),Speciality varchar(30),EmailId varchar(30),OfficeStreet varchar(30),Address varchar(30),OfficeCity varchar(30),OfficeState varchar(30),UserName varchar(30),Password varchar(30));
CREATE TABLE Patient(patientId int PRIMARY KEY,FirstName varchar(30),LastName varchar(30),EmailId varchar(30),Username varchar(30),Password varchar(30));
CREATE TABLE Message(msgId int PRIMARY KEY,patientId int FOREIGN KEY,DoctorId int FOREIGN KEY,senderName varchar(20),senttime TIMESTAMP() not null,msgBox varchar(40),status varchar(1));
CREATE TABLE DoctorPatient(patientId int,FOREIGN KEY(patientId)REFERENCES PATIENT(patientId),doctorId int, FOREIGN KEY(doctorId)REFERENCES DOCTOR(doctorId),status varchar(1));
CREATE TABLE Appointment(dateSelect DATE NOT NULL, slotNumber int, doctorId int,FOREIGN KEY(doctorId)REFERENCES DOCTOR(doctorId), patientId int, FOREIGN KEY (patientId) REFERENCES  PATIENT(patientId),doctorsPesNote varchar);
CREATE TABLE Test(testId int PRIMARY KEY,testDate DATE,testName varchar(20), doctorId int,FOREIGN KEY(doctorId)REFERENCES DOCTOR(doctorId), patientId int,FOREIGN KEY(patientId) REFERENCES PATIENT(patientId),doctorNote varchar(50));
CREATE TABLE TestResult(resultId int PRIMARY KEY, testId int,FOREIGN KEY(testId)REFERENCES Test(testId),testResultDate DATE NOT NULL,NormalRange varchar(25),ActualResult varchar(25),testResultsNote varchar(30));