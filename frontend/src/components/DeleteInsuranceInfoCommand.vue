<template>
    <v-card outlined>
        <v-card-title>
            DeleteInsuranceInfo
        </v-card-title>

        <v-card-text>
            <Number label="VehicleId" v-model="value.vehicleId" :editMode="editMode"/>
            <Date label="InsuranceJoinDate" v-model="value.insuranceJoinDate" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="deleteInsuranceInfo"
            >
                DeleteInsuranceInfo
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
        name: 'DeleteInsuranceInfoCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.vehicleId = 0;
            this.value.insuranceJoinDate = '2024-10-31';
        },
        watch: {
        },
        methods: {
            deleteInsuranceInfo() {
                this.$emit('deleteInsuranceInfo', this.value);
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

