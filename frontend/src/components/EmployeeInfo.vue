<template>

    <v-card outlined>
        <v-card-title>
            EmployeeInfo
        </v-card-title>

        <v-card-text>
            <String label="employeeId" v-model="value.EmployeeId" :editMode="editMode"/>
            <String label="name" v-model="value.Name" :editMode="editMode"/>
            <String label="company" v-model="value.Company" :editMode="editMode"/>
            <String label="responsibleSettlement" v-model="value.ResponsibleSettlement" :editMode="editMode"/>
            <String label="position" v-model="value.Position" :editMode="editMode"/>
            <String label="responsibleTask" v-model="value.ResponsibleTask" :editMode="editMode"/>
            <String label="phoneNumber" v-model="value.PhoneNumber" :editMode="editMode"/>
            <String label="licenseNumber" v-model="value.LicenseNumber" :editMode="editMode"/>
            <String label="idNumber" v-model="value.IdNumber" :editMode="editMode"/>
            <String label="responsibleVehicleNumber" v-model="value.ResponsibleVehicleNumber" :editMode="editMode"/>
            <String label="vehicleType" v-model="value.VehicleType" :editMode="editMode"/>
            <String label="retirementStatus" v-model="value.RetirementStatus" :editMode="editMode"/>
            <Date label="retirementDate" v-model="value.RetirementDate" :editMode="editMode"/>
            <String label="photo" v-model="value.Photo" :editMode="editMode"/>
            <String label="remarks" v-model="value.Remarks" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </v-card>
</template>

<script>

    export default {
        name: 'EmployeeInfo',
        components:{},
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
            inList: Boolean,
            label: String,
        },
        data: () => ({
        }),
        async created() {
            if(!Object.values(this.value)[0]) {
                this.$emit('input', {});
                this.newValue = {
                    'EmployeeId': '',
                    'Name': '',
                    'Company': '',
                    'ResponsibleSettlement': '',
                    'Position': '',
                    'ResponsibleTask': '',
                    'PhoneNumber': '',
                    'LicenseNumber': '',
                    'IdNumber': '',
                    'ResponsibleVehicleNumber': '',
                    'VehicleType': '',
                    'RetirementStatus': '',
                    'RetirementDate': '',
                    'Photo': '',
                    'Remarks': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('EmployeeId' in this.value)) {
                    this.value.EmployeeId = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('Name' in this.value)) {
                    this.value.Name = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('Company' in this.value)) {
                    this.value.Company = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('ResponsibleSettlement' in this.value)) {
                    this.value.ResponsibleSettlement = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('Position' in this.value)) {
                    this.value.Position = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('ResponsibleTask' in this.value)) {
                    this.value.ResponsibleTask = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('PhoneNumber' in this.value)) {
                    this.value.PhoneNumber = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('LicenseNumber' in this.value)) {
                    this.value.LicenseNumber = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('IdNumber' in this.value)) {
                    this.value.IdNumber = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('ResponsibleVehicleNumber' in this.value)) {
                    this.value.ResponsibleVehicleNumber = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('VehicleType' in this.value)) {
                    this.value.VehicleType = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('RetirementStatus' in this.value)) {
                    this.value.RetirementStatus = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('RetirementDate' in this.value)) {
                    this.value.RetirementDate = '2024-10-31';
                }
            }
            if(typeof this.value === 'object') {
                if(!('Photo' in this.value)) {
                    this.value.Photo = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('Remarks' in this.value)) {
                    this.value.Remarks = '';
                }
            }
        },
        watch: {
            value(val) {
                this.$emit('input', val);
            },
            newValue(val) {
                this.$emit('input', val);
            },
        },

        methods: {
            edit() {
                this.editMode = true;
            },
            async add() {
                this.editMode = false;
                this.$emit('input', this.value);

                if(this.isNew){
                    this.$emit('add', this.value);
                } else {
                    this.$emit('edit', this.value);
                }
            },
            async remove(){
                this.editMode = false;
                this.isDeleted = true;

                this.$emit('input', this.value);
                this.$emit('delete', this.value);
            },
            change(){
                this.$emit('change', this.value);
            },
        }
    }
</script>

