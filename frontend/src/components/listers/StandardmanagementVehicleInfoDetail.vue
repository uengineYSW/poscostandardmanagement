<template>
    <v-card outlined>
        <v-card-title>
            VehicleInfo # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="VehicleId" v-model="item.vehicleId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="VehicleNumber" v-model="item.vehicleNumber" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Classification" v-model="item.classification" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ManufacturerCode" v-model="item.manufacturerCode" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="VehicleTypeCode" v-model="item.vehicleTypeCode" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="VehicleModelCode" v-model="item.vehicleModelCode" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="UsageCode" v-model="item.usageCode" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="FuelType" v-model="item.fuelType" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="VehicleAffiliationCode" v-model="item.vehicleAffiliationCode" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="AssetCode" v-model="item.assetCode" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="OperatingDepartment" v-model="item.operatingDepartment" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="AcquisitionAmount" v-model="item.acquisitionAmount" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ResponsibleDriverId" v-model="item.responsibleDriverId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="MainUser" v-model="item.mainUser" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="VehicleRegistrationDate" v-model="item.vehicleRegistrationDate" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="VehicleSaleDate" v-model="item.vehicleSaleDate" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ChassisNumber" v-model="item.chassisNumber" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="VehicleFormat" v-model="item.vehicleFormat" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="VehicleYear" v-model="item.vehicleYear" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Output" v-model="item.output" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Length" v-model="item.length" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Width" v-model="item.width" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Height" v-model="item.height" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Weight" v-model="item.weight" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="LoadCapacity" v-model="item.loadCapacity" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Displacement" v-model="item.displacement" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="SeatingCapacity" v-model="item.seatingCapacity" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="StandardFuelEfficiency" v-model="item.standardFuelEfficiency" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="FuelTankCapacity" v-model="item.fuelTankCapacity" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="DepartureKm" v-model="item.departureKm" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="AccumulatedKm" v-model="item.accumulatedKm" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="TotalAccumulatedKm" v-model="item.totalAccumulatedKm" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="RegularInspectionDate" v-model="item.regularInspectionDate" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Remarks" v-model="item.remarks" :editMode="editMode" @change="change" />
            </div>
            <VehicleSpec offline label="VehicleSpec" v-model="item.vehicleSpec" :editMode="false" :key="false" @change="change" />
            <VehicleOwnership offline label="VehicleOwnership" v-model="item.vehicleOwnership" :editMode="false" :key="false" @change="change" />
            <div>
                <String label="UnavailabilityReason" v-model="item.unavailabilityReason" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="UnavailabilityDate" v-model="item.unavailabilityDate" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>

        <v-card-actions>
            <v-btn text color="deep-purple lighten-2" large @click="goList">List</v-btn>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="edit"
                    v-if="!editMode"
            >
                Edit
            </v-btn>
            <v-btn
                    color="primary"
                    text
                    @click="save"
                    v-else
            >
                Save
            </v-btn>
            <v-btn
                    color="primary"
                    text
                    @click="remove"
                    v-if="!editMode"
            >
                Delete
            </v-btn>
            <v-btn
                    color="primary"
                    text
                    @click="editMode = false"
                    v-if="editMode"
            >
                Cancel
            </v-btn>
        </v-card-actions>
    </v-card>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'StandardmanagementVehicleInfoDetail',
        components:{},
        props: {
        },
        data: () => ({
            item: null,
            editMode: false,
        }),
        async created() {
            var me = this;
            var params = this.$route.params;
            var temp = await axios.get(axios.fixUrl('/vehicleInfos/' + params.id))
            if(temp.data) {
                me.item = temp.data
            }
        },
        methods: {
            goList() {
                var path = window.location.href.slice(window.location.href.indexOf("/#/"), window.location.href.lastIndexOf("/#"));
                path = path.replace("/#/", "/");
                this.$router.push(path);
            },
            edit() {
                this.editMode = true;
            },
            async remove(){
                try {
                    if (!this.offline) {
                        await axios.delete(axios.fixUrl(this.item._links.self.href))
                    }

                    this.editMode = false;

                    this.$emit('input', this.item);
                    this.$emit('delete', this.item);

                } catch(e) {
                    console.log(e)
                }
            },
        },
    };
</script>
