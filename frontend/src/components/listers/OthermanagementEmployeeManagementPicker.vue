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
                                Company :  {{item.company }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ResponsibleSettlement :  {{item.responsibleSettlement }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Position :  {{item.position }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ResponsibleTask :  {{item.responsibleTask }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                PhoneNumber :  {{item.phoneNumber }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                LicenseNumber :  {{item.licenseNumber }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                IdNumber :  {{item.idNumber }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ResponsibleVehicleNumber :  {{item.responsibleVehicleNumber }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                VehicleType :  {{item.vehicleType }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                RetirementStatus :  {{item.retirementStatus }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                RetirementDate :  {{item.retirementDate }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Photo :  {{item.photo }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Remarks :  {{item.remarks }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                EmployeeInfo :  {{item.employeeInfo }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                EmployeeId :  {{item.employeeId }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Name :  {{item.name }}
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
        name: 'OthermanagementEmployeeManagementPicker',
        props: {
            value: [String, Object, Array, Number, Boolean],
        },
        data: () => ({
            list: [],
            selected: null,
        }),
        async created() {
            var me = this;
            var temp = await axios.get(axios.fixUrl('/employeeManagements'))
            if(temp.data) {
                me.list = temp.data._embedded.employeeManagements;
            }

            if(me.value && typeof me.value == "object" && Object.values(me.value)[0]) {
                var id = Object.values(me.value)[0];
                var tmpValue = await axios.get(axios.fixUrl('/employeeManagements/' + id))
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
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    obj['employeeId'] = arr[4]; 
                    
                    
                    
                    this.$emit('selected', obj);
                }
            },
        },
    };
</script>

