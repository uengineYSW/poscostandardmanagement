<template>
    <div>
        <v-data-table
                :headers="headers"
                :items="values"
                :items-per-page="5"
                class="elevation-1"
        ></v-data-table>

        <v-col style="margin-bottom:40px;">
            <div class="text-center">
                <v-dialog
                        v-model="openDialog"
                        width="332.5"
                        fullscreen
                        hide-overlay
                        transition="dialog-bottom-transition"
                >
                    <template v-slot:activator="{ on, attrs }">
                        <v-fab-transition>
                            <v-btn
                                    color="primary"
                                    fab
                                    dark
                                    large
                                    style="position:absolute; bottom: 5%; right: 2%; z-index:99"
                                    @click="openDialog=true;"
                            >
                                <v-icon v-bind="attrs" v-on="on">mdi-plus</v-icon>
                            </v-btn>
                        </v-fab-transition>
                    </template>

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
            headers: 
                [
                    { text: "vehicleId", value: "vehicleId" },
                    { text: "operationDate", value: "operationDate" },
                    { text: "operationSeq", value: "operationSeq" },
                    { text: "driverId", value: "driverId" },
                    { text: "passengerWorkDistinction", value: "passengerWorkDistinction" },
                    { text: "operationPurpose", value: "operationPurpose" },
                    { text: "numberOfPassengers", value: "numberOfPassengers" },
                    { text: "operationPlace", value: "operationPlace" },
                    { text: "operationKm", value: "operationKm" },
                    { text: "departureTime", value: "departureTime" },
                    { text: "arrivalTime", value: "arrivalTime" },
                    { text: "operationTimeMin", value: "operationTimeMin" },
                    { text: "waitingTimeMin", value: "waitingTimeMin" },
                    { text: "fuelSupplier", value: "fuelSupplier" },
                    { text: "fuelAmount", value: "fuelAmount" },
                    { text: "fuelUnitPrice", value: "fuelUnitPrice" },
                    { text: "cardFuelAmount", value: "cardFuelAmount" },
                    { text: "cardFuelSupplyAmount", value: "cardFuelSupplyAmount" },
                    { text: "cardFuelTax", value: "cardFuelTax" },
                    { text: "cardTollFee", value: "cardTollFee" },
                    { text: "cashFuelAmount", value: "cashFuelAmount" },
                    { text: "cashFuelSupplyAmount", value: "cashFuelSupplyAmount" },
                    { text: "cashFuelTax", value: "cashFuelTax" },
                    { text: "cashTollFee", value: "cashTollFee" },
                    { text: "cashParkingFee", value: "cashParkingFee" },
                    { text: "remarks", value: "remarks" },
                ],
            operationRecord : [],
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
            },
        }
    }
</script>

