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
            EmployeeManagement # {{decode(value._links.self.href.split("/")[value._links.self.href.split("/").length - 1])}}
        </v-card-title >
        <v-card-title v-else>
            EmployeeManagement
        </v-card-title >        

        <v-card-text style="background-color: white;">
            <String label="Company" v-model="value.company" :editMode="editMode" :inputUI="''"/>
            <String label="ResponsibleSettlement" v-model="value.responsibleSettlement" :editMode="editMode" :inputUI="''"/>
            <String label="Position" v-model="value.position" :editMode="editMode" :inputUI="''"/>
            <String label="ResponsibleTask" v-model="value.responsibleTask" :editMode="editMode" :inputUI="''"/>
            <String label="PhoneNumber" v-model="value.phoneNumber" :editMode="editMode" :inputUI="''"/>
            <String label="LicenseNumber" v-model="value.licenseNumber" :editMode="editMode" :inputUI="''"/>
            <String label="IdNumber" v-model="value.idNumber" :editMode="editMode" :inputUI="''"/>
            <String label="ResponsibleVehicleNumber" v-model="value.responsibleVehicleNumber" :editMode="editMode" :inputUI="''"/>
            <String label="VehicleType" v-model="value.vehicleType" :editMode="editMode" :inputUI="''"/>
            <String label="RetirementStatus" v-model="value.retirementStatus" :editMode="editMode" :inputUI="''"/>
            <Date label="RetirementDate" v-model="value.retirementDate" :editMode="editMode" :inputUI="''"/>
            <String label="Photo" v-model="value.photo" :editMode="editMode" :inputUI="''"/>
            <String label="Remarks" v-model="value.remarks" :editMode="editMode" :inputUI="''"/>
            <EmployeeInfo offline label="EmployeeInfo" v-model="value.employeeInfo" :editMode="editMode" @change="change"/>
            <EmployeeId offline label="EmployeeId" v-model="value.employeeId" :editMode="editMode" @change="change"/>
            <Name offline label="Name" v-model="value.name" :editMode="editMode" @change="change"/>
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
                    CreateEmployeeManagement
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="save"
                >
                    DeleteEmployeeManagement
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
            <v-btn
                v-if="!editMode"
                color="primary"
                text
                @click="openProcessEmployeeRetirement"
            >
                ProcessEmployeeRetirement
            </v-btn>
            <v-dialog v-model="processEmployeeRetirementDiagram" width="500">
                <ProcessEmployeeRetirementCommand
                    @closeDialog="closeProcessEmployeeRetirement"
                    @processEmployeeRetirement="processEmployeeRetirement"
                ></ProcessEmployeeRetirementCommand>
            </v-dialog>
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
        name: 'OthermanagementEmployeeManagement',
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
            processEmployeeRetirementDiagram: false,
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
                            temp = await axios.post(axios.fixUrl('/employeeManagements'), this.value)
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
            async processEmployeeRetirement(params) {
                try {
                    if(!this.offline) {
                        var temp = await axios.put(axios.fixUrl(this.value._links['processemployeeretirement'].href), params)
                        for(var k in temp.data) {
                            this.value[k]=temp.data[k];
                        }
                    }

                    this.editMode = false;
                    this.closeProcessEmployeeRetirement();
                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
            },
            openProcessEmployeeRetirement() {
                this.processEmployeeRetirementDiagram = true;
            },
            closeProcessEmployeeRetirement() {
                this.processEmployeeRetirementDiagram = false;
            },
        },
    }
</script>

