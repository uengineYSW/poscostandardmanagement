<template>
    <div>
        <v-list two-line v-if="list.length > 0">
            <v-list-item-group 
                    v-model="selected" 
                    color="primary"
                    @change="select"
            >
                <v-list-item v-for="(item, idx) in list" :key="idx">
                    <template v-slot:default="{ active }">
                        <v-list-item-avatar color="primary-darker-1">
                        </v-list-item-avatar>
                        
                        <v-list-item-content>
                            <v-list-item-title>
                            </v-list-item-title>
                            <v-list-item-subtitle>
                                VehicleId :  {{item.vehicleId }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OperationDate :  {{item.operationDate }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OperationSeq :  {{item.operationSeq }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                DriverId :  {{item.driverId }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                PassengerWorkDistinction :  {{item.passengerWorkDistinction }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OperationPurpose :  {{item.operationPurpose }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                NumberOfPassengers :  {{item.numberOfPassengers }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OperationPlace :  {{item.operationPlace }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OperationKm :  {{item.operationKm }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                DepartureTime :  {{item.departureTime }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ArrivalTime :  {{item.arrivalTime }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OperationTimeMin :  {{item.operationTimeMin }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                WaitingTimeMin :  {{item.waitingTimeMin }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                FuelSupplier :  {{item.fuelSupplier }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                FuelAmount :  {{item.fuelAmount }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                FuelUnitPrice :  {{item.fuelUnitPrice }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                CardFuelAmount :  {{item.cardFuelAmount }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                CardFuelSupplyAmount :  {{item.cardFuelSupplyAmount }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                CardFuelTax :  {{item.cardFuelTax }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                CardTollFee :  {{item.cardTollFee }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                CashFuelAmount :  {{item.cashFuelAmount }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                CashFuelSupplyAmount :  {{item.cashFuelSupplyAmount }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                CashFuelTax :  {{item.cashFuelTax }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                CashTollFee :  {{item.cashTollFee }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                CashParkingFee :  {{item.cashParkingFee }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Remarks :  {{item.remarks }}
                            </v-list-item-subtitle>
                        </v-list-item-content>

                        <v-list-item-action>
                            <v-checkbox :input-value="active" color="primary-darker-1"></v-checkbox>
                        </v-list-item-action>
                    </template>
                </v-list-item>
            </v-list-item-group>
        </v-list>
    </div>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'StandardmanagementOperationRecordPicker',
        props: {
            value: [String, Object, Array, Number, Boolean],
        },
        data: () => ({
            list: [],
            selected: null,
        }),
        async created() {
            var me = this;
            var temp = await axios.get(axios.fixUrl('/operationRecords'))
            if(temp.data) {
                me.list = temp.data._embedded.operationRecords;
            }

            if(me.value && typeof me.value == "object" && Object.values(me.value)[0]) {
                var id = Object.values(me.value)[0];
                var tmpValue = await axios.get(axios.fixUrl('/operationRecords/' + id))
                if(tmpValue.data) {
                    var val = tmpValue.data
                    me.list.forEach(function(item, idx) {
                        if(item.name == val.name) {
                            me.selected = idx
                        }
                    })
                }
            }
        },
        methods: {
            select(val) {
                var obj = {}
                if(val != undefined) {
                    var arr = this.list[val]._links.self.href.split('/');
                    obj['vehicleId'] = arr[4]; 
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    this.$emit('selected', obj);
                }
            },
        },
    };
</script>

