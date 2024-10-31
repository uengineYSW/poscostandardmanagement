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

                    <OthermanagementEmployeeManagement :offline="offline" class="video-card" :isNew="true" :editMode="true" v-model="newValue" @add="append" v-if="tick"/>
                
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
    import OthermanagementEmployeeManagement from './../OthermanagementEmployeeManagement.vue';

    export default {
        name: 'OthermanagementEmployeeManagementManager',
        components: {
            OthermanagementEmployeeManagement,
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
                    { text: "company", value: "company" },
                    { text: "responsibleSettlement", value: "responsibleSettlement" },
                    { text: "position", value: "position" },
                    { text: "responsibleTask", value: "responsibleTask" },
                    { text: "phoneNumber", value: "phoneNumber" },
                    { text: "licenseNumber", value: "licenseNumber" },
                    { text: "idNumber", value: "idNumber" },
                    { text: "responsibleVehicleNumber", value: "responsibleVehicleNumber" },
                    { text: "vehicleType", value: "vehicleType" },
                    { text: "retirementStatus", value: "retirementStatus" },
                    { text: "retirementDate", value: "retirementDate" },
                    { text: "photo", value: "photo" },
                    { text: "remarks", value: "remarks" },
                    { text: "employeeInfo", value: "employeeInfo" },
                    { text: "employeeId", value: "employeeId" },
                    { text: "name", value: "name" },
                ],
            employeeManagement : [],
            newValue: {},
            tick : true,
            openDialog : false,
        }),
        async created() {
            if(this.offline){
                if(!this.values) this.values = [];
                return;
            }

            var temp = await axios.get(axios.fixUrl('/employeemanagements'))
            temp.data._embedded.employeemanagements.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])
            this.values = temp.data._embedded.employeemanagements;

            this.newValue = {
                'company': '',
                'responsibleSettlement': '',
                'position': '',
                'responsibleTask': '',
                'phoneNumber': '',
                'licenseNumber': '',
                'idNumber': '',
                'responsibleVehicleNumber': '',
                'vehicleType': '',
                'retirementStatus': '',
                'retirementDate': '2024-10-31',
                'photo': '',
                'remarks': '',
                'employeeInfo': {},
                'employeeId': {},
                'name': {},
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

