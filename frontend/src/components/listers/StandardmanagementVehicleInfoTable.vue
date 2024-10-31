<template>
    <div>
        <v-data-table
                :headers="headers"
                :items="values"
                :items-per-page="5"
                class="elevation-1"
        ></v-data-table>

        <v-col style="margin-bottom:40px;">
            <div class="text-center">
                <v-dialog
                        v-model="openDialog"
                        width="332.5"
                        fullscreen
                        hide-overlay
                        transition="dialog-bottom-transition"
                >
                    <template v-slot:activator="{ on, attrs }">
                        <v-fab-transition>
                            <v-btn
                                    color="primary"
                                    fab
                                    dark
                                    large
                                    style="position:absolute; bottom: 5%; right: 2%; z-index:99"
                                    @click="openDialog=true;"
                            >
                                <v-icon v-bind="attrs" v-on="on">mdi-plus</v-icon>
                            </v-btn>
                        </v-fab-transition>
                    </template>

                    <StandardmanagementVehicleInfo :offline="offline" class="video-card" :isNew="true" :editMode="true" v-model="newValue" @add="append" v-if="tick"/>
                
                    <v-btn
                            style="postition:absolute; top:2%; right:2%"
                            @click="closeDialog()"
                            depressed 
                            icon 
                            absolute
                    >
                        <v-icon>mdi-close</v-icon>
                    </v-btn>
                </v-dialog>
            </div>
        </v-col>
    </div>
</template>

<script>
    const axios = require('axios').default;
    import StandardmanagementVehicleInfo from './../StandardmanagementVehicleInfo.vue';

    export default {
        name: 'StandardmanagementVehicleInfoManager',
        components: {
            StandardmanagementVehicleInfo,
        },
        props: {
            offline: Boolean,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            values: [],
            headers: 
                [
                    { text: "vehicleId", value: "vehicleId" },
                    { text: "vehicleNumber", value: "vehicleNumber" },
                    { text: "classification", value: "classification" },
                    { text: "manufacturerCode", value: "manufacturerCode" },
                    { text: "vehicleTypeCode", value: "vehicleTypeCode" },
                    { text: "vehicleModelCode", value: "vehicleModelCode" },
                    { text: "usageCode", value: "usageCode" },
                    { text: "fuelType", value: "fuelType" },
                    { text: "vehicleAffiliationCode", value: "vehicleAffiliationCode" },
                    { text: "assetCode", value: "assetCode" },
                    { text: "operatingDepartment", value: "operatingDepartment" },
                    { text: "acquisitionAmount", value: "acquisitionAmount" },
                    { text: "responsibleDriverId", value: "responsibleDriverId" },
                    { text: "mainUser", value: "mainUser" },
                    { text: "vehicleRegistrationDate", value: "vehicleRegistrationDate" },
                    { text: "vehicleSaleDate", value: "vehicleSaleDate" },
                    { text: "chassisNumber", value: "chassisNumber" },
                    { text: "vehicleFormat", value: "vehicleFormat" },
                    { text: "vehicleYear", value: "vehicleYear" },
                    { text: "output", value: "output" },
                    { text: "length", value: "length" },
                    { text: "width", value: "width" },
                    { text: "height", value: "height" },
                    { text: "weight", value: "weight" },
                    { text: "loadCapacity", value: "loadCapacity" },
                    { text: "displacement", value: "displacement" },
                    { text: "seatingCapacity", value: "seatingCapacity" },
                    { text: "standardFuelEfficiency", value: "standardFuelEfficiency" },
                    { text: "fuelTankCapacity", value: "fuelTankCapacity" },
                    { text: "departureKm", value: "departureKm" },
                    { text: "accumulatedKm", value: "accumulatedKm" },
                    { text: "totalAccumulatedKm", value: "totalAccumulatedKm" },
                    { text: "regularInspectionDate", value: "regularInspectionDate" },
                    { text: "remarks", value: "remarks" },
                    { text: "vehicleSpec", value: "vehicleSpec" },
                    { text: "vehicleOwnership", value: "vehicleOwnership" },
                    { text: "unavailabilityReason", value: "unavailabilityReason" },
                    { text: "unavailabilityDate", value: "unavailabilityDate" },
                ],
            vehicleInfo : [],
            newValue: {},
            tick : true,
            openDialog : false,
        }),
        async created() {
            if(this.offline){
                if(!this.values) this.values = [];
                return;
            }

            var temp = await axios.get(axios.fixUrl('/vehicleinfos'))
            temp.data._embedded.vehicleinfos.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])
            this.values = temp.data._embedded.vehicleinfos;

            this.newValue = {
                'vehicleId': 0,
                'vehicleNumber': '',
                'classification': '',
                'manufacturerCode': '',
                'vehicleTypeCode': '',
                'vehicleModelCode': '',
                'usageCode': '',
                'fuelType': '',
                'vehicleAffiliationCode': '',
                'assetCode': '',
                'operatingDepartment': '',
                'acquisitionAmount': 0,
                'responsibleDriverId': '',
                'mainUser': '',
                'vehicleRegistrationDate': '2024-10-31',
                'vehicleSaleDate': '2024-10-31',
                'chassisNumber': '',
                'vehicleFormat': '',
                'vehicleYear': '',
                'output': '',
                'length': 0,
                'width': 0,
                'height': 0,
                'weight': 0,
                'loadCapacity': 0,
                'displacement': 0,
                'seatingCapacity': 0,
                'standardFuelEfficiency': 0,
                'fuelTankCapacity': 0,
                'departureKm': 0,
                'accumulatedKm': 0,
                'totalAccumulatedKm': 0,
                'regularInspectionDate': '2024-10-31',
                'remarks': '',
                'vehicleSpec': {},
                'vehicleOwnership': {},
                'unavailabilityReason': '',
                'unavailabilityDate': '2024-10-31',
            }
        },
        methods: {
            closeDialog(){
                this.openDialog = false
            },
            append(value){
                this.tick = false
                this.newValue = {}
                this.values.push(value)
                
                this.$emit('input', this.values);

                this.$nextTick(function(){
                    this.tick=true
                })
            },
        }
    }
</script>

