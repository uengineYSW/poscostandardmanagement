<template>

    <v-card outlined>
        <v-card-title>
            VehicleSpec
        </v-card-title>

        <v-card-text>
            <String label="vehicleTypeCode" v-model="value.VehicleTypeCode" :editMode="editMode"/>
            <String label="vehicleModelCode" v-model="value.VehicleModelCode" :editMode="editMode"/>
            <String label="vehicleYear" v-model="value.VehicleYear" :editMode="editMode"/>
            <String label="output" v-model="value.Output" :editMode="editMode"/>
            <Number label="length" v-model="value.Length" :editMode="editMode"/>
            <Number label="width" v-model="value.Width" :editMode="editMode"/>
            <Number label="height" v-model="value.Height" :editMode="editMode"/>
            <Number label="weight" v-model="value.Weight" :editMode="editMode"/>
            <Number label="loadCapacity" v-model="value.LoadCapacity" :editMode="editMode"/>
            <Number label="displacement" v-model="value.Displacement" :editMode="editMode"/>
            <Number label="seatingCapacity" v-model="value.SeatingCapacity" :editMode="editMode"/>
            <Number label="standardFuelEfficiency" v-model="value.StandardFuelEfficiency" :editMode="editMode"/>
            <Number label="fuelTankCapacity" v-model="value.FuelTankCapacity" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </v-card>
</template>

<script>

    export default {
        name: 'VehicleSpec',
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
                    'VehicleTypeCode': '',
                    'VehicleModelCode': '',
                    'VehicleYear': '',
                    'Output': '',
                    'Length': '',
                    'Width': '',
                    'Height': '',
                    'Weight': '',
                    'LoadCapacity': '',
                    'Displacement': '',
                    'SeatingCapacity': '',
                    'StandardFuelEfficiency': '',
                    'FuelTankCapacity': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('VehicleTypeCode' in this.value)) {
                    this.value.VehicleTypeCode = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('VehicleModelCode' in this.value)) {
                    this.value.VehicleModelCode = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('VehicleYear' in this.value)) {
                    this.value.VehicleYear = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('Output' in this.value)) {
                    this.value.Output = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('Length' in this.value)) {
                    this.value.Length = 0;
                }
            }
            if(typeof this.value === 'object') {
                if(!('Width' in this.value)) {
                    this.value.Width = 0;
                }
            }
            if(typeof this.value === 'object') {
                if(!('Height' in this.value)) {
                    this.value.Height = 0;
                }
            }
            if(typeof this.value === 'object') {
                if(!('Weight' in this.value)) {
                    this.value.Weight = 0;
                }
            }
            if(typeof this.value === 'object') {
                if(!('LoadCapacity' in this.value)) {
                    this.value.LoadCapacity = 0;
                }
            }
            if(typeof this.value === 'object') {
                if(!('Displacement' in this.value)) {
                    this.value.Displacement = 0;
                }
            }
            if(typeof this.value === 'object') {
                if(!('SeatingCapacity' in this.value)) {
                    this.value.SeatingCapacity = 0;
                }
            }
            if(typeof this.value === 'object') {
                if(!('StandardFuelEfficiency' in this.value)) {
                    this.value.StandardFuelEfficiency = 0;
                }
            }
            if(typeof this.value === 'object') {
                if(!('FuelTankCapacity' in this.value)) {
                    this.value.FuelTankCapacity = 0;
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

