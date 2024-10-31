<template>
    <div>
    <h1>SettlementManagement</h1>
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
                        SettlementManagement 등록
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
                            [ Id :  {{data.id }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ SettlementType :  {{data.settlementType }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ SettlementDate :  {{data.settlementDate }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ ConfirmationStatus :  {{data.confirmationStatus }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ SettlementPeriodFrom :  {{data.settlementPeriodFrom }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ SettlementPeriodTo :  {{data.settlementPeriodTo }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ VehicleCount1 :  {{data.vehicleCount1 }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ VehicleCount2 :  {{data.vehicleCount2 }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ VehicleCount3 :  {{data.vehicleCount3 }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ VehicleCount4 :  {{data.vehicleCount4 }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ VehicleCount5 :  {{data.vehicleCount5 }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ VehicleCount6 :  {{data.vehicleCount6 }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ OperatingStaff1 :  {{data.operatingStaff1 }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ OperatingStaff2 :  {{data.operatingStaff2 }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ OperatingStaff3 :  {{data.operatingStaff3 }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ OperatingStaff4 :  {{data.operatingStaff4 }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ OperatingStaff5 :  {{data.operatingStaff5 }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ OperatingStaff6 :  {{data.operatingStaff6 }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ MaterialCostPassenger :  {{data.materialCostPassenger }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ MaterialCostBus :  {{data.materialCostBus }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ FuelCostPassenger :  {{data.fuelCostPassenger }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ FuelCostBus :  {{data.fuelCostBus }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ PartsCostPassenger :  {{data.partsCostPassenger }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ PartsCostBus :  {{data.partsCostBus }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ LaborCostPassenger :  {{data.laborCostPassenger }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ LaborCostBus :  {{data.laborCostBus }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ DirectLaborCostPassenger :  {{data.directLaborCostPassenger }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ DirectLaborCostBus :  {{data.directLaborCostBus }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ IndirectLaborCostPassenger :  {{data.indirectLaborCostPassenger }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ IndirectLaborCostBus :  {{data.indirectLaborCostBus }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ ExpensesPassenger :  {{data.expensesPassenger }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ SettlementInfo :  {{data.settlementInfo }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ SettlementPeriod :  {{data.settlementPeriod }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ Amount :  {{data.amount }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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

