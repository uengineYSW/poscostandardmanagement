<template>
    <v-card outlined>
        <v-card-title>
            DispatchRequest # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="DispatchRequestId" v-model="item.dispatchRequestId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ApplicantId" v-model="item.applicantId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="ApplicationDate" v-model="item.applicationDate" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ApplicantDepartmentCode" v-model="item.applicantDepartmentCode" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="OfficePhoneNumber" v-model="item.officePhoneNumber" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="MobilePhoneNumber" v-model="item.mobilePhoneNumber" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ApproverId" v-model="item.approverId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ApproverPosition" v-model="item.approverPosition" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="MainDepartment" v-model="item.mainDepartment" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="MainDepartmentManagerId" v-model="item.mainDepartmentManagerId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="ApprovalDate" v-model="item.approvalDate" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ProgressStatus" v-model="item.progressStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="UsagePurposeCode" v-model="item.usagePurposeCode" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="UsagePurposeDetail" v-model="item.usagePurposeDetail" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="UserId" v-model="item.userId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Visitor" v-model="item.visitor" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="NumberOfPassengers" v-model="item.numberOfPassengers" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="OperationPeriodFrom" v-model="item.operationPeriodFrom" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="OperationPeriodTo" v-model="item.operationPeriodTo" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="InOutDistinction" v-model="item.inOutDistinction" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="RoundTrip" v-model="item.roundTrip" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="OperationSection1" v-model="item.operationSection1" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="OperationSection2" v-model="item.operationSection2" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="OperationSection3" v-model="item.operationSection3" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="OperationSection4" v-model="item.operationSection4" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="OperationSection5" v-model="item.operationSection5" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="RequestedNumber1" v-model="item.requestedNumber1" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="RequestedNumber2" v-model="item.requestedNumber2" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="RequestedNumber3" v-model="item.requestedNumber3" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="DriverIncluded" v-model="item.driverIncluded" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="DetailedSchedule" v-model="item.detailedSchedule" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="AttachedDocumentName" v-model="item.attachedDocumentName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="AttachedDocument" v-model="item.attachedDocument" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="EmailSent" v-model="item.emailSent" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="SmsSent" v-model="item.smsSent" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="DispatchResultContent" v-model="item.dispatchResultContent" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="DispatchCarNumber" v-model="item.dispatchCarNumber" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="DispatchDriverId" v-model="item.dispatchDriverId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="DispatchDriverPhoneNumber" v-model="item.dispatchDriverPhoneNumber" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Remarks" v-model="item.remarks" :editMode="editMode" @change="change" />
            </div>
            <PhoneNumber offline label="PhoneNumber" v-model="item.phoneNumber" :editMode="false" :key="false" @change="change" />
            <Applicant offline label="Applicant" v-model="item.applicant" :editMode="false" :key="false" @change="change" />
            <Approver offline label="Approver" v-model="item.approver" :editMode="false" :key="false" @change="change" />
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
        name: 'StandardmanagementDispatchRequestDetail',
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
            var temp = await axios.get(axios.fixUrl('/dispatchRequests/' + params.id))
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
