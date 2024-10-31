<template>

    <v-card outlined>
        <v-card-title>
            SettlementInfo
        </v-card-title>

        <v-card-text>
            <String label="SettlementType" v-model="value.settlementType" :editMode="editMode"/>
            <Date label="SettlementDate" v-model="value.settlementDate" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </v-card>
</template>

<script>

    export default {
        name: 'SettlementInfo',
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
                    'id': '',
                    'settlementType': '',
                    'settlementDate': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('settlementType' in this.value)) {
                    this.value.settlementType = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('settlementDate' in this.value)) {
                    this.value.settlementDate = '2024-10-31';
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

