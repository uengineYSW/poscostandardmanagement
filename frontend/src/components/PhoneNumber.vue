<template>

    <v-card outlined>
        <v-card-title>
            PhoneNumber
        </v-card-title>

        <v-card-text>
            <String label="officePhoneNumber" v-model="value.OfficePhoneNumber" :editMode="editMode"/>
            <String label="mobilePhoneNumber" v-model="value.MobilePhoneNumber" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </v-card>
</template>

<script>

    export default {
        name: 'PhoneNumber',
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
                    'OfficePhoneNumber': '',
                    'MobilePhoneNumber': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('OfficePhoneNumber' in this.value)) {
                    this.value.OfficePhoneNumber = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('MobilePhoneNumber' in this.value)) {
                    this.value.MobilePhoneNumber = '';
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

