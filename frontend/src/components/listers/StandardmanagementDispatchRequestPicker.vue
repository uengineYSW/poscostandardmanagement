<template>
    <div>
        <v-list two-line v-if="list.length > 0">
            <v-list-item-group 
                    v-model="selected" 
                    color="primary"
                    @change="select"
            >
                <v-list-item v-for="(item, idx) in list" :key="idx">
                    <template v-slot:default="{ active }">
                        <v-list-item-avatar color="primary-darker-1">
                        </v-list-item-avatar>
                        
                        <v-list-item-content>
                            <v-list-item-title>
                            </v-list-item-title>
                            <v-list-item-subtitle>
                                DispatchRequestId :  {{item.dispatchRequestId }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ApplicantId :  {{item.applicantId }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ApplicationDate :  {{item.applicationDate }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ApplicantDepartmentCode :  {{item.applicantDepartmentCode }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OfficePhoneNumber :  {{item.officePhoneNumber }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                MobilePhoneNumber :  {{item.mobilePhoneNumber }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ApproverId :  {{item.approverId }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ApproverPosition :  {{item.approverPosition }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                MainDepartment :  {{item.mainDepartment }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                MainDepartmentManagerId :  {{item.mainDepartmentManagerId }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ApprovalDate :  {{item.approvalDate }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ProgressStatus :  {{item.progressStatus }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                UsagePurposeCode :  {{item.usagePurposeCode }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                UsagePurposeDetail :  {{item.usagePurposeDetail }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                UserId :  {{item.userId }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Visitor :  {{item.visitor }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                NumberOfPassengers :  {{item.numberOfPassengers }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OperationPeriodFrom :  {{item.operationPeriodFrom }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OperationPeriodTo :  {{item.operationPeriodTo }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                InOutDistinction :  {{item.inOutDistinction }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                RoundTrip :  {{item.roundTrip }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OperationSection1 :  {{item.operationSection1 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OperationSection2 :  {{item.operationSection2 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OperationSection3 :  {{item.operationSection3 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OperationSection4 :  {{item.operationSection4 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OperationSection5 :  {{item.operationSection5 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                RequestedNumber1 :  {{item.requestedNumber1 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                RequestedNumber2 :  {{item.requestedNumber2 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                RequestedNumber3 :  {{item.requestedNumber3 }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                DriverIncluded :  {{item.driverIncluded }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                DetailedSchedule :  {{item.detailedSchedule }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                AttachedDocumentName :  {{item.attachedDocumentName }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                AttachedDocument :  {{item.attachedDocument }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                EmailSent :  {{item.emailSent }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                SmsSent :  {{item.smsSent }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                DispatchResultContent :  {{item.dispatchResultContent }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                DispatchCarNumber :  {{item.dispatchCarNumber }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                DispatchDriverId :  {{item.dispatchDriverId }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                DispatchDriverPhoneNumber :  {{item.dispatchDriverPhoneNumber }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Remarks :  {{item.remarks }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                PhoneNumber :  {{item.phoneNumber }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Applicant :  {{item.applicant }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Approver :  {{item.approver }}
                            </v-list-item-subtitle>
                        </v-list-item-content>

                        <v-list-item-action>
                            <v-checkbox :input-value="active" color="primary-darker-1"></v-checkbox>
                        </v-list-item-action>
                    </template>
                </v-list-item>
            </v-list-item-group>
        </v-list>
    </div>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'StandardmanagementDispatchRequestPicker',
        props: {
            value: [String, Object, Array, Number, Boolean],
        },
        data: () => ({
            list: [],
            selected: null,
        }),
        async created() {
            var me = this;
            var temp = await axios.get(axios.fixUrl('/dispatchRequests'))
            if(temp.data) {
                me.list = temp.data._embedded.dispatchRequests;
            }

            if(me.value && typeof me.value == "object" && Object.values(me.value)[0]) {
                var id = Object.values(me.value)[0];
                var tmpValue = await axios.get(axios.fixUrl('/dispatchRequests/' + id))
                if(tmpValue.data) {
                    var val = tmpValue.data
                    me.list.forEach(function(item, idx) {
                        if(item.name == val.name) {
                            me.selected = idx
                        }
                    })
                }
            }
        },
        methods: {
            select(val) {
                var obj = {}
                if(val != undefined) {
                    var arr = this.list[val]._links.self.href.split('/');
                    obj['dispatchRequestId'] = arr[4]; 
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    this.$emit('selected', obj);
                }
            },
        },
    };
</script>

