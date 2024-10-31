<template>
    <v-card outlined>
        <v-card-title>
            CreateAccidentRecord
        </v-card-title>

        <v-card-text>
            <Number label="VehicleId" v-model="value.vehicleId" :editMode="editMode"/>
            <Date label="AccidentDate" v-model="value.accidentDate" :editMode="editMode"/>
            <String label="AccidentType" v-model="value.accidentType" :editMode="editMode"/>
            <String label="AccidentPerson" v-model="value.accidentPerson" :editMode="editMode"/>
            <String label="Confirmer" v-model="value.confirmer" :editMode="editMode"/>
            <String label="AccidentDetail" v-model="value.accidentDetail" :editMode="editMode"/>
            <String label="Remarks" v-model="value.remarks" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createAccidentRecord"
            >
                CreateAccidentRecord
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
        name: 'CreateAccidentRecordCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.vehicleId = 0;
            this.value.accidentDate = '2024-10-31';
            this.value.accidentType = '';
            this.value.accidentPerson = '';
            this.value.confirmer = '';
            this.value.accidentDetail = '';
            this.value.remarks = '';
        },
        watch: {
        },
        methods: {
            createAccidentRecord() {
                this.$emit('createAccidentRecord', this.value);
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

