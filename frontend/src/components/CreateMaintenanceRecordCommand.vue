<template>
    <v-card outlined>
        <v-card-title>
            CreateMaintenanceRecord
        </v-card-title>

        <v-card-text>
            <Number label="VehicleId" v-model="value.vehicleId" :editMode="editMode"/>
            <Date label="MaintenanceDate" v-model="value.maintenanceDate" :editMode="editMode"/>
            <Number label="MaintenanceSeq" v-model="value.maintenanceSeq" :editMode="editMode"/>
            <String label="MaintenanceCompanyCode" v-model="value.maintenanceCompanyCode" :editMode="editMode"/>
            <String label="MaintenanceItemCode" v-model="value.maintenanceItemCode" :editMode="editMode"/>
            <String label="MaintenanceItemName" v-model="value.maintenanceItemName" :editMode="editMode"/>
            <String label="Unit" v-model="value.unit" :editMode="editMode"/>
            <Number label="Quantity" v-model="value.quantity" :editMode="editMode"/>
            <Number label="UnitPrice" v-model="value.unitPrice" :editMode="editMode"/>
            <Number label="SupplyAmount" v-model="value.supplyAmount" :editMode="editMode"/>
            <Number label="Tax" v-model="value.tax" :editMode="editMode"/>
            <Number label="Amount" v-model="value.amount" :editMode="editMode"/>
            <String label="PreventiveMaintenance" v-model="value.preventiveMaintenance" :editMode="editMode"/>
            <String label="PreventiveMaintenanceItem" v-model="value.preventiveMaintenanceItem" :editMode="editMode"/>
            <String label="Remarks" v-model="value.remarks" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createMaintenanceRecord"
            >
                CreateMaintenanceRecord
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
        name: 'CreateMaintenanceRecordCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.vehicleId = 0;
            this.value.maintenanceDate = '2024-10-31';
            this.value.maintenanceSeq = 0;
            this.value.maintenanceCompanyCode = '';
            this.value.maintenanceItemCode = '';
            this.value.maintenanceItemName = '';
            this.value.unit = '';
            this.value.quantity = 0;
            this.value.unitPrice = 0;
            this.value.supplyAmount = 0;
            this.value.tax = 0;
            this.value.amount = 0;
            this.value.preventiveMaintenance = '';
            this.value.preventiveMaintenanceItem = '';
            this.value.remarks = '';
        },
        watch: {
        },
        methods: {
            createMaintenanceRecord() {
                this.$emit('createMaintenanceRecord', this.value);
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

