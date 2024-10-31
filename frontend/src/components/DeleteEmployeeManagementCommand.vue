<template>
    <v-card outlined>
        <v-card-title>
            DeleteEmployeeManagement
        </v-card-title>

        <v-card-text>
            <String label="EmployeeId" v-model="value.employeeId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="deleteEmployeeManagement"
            >
                DeleteEmployeeManagement
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
        name: 'DeleteEmployeeManagementCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.employeeId = '';
        },
        watch: {
        },
        methods: {
            deleteEmployeeManagement() {
                this.$emit('deleteEmployeeManagement', this.value);
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

