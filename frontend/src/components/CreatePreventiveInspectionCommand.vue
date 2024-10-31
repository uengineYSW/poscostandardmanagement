<template>
    <v-card outlined>
        <v-card-title>
            CreatePreventiveInspection
        </v-card-title>

        <v-card-text>
            <Number label="VehicleId" v-model="value.vehicleId" :editMode="editMode"/>
            <String label="InspectionContent" v-model="value.inspectionContent" :editMode="editMode"/>
            <String label="RegularCheckStandard" v-model="value.regularCheckStandard" :editMode="editMode"/>
            <Number label="StandardKm" v-model="value.standardKm" :editMode="editMode"/>
            <Number label="RecentInspectionKm" v-model="value.recentInspectionKm" :editMode="editMode"/>
            <Number label="InspectionScheduledKm" v-model="value.inspectionScheduledKm" :editMode="editMode"/>
            <Number label="StandardReport" v-model="value.standardReport" :editMode="editMode"/>
            <Date label="RecentInspectionDate" v-model="value.recentInspectionDate" :editMode="editMode"/>
            <Date label="InspectionScheduledDate" v-model="value.inspectionScheduledDate" :editMode="editMode"/>
            <String label="Remarks" v-model="value.remarks" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createPreventiveInspection"
            >
                CreatePreventiveInspection
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
        name: 'CreatePreventiveInspectionCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.vehicleId = 0;
            this.value.inspectionContent = '';
            this.value.regularCheckStandard = '';
            this.value.standardKm = 0;
            this.value.recentInspectionKm = 0;
            this.value.inspectionScheduledKm = 0;
            this.value.standardReport = 0;
            this.value.recentInspectionDate = '2024-10-31';
            this.value.inspectionScheduledDate = '2024-10-31';
            this.value.remarks = '';
        },
        watch: {
        },
        methods: {
            createPreventiveInspection() {
                this.$emit('createPreventiveInspection', this.value);
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

