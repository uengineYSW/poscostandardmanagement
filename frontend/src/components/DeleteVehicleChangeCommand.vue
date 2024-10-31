<template>
    <v-card outlined>
        <v-card-title>
            DeleteVehicleChange
        </v-card-title>

        <v-card-text>
            <Number label="VehicleId" v-model="value.vehicleId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="deleteVehicleChange"
            >
                DeleteVehicleChange
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
        name: 'DeleteVehicleChangeCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.vehicleId = 0;
        },
        watch: {
        },
        methods: {
            deleteVehicleChange() {
                this.$emit('deleteVehicleChange', this.value);
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

