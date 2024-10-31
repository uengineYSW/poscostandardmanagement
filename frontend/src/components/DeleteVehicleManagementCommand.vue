<template>
    <v-card outlined>
        <v-card-title>
            DeleteVehicleManagement
        </v-card-title>

        <v-card-text>
            <Number label="Seq" v-model="value.seq" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="deleteVehicleManagement"
            >
                DeleteVehicleManagement
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
        name: 'DeleteVehicleManagementCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.seq = 0;
        },
        watch: {
        },
        methods: {
            deleteVehicleManagement() {
                this.$emit('deleteVehicleManagement', this.value);
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

