<template>
    <v-card outlined>
        <v-card-title>
            SettlementManagement # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="SettlementType" v-model="item.settlementType" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="SettlementDate" v-model="item.settlementDate" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ConfirmationStatus" v-model="item.confirmationStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="SettlementPeriodFrom" v-model="item.settlementPeriodFrom" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="SettlementPeriodTo" v-model="item.settlementPeriodTo" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="VehicleCount1" v-model="item.vehicleCount1" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="VehicleCount2" v-model="item.vehicleCount2" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="VehicleCount3" v-model="item.vehicleCount3" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="VehicleCount4" v-model="item.vehicleCount4" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="VehicleCount5" v-model="item.vehicleCount5" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="VehicleCount6" v-model="item.vehicleCount6" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="OperatingStaff1" v-model="item.operatingStaff1" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="OperatingStaff2" v-model="item.operatingStaff2" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="OperatingStaff3" v-model="item.operatingStaff3" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="OperatingStaff4" v-model="item.operatingStaff4" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="OperatingStaff5" v-model="item.operatingStaff5" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="OperatingStaff6" v-model="item.operatingStaff6" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="MaterialCostPassenger" v-model="item.materialCostPassenger" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="MaterialCostBus" v-model="item.materialCostBus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="FuelCostPassenger" v-model="item.fuelCostPassenger" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="FuelCostBus" v-model="item.fuelCostBus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="PartsCostPassenger" v-model="item.partsCostPassenger" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="PartsCostBus" v-model="item.partsCostBus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="LaborCostPassenger" v-model="item.laborCostPassenger" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="LaborCostBus" v-model="item.laborCostBus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="DirectLaborCostPassenger" v-model="item.directLaborCostPassenger" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="DirectLaborCostBus" v-model="item.directLaborCostBus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="IndirectLaborCostPassenger" v-model="item.indirectLaborCostPassenger" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="IndirectLaborCostBus" v-model="item.indirectLaborCostBus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="ExpensesPassenger" v-model="item.expensesPassenger" :editMode="editMode" @change="change" />
            </div>
            <SettlementInfo offline label="SettlementInfo" v-model="item.settlementInfo" :editMode="false" :key="false" @change="change" />
            <SettlementPeriod offline label="SettlementPeriod" v-model="item.settlementPeriod" :editMode="false" :key="false" @change="change" />
            <Amount offline label="Amount" v-model="item.amount" :editMode="false" :key="false" @change="change" />
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
        name: 'OthermanagementSettlementManagementDetail',
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
            var temp = await axios.get(axios.fixUrl('/settlementManagements/' + params.id))
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
