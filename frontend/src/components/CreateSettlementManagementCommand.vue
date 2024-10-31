<template>
    <v-card outlined>
        <v-card-title>
            CreateSettlementManagement
        </v-card-title>

        <v-card-text>
            <Number label="Id" v-model="value.id" :editMode="editMode"/>
            <String label="SettlementType" v-model="value.settlementType" :editMode="editMode"/>
            <Date label="SettlementDate" v-model="value.settlementDate" :editMode="editMode"/>
            <String label="ConfirmationStatus" v-model="value.confirmationStatus" :editMode="editMode"/>
            <Date label="SettlementPeriodFrom" v-model="value.settlementPeriodFrom" :editMode="editMode"/>
            <Date label="SettlementPeriodTo" v-model="value.settlementPeriodTo" :editMode="editMode"/>
            <Number label="VehicleCount1" v-model="value.vehicleCount1" :editMode="editMode"/>
            <Number label="VehicleCount2" v-model="value.vehicleCount2" :editMode="editMode"/>
            <Number label="VehicleCount3" v-model="value.vehicleCount3" :editMode="editMode"/>
            <Number label="VehicleCount4" v-model="value.vehicleCount4" :editMode="editMode"/>
            <Number label="VehicleCount5" v-model="value.vehicleCount5" :editMode="editMode"/>
            <Number label="VehicleCount6" v-model="value.vehicleCount6" :editMode="editMode"/>
            <Number label="OperatingStaff1" v-model="value.operatingStaff1" :editMode="editMode"/>
            <Number label="OperatingStaff2" v-model="value.operatingStaff2" :editMode="editMode"/>
            <Number label="OperatingStaff3" v-model="value.operatingStaff3" :editMode="editMode"/>
            <Number label="OperatingStaff4" v-model="value.operatingStaff4" :editMode="editMode"/>
            <Number label="OperatingStaff5" v-model="value.operatingStaff5" :editMode="editMode"/>
            <Number label="OperatingStaff6" v-model="value.operatingStaff6" :editMode="editMode"/>
            <Number label="MaterialCostPassenger" v-model="value.materialCostPassenger" :editMode="editMode"/>
            <Number label="MaterialCostBus" v-model="value.materialCostBus" :editMode="editMode"/>
            <Number label="FuelCostPassenger" v-model="value.fuelCostPassenger" :editMode="editMode"/>
            <Number label="FuelCostBus" v-model="value.fuelCostBus" :editMode="editMode"/>
            <Number label="PartsCostPassenger" v-model="value.partsCostPassenger" :editMode="editMode"/>
            <Number label="PartsCostBus" v-model="value.partsCostBus" :editMode="editMode"/>
            <Number label="LaborCostPassenger" v-model="value.laborCostPassenger" :editMode="editMode"/>
            <Number label="LaborCostBus" v-model="value.laborCostBus" :editMode="editMode"/>
            <Number label="DirectLaborCostPassenger" v-model="value.directLaborCostPassenger" :editMode="editMode"/>
            <Number label="DirectLaborCostBus" v-model="value.directLaborCostBus" :editMode="editMode"/>
            <Number label="IndirectLaborCostPassenger" v-model="value.indirectLaborCostPassenger" :editMode="editMode"/>
            <Number label="IndirectLaborCostBus" v-model="value.indirectLaborCostBus" :editMode="editMode"/>
            <Number label="ExpensesPassenger" v-model="value.expensesPassenger" :editMode="editMode"/>
            <SettlementInfo offline label="SettlementInfo" v-model="value.settlementInfo" :editMode="editMode" @change="change"/>
            <SettlementPeriod offline label="SettlementPeriod" v-model="value.settlementPeriod" :editMode="editMode" @change="change"/>
            <Amount offline label="Amount" v-model="value.amount" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createSettlementManagement"
            >
                CreateSettlementManagement
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'CreateSettlementManagementCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.id = 0;
            this.value.settlementType = '';
            this.value.settlementDate = '2024-10-31';
            this.value.confirmationStatus = '';
            this.value.settlementPeriodFrom = '2024-10-31';
            this.value.settlementPeriodTo = '2024-10-31';
            this.value.vehicleCount1 = 0;
            this.value.vehicleCount2 = 0;
            this.value.vehicleCount3 = 0;
            this.value.vehicleCount4 = 0;
            this.value.vehicleCount5 = 0;
            this.value.vehicleCount6 = 0;
            this.value.operatingStaff1 = 0;
            this.value.operatingStaff2 = 0;
            this.value.operatingStaff3 = 0;
            this.value.operatingStaff4 = 0;
            this.value.operatingStaff5 = 0;
            this.value.operatingStaff6 = 0;
            this.value.materialCostPassenger = 0;
            this.value.materialCostBus = 0;
            this.value.fuelCostPassenger = 0;
            this.value.fuelCostBus = 0;
            this.value.partsCostPassenger = 0;
            this.value.partsCostBus = 0;
            this.value.laborCostPassenger = 0;
            this.value.laborCostBus = 0;
            this.value.directLaborCostPassenger = 0;
            this.value.directLaborCostBus = 0;
            this.value.indirectLaborCostPassenger = 0;
            this.value.indirectLaborCostBus = 0;
            this.value.expensesPassenger = 0;
            this.value.settlementInfo = {};
            this.value.settlementPeriod = {};
            this.value.amount = {};
        },
        watch: {
        },
        methods: {
            createSettlementManagement() {
                this.$emit('createSettlementManagement', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

