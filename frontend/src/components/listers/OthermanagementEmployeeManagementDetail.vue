<template>
    <v-card outlined>
        <v-card-title>
            EmployeeManagement # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="Company" v-model="item.company" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ResponsibleSettlement" v-model="item.responsibleSettlement" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Position" v-model="item.position" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ResponsibleTask" v-model="item.responsibleTask" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="PhoneNumber" v-model="item.phoneNumber" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="LicenseNumber" v-model="item.licenseNumber" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="IdNumber" v-model="item.idNumber" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ResponsibleVehicleNumber" v-model="item.responsibleVehicleNumber" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="VehicleType" v-model="item.vehicleType" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="RetirementStatus" v-model="item.retirementStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="RetirementDate" v-model="item.retirementDate" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Photo" v-model="item.photo" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Remarks" v-model="item.remarks" :editMode="editMode" @change="change" />
            </div>
            <EmployeeInfo offline label="EmployeeInfo" v-model="item.employeeInfo" :editMode="false" :key="false" @change="change" />
            <EmployeeId offline label="EmployeeId" v-model="item.employeeId" :editMode="false" :key="false" @change="change" />
            <Name offline label="Name" v-model="item.name" :editMode="false" :key="false" @change="change" />
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
        name: 'OthermanagementEmployeeManagementDetail',
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
            var temp = await axios.get(axios.fixUrl('/employeeManagements/' + params.id))
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
