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
            DispatchRequest # {{decode(value._links.self.href.split("/")[value._links.self.href.split("/").length - 1])}}
        </v-card-title >
        <v-card-title v-else>
            DispatchRequest
        </v-card-title >        

        <v-card-text style="background-color: white;">
            <Number v-if="editMode" label="DispatchRequestId" v-model="value.dispatchRequestId" :editMode="editMode" :inputUI="''"/>
            <String label="ApplicantId" v-model="value.applicantId" :editMode="editMode" :inputUI="''"/>
            <Date label="ApplicationDate" v-model="value.applicationDate" :editMode="editMode" :inputUI="''"/>
            <String label="ApplicantDepartmentCode" v-model="value.applicantDepartmentCode" :editMode="editMode" :inputUI="''"/>
            <String label="OfficePhoneNumber" v-model="value.officePhoneNumber" :editMode="editMode" :inputUI="''"/>
            <String label="MobilePhoneNumber" v-model="value.mobilePhoneNumber" :editMode="editMode" :inputUI="''"/>
            <String label="ApproverId" v-model="value.approverId" :editMode="editMode" :inputUI="''"/>
            <String label="ApproverPosition" v-model="value.approverPosition" :editMode="editMode" :inputUI="''"/>
            <String label="MainDepartment" v-model="value.mainDepartment" :editMode="editMode" :inputUI="''"/>
            <String label="MainDepartmentManagerId" v-model="value.mainDepartmentManagerId" :editMode="editMode" :inputUI="''"/>
            <Date label="ApprovalDate" v-model="value.approvalDate" :editMode="editMode" :inputUI="''"/>
            <String label="ProgressStatus" v-model="value.progressStatus" :editMode="editMode" :inputUI="''"/>
            <String label="UsagePurposeCode" v-model="value.usagePurposeCode" :editMode="editMode" :inputUI="''"/>
            <String label="UsagePurposeDetail" v-model="value.usagePurposeDetail" :editMode="editMode" :inputUI="''"/>
            <String label="UserId" v-model="value.userId" :editMode="editMode" :inputUI="''"/>
            <String label="Visitor" v-model="value.visitor" :editMode="editMode" :inputUI="''"/>
            <Number label="NumberOfPassengers" v-model="value.numberOfPassengers" :editMode="editMode" :inputUI="''"/>
            <Date label="OperationPeriodFrom" v-model="value.operationPeriodFrom" :editMode="editMode" :inputUI="''"/>
            <Date label="OperationPeriodTo" v-model="value.operationPeriodTo" :editMode="editMode" :inputUI="''"/>
            <String label="InOutDistinction" v-model="value.inOutDistinction" :editMode="editMode" :inputUI="''"/>
            <String label="RoundTrip" v-model="value.roundTrip" :editMode="editMode" :inputUI="''"/>
            <String label="OperationSection1" v-model="value.operationSection1" :editMode="editMode" :inputUI="''"/>
            <String label="OperationSection2" v-model="value.operationSection2" :editMode="editMode" :inputUI="''"/>
            <String label="OperationSection3" v-model="value.operationSection3" :editMode="editMode" :inputUI="''"/>
            <String label="OperationSection4" v-model="value.operationSection4" :editMode="editMode" :inputUI="''"/>
            <String label="OperationSection5" v-model="value.operationSection5" :editMode="editMode" :inputUI="''"/>
            <Number label="RequestedNumber1" v-model="value.requestedNumber1" :editMode="editMode" :inputUI="''"/>
            <Number label="RequestedNumber2" v-model="value.requestedNumber2" :editMode="editMode" :inputUI="''"/>
            <Number label="RequestedNumber3" v-model="value.requestedNumber3" :editMode="editMode" :inputUI="''"/>
            <String label="DriverIncluded" v-model="value.driverIncluded" :editMode="editMode" :inputUI="''"/>
            <String label="DetailedSchedule" v-model="value.detailedSchedule" :editMode="editMode" :inputUI="''"/>
            <String label="AttachedDocumentName" v-model="value.attachedDocumentName" :editMode="editMode" :inputUI="''"/>
            <String label="AttachedDocument" v-model="value.attachedDocument" :editMode="editMode" :inputUI="''"/>
            <String label="EmailSent" v-model="value.emailSent" :editMode="editMode" :inputUI="''"/>
            <String label="SmsSent" v-model="value.smsSent" :editMode="editMode" :inputUI="''"/>
            <String label="DispatchResultContent" v-model="value.dispatchResultContent" :editMode="editMode" :inputUI="''"/>
            <String label="DispatchCarNumber" v-model="value.dispatchCarNumber" :editMode="editMode" :inputUI="''"/>
            <String label="DispatchDriverId" v-model="value.dispatchDriverId" :editMode="editMode" :inputUI="''"/>
            <String label="DispatchDriverPhoneNumber" v-model="value.dispatchDriverPhoneNumber" :editMode="editMode" :inputUI="''"/>
            <String label="Remarks" v-model="value.remarks" :editMode="editMode" :inputUI="''"/>
            <PhoneNumber offline label="PhoneNumber" v-model="value.phoneNumber" :editMode="editMode" @change="change"/>
            <Applicant offline label="Applicant" v-model="value.applicant" :editMode="editMode" @change="change"/>
            <Approver offline label="Approver" v-model="value.approver" :editMode="editMode" @change="change"/>
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
                    CreateDispatchRequest
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="save"
                >
                    DeleteDispatchRequest
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
        name: 'StandardmanagementDispatchRequest',
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
                            temp = await axios.post(axios.fixUrl('/dispatchRequests'), this.value)
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

