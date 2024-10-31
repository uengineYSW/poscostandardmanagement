<template>
    <v-card outlined>
        <v-card-title>
            CreateInsuranceInfo
        </v-card-title>

        <v-card-text>
            <Number label="VehicleId" v-model="value.vehicleId" :editMode="editMode"/>
            <Date label="InsuranceJoinDate" v-model="value.insuranceJoinDate" :editMode="editMode"/>
            <Date label="ValidityFromDate" v-model="value.validityFromDate" :editMode="editMode"/>
            <Date label="ValidityToDate" v-model="value.validityToDate" :editMode="editMode"/>
            <String label="InsuranceCompany" v-model="value.insuranceCompany" :editMode="editMode"/>
            <Number label="DiscountRate" v-model="value.discountRate" :editMode="editMode"/>
            <Number label="LiabilityInsuranceI" v-model="value.liabilityInsuranceI" :editMode="editMode"/>
            <Number label="LiabilityInsuranceIi" v-model="value.liabilityInsuranceIi" :editMode="editMode"/>
            <Number label="PropertyDamage" v-model="value.propertyDamage" :editMode="editMode"/>
            <Number label="PersonalInjury" v-model="value.personalInjury" :editMode="editMode"/>
            <Number label="UninsuredVehicleDamage" v-model="value.uninsuredVehicleDamage" :editMode="editMode"/>
            <Number label="OwnVehicleDamage" v-model="value.ownVehicleDamage" :editMode="editMode"/>
            <Number label="SpecialItems" v-model="value.specialItems" :editMode="editMode"/>
            <String label="Remarks" v-model="value.remarks" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createInsuranceInfo"
            >
                CreateInsuranceInfo
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
        name: 'CreateInsuranceInfoCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.vehicleId = 0;
            this.value.insuranceJoinDate = '2024-10-31';
            this.value.validityFromDate = '2024-10-31';
            this.value.validityToDate = '2024-10-31';
            this.value.insuranceCompany = '';
            this.value.discountRate = 0;
            this.value.liabilityInsuranceI = 0;
            this.value.liabilityInsuranceIi = 0;
            this.value.propertyDamage = 0;
            this.value.personalInjury = 0;
            this.value.uninsuredVehicleDamage = 0;
            this.value.ownVehicleDamage = 0;
            this.value.specialItems = 0;
            this.value.remarks = '';
        },
        watch: {
        },
        methods: {
            createInsuranceInfo() {
                this.$emit('createInsuranceInfo', this.value);
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

