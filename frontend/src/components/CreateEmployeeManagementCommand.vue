<template>
    <v-card outlined>
        <v-card-title>
            CreateEmployeeManagement
        </v-card-title>

        <v-card-text>
            <String label="EmployeeId" v-model="value.employeeId" :editMode="editMode"/>
            <String label="Name" v-model="value.name" :editMode="editMode"/>
            <String label="Company" v-model="value.company" :editMode="editMode"/>
            <String label="ResponsibleSettlement" v-model="value.responsibleSettlement" :editMode="editMode"/>
            <String label="Position" v-model="value.position" :editMode="editMode"/>
            <String label="ResponsibleTask" v-model="value.responsibleTask" :editMode="editMode"/>
            <String label="PhoneNumber" v-model="value.phoneNumber" :editMode="editMode"/>
            <String label="LicenseNumber" v-model="value.licenseNumber" :editMode="editMode"/>
            <String label="IdNumber" v-model="value.idNumber" :editMode="editMode"/>
            <String label="ResponsibleVehicleNumber" v-model="value.responsibleVehicleNumber" :editMode="editMode"/>
            <String label="VehicleType" v-model="value.vehicleType" :editMode="editMode"/>
            <String label="RetirementStatus" v-model="value.retirementStatus" :editMode="editMode"/>
            <Date label="RetirementDate" v-model="value.retirementDate" :editMode="editMode"/>
            <String label="Photo" v-model="value.photo" :editMode="editMode"/>
            <String label="Remarks" v-model="value.remarks" :editMode="editMode"/>
            <EmployeeInfo offline label="EmployeeInfo" v-model="value.employeeInfo" :editMode="editMode" @change="change"/>
            <EmployeeId offline label="EmployeeId" v-model="value.employeeId" :editMode="editMode" @change="change"/>
            <Name offline label="Name" v-model="value.name" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createEmployeeManagement"
            >
                CreateEmployeeManagement
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
        name: 'CreateEmployeeManagementCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.employeeId = '';
            this.value.name = '';
            this.value.company = '';
            this.value.responsibleSettlement = '';
            this.value.position = '';
            this.value.responsibleTask = '';
            this.value.phoneNumber = '';
            this.value.licenseNumber = '';
            this.value.idNumber = '';
            this.value.responsibleVehicleNumber = '';
            this.value.vehicleType = '';
            this.value.retirementStatus = '';
            this.value.retirementDate = '2024-10-31';
            this.value.photo = '';
            this.value.remarks = '';
            this.value.employeeInfo = {};
            this.value.employeeId = {};
            this.value.name = {};
        },
        watch: {
        },
        methods: {
            createEmployeeManagement() {
                this.$emit('createEmployeeManagement', this.value);
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

