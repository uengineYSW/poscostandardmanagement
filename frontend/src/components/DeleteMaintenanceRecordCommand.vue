<template>
    <v-card outlined>
        <v-card-title>
            DeleteMaintenanceRecord
        </v-card-title>

        <v-card-text>
            <Number label="VehicleId" v-model="value.vehicleId" :editMode="editMode"/>
            <Date label="MaintenanceDate" v-model="value.maintenanceDate" :editMode="editMode"/>
            <Number label="MaintenanceSeq" v-model="value.maintenanceSeq" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="deleteMaintenanceRecord"
            >
                DeleteMaintenanceRecord
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
        name: 'DeleteMaintenanceRecordCommand',
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
        },
        watch: {
        },
        methods: {
            deleteMaintenanceRecord() {
                this.$emit('deleteMaintenanceRecord', this.value);
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

