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

                    <OthermanagementSettlementManagement :offline="offline" class="video-card" :isNew="true" :editMode="true" v-model="newValue" @add="append" v-if="tick"/>
                
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
    import OthermanagementSettlementManagement from './../OthermanagementSettlementManagement.vue';

    export default {
        name: 'OthermanagementSettlementManagementManager',
        components: {
            OthermanagementSettlementManagement,
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
                    { text: "id", value: "id" },
                    { text: "settlementType", value: "settlementType" },
                    { text: "settlementDate", value: "settlementDate" },
                    { text: "confirmationStatus", value: "confirmationStatus" },
                    { text: "settlementPeriodFrom", value: "settlementPeriodFrom" },
                    { text: "settlementPeriodTo", value: "settlementPeriodTo" },
                    { text: "vehicleCount1", value: "vehicleCount1" },
                    { text: "vehicleCount2", value: "vehicleCount2" },
                    { text: "vehicleCount3", value: "vehicleCount3" },
                    { text: "vehicleCount4", value: "vehicleCount4" },
                    { text: "vehicleCount5", value: "vehicleCount5" },
                    { text: "vehicleCount6", value: "vehicleCount6" },
                    { text: "operatingStaff1", value: "operatingStaff1" },
                    { text: "operatingStaff2", value: "operatingStaff2" },
                    { text: "operatingStaff3", value: "operatingStaff3" },
                    { text: "operatingStaff4", value: "operatingStaff4" },
                    { text: "operatingStaff5", value: "operatingStaff5" },
                    { text: "operatingStaff6", value: "operatingStaff6" },
                    { text: "materialCostPassenger", value: "materialCostPassenger" },
                    { text: "materialCostBus", value: "materialCostBus" },
                    { text: "fuelCostPassenger", value: "fuelCostPassenger" },
                    { text: "fuelCostBus", value: "fuelCostBus" },
                    { text: "partsCostPassenger", value: "partsCostPassenger" },
                    { text: "partsCostBus", value: "partsCostBus" },
                    { text: "laborCostPassenger", value: "laborCostPassenger" },
                    { text: "laborCostBus", value: "laborCostBus" },
                    { text: "directLaborCostPassenger", value: "directLaborCostPassenger" },
                    { text: "directLaborCostBus", value: "directLaborCostBus" },
                    { text: "indirectLaborCostPassenger", value: "indirectLaborCostPassenger" },
                    { text: "indirectLaborCostBus", value: "indirectLaborCostBus" },
                    { text: "expensesPassenger", value: "expensesPassenger" },
                    { text: "settlementInfo", value: "settlementInfo" },
                    { text: "settlementPeriod", value: "settlementPeriod" },
                    { text: "amount", value: "amount" },
                ],
            settlementManagement : [],
            newValue: {},
            tick : true,
            openDialog : false,
        }),
        async created() {
            if(this.offline){
                if(!this.values) this.values = [];
                return;
            }

            var temp = await axios.get(axios.fixUrl('/settlementmanagements'))
            temp.data._embedded.settlementmanagements.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])
            this.values = temp.data._embedded.settlementmanagements;

            this.newValue = {
                'settlementType': '',
                'settlementDate': '2024-10-31',
                'confirmationStatus': '',
                'settlementPeriodFrom': '2024-10-31',
                'settlementPeriodTo': '2024-10-31',
                'vehicleCount1': 0,
                'vehicleCount2': 0,
                'vehicleCount3': 0,
                'vehicleCount4': 0,
                'vehicleCount5': 0,
                'vehicleCount6': 0,
                'operatingStaff1': 0,
                'operatingStaff2': 0,
                'operatingStaff3': 0,
                'operatingStaff4': 0,
                'operatingStaff5': 0,
                'operatingStaff6': 0,
                'materialCostPassenger': 0,
                'materialCostBus': 0,
                'fuelCostPassenger': 0,
                'fuelCostBus': 0,
                'partsCostPassenger': 0,
                'partsCostBus': 0,
                'laborCostPassenger': 0,
                'laborCostBus': 0,
                'directLaborCostPassenger': 0,
                'directLaborCostBus': 0,
                'indirectLaborCostPassenger': 0,
                'indirectLaborCostBus': 0,
                'expensesPassenger': 0,
                'settlementInfo': {},
                'settlementPeriod': {},
                'amount': {},
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

