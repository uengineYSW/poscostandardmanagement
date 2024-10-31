<template>
    <v-card outlined>
        <v-card-title>
            DeleteOperationRecord
        </v-card-title>

        <v-card-text>
            <Number label="VehicleId" v-model="value.vehicleId" :editMode="editMode"/>
            <Date label="OperationDate" v-model="value.operationDate" :editMode="editMode"/>
            <Number label="OperationSeq" v-model="value.operationSeq" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="deleteOperationRecord"
            >
                DeleteOperationRecord
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
        name: 'DeleteOperationRecordCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.vehicleId = 0;
            this.value.operationDate = '2024-10-31';
            this.value.operationSeq = 0;
        },
        watch: {
        },
        methods: {
            deleteOperationRecord() {
                this.$emit('deleteOperationRecord', this.value);
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

