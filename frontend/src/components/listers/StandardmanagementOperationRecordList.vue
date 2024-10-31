<template>
    <div>
    <h1>OperationRecord</h1>
        <v-row>
            <v-card
                class="mx-auto"
                style="height:300px; width:300px; margin-bottom:20px; text-align: center;"
                outlined
            >
                <v-list-item>
                    <v-list-item-avatar 
                        class="mx-auto"
                        size="80"
                        style="margin-top:80px;"
                    ><v-icon color="primary" x-large>mdi-plus</v-icon>
                    </v-list-item-avatar>
                </v-list-item>

                <v-card-actions>
                    <v-btn 
                        v-on="on"
                        class="mx-auto"
                        outlined
                        rounded
                        @click="openDialog=true;"
                        color="primary"
                        style="font-weight:500; font-size:20px; padding:15px; border:solid 2px; max-width:250px; overflow:hidden"
                    >
                        OperationRecord 등록
                    </v-btn>
                </v-card-actions>
            </v-card>
        </v-row>
        <v-list two-line>
            <template>
                <v-list-item v-for="(data, n) in values" :key="n">
                    <v-list-item-avatar color="grey darken-1">
                        <v-img :src="data.photo ? data.photo:'https://cdn.vuetifyjs.com/images/cards/cooking.png'"/>
                    </v-list-item-avatar>

                    <v-list-item-content>
                        <v-list-item-title style="margin-bottom:10px;">
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                        </v-list-item-title>

                        <v-list-item-subtitle style="font-size:25px; font-weight:700;">
                            [ VehicleId :  {{data.vehicleId }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ OperationDate :  {{data.operationDate }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ OperationSeq :  {{data.operationSeq }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ DriverId :  {{data.driverId }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ PassengerWorkDistinction :  {{data.passengerWorkDistinction }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ OperationPurpose :  {{data.operationPurpose }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ NumberOfPassengers :  {{data.numberOfPassengers }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ OperationPlace :  {{data.operationPlace }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ OperationKm :  {{data.operationKm }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ DepartureTime :  {{data.departureTime }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ ArrivalTime :  {{data.arrivalTime }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ OperationTimeMin :  {{data.operationTimeMin }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ WaitingTimeMin :  {{data.waitingTimeMin }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ FuelSupplier :  {{data.fuelSupplier }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ FuelAmount :  {{data.fuelAmount }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ FuelUnitPrice :  {{data.fuelUnitPrice }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ CardFuelAmount :  {{data.cardFuelAmount }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ CardFuelSupplyAmount :  {{data.cardFuelSupplyAmount }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ CardFuelTax :  {{data.cardFuelTax }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ CardTollFee :  {{data.cardTollFee }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ CashFuelAmount :  {{data.cashFuelAmount }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ CashFuelSupplyAmount :  {{data.cashFuelSupplyAmount }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ CashFuelTax :  {{data.cashFuelTax }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ CashTollFee :  {{data.cashTollFee }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ CashParkingFee :  {{data.cashParkingFee }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ Remarks :  {{data.remarks }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </v-list-item-subtitle>

                    </v-list-item-content>
                </v-list-item>

                <v-divider v-if="n !== 6" :key="`divider-${n}`" inset></v-divider>
            </template>
        </v-list>

        <v-col style="margin-bottom:40px;">
            <div class="text-center">
                <v-dialog
                        v-model="openDialog"
                        width="332.5"
                        fullscreen
                        hide-overlay
                        transition="dialog-bottom-transition"
                >

                    <StandardmanagementOperationRecord :offline="offline" class="video-card" :isNew="true" :editMode="true" v-model="newValue" @add="append" v-if="tick"/>
                
                    <v-btn
                            style="postition:absolute; top:2%; right:2%"
                            @click="closeDialog()"
                            depressed 
                            icon 
                            absolute
                    >
                        <v-icon>mdi-close</v-icon>
                    </v-btn>
                </v-dialog>
            </div>
        </v-col>
    </div>
</template>

<script>
    const axios = require('axios').default;
    import StandardmanagementOperationRecord from './../StandardmanagementOperationRecord.vue';

    export default {
        name: 'StandardmanagementOperationRecordManager',
        components: {
            StandardmanagementOperationRecord,
        },
        props: {
            offline: Boolean,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            values: [],
            newValue: {},
            tick : true,
            openDialog : false,
        }),
        async created() {
            if(this.offline){
                if(!this.values) this.values = [];
                return;
            } 

            var temp = await axios.get(axios.fixUrl('/operationrecords'))
            temp.data._embedded.operationrecords.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])
            this.values = temp.data._embedded.operationrecords;
            
            this.newValue = {
                'vehicleId': 0,
                'operationDate': '2024-10-31',
                'operationSeq': 0,
                'driverId': '',
                'passengerWorkDistinction': '',
                'operationPurpose': '',
                'numberOfPassengers': 0,
                'operationPlace': '',
                'operationKm': 0,
                'departureTime': '2024-10-31',
                'arrivalTime': '2024-10-31',
                'operationTimeMin': 0,
                'waitingTimeMin': 0,
                'fuelSupplier': '',
                'fuelAmount': 0,
                'fuelUnitPrice': 0,
                'cardFuelAmount': 0,
                'cardFuelSupplyAmount': 0,
                'cardFuelTax': 0,
                'cardTollFee': 0,
                'cashFuelAmount': 0,
                'cashFuelSupplyAmount': 0,
                'cashFuelTax': 0,
                'cashTollFee': 0,
                'cashParkingFee': 0,
                'remarks': '',
            }
        },
        methods: {
            closeDialog(){
                this.openDialog = false
            },
            append(value){
                this.tick = false
                this.newValue = {}
                this.values.push(value)
                
                this.$emit('input', this.values);

                this.$nextTick(function(){
                    this.tick=true
                })
            }
        },
    };
</script>


<style>
    .video-card {
        width:300px; 
        margin-left:4.5%; 
        margin-top:50px; 
        margin-bottom:50px;
    }
</style>

