<template>
    <v-card outlined>
        <v-card-title>
            ProcessEmployeeRetirement
        </v-card-title>

        <v-card-text>
            <EmployeeId offline label="EmployeeId" v-model="value.employeeId" :editMode="editMode" @change="change"/>
            <Date label="RetirementDate" v-model="value.retirementDate" :editMode="editMode"/>
            <String label="RetirementStatus" v-model="value.retirementStatus" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="processEmployeeRetirement"
            >
                ProcessEmployeeRetirement
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
        name: 'ProcessEmployeeRetirementCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.employeeId = {};
            this.value.retirementDate = '2024-10-31';
            this.value.retirementStatus = '';
        },
        watch: {
        },
        methods: {
            processEmployeeRetirement() {
                this.$emit('processEmployeeRetirement', this.value);
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

