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
                                MaintenanceDate :  {{item.maintenanceDate }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                MaintenanceSeq :  {{item.maintenanceSeq }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                MaintenanceCompanyCode :  {{item.maintenanceCompanyCode }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                MaintenanceItemCode :  {{item.maintenanceItemCode }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                MaintenanceItemName :  {{item.maintenanceItemName }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Unit :  {{item.unit }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Quantity :  {{item.quantity }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                UnitPrice :  {{item.unitPrice }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                SupplyAmount :  {{item.supplyAmount }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Tax :  {{item.tax }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Amount :  {{item.amount }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                PreventiveMaintenance :  {{item.preventiveMaintenance }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                PreventiveMaintenanceItem :  {{item.preventiveMaintenanceItem }}
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
        name: 'StandardmanagementMaintenanceRecordPicker',
        props: {
            value: [String, Object, Array, Number, Boolean],
        },
        data: () => ({
            list: [],
            selected: null,
        }),
        async created() {
            var me = this;
            var temp = await axios.get(axios.fixUrl('/maintenanceRecords'))
            if(temp.data) {
                me.list = temp.data._embedded.maintenanceRecords;
            }

            if(me.value && typeof me.value == "object" && Object.values(me.value)[0]) {
                var id = Object.values(me.value)[0];
                var tmpValue = await axios.get(axios.fixUrl('/maintenanceRecords/' + id))
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

