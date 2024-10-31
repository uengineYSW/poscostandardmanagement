<template>
    <v-card outlined>
        <v-card-title>
            MaintenanceRecord # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="VehicleId" v-model="item.vehicleId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="MaintenanceDate" v-model="item.maintenanceDate" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="MaintenanceSeq" v-model="item.maintenanceSeq" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="MaintenanceCompanyCode" v-model="item.maintenanceCompanyCode" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="MaintenanceItemCode" v-model="item.maintenanceItemCode" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="MaintenanceItemName" v-model="item.maintenanceItemName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Unit" v-model="item.unit" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Quantity" v-model="item.quantity" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="UnitPrice" v-model="item.unitPrice" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="SupplyAmount" v-model="item.supplyAmount" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Tax" v-model="item.tax" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Amount" v-model="item.amount" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="PreventiveMaintenance" v-model="item.preventiveMaintenance" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="PreventiveMaintenanceItem" v-model="item.preventiveMaintenanceItem" :editMode="editMode" @change="change" />
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
        name: 'StandardmanagementMaintenanceRecordDetail',
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
            var temp = await axios.get(axios.fixUrl('/maintenanceRecords/' + params.id))
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
