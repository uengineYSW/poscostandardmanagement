<template>
    <v-card outlined>
        <v-card-title>
            CreateOperationRecord
        </v-card-title>

        <v-card-text>
            <Number label="VehicleId" v-model="value.vehicleId" :editMode="editMode"/>
            <Date label="OperationDate" v-model="value.operationDate" :editMode="editMode"/>
            <Number label="OperationSeq" v-model="value.operationSeq" :editMode="editMode"/>
            <String label="DriverId" v-model="value.driverId" :editMode="editMode"/>
            <String label="PassengerWorkDistinction" v-model="value.passengerWorkDistinction" :editMode="editMode"/>
            <String label="OperationPurpose" v-model="value.operationPurpose" :editMode="editMode"/>
            <Number label="NumberOfPassengers" v-model="value.numberOfPassengers" :editMode="editMode"/>
            <String label="OperationPlace" v-model="value.operationPlace" :editMode="editMode"/>
            <Number label="OperationKm" v-model="value.operationKm" :editMode="editMode"/>
            <Date label="DepartureTime" v-model="value.departureTime" :editMode="editMode"/>
            <Date label="ArrivalTime" v-model="value.arrivalTime" :editMode="editMode"/>
            <Number label="OperationTimeMin" v-model="value.operationTimeMin" :editMode="editMode"/>
            <Number label="WaitingTimeMin" v-model="value.waitingTimeMin" :editMode="editMode"/>
            <String label="FuelSupplier" v-model="value.fuelSupplier" :editMode="editMode"/>
            <Number label="FuelAmount" v-model="value.fuelAmount" :editMode="editMode"/>
            <Number label="FuelUnitPrice" v-model="value.fuelUnitPrice" :editMode="editMode"/>
            <Number label="CardFuelAmount" v-model="value.cardFuelAmount" :editMode="editMode"/>
            <Number label="CardFuelSupplyAmount" v-model="value.cardFuelSupplyAmount" :editMode="editMode"/>
            <Number label="CardFuelTax" v-model="value.cardFuelTax" :editMode="editMode"/>
            <Number label="CardTollFee" v-model="value.cardTollFee" :editMode="editMode"/>
            <Number label="CashFuelAmount" v-model="value.cashFuelAmount" :editMode="editMode"/>
            <Number label="CashFuelSupplyAmount" v-model="value.cashFuelSupplyAmount" :editMode="editMode"/>
            <Number label="CashFuelTax" v-model="value.cashFuelTax" :editMode="editMode"/>
            <Number label="CashTollFee" v-model="value.cashTollFee" :editMode="editMode"/>
            <Number label="CashParkingFee" v-model="value.cashParkingFee" :editMode="editMode"/>
            <String label="Remarks" v-model="value.remarks" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createOperationRecord"
            >
                CreateOperationRecord
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
        name: 'CreateOperationRecordCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.vehicleId = 0;
            this.value.operationDate = '2024-10-31';
            this.value.operationSeq = 0;
            this.value.driverId = '';
            this.value.passengerWorkDistinction = '';
            this.value.operationPurpose = '';
            this.value.numberOfPassengers = 0;
            this.value.operationPlace = '';
            this.value.operationKm = 0;
            this.value.departureTime = '2024-10-31';
            this.value.arrivalTime = '2024-10-31';
            this.value.operationTimeMin = 0;
            this.value.waitingTimeMin = 0;
            this.value.fuelSupplier = '';
            this.value.fuelAmount = 0;
            this.value.fuelUnitPrice = 0;
            this.value.cardFuelAmount = 0;
            this.value.cardFuelSupplyAmount = 0;
            this.value.cardFuelTax = 0;
            this.value.cardTollFee = 0;
            this.value.cashFuelAmount = 0;
            this.value.cashFuelSupplyAmount = 0;
            this.value.cashFuelTax = 0;
            this.value.cashTollFee = 0;
            this.value.cashParkingFee = 0;
            this.value.remarks = '';
        },
        watch: {
        },
        methods: {
            createOperationRecord() {
                this.$emit('createOperationRecord', this.value);
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

