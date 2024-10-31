<template>

    <v-card outlined>
        <v-card-title>
            VehicleInfo
        </v-card-title>

        <v-card-text>
            <Number label="vehicleNumberId" v-model="value.VehicleNumberId" :editMode="editMode"/>
            <Date label="date" v-model="value.Date" :editMode="editMode"/>
            <Number label="seq" v-model="value.Seq" :editMode="editMode"/>
            <String label="vehicleType" v-model="value.VehicleType" :editMode="editMode"/>
            <String label="item" v-model="value.Item" :editMode="editMode"/>
            <Number label="unitPrice" v-model="value.UnitPrice" :editMode="editMode"/>
            <Number label="quantity" v-model="value.Quantity" :editMode="editMode"/>
            <Number label="supplyAmount" v-model="value.SupplyAmount" :editMode="editMode"/>
            <Number label="vat" v-model="value.Vat" :editMode="editMode"/>
            <Number label="total" v-model="value.Total" :editMode="editMode"/>
            <String label="remarks" v-model="value.Remarks" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </v-card>
</template>

<script>

    export default {
        name: 'VehicleInfo',
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
                    'VehicleNumberId': '',
                    'Date': '',
                    'Seq': '',
                    'VehicleType': '',
                    'Item': '',
                    'UnitPrice': '',
                    'Quantity': '',
                    'SupplyAmount': '',
                    'Vat': '',
                    'Total': '',
                    'Remarks': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('VehicleNumberId' in this.value)) {
                    this.value.VehicleNumberId = 0;
                }
            }
            if(typeof this.value === 'object') {
                if(!('Date' in this.value)) {
                    this.value.Date = '2024-10-31';
                }
            }
            if(typeof this.value === 'object') {
                if(!('Seq' in this.value)) {
                    this.value.Seq = 0;
                }
            }
            if(typeof this.value === 'object') {
                if(!('VehicleType' in this.value)) {
                    this.value.VehicleType = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('Item' in this.value)) {
                    this.value.Item = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('UnitPrice' in this.value)) {
                    this.value.UnitPrice = 0;
                }
            }
            if(typeof this.value === 'object') {
                if(!('Quantity' in this.value)) {
                    this.value.Quantity = 0;
                }
            }
            if(typeof this.value === 'object') {
                if(!('SupplyAmount' in this.value)) {
                    this.value.SupplyAmount = 0;
                }
            }
            if(typeof this.value === 'object') {
                if(!('Vat' in this.value)) {
                    this.value.Vat = 0;
                }
            }
            if(typeof this.value === 'object') {
                if(!('Total' in this.value)) {
                    this.value.Total = 0;
                }
            }
            if(typeof this.value === 'object') {
                if(!('Remarks' in this.value)) {
                    this.value.Remarks = '';
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

