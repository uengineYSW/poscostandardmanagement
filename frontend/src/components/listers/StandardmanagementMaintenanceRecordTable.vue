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

                    <StandardmanagementMaintenanceRecord :offline="offline" class="video-card" :isNew="true" :editMode="true" v-model="newValue" @add="append" v-if="tick"/>
                
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
    import StandardmanagementMaintenanceRecord from './../StandardmanagementMaintenanceRecord.vue';

    export default {
        name: 'StandardmanagementMaintenanceRecordManager',
        components: {
            StandardmanagementMaintenanceRecord,
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
                    { text: "maintenanceDate", value: "maintenanceDate" },
                    { text: "maintenanceSeq", value: "maintenanceSeq" },
                    { text: "maintenanceCompanyCode", value: "maintenanceCompanyCode" },
                    { text: "maintenanceItemCode", value: "maintenanceItemCode" },
                    { text: "maintenanceItemName", value: "maintenanceItemName" },
                    { text: "unit", value: "unit" },
                    { text: "quantity", value: "quantity" },
                    { text: "unitPrice", value: "unitPrice" },
                    { text: "supplyAmount", value: "supplyAmount" },
                    { text: "tax", value: "tax" },
                    { text: "amount", value: "amount" },
                    { text: "preventiveMaintenance", value: "preventiveMaintenance" },
                    { text: "preventiveMaintenanceItem", value: "preventiveMaintenanceItem" },
                    { text: "remarks", value: "remarks" },
                ],
            maintenanceRecord : [],
            newValue: {},
            tick : true,
            openDialog : false,
        }),
        async created() {
            if(this.offline){
                if(!this.values) this.values = [];
                return;
            }

            var temp = await axios.get(axios.fixUrl('/maintenancerecords'))
            temp.data._embedded.maintenancerecords.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])
            this.values = temp.data._embedded.maintenancerecords;

            this.newValue = {
                'vehicleId': 0,
                'maintenanceDate': '2024-10-31',
                'maintenanceSeq': 0,
                'maintenanceCompanyCode': '',
                'maintenanceItemCode': '',
                'maintenanceItemName': '',
                'unit': '',
                'quantity': 0,
                'unitPrice': 0,
                'supplyAmount': 0,
                'tax': 0,
                'amount': 0,
                'preventiveMaintenance': '',
                'preventiveMaintenanceItem': '',
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

