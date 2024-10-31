<template>
    <div>
    <h1>VehicleInfo</h1>
        <v-row>
            <v-card
                class="mx-auto"
                style="height:300px; width:300px; margin-bottom:20px; text-align: center;"
                outlined
            >
                <v-list-item>
                    <v-list-item-avatar 
                        class="mx-auto"
                        size="80"
                        style="margin-top:80px;"
                    ><v-icon color="primary" x-large>mdi-plus</v-icon>
                    </v-list-item-avatar>
                </v-list-item>

                <v-card-actions>
                    <v-btn 
                        v-on="on"
                        class="mx-auto"
                        outlined
                        rounded
                        @click="openDialog=true;"
                        color="primary"
                        style="font-weight:500; font-size:20px; padding:15px; border:solid 2px; max-width:250px; overflow:hidden"
                    >
                        VehicleInfo 등록
                    </v-btn>
                </v-card-actions>
            </v-card>
        </v-row>
        <v-list two-line>
            <template>
                <v-list-item v-for="(data, n) in values" :key="n">
                    <v-list-item-avatar color="grey darken-1">
                        <v-img :src="data.photo ? data.photo:'https://cdn.vuetifyjs.com/images/cards/cooking.png'"/>
                    </v-list-item-avatar>

                    <v-list-item-content>
                        <v-list-item-title style="margin-bottom:10px;">
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                        </v-list-item-title>

                        <v-list-item-subtitle style="font-size:25px; font-weight:700;">
                            [ VehicleId :  {{data.vehicleId }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ VehicleNumber :  {{data.vehicleNumber }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ Classification :  {{data.classification }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ ManufacturerCode :  {{data.manufacturerCode }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ VehicleTypeCode :  {{data.vehicleTypeCode }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ VehicleModelCode :  {{data.vehicleModelCode }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ UsageCode :  {{data.usageCode }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ FuelType :  {{data.fuelType }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ VehicleAffiliationCode :  {{data.vehicleAffiliationCode }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ AssetCode :  {{data.assetCode }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ OperatingDepartment :  {{data.operatingDepartment }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ AcquisitionAmount :  {{data.acquisitionAmount }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ ResponsibleDriverId :  {{data.responsibleDriverId }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ MainUser :  {{data.mainUser }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ VehicleRegistrationDate :  {{data.vehicleRegistrationDate }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ VehicleSaleDate :  {{data.vehicleSaleDate }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ ChassisNumber :  {{data.chassisNumber }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ VehicleFormat :  {{data.vehicleFormat }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ VehicleYear :  {{data.vehicleYear }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ Output :  {{data.output }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ Length :  {{data.length }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ Width :  {{data.width }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ Height :  {{data.height }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ Weight :  {{data.weight }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ LoadCapacity :  {{data.loadCapacity }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ Displacement :  {{data.displacement }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ SeatingCapacity :  {{data.seatingCapacity }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ StandardFuelEfficiency :  {{data.standardFuelEfficiency }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ FuelTankCapacity :  {{data.fuelTankCapacity }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ DepartureKm :  {{data.departureKm }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ AccumulatedKm :  {{data.accumulatedKm }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ TotalAccumulatedKm :  {{data.totalAccumulatedKm }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ RegularInspectionDate :  {{data.regularInspectionDate }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ Remarks :  {{data.remarks }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ VehicleSpec :  {{data.vehicleSpec }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ VehicleOwnership :  {{data.vehicleOwnership }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ UnavailabilityReason :  {{data.unavailabilityReason }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ UnavailabilityDate :  {{data.unavailabilityDate }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </v-list-item-subtitle>

                    </v-list-item-content>
                </v-list-item>

                <v-divider v-if="n !== 6" :key="`divider-${n}`" inset></v-divider>
            </template>
        </v-list>

        <v-col style="margin-bottom:40px;">
            <div class="text-center">
                <v-dialog
                        v-model="openDialog"
                        width="332.5"
                        fullscreen
                        hide-overlay
                        transition="dialog-bottom-transition"
                >

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
            }
        },
    };
</script>


<style>
    .video-card {
        width:300px; 
        margin-left:4.5%; 
        margin-top:50px; 
        margin-bottom:50px;
    }
</style>

