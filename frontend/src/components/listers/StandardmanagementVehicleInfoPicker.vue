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
                                VehicleNumber :  {{item.vehicleNumber }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Classification :  {{item.classification }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ManufacturerCode :  {{item.manufacturerCode }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                VehicleTypeCode :  {{item.vehicleTypeCode }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                VehicleModelCode :  {{item.vehicleModelCode }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                UsageCode :  {{item.usageCode }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                FuelType :  {{item.fuelType }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                VehicleAffiliationCode :  {{item.vehicleAffiliationCode }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                AssetCode :  {{item.assetCode }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OperatingDepartment :  {{item.operatingDepartment }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                AcquisitionAmount :  {{item.acquisitionAmount }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ResponsibleDriverId :  {{item.responsibleDriverId }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                MainUser :  {{item.mainUser }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                VehicleRegistrationDate :  {{item.vehicleRegistrationDate }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                VehicleSaleDate :  {{item.vehicleSaleDate }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ChassisNumber :  {{item.chassisNumber }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                VehicleFormat :  {{item.vehicleFormat }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                VehicleYear :  {{item.vehicleYear }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Output :  {{item.output }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Length :  {{item.length }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Width :  {{item.width }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Height :  {{item.height }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Weight :  {{item.weight }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                LoadCapacity :  {{item.loadCapacity }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Displacement :  {{item.displacement }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                SeatingCapacity :  {{item.seatingCapacity }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                StandardFuelEfficiency :  {{item.standardFuelEfficiency }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                FuelTankCapacity :  {{item.fuelTankCapacity }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                DepartureKm :  {{item.departureKm }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                AccumulatedKm :  {{item.accumulatedKm }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                TotalAccumulatedKm :  {{item.totalAccumulatedKm }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                RegularInspectionDate :  {{item.regularInspectionDate }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Remarks :  {{item.remarks }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                VehicleSpec :  {{item.vehicleSpec }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                VehicleOwnership :  {{item.vehicleOwnership }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                UnavailabilityReason :  {{item.unavailabilityReason }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                UnavailabilityDate :  {{item.unavailabilityDate }}
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
        name: 'StandardmanagementVehicleInfoPicker',
        props: {
            value: [String, Object, Array, Number, Boolean],
        },
        data: () => ({
            list: [],
            selected: null,
        }),
        async created() {
            var me = this;
            var temp = await axios.get(axios.fixUrl('/vehicleInfos'))
            if(temp.data) {
                me.list = temp.data._embedded.vehicleInfos;
            }

            if(me.value && typeof me.value == "object" && Object.values(me.value)[0]) {
                var id = Object.values(me.value)[0];
                var tmpValue = await axios.get(axios.fixUrl('/vehicleInfos/' + id))
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

