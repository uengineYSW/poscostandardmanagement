<template>

    <v-card outlined>
        <v-card-title>
            EmployeeId
        </v-card-title>

        <v-card-text>
            <String label="employeeId" v-model="value.EmployeeId" :editMode="editMode"/>
            <Number label="EmployNumber" v-model="value.employNumber" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </v-card>
</template>

<script>

    export default {
        name: 'EmployeeId',
        components:{},
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
            inList: Boolean,
            label: String,
        },
        data: () => ({
        }),
        async created() {
            if(!Object.values(this.value)[0]) {
                this.$emit('input', {});
                this.newValue = {
                    'EmployeeId': '',
                    'employNumber': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('EmployeeId' in this.value)) {
                    this.value.EmployeeId = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('employNumber' in this.value)) {
                    this.value.employNumber = 0;
                }
            }
        },
        watch: {
            value(val) {
                this.$emit('input', val);
            },
            newValue(val) {
                this.$emit('input', val);
            },
        },

        methods: {
            edit() {
                this.editMode = true;
            },
            async add() {
                this.editMode = false;
                this.$emit('input', this.value);

                if(this.isNew){
                    this.$emit('add', this.value);
                } else {
                    this.$emit('edit', this.value);
                }
            },
            async remove(){
                this.editMode = false;
                this.isDeleted = true;

                this.$emit('input', this.value);
                this.$emit('delete', this.value);
            },
            change(){
                this.$emit('change', this.value);
            },
        }
    }
</script>

