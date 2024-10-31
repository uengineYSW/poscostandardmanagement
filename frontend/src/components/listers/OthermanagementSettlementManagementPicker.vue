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
                                SettlementType :  {{item.settlementType }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                SettlementDate :  {{item.settlementDate }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ConfirmationStatus :  {{item.confirmationStatus }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                SettlementPeriodFrom :  {{item.settlementPeriodFrom }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                SettlementPeriodTo :  {{item.settlementPeriodTo }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                VehicleCount1 :  {{item.vehicleCount1 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                VehicleCount2 :  {{item.vehicleCount2 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                VehicleCount3 :  {{item.vehicleCount3 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                VehicleCount4 :  {{item.vehicleCount4 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                VehicleCount5 :  {{item.vehicleCount5 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                VehicleCount6 :  {{item.vehicleCount6 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OperatingStaff1 :  {{item.operatingStaff1 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OperatingStaff2 :  {{item.operatingStaff2 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OperatingStaff3 :  {{item.operatingStaff3 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OperatingStaff4 :  {{item.operatingStaff4 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OperatingStaff5 :  {{item.operatingStaff5 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OperatingStaff6 :  {{item.operatingStaff6 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                MaterialCostPassenger :  {{item.materialCostPassenger }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                MaterialCostBus :  {{item.materialCostBus }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                FuelCostPassenger :  {{item.fuelCostPassenger }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                FuelCostBus :  {{item.fuelCostBus }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                PartsCostPassenger :  {{item.partsCostPassenger }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                PartsCostBus :  {{item.partsCostBus }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                LaborCostPassenger :  {{item.laborCostPassenger }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                LaborCostBus :  {{item.laborCostBus }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                DirectLaborCostPassenger :  {{item.directLaborCostPassenger }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                DirectLaborCostBus :  {{item.directLaborCostBus }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                IndirectLaborCostPassenger :  {{item.indirectLaborCostPassenger }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                IndirectLaborCostBus :  {{item.indirectLaborCostBus }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ExpensesPassenger :  {{item.expensesPassenger }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                SettlementInfo :  {{item.settlementInfo }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                SettlementPeriod :  {{item.settlementPeriod }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Amount :  {{item.amount }}
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
        name: 'OthermanagementSettlementManagementPicker',
        props: {
            value: [String, Object, Array, Number, Boolean],
        },
        data: () => ({
            list: [],
            selected: null,
        }),
        async created() {
            var me = this;
            var temp = await axios.get(axios.fixUrl('/settlementManagements'))
            if(temp.data) {
                me.list = temp.data._embedded.settlementManagements;
            }

            if(me.value && typeof me.value == "object" && Object.values(me.value)[0]) {
                var id = Object.values(me.value)[0];
                var tmpValue = await axios.get(axios.fixUrl('/settlementManagements/' + id))
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
                    obj['id'] = arr[4]; 
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    this.$emit('selected', obj);
                }
            },
        },
    };
</script>

