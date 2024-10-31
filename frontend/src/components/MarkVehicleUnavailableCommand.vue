<template>
    <v-card outlined>
        <v-card-title>
            MarkVehicleUnavailable
        </v-card-title>

        <v-card-text>
            <Number label="VehicleId" v-model="value.vehicleId" :editMode="editMode"/>
            <String label="UnavailabilityReason" v-model="value.unavailabilityReason" :editMode="editMode"/>
            <Date label="UnavailabilityDate" v-model="value.unavailabilityDate" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="markVehicleUnavailable"
            >
                MarkVehicleUnavailable
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
        name: 'MarkVehicleUnavailableCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.vehicleId = 0;
            this.value.unavailabilityReason = '';
            this.value.unavailabilityDate = '2024-10-31';
        },
        watch: {
        },
        methods: {
            markVehicleUnavailable() {
                this.$emit('markVehicleUnavailable', this.value);
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

