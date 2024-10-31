# 

## Model
www.msaez.io/#/storming/poscostandardmanagement

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- standardmanagement
- othermanagement


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- standardmanagement
```
 http :8088/dispatchRequests dispatchRequestId="dispatchRequestId" applicantId="applicantId" applicationDate="applicationDate" applicantDepartmentCode="applicantDepartmentCode" officePhoneNumber="officePhoneNumber" mobilePhoneNumber="mobilePhoneNumber" approverId="approverId" approverPosition="approverPosition" mainDepartment="mainDepartment" mainDepartmentManagerId="mainDepartmentManagerId" approvalDate="approvalDate" progressStatus="progressStatus" usagePurposeCode="usagePurposeCode" usagePurposeDetail="usagePurposeDetail" userId="userId" visitor="visitor" numberOfPassengers="numberOfPassengers" operationPeriodFrom="operationPeriodFrom" operationPeriodTo="operationPeriodTo" inOutDistinction="inOutDistinction" roundTrip="roundTrip" operationSection1="operationSection1" operationSection2="operationSection2" operationSection3="operationSection3" operationSection4="operationSection4" operationSection5="operationSection5" requestedNumber1="requestedNumber1" requestedNumber2="requestedNumber2" requestedNumber3="requestedNumber3" driverIncluded="driverIncluded" detailedSchedule="detailedSchedule" attachedDocumentName="attachedDocumentName" attachedDocument="attachedDocument" emailSent="emailSent" smsSent="smsSent" dispatchResultContent="dispatchResultContent" dispatchCarNumber="dispatchCarNumber" dispatchDriverId="dispatchDriverId" dispatchDriverPhoneNumber="dispatchDriverPhoneNumber" remarks="remarks" phoneNumber="phoneNumber" applicant="applicant" approver="approver" 
 http :8088/vehicleInfos vehicleId="vehicleId" vehicleNumber="vehicleNumber" classification="classification" manufacturerCode="manufacturerCode" vehicleTypeCode="vehicleTypeCode" vehicleModelCode="vehicleModelCode" usageCode="usageCode" fuelType="fuelType" vehicleAffiliationCode="vehicleAffiliationCode" assetCode="assetCode" operatingDepartment="operatingDepartment" acquisitionAmount="acquisitionAmount" responsibleDriverId="responsibleDriverId" mainUser="mainUser" vehicleRegistrationDate="vehicleRegistrationDate" vehicleSaleDate="vehicleSaleDate" chassisNumber="chassisNumber" vehicleFormat="vehicleFormat" vehicleYear="vehicleYear" output="output" length="length" width="width" height="height" weight="weight" loadCapacity="loadCapacity" displacement="displacement" seatingCapacity="seatingCapacity" standardFuelEfficiency="standardFuelEfficiency" fuelTankCapacity="fuelTankCapacity" departureKm="departureKm" accumulatedKm="accumulatedKm" totalAccumulatedKm="totalAccumulatedKm" regularInspectionDate="regularInspectionDate" remarks="remarks" vehicleSpec="vehicleSpec" vehicleOwnership="vehicleOwnership" unavailabilityReason="unavailabilityReason" unavailabilityDate="unavailabilityDate" 
 http :8088/vehicleChanges vehicleId="vehicleId" changeDate="changeDate" oldVehicleNumber="oldVehicleNumber" changeReason="changeReason" remarks="remarks" 
 http :8088/preventiveInspections vehicleId="vehicleId" inspectionContent="inspectionContent" regularCheckStandard="regularCheckStandard" standardKm="standardKm" recentInspectionKm="recentInspectionKm" inspectionScheduledKm="inspectionScheduledKm" standardReport="standardReport" recentInspectionDate="recentInspectionDate" inspectionScheduledDate="inspectionScheduledDate" remarks="remarks" 
 http :8088/operationRecords vehicleId="vehicleId" operationDate="operationDate" operationSeq="operationSeq" driverId="driverId" passengerWorkDistinction="passengerWorkDistinction" operationPurpose="operationPurpose" numberOfPassengers="numberOfPassengers" operationPlace="operationPlace" operationKm="operationKm" departureTime="departureTime" arrivalTime="arrivalTime" operationTimeMin="operationTimeMin" waitingTimeMin="waitingTimeMin" fuelSupplier="fuelSupplier" fuelAmount="fuelAmount" fuelUnitPrice="fuelUnitPrice" cardFuelAmount="cardFuelAmount" cardFuelSupplyAmount="cardFuelSupplyAmount" cardFuelTax="cardFuelTax" cardTollFee="cardTollFee" cashFuelAmount="cashFuelAmount" cashFuelSupplyAmount="cashFuelSupplyAmount" cashFuelTax="cashFuelTax" cashTollFee="cashTollFee" cashParkingFee="cashParkingFee" remarks="remarks" 
 http :8088/maintenanceRecords vehicleId="vehicleId" maintenanceDate="maintenanceDate" maintenanceSeq="maintenanceSeq" maintenanceCompanyCode="maintenanceCompanyCode" maintenanceItemCode="maintenanceItemCode" maintenanceItemName="maintenanceItemName" unit="unit" quantity="quantity" unitPrice="unitPrice" supplyAmount="supplyAmount" tax="tax" amount="amount" preventiveMaintenance="preventiveMaintenance" preventiveMaintenanceItem="preventiveMaintenanceItem" remarks="remarks" 
 http :8088/insuranceInfos vehicleId="vehicleId" insuranceJoinDate="insuranceJoinDate" validityFromDate="validityFromDate" validityToDate="validityToDate" insuranceCompany="insuranceCompany" discountRate="discountRate" liabilityInsuranceI="liabilityInsuranceI" liabilityInsuranceIi="liabilityInsuranceII" propertyDamage="propertyDamage" personalInjury="personalInjury" uninsuredVehicleDamage="uninsuredVehicleDamage" ownVehicleDamage="ownVehicleDamage" specialItems="specialItems" remarks="remarks" 
 http :8088/accidentRecords vehicleId="vehicleId" accidentDate="accidentDate" accidentType="accidentType" accidentPerson="accidentPerson" confirmer="confirmer" accidentDetail="accidentDetail" remarks="remarks" 
```
- othermanagement
```
 http :8088/vehicleManagements taxType="taxType" employeeId="employeeId" date="date" seq="seq" amount="amount" vat="vat" totalAmount="totalAmount" remarks="remarks" vehicleInfo="vehicleInfo" vehicleNumber="vehicleNumber" vehicleType="vehicleType" 
 http :8088/settlementManagements id="id" settlementType="settlementType" settlementDate="settlementDate" confirmationStatus="confirmationStatus" settlementPeriodFrom="settlementPeriodFrom" settlementPeriodTo="settlementPeriodTo" vehicleCount1="vehicleCount1" vehicleCount2="vehicleCount2" vehicleCount3="vehicleCount3" vehicleCount4="vehicleCount4" vehicleCount5="vehicleCount5" vehicleCount6="vehicleCount6" operatingStaff1="operatingStaff1" operatingStaff2="operatingStaff2" operatingStaff3="operatingStaff3" operatingStaff4="operatingStaff4" operatingStaff5="operatingStaff5" operatingStaff6="operatingStaff6" materialCostPassenger="materialCostPassenger" materialCostBus="materialCostBus" fuelCostPassenger="fuelCostPassenger" fuelCostBus="fuelCostBus" partsCostPassenger="partsCostPassenger" partsCostBus="partsCostBus" laborCostPassenger="laborCostPassenger" laborCostBus="laborCostBus" directLaborCostPassenger="directLaborCostPassenger" directLaborCostBus="directLaborCostBus" indirectLaborCostPassenger="indirectLaborCostPassenger" indirectLaborCostBus="indirectLaborCostBus" expensesPassenger="expensesPassenger" settlementInfo="settlementInfo" settlementPeriod="settlementPeriod" amount="amount" 
 http :8088/codeManagements id="id" codeCategoryName="codeCategoryName" settlementType="settlementType" remarks="remarks" codeInfo="codeInfo" codeCategory="codeCategory" code="code" 
 http :8088/employeeManagements company="company" responsibleSettlement="responsibleSettlement" position="position" responsibleTask="responsibleTask" phoneNumber="phoneNumber" licenseNumber="licenseNumber" idNumber="idNumber" responsibleVehicleNumber="responsibleVehicleNumber" vehicleType="vehicleType" retirementStatus="retirementStatus" retirementDate="retirementDate" photo="photo" remarks="remarks" employeeInfo="employeeInfo" employeeId="employeeId" name="name" 
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

