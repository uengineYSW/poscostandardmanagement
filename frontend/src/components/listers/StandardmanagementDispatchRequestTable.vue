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

                    <StandardmanagementDispatchRequest :offline="offline" class="video-card" :isNew="true" :editMode="true" v-model="newValue" @add="append" v-if="tick"/>
                
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
    import StandardmanagementDispatchRequest from './../StandardmanagementDispatchRequest.vue';

    export default {
        name: 'StandardmanagementDispatchRequestManager',
        components: {
            StandardmanagementDispatchRequest,
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
                    { text: "dispatchRequestId", value: "dispatchRequestId" },
                    { text: "applicantId", value: "applicantId" },
                    { text: "applicationDate", value: "applicationDate" },
                    { text: "applicantDepartmentCode", value: "applicantDepartmentCode" },
                    { text: "officePhoneNumber", value: "officePhoneNumber" },
                    { text: "mobilePhoneNumber", value: "mobilePhoneNumber" },
                    { text: "approverId", value: "approverId" },
                    { text: "approverPosition", value: "approverPosition" },
                    { text: "mainDepartment", value: "mainDepartment" },
                    { text: "mainDepartmentManagerId", value: "mainDepartmentManagerId" },
                    { text: "approvalDate", value: "approvalDate" },
                    { text: "progressStatus", value: "progressStatus" },
                    { text: "usagePurposeCode", value: "usagePurposeCode" },
                    { text: "usagePurposeDetail", value: "usagePurposeDetail" },
                    { text: "userId", value: "userId" },
                    { text: "visitor", value: "visitor" },
                    { text: "numberOfPassengers", value: "numberOfPassengers" },
                    { text: "operationPeriodFrom", value: "operationPeriodFrom" },
                    { text: "operationPeriodTo", value: "operationPeriodTo" },
                    { text: "inOutDistinction", value: "inOutDistinction" },
                    { text: "roundTrip", value: "roundTrip" },
                    { text: "operationSection1", value: "operationSection1" },
                    { text: "operationSection2", value: "operationSection2" },
                    { text: "operationSection3", value: "operationSection3" },
                    { text: "operationSection4", value: "operationSection4" },
                    { text: "operationSection5", value: "operationSection5" },
                    { text: "requestedNumber1", value: "requestedNumber1" },
                    { text: "requestedNumber2", value: "requestedNumber2" },
                    { text: "requestedNumber3", value: "requestedNumber3" },
                    { text: "driverIncluded", value: "driverIncluded" },
                    { text: "detailedSchedule", value: "detailedSchedule" },
                    { text: "attachedDocumentName", value: "attachedDocumentName" },
                    { text: "attachedDocument", value: "attachedDocument" },
                    { text: "emailSent", value: "emailSent" },
                    { text: "smsSent", value: "smsSent" },
                    { text: "dispatchResultContent", value: "dispatchResultContent" },
                    { text: "dispatchCarNumber", value: "dispatchCarNumber" },
                    { text: "dispatchDriverId", value: "dispatchDriverId" },
                    { text: "dispatchDriverPhoneNumber", value: "dispatchDriverPhoneNumber" },
                    { text: "remarks", value: "remarks" },
                    { text: "phoneNumber", value: "phoneNumber" },
                    { text: "applicant", value: "applicant" },
                    { text: "approver", value: "approver" },
                ],
            dispatchRequest : [],
            newValue: {},
            tick : true,
            openDialog : false,
        }),
        async created() {
            if(this.offline){
                if(!this.values) this.values = [];
                return;
            }

            var temp = await axios.get(axios.fixUrl('/dispatchrequests'))
            temp.data._embedded.dispatchrequests.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])
            this.values = temp.data._embedded.dispatchrequests;

            this.newValue = {
                'dispatchRequestId': 0,
                'applicantId': '',
                'applicationDate': '2024-10-31',
                'applicantDepartmentCode': '',
                'officePhoneNumber': '',
                'mobilePhoneNumber': '',
                'approverId': '',
                'approverPosition': '',
                'mainDepartment': '',
                'mainDepartmentManagerId': '',
                'approvalDate': '2024-10-31',
                'progressStatus': '',
                'usagePurposeCode': '',
                'usagePurposeDetail': '',
                'userId': '',
                'visitor': '',
                'numberOfPassengers': 0,
                'operationPeriodFrom': '2024-10-31',
                'operationPeriodTo': '2024-10-31',
                'inOutDistinction': '',
                'roundTrip': '',
                'operationSection1': '',
                'operationSection2': '',
                'operationSection3': '',
                'operationSection4': '',
                'operationSection5': '',
                'requestedNumber1': 0,
                'requestedNumber2': 0,
                'requestedNumber3': 0,
                'driverIncluded': '',
                'detailedSchedule': '',
                'attachedDocumentName': '',
                'attachedDocument': '',
                'emailSent': '',
                'smsSent': '',
                'dispatchResultContent': '',
                'dispatchCarNumber': '',
                'dispatchDriverId': '',
                'dispatchDriverPhoneNumber': '',
                'remarks': '',
                'phoneNumber': {},
                'applicant': {},
                'approver': {},
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

