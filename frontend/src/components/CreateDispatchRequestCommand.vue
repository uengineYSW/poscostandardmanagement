<template>
    <v-card outlined>
        <v-card-title>
            CreateDispatchRequest
        </v-card-title>

        <v-card-text>
            <Number label="DispatchRequestId" v-model="value.dispatchRequestId" :editMode="editMode"/>
            <String label="ApplicantId" v-model="value.applicantId" :editMode="editMode"/>
            <Date label="ApplicationDate" v-model="value.applicationDate" :editMode="editMode"/>
            <String label="ApplicantDepartmentCode" v-model="value.applicantDepartmentCode" :editMode="editMode"/>
            <String label="OfficePhoneNumber" v-model="value.officePhoneNumber" :editMode="editMode"/>
            <String label="MobilePhoneNumber" v-model="value.mobilePhoneNumber" :editMode="editMode"/>
            <String label="ApproverId" v-model="value.approverId" :editMode="editMode"/>
            <String label="ApproverPosition" v-model="value.approverPosition" :editMode="editMode"/>
            <Date label="ApprovalDate" v-model="value.approvalDate" :editMode="editMode"/>
            <String label="MainDepartment" v-model="value.mainDepartment" :editMode="editMode"/>
            <String label="MainDepartmentManagerId" v-model="value.mainDepartmentManagerId" :editMode="editMode"/>
            <Date label="ApprovalDate" v-model="value.approvalDate" :editMode="editMode"/>
            <String label="ProgressStatus" v-model="value.progressStatus" :editMode="editMode"/>
            <String label="UsagePurposeCode" v-model="value.usagePurposeCode" :editMode="editMode"/>
            <String label="UsagePurposeDetail" v-model="value.usagePurposeDetail" :editMode="editMode"/>
            <String label="UserId" v-model="value.userId" :editMode="editMode"/>
            <String label="Visitor" v-model="value.visitor" :editMode="editMode"/>
            <Number label="NumberOfPassengers" v-model="value.numberOfPassengers" :editMode="editMode"/>
            <Date label="OperationPeriodFrom" v-model="value.operationPeriodFrom" :editMode="editMode"/>
            <Date label="OperationPeriodTo" v-model="value.operationPeriodTo" :editMode="editMode"/>
            <String label="InOutDistinction" v-model="value.inOutDistinction" :editMode="editMode"/>
            <String label="RoundTrip" v-model="value.roundTrip" :editMode="editMode"/>
            <String label="OperationSection1" v-model="value.operationSection1" :editMode="editMode"/>
            <String label="OperationSection2" v-model="value.operationSection2" :editMode="editMode"/>
            <String label="OperationSection3" v-model="value.operationSection3" :editMode="editMode"/>
            <String label="OperationSection4" v-model="value.operationSection4" :editMode="editMode"/>
            <String label="OperationSection5" v-model="value.operationSection5" :editMode="editMode"/>
            <Number label="RequestedNumber1" v-model="value.requestedNumber1" :editMode="editMode"/>
            <Number label="RequestedNumber2" v-model="value.requestedNumber2" :editMode="editMode"/>
            <Number label="RequestedNumber3" v-model="value.requestedNumber3" :editMode="editMode"/>
            <String label="DriverIncluded" v-model="value.driverIncluded" :editMode="editMode"/>
            <String label="DetailedSchedule" v-model="value.detailedSchedule" :editMode="editMode"/>
            <String label="AttachedDocumentName" v-model="value.attachedDocumentName" :editMode="editMode"/>
            <String label="AttachedDocument" v-model="value.attachedDocument" :editMode="editMode"/>
            <String label="EmailSent" v-model="value.emailSent" :editMode="editMode"/>
            <String label="SmsSent" v-model="value.smsSent" :editMode="editMode"/>
            <String label="DispatchResultContent" v-model="value.dispatchResultContent" :editMode="editMode"/>
            <String label="DispatchCarNumber" v-model="value.dispatchCarNumber" :editMode="editMode"/>
            <String label="DispatchDriverId" v-model="value.dispatchDriverId" :editMode="editMode"/>
            <String label="DispatchDriverPhoneNumber" v-model="value.dispatchDriverPhoneNumber" :editMode="editMode"/>
            <String label="Remarks" v-model="value.remarks" :editMode="editMode"/>
            <PhoneNumber offline label="PhoneNumber" v-model="value.phoneNumber" :editMode="editMode" @change="change"/>
            <Applicant offline label="Applicant" v-model="value.applicant" :editMode="editMode" @change="change"/>
            <Approver offline label="Approver" v-model="value.approver" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createDispatchRequest"
            >
                CreateDispatchRequest
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'CreateDispatchRequestCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.dispatchRequestId = 0;
            this.value.applicantId = '';
            this.value.applicationDate = '2024-10-31';
            this.value.applicantDepartmentCode = '';
            this.value.officePhoneNumber = '';
            this.value.mobilePhoneNumber = '';
            this.value.approverId = '';
            this.value.approverPosition = '';
            this.value.approvalDate = '2024-10-31';
            this.value.mainDepartment = '';
            this.value.mainDepartmentManagerId = '';
            this.value.approvalDate = '2024-10-31';
            this.value.progressStatus = '';
            this.value.usagePurposeCode = '';
            this.value.usagePurposeDetail = '';
            this.value.userId = '';
            this.value.visitor = '';
            this.value.numberOfPassengers = 0;
            this.value.operationPeriodFrom = '2024-10-31';
            this.value.operationPeriodTo = '2024-10-31';
            this.value.inOutDistinction = '';
            this.value.roundTrip = '';
            this.value.operationSection1 = '';
            this.value.operationSection2 = '';
            this.value.operationSection3 = '';
            this.value.operationSection4 = '';
            this.value.operationSection5 = '';
            this.value.requestedNumber1 = 0;
            this.value.requestedNumber2 = 0;
            this.value.requestedNumber3 = 0;
            this.value.driverIncluded = '';
            this.value.detailedSchedule = '';
            this.value.attachedDocumentName = '';
            this.value.attachedDocument = '';
            this.value.emailSent = '';
            this.value.smsSent = '';
            this.value.dispatchResultContent = '';
            this.value.dispatchCarNumber = '';
            this.value.dispatchDriverId = '';
            this.value.dispatchDriverPhoneNumber = '';
            this.value.remarks = '';
            this.value.phoneNumber = {};
            this.value.applicant = {};
            this.value.approver = {};
        },
        watch: {
        },
        methods: {
            createDispatchRequest() {
                this.$emit('createDispatchRequest', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

