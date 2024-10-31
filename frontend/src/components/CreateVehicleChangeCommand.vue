<template>
    <v-card outlined>
        <v-card-title>
            CreateVehicleChange
        </v-card-title>

        <v-card-text>
            <Number label="VehicleId" v-model="value.vehicleId" :editMode="editMode"/>
            <Date label="ChangeDate" v-model="value.changeDate" :editMode="editMode"/>
            <String label="OldVehicleNumber" v-model="value.oldVehicleNumber" :editMode="editMode"/>
            <String label="ChangeReason" v-model="value.changeReason" :editMode="editMode"/>
            <String label="Remarks" v-model="value.remarks" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createVehicleChange"
            >
                CreateVehicleChange
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
        name: 'CreateVehicleChangeCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.vehicleId = 0;
            this.value.changeDate = '2024-10-31';
            this.value.oldVehicleNumber = '';
            this.value.changeReason = '';
            this.value.remarks = '';
        },
        watch: {
        },
        methods: {
            createVehicleChange() {
                this.$emit('createVehicleChange', this.value);
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

