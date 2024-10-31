<template>
    <v-card outlined>
        <v-card-title>
            CreateVehicleManagement
        </v-card-title>

        <v-card-text>
            <String label="TaxType" v-model="value.taxType" :editMode="editMode"/>
            <String label="EmployeeId" v-model="value.employeeId" :editMode="editMode"/>
            <Date label="Date" v-model="value.date" :editMode="editMode"/>
            <Number label="Seq" v-model="value.seq" :editMode="editMode"/>
            <String label="VehicleType" v-model="value.vehicleType" :editMode="editMode"/>
            <String label="VehicleNumber" v-model="value.vehicleNumber" :editMode="editMode"/>
            <Number label="Amount" v-model="value.amount" :editMode="editMode"/>
            <Number label="Vat" v-model="value.vat" :editMode="editMode"/>
            <Number label="TotalAmount" v-model="value.totalAmount" :editMode="editMode"/>
            <String label="Remarks" v-model="value.remarks" :editMode="editMode"/>
            <VehicleInfo offline label="VehicleInfo" v-model="value.vehicleInfo" :editMode="editMode" @change="change"/>
            <VehicleNumber offline label="VehicleNumber" v-model="value.vehicleNumber" :editMode="editMode" @change="change"/>
            <VehicleType offline label="VehicleType" v-model="value.vehicleType" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createVehicleManagement"
            >
                CreateVehicleManagement
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
        name: 'CreateVehicleManagementCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.taxType = '';
            this.value.employeeId = '';
            this.value.date = '2024-10-31';
            this.value.seq = 0;
            this.value.vehicleType = '';
            this.value.vehicleNumber = '';
            this.value.amount = 0;
            this.value.vat = 0;
            this.value.totalAmount = 0;
            this.value.remarks = '';
            this.value.vehicleInfo = {};
            this.value.vehicleNumber = {};
            this.value.vehicleType = {};
        },
        watch: {
        },
        methods: {
            createVehicleManagement() {
                this.$emit('createVehicleManagement', this.value);
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

