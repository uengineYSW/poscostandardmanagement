<template>
    <div>
    <h1>DispatchRequest</h1>
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
                        DispatchRequest 등록
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
                            [ DispatchRequestId :  {{data.dispatchRequestId }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ ApplicantId :  {{data.applicantId }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ ApplicationDate :  {{data.applicationDate }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ ApplicantDepartmentCode :  {{data.applicantDepartmentCode }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ OfficePhoneNumber :  {{data.officePhoneNumber }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ MobilePhoneNumber :  {{data.mobilePhoneNumber }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ ApproverId :  {{data.approverId }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ ApproverPosition :  {{data.approverPosition }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ MainDepartment :  {{data.mainDepartment }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ MainDepartmentManagerId :  {{data.mainDepartmentManagerId }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ ApprovalDate :  {{data.approvalDate }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ ProgressStatus :  {{data.progressStatus }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ UsagePurposeCode :  {{data.usagePurposeCode }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ UsagePurposeDetail :  {{data.usagePurposeDetail }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ UserId :  {{data.userId }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ Visitor :  {{data.visitor }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ NumberOfPassengers :  {{data.numberOfPassengers }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ OperationPeriodFrom :  {{data.operationPeriodFrom }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ OperationPeriodTo :  {{data.operationPeriodTo }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ InOutDistinction :  {{data.inOutDistinction }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ RoundTrip :  {{data.roundTrip }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ OperationSection1 :  {{data.operationSection1 }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ OperationSection2 :  {{data.operationSection2 }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ OperationSection3 :  {{data.operationSection3 }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ OperationSection4 :  {{data.operationSection4 }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ OperationSection5 :  {{data.operationSection5 }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ RequestedNumber1 :  {{data.requestedNumber1 }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ RequestedNumber2 :  {{data.requestedNumber2 }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ RequestedNumber3 :  {{data.requestedNumber3 }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ DriverIncluded :  {{data.driverIncluded }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ DetailedSchedule :  {{data.detailedSchedule }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ AttachedDocumentName :  {{data.attachedDocumentName }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ AttachedDocument :  {{data.attachedDocument }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ EmailSent :  {{data.emailSent }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ SmsSent :  {{data.smsSent }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ DispatchResultContent :  {{data.dispatchResultContent }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ DispatchCarNumber :  {{data.dispatchCarNumber }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ DispatchDriverId :  {{data.dispatchDriverId }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ DispatchDriverPhoneNumber :  {{data.dispatchDriverPhoneNumber }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ Remarks :  {{data.remarks }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ PhoneNumber :  {{data.phoneNumber }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ Applicant :  {{data.applicant }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ Approver :  {{data.approver }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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

