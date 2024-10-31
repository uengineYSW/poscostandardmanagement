<template>
    <v-card style="width:450px; height:100%;" outlined>
        <template slot="progress">
            <v-progress-linear
                    color="primary-darker-1"
                    height="10"
                    indeterminate
            ></v-progress-linear>
        </template>

        <v-card-title v-if="value._links">
            VehicleInfo # {{decode(value._links.self.href.split("/")[value._links.self.href.split("/").length - 1])}}
        </v-card-title >
        <v-card-title v-else>
            VehicleInfo
        </v-card-title >        

        <v-card-text style="background-color: white;">
            <Number v-if="editMode" label="VehicleId" v-model="value.vehicleId" :editMode="editMode" :inputUI="''"/>
            <String label="VehicleNumber" v-model="value.vehicleNumber" :editMode="editMode" :inputUI="''"/>
            <String label="Classification" v-model="value.classification" :editMode="editMode" :inputUI="''"/>
            <String label="ManufacturerCode" v-model="value.manufacturerCode" :editMode="editMode" :inputUI="''"/>
            <String label="VehicleTypeCode" v-model="value.vehicleTypeCode" :editMode="editMode" :inputUI="''"/>
            <String label="VehicleModelCode" v-model="value.vehicleModelCode" :editMode="editMode" :inputUI="''"/>
            <String label="UsageCode" v-model="value.usageCode" :editMode="editMode" :inputUI="''"/>
            <String label="FuelType" v-model="value.fuelType" :editMode="editMode" :inputUI="''"/>
            <String label="VehicleAffiliationCode" v-model="value.vehicleAffiliationCode" :editMode="editMode" :inputUI="''"/>
            <String label="AssetCode" v-model="value.assetCode" :editMode="editMode" :inputUI="''"/>
            <String label="OperatingDepartment" v-model="value.operatingDepartment" :editMode="editMode" :inputUI="''"/>
            <Number label="AcquisitionAmount" v-model="value.acquisitionAmount" :editMode="editMode" :inputUI="''"/>
            <String label="ResponsibleDriverId" v-model="value.responsibleDriverId" :editMode="editMode" :inputUI="''"/>
            <String label="MainUser" v-model="value.mainUser" :editMode="editMode" :inputUI="''"/>
            <Date label="VehicleRegistrationDate" v-model="value.vehicleRegistrationDate" :editMode="editMode" :inputUI="''"/>
            <Date label="VehicleSaleDate" v-model="value.vehicleSaleDate" :editMode="editMode" :inputUI="''"/>
            <String label="ChassisNumber" v-model="value.chassisNumber" :editMode="editMode" :inputUI="''"/>
            <String label="VehicleFormat" v-model="value.vehicleFormat" :editMode="editMode" :inputUI="''"/>
            <String label="VehicleYear" v-model="value.vehicleYear" :editMode="editMode" :inputUI="''"/>
            <String label="Output" v-model="value.output" :editMode="editMode" :inputUI="''"/>
            <Number label="Length" v-model="value.length" :editMode="editMode" :inputUI="''"/>
            <Number label="Width" v-model="value.width" :editMode="editMode" :inputUI="''"/>
            <Number label="Height" v-model="value.height" :editMode="editMode" :inputUI="''"/>
            <Number label="Weight" v-model="value.weight" :editMode="editMode" :inputUI="''"/>
            <Number label="LoadCapacity" v-model="value.loadCapacity" :editMode="editMode" :inputUI="''"/>
            <Number label="Displacement" v-model="value.displacement" :editMode="editMode" :inputUI="''"/>
            <Number label="SeatingCapacity" v-model="value.seatingCapacity" :editMode="editMode" :inputUI="''"/>
            <Number label="StandardFuelEfficiency" v-model="value.standardFuelEfficiency" :editMode="editMode" :inputUI="''"/>
            <Number label="FuelTankCapacity" v-model="value.fuelTankCapacity" :editMode="editMode" :inputUI="''"/>
            <Number label="DepartureKm" v-model="value.departureKm" :editMode="editMode" :inputUI="''"/>
            <Number label="AccumulatedKm" v-model="value.accumulatedKm" :editMode="editMode" :inputUI="''"/>
            <Number label="TotalAccumulatedKm" v-model="value.totalAccumulatedKm" :editMode="editMode" :inputUI="''"/>
            <Date label="RegularInspectionDate" v-model="value.regularInspectionDate" :editMode="editMode" :inputUI="''"/>
            <String label="Remarks" v-model="value.remarks" :editMode="editMode" :inputUI="''"/>
            <VehicleSpec offline label="VehicleSpec" v-model="value.vehicleSpec" :editMode="editMode" @change="change"/>
            <VehicleOwnership offline label="VehicleOwnership" v-model="value.vehicleOwnership" :editMode="editMode" @change="change"/>
            <String label="UnavailabilityReason" v-model="value.unavailabilityReason" :editMode="editMode" :inputUI="''"/>
            <Date label="UnavailabilityDate" v-model="value.unavailabilityDate" :editMode="editMode" :inputUI="''"/>
        </v-card-text>

        <v-card-actions style="background-color: white;">
            <v-spacer></v-spacer>
            <v-btn
                color="primary"
                text
                @click="edit"
                v-if="!editMode"
            >
                수정
            </v-btn>
            <div v-else>
                <v-btn
                    color="primary"
                    text
                    @click="save"
                >
                    CreateVehicleInfo
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="save"
                >
                    DeleteVehicleInfo
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="remove"
                    v-if="!editMode"
                >
                    삭제
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="editMode = false"
                    v-if="editMode && !isNew"
                >
                    취소
                </v-btn>
            </div>
        </v-card-actions>
        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                v-if="!editMode"
                color="primary"
                text
                @click="openMarkVehicleUnavailable"
            >
                MarkVehicleUnavailable
            </v-btn>
            <v-dialog v-model="markVehicleUnavailableDiagram" width="500">
                <MarkVehicleUnavailableCommand
                    @closeDialog="closeMarkVehicleUnavailable"
                    @markVehicleUnavailable="markVehicleUnavailable"
                ></MarkVehicleUnavailableCommand>
            </v-dialog>
        </v-card-actions>

        <v-snackbar
            v-model="snackbar.status"
            :top="true"
            :timeout="snackbar.timeout"
            color="error"
        >
            {{ snackbar.text }}
            <v-btn dark text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
    </v-card>

</template>

<script>
    const axios = require('axios').default;


    export default {
        name: 'StandardmanagementVehicleInfo',
        components:{
        },
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
        },
        data: () => ({
            snackbar: {
                status: false,
                timeout: 5000,
                text: '',
            },
            markVehicleUnavailableDiagram: false,
        }),
	async created() {
        },
        methods: {
            decode(value) {
                return decodeURIComponent(value);
            },
            selectFile(){
                if(this.editMode == false) {
                    return false;
                }
                var me = this
                var input = document.createElement("input");
                input.type = "file";
                input.accept = "image/*";
                input.id = "uploadInput";
                
                input.click();
                input.onchange = function (event) {
                    var file = event.target.files[0]
                    var reader = new FileReader();

                    reader.onload = function () {
                        var result = reader.result;
                        me.imageUrl = result;
                        me.value.photo = result;
                        
                    };
                    reader.readAsDataURL( file );
                };
            },
            edit() {
                this.editMode = true;
            },
            async save(){
                try {
                    var temp = null;

                    if(!this.offline) {
                        if(this.isNew) {
                            temp = await axios.post(axios.fixUrl('/vehicleInfos'), this.value)
                        } else {
                            temp = await axios.put(axios.fixUrl(this.value._links.self.href), this.value)
                        }
                    }

                    if(this.value!=null) {
                        for(var k in temp.data) this.value[k]=temp.data[k];
                    } else {
                        this.value = temp.data;
                    }

                    this.editMode = false;
                    this.$emit('input', this.value);

                    if (this.isNew) {
                        this.$emit('add', this.value);
                    } else {
                        this.$emit('edit', this.value);
                    }

                    location.reload()

                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
                
            },
            async remove(){
                try {
                    if (!this.offline) {
                        await axios.delete(axios.fixUrl(this.value._links.self.href))
                    }

                    this.editMode = false;
                    this.isDeleted = true;

                    this.$emit('input', this.value);
                    this.$emit('delete', this.value);

                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
            },
            change(){
                this.$emit('input', this.value);
            },
            async markVehicleUnavailable(params) {
                try {
                    if(!this.offline) {
                        var temp = await axios.put(axios.fixUrl(this.value._links['markvehicleunavailable'].href), params)
                        for(var k in temp.data) {
                            this.value[k]=temp.data[k];
                        }
                    }

                    this.editMode = false;
                    this.closeMarkVehicleUnavailable();
                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
            },
            openMarkVehicleUnavailable() {
                this.markVehicleUnavailableDiagram = true;
            },
            closeMarkVehicleUnavailable() {
                this.markVehicleUnavailableDiagram = false;
            },
        },
    }
</script>

