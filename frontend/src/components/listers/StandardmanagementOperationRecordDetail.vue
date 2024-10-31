<template>
    <v-card outlined>
        <v-card-title>
            OperationRecord # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="VehicleId" v-model="item.vehicleId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="OperationDate" v-model="item.operationDate" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="OperationSeq" v-model="item.operationSeq" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="DriverId" v-model="item.driverId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="PassengerWorkDistinction" v-model="item.passengerWorkDistinction" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="OperationPurpose" v-model="item.operationPurpose" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="NumberOfPassengers" v-model="item.numberOfPassengers" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="OperationPlace" v-model="item.operationPlace" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="OperationKm" v-model="item.operationKm" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="DepartureTime" v-model="item.departureTime" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="ArrivalTime" v-model="item.arrivalTime" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="OperationTimeMin" v-model="item.operationTimeMin" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="WaitingTimeMin" v-model="item.waitingTimeMin" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="FuelSupplier" v-model="item.fuelSupplier" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="FuelAmount" v-model="item.fuelAmount" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="FuelUnitPrice" v-model="item.fuelUnitPrice" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="CardFuelAmount" v-model="item.cardFuelAmount" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="CardFuelSupplyAmount" v-model="item.cardFuelSupplyAmount" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="CardFuelTax" v-model="item.cardFuelTax" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="CardTollFee" v-model="item.cardTollFee" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="CashFuelAmount" v-model="item.cashFuelAmount" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="CashFuelSupplyAmount" v-model="item.cashFuelSupplyAmount" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="CashFuelTax" v-model="item.cashFuelTax" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="CashTollFee" v-model="item.cashTollFee" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="CashParkingFee" v-model="item.cashParkingFee" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Remarks" v-model="item.remarks" :editMode="editMode" @change="change" />
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
        name: 'StandardmanagementOperationRecordDetail',
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
            var temp = await axios.get(axios.fixUrl('/operationRecords/' + params.id))
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
