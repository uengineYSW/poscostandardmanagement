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
            SettlementManagement # {{decode(value._links.self.href.split("/")[value._links.self.href.split("/").length - 1])}}
        </v-card-title >
        <v-card-title v-else>
            SettlementManagement
        </v-card-title >        

        <v-card-text style="background-color: white;">
            <String label="SettlementType" v-model="value.settlementType" :editMode="editMode" :inputUI="''"/>
            <Date label="SettlementDate" v-model="value.settlementDate" :editMode="editMode" :inputUI="''"/>
            <String label="ConfirmationStatus" v-model="value.confirmationStatus" :editMode="editMode" :inputUI="''"/>
            <Date label="SettlementPeriodFrom" v-model="value.settlementPeriodFrom" :editMode="editMode" :inputUI="''"/>
            <Date label="SettlementPeriodTo" v-model="value.settlementPeriodTo" :editMode="editMode" :inputUI="''"/>
            <Number label="VehicleCount1" v-model="value.vehicleCount1" :editMode="editMode" :inputUI="''"/>
            <Number label="VehicleCount2" v-model="value.vehicleCount2" :editMode="editMode" :inputUI="''"/>
            <Number label="VehicleCount3" v-model="value.vehicleCount3" :editMode="editMode" :inputUI="''"/>
            <Number label="VehicleCount4" v-model="value.vehicleCount4" :editMode="editMode" :inputUI="''"/>
            <Number label="VehicleCount5" v-model="value.vehicleCount5" :editMode="editMode" :inputUI="''"/>
            <Number label="VehicleCount6" v-model="value.vehicleCount6" :editMode="editMode" :inputUI="''"/>
            <Number label="OperatingStaff1" v-model="value.operatingStaff1" :editMode="editMode" :inputUI="''"/>
            <Number label="OperatingStaff2" v-model="value.operatingStaff2" :editMode="editMode" :inputUI="''"/>
            <Number label="OperatingStaff3" v-model="value.operatingStaff3" :editMode="editMode" :inputUI="''"/>
            <Number label="OperatingStaff4" v-model="value.operatingStaff4" :editMode="editMode" :inputUI="''"/>
            <Number label="OperatingStaff5" v-model="value.operatingStaff5" :editMode="editMode" :inputUI="''"/>
            <Number label="OperatingStaff6" v-model="value.operatingStaff6" :editMode="editMode" :inputUI="''"/>
            <Number label="MaterialCostPassenger" v-model="value.materialCostPassenger" :editMode="editMode" :inputUI="''"/>
            <Number label="MaterialCostBus" v-model="value.materialCostBus" :editMode="editMode" :inputUI="''"/>
            <Number label="FuelCostPassenger" v-model="value.fuelCostPassenger" :editMode="editMode" :inputUI="''"/>
            <Number label="FuelCostBus" v-model="value.fuelCostBus" :editMode="editMode" :inputUI="''"/>
            <Number label="PartsCostPassenger" v-model="value.partsCostPassenger" :editMode="editMode" :inputUI="''"/>
            <Number label="PartsCostBus" v-model="value.partsCostBus" :editMode="editMode" :inputUI="''"/>
            <Number label="LaborCostPassenger" v-model="value.laborCostPassenger" :editMode="editMode" :inputUI="''"/>
            <Number label="LaborCostBus" v-model="value.laborCostBus" :editMode="editMode" :inputUI="''"/>
            <Number label="DirectLaborCostPassenger" v-model="value.directLaborCostPassenger" :editMode="editMode" :inputUI="''"/>
            <Number label="DirectLaborCostBus" v-model="value.directLaborCostBus" :editMode="editMode" :inputUI="''"/>
            <Number label="IndirectLaborCostPassenger" v-model="value.indirectLaborCostPassenger" :editMode="editMode" :inputUI="''"/>
            <Number label="IndirectLaborCostBus" v-model="value.indirectLaborCostBus" :editMode="editMode" :inputUI="''"/>
            <Number label="ExpensesPassenger" v-model="value.expensesPassenger" :editMode="editMode" :inputUI="''"/>
            <SettlementInfo offline label="SettlementInfo" v-model="value.settlementInfo" :editMode="editMode" @change="change"/>
            <SettlementPeriod offline label="SettlementPeriod" v-model="value.settlementPeriod" :editMode="editMode" @change="change"/>
            <Amount offline label="Amount" v-model="value.amount" :editMode="editMode" @change="change"/>
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
                    CreateSettlementManagement
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="save"
                >
                    DeleteSettlementManagement
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
        name: 'OthermanagementSettlementManagement',
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
                            temp = await axios.post(axios.fixUrl('/settlementManagements'), this.value)
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
        },
    }
</script>

