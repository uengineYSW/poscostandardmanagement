<template>
    <v-card outlined>
        <v-card-title>
            CreateVehicleInfo
        </v-card-title>

        <v-card-text>
            <Number label="VehicleId" v-model="value.vehicleId" :editMode="editMode"/>
            <String label="VehicleNumber" v-model="value.vehicleNumber" :editMode="editMode"/>
            <String label="Classification" v-model="value.classification" :editMode="editMode"/>
            <String label="ManufacturerCode" v-model="value.manufacturerCode" :editMode="editMode"/>
            <String label="VehicleTypeCode" v-model="value.vehicleTypeCode" :editMode="editMode"/>
            <String label="VehicleModelCode" v-model="value.vehicleModelCode" :editMode="editMode"/>
            <String label="UsageCode" v-model="value.usageCode" :editMode="editMode"/>
            <String label="FuelType" v-model="value.fuelType" :editMode="editMode"/>
            <String label="VehicleAffiliationCode" v-model="value.vehicleAffiliationCode" :editMode="editMode"/>
            <String label="VehicleOwnership" v-model="value.vehicleOwnership" :editMode="editMode"/>
            <String label="AssetCode" v-model="value.assetCode" :editMode="editMode"/>
            <String label="OperatingDepartment" v-model="value.operatingDepartment" :editMode="editMode"/>
            <Number label="AcquisitionAmount" v-model="value.acquisitionAmount" :editMode="editMode"/>
            <String label="ResponsibleDriverId" v-model="value.responsibleDriverId" :editMode="editMode"/>
            <String label="MainUser" v-model="value.mainUser" :editMode="editMode"/>
            <Date label="VehicleRegistrationDate" v-model="value.vehicleRegistrationDate" :editMode="editMode"/>
            <Date label="VehicleSaleDate" v-model="value.vehicleSaleDate" :editMode="editMode"/>
            <String label="ChassisNumber" v-model="value.chassisNumber" :editMode="editMode"/>
            <String label="VehicleFormat" v-model="value.vehicleFormat" :editMode="editMode"/>
            <String label="VehicleYear" v-model="value.vehicleYear" :editMode="editMode"/>
            <String label="Output" v-model="value.output" :editMode="editMode"/>
            <Number label="Length" v-model="value.length" :editMode="editMode"/>
            <Number label="Width" v-model="value.width" :editMode="editMode"/>
            <Number label="Height" v-model="value.height" :editMode="editMode"/>
            <Number label="Weight" v-model="value.weight" :editMode="editMode"/>
            <Number label="LoadCapacity" v-model="value.loadCapacity" :editMode="editMode"/>
            <Number label="Displacement" v-model="value.displacement" :editMode="editMode"/>
            <Number label="SeatingCapacity" v-model="value.seatingCapacity" :editMode="editMode"/>
            <Number label="StandardFuelEfficiency" v-model="value.standardFuelEfficiency" :editMode="editMode"/>
            <Number label="FuelTankCapacity" v-model="value.fuelTankCapacity" :editMode="editMode"/>
            <Number label="DepartureKm" v-model="value.departureKm" :editMode="editMode"/>
            <Number label="AccumulatedKm" v-model="value.accumulatedKm" :editMode="editMode"/>
            <Number label="TotalAccumulatedKm" v-model="value.totalAccumulatedKm" :editMode="editMode"/>
            <Date label="RegularInspectionDate" v-model="value.regularInspectionDate" :editMode="editMode"/>
            <String label="Remarks" v-model="value.remarks" :editMode="editMode"/>
            <VehicleSpec offline label="VehicleSpec" v-model="value.vehicleSpec" :editMode="editMode" @change="change"/>
            <VehicleOwnership offline label="VehicleOwnership" v-model="value.vehicleOwnership" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createVehicleInfo"
            >
                CreateVehicleInfo
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'CreateVehicleInfoCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.vehicleId = 0;
            this.value.vehicleNumber = '';
            this.value.classification = '';
            this.value.manufacturerCode = '';
            this.value.vehicleTypeCode = '';
            this.value.vehicleModelCode = '';
            this.value.usageCode = '';
            this.value.fuelType = '';
            this.value.vehicleAffiliationCode = '';
            this.value.vehicleOwnership = '';
            this.value.assetCode = '';
            this.value.operatingDepartment = '';
            this.value.acquisitionAmount = 0;
            this.value.responsibleDriverId = '';
            this.value.mainUser = '';
            this.value.vehicleRegistrationDate = '2024-10-31';
            this.value.vehicleSaleDate = '2024-10-31';
            this.value.chassisNumber = '';
            this.value.vehicleFormat = '';
            this.value.vehicleYear = '';
            this.value.output = '';
            this.value.length = 0;
            this.value.width = 0;
            this.value.height = 0;
            this.value.weight = 0;
            this.value.loadCapacity = 0;
            this.value.displacement = 0;
            this.value.seatingCapacity = 0;
            this.value.standardFuelEfficiency = 0;
            this.value.fuelTankCapacity = 0;
            this.value.departureKm = 0;
            this.value.accumulatedKm = 0;
            this.value.totalAccumulatedKm = 0;
            this.value.regularInspectionDate = '2024-10-31';
            this.value.remarks = '';
            this.value.vehicleSpec = {};
            this.value.vehicleOwnership = {};
        },
        watch: {
        },
        methods: {
            createVehicleInfo() {
                this.$emit('createVehicleInfo', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

