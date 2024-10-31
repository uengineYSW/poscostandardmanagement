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
                                InsuranceJoinDate :  {{item.insuranceJoinDate }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ValidityFromDate :  {{item.validityFromDate }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ValidityToDate :  {{item.validityToDate }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                InsuranceCompany :  {{item.insuranceCompany }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                DiscountRate :  {{item.discountRate }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                LiabilityInsuranceI :  {{item.liabilityInsuranceI }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                LiabilityInsuranceIi :  {{item.liabilityInsuranceIi }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                PropertyDamage :  {{item.propertyDamage }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                PersonalInjury :  {{item.personalInjury }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                UninsuredVehicleDamage :  {{item.uninsuredVehicleDamage }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OwnVehicleDamage :  {{item.ownVehicleDamage }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                SpecialItems :  {{item.specialItems }}
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
        name: 'StandardmanagementInsuranceInfoPicker',
        props: {
            value: [String, Object, Array, Number, Boolean],
        },
        data: () => ({
            list: [],
            selected: null,
        }),
        async created() {
            var me = this;
            var temp = await axios.get(axios.fixUrl('/insuranceInfos'))
            if(temp.data) {
                me.list = temp.data._embedded.insuranceInfos;
            }

            if(me.value && typeof me.value == "object" && Object.values(me.value)[0]) {
                var id = Object.values(me.value)[0];
                var tmpValue = await axios.get(axios.fixUrl('/insuranceInfos/' + id))
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

