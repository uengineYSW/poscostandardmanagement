

<template>
    <v-app id="inspire">
        <div>
            <v-app-bar color="primary" app clipped-left flat>
                <v-toolbar-title>
                    <span class="second-word font uppercase"
                        style="font-weight:700;"
                    >
                        <v-app-bar-nav-icon
                            @click="openSideBar()"
                            style="z-index:1;
                            height:56px;
                            width:30px;
                            margin-right:10px;
                            font-weight:300;
                            font-size:55px;"
                        >
                            <div style="line-height:100%;">≡</div>
                        </v-app-bar-nav-icon>
                    </span>
                </v-toolbar-title>
                <span v-if="urlPath!=null" 
                    class="mdi mdi-home" 
                    key="" 
                    to="/" 
                    @click="goHome()"
                    style="margin-left:10px; font-size:20px; cursor:pointer;"
		        ></span> 
                <v-spacer></v-spacer>

            </v-app-bar>

            <v-navigation-drawer app clipped flat v-model="sideBar">
                <v-list>
                    <v-list-item
                        class="px-2"
                        key="dispatchRequests"
                        to="/standardmanagements/dispatchRequests"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        DispatchRequest
                    </v-list-item>

                    <v-list-item
                        class="px-2"
                        key="vehicleInfos"
                        to="/standardmanagements/vehicleInfos"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        VehicleInfo
                    </v-list-item>

                    <v-list-item
                        class="px-2"
                        key="vehicleChanges"
                        to="/standardmanagements/vehicleChanges"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        VehicleChange
                    </v-list-item>

                    <v-list-item
                        class="px-2"
                        key="preventiveInspections"
                        to="/standardmanagements/preventiveInspections"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        PreventiveInspection
                    </v-list-item>

                    <v-list-item
                        class="px-2"
                        key="operationRecords"
                        to="/standardmanagements/operationRecords"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        OperationRecord
                    </v-list-item>

                    <v-list-item
                        class="px-2"
                        key="maintenanceRecords"
                        to="/standardmanagements/maintenanceRecords"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        MaintenanceRecord
                    </v-list-item>

                    <v-list-item
                        class="px-2"
                        key="insuranceInfos"
                        to="/standardmanagements/insuranceInfos"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        InsuranceInfo
                    </v-list-item>

                    <v-list-item
                        class="px-2"
                        key="accidentRecords"
                        to="/standardmanagements/accidentRecords"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        AccidentRecord
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="vehicleManagements"
                        to="/othermanagements/vehicleManagements"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        VehicleManagement
                    </v-list-item>

                    <v-list-item
                        class="px-2"
                        key="settlementManagements"
                        to="/othermanagements/settlementManagements"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        SettlementManagement
                    </v-list-item>

                    <v-list-item
                        class="px-2"
                        key="codeManagements"
                        to="/othermanagements/codeManagements"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        CodeManagement
                    </v-list-item>

                    <v-list-item
                        class="px-2"
                        key="employeeManagements"
                        to="/othermanagements/employeeManagements"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        EmployeeManagement
                    </v-list-item>


                </v-list>
            </v-navigation-drawer>
        </div>

        <v-main>
            <v-container style="padding:0px;" v-if="urlPath" fluid>
                <router-view></router-view>
            </v-container>
            <v-container style="padding:0px;" v-else fluid>
                <div style="width:100%; margin:0px 0px 20px 0px; position: relative;">
                    <v-img style="width:100%; height:300px;"
                        src=""
                    ></v-img>
                    <div class="App-main-text-overlap"></div>
                    <div class="App-sub-text-overlap"></div>
                </div>
                <v-row>
                    <v-col cols="4" class="d-flex justify-center" v-for="(aggregate, index) in aggregate" :key="index">
                        <div 
                            class="flip-card"
                            @mouseover="flipCard(index)"
                            @mouseleave="unflipCard(index)"
                            :class="{ 'is-flipped': flipped[index] }"
                        >
                            <div class="flip-card-inner">
                                <div class="flip-card-front">
                                    <v-card
                                        class="mx-auto"
                                        style="width:300px; min-height: 310px; margin-bottom:20px; text-align: center; border-radius: 10px;"
                                        outlined
                                    >
                                        <v-list-item style="padding:15px; margin:0px;">
                                            <v-img style="width:100%; height:120px; border-radius: 10px;" :src="aggregate.ImageUrl"></v-img>
                                        </v-list-item>
                                        <div style="text-align: left; padding:10px 15px 15px 15px; margin-top:-10px;">
                                            <h2>{{ aggregate.title }}</h2>
                                            <div>{{ aggregate.description }}</div>
                                        </div>
                                    </v-card>
                                </div>
                                <div class="flip-card-back">
                                    <v-card
                                        color="primary"
                                        class="mx-auto"
                                        style="width:300px; min-height: 310px; margin-bottom:20px; text-align: center; border-radius: 10px;"
                                        outlined
                                        :key="aggregate.key"
                                        :to="aggregate.route"
                                        @click="changeUrl()"
                                    >
                                        <v-list-item style="padding:15px; margin:0px;">
                                            <v-img style="width:100%; height:120px; border-radius: 10px;" :src="aggregate.ImageUrl"></v-img>
                                        </v-list-item>
                                        <h2 style="color:white;">{{ aggregate.title }} 관리</h2>
                                    </v-card>
                                </div>
                            </div>
                        </div>
                    </v-col>
                </v-row>
            </v-container>
        </v-main>
    </v-app>
</template>

<script>

export default {
    name: "App",
    data: () => ({
        useComponent: "",
        drawer: true,
        components: [],
        sideBar: true,
        urlPath: null,
        flipped: [],
        ImageUrl: '',
        aggregate: [
            { 
                title: 'DispatchRequest', 
                description: '', 
                key: 'dispatchRequests', 
                route: '/standardmanagements/dispatchRequests',
                ImageUrl: '',
            },
            { 
                title: 'VehicleInfo', 
                description: '차량 사용불가능 처리 커맨드 추가', 
                key: 'vehicleInfos', 
                route: '/standardmanagements/vehicleInfos',
                ImageUrl: '',
            },
            { 
                title: 'VehicleChange', 
                description: '', 
                key: 'vehicleChanges', 
                route: '/standardmanagements/vehicleChanges',
                ImageUrl: '',
            },
            { 
                title: 'PreventiveInspection', 
                description: '', 
                key: 'preventiveInspections', 
                route: '/standardmanagements/preventiveInspections',
                ImageUrl: '',
            },
            { 
                title: 'OperationRecord', 
                description: '', 
                key: 'operationRecords', 
                route: '/standardmanagements/operationRecords',
                ImageUrl: '',
            },
            { 
                title: 'MaintenanceRecord', 
                description: '', 
                key: 'maintenanceRecords', 
                route: '/standardmanagements/maintenanceRecords',
                ImageUrl: '',
            },
            { 
                title: 'InsuranceInfo', 
                description: '', 
                key: 'insuranceInfos', 
                route: '/standardmanagements/insuranceInfos',
                ImageUrl: '',
            },
            { 
                title: 'AccidentRecord', 
                description: '', 
                key: 'accidentRecords', 
                route: '/standardmanagements/accidentRecords',
                ImageUrl: '',
            },
            { 
                title: 'VehicleManagement', 
                description: 'update command 생성', 
                key: 'vehicleManagements', 
                route: '/othermanagements/vehicleManagements',
                ImageUrl: '',
            },
            { 
                title: 'SettlementManagement', 
                description: '', 
                key: 'settlementManagements', 
                route: '/othermanagements/settlementManagements',
                ImageUrl: '',
            },
            { 
                title: 'CodeManagement', 
                description: '', 
                key: 'codeManagements', 
                route: '/othermanagements/codeManagements',
                ImageUrl: '',
            },
            { 
                title: 'EmployeeManagement', 
                description: '직원 은퇴처리 커맨드 추가', 
                key: 'employeeManagements', 
                route: '/othermanagements/employeeManagements',
                ImageUrl: '',
            },
            
        ],
    }),
    
    async created() {
      var path = document.location.href.split("#/")
      this.urlPath = path[1];

    },
    watch: {
        cards(newCards) {
            this.flipped = new Array(newCards.length).fill(false);
        },
    },

    mounted() {
        var me = this;
        me.components = this.$ManagerLists;
    },

    methods: {
        openSideBar(){
            this.sideBar = !this.sideBar
        },
        changeUrl() {
            var path = document.location.href.split("#/")
            this.urlPath = path[1];
            this.flipped.fill(false);
        },
        goHome() {
            this.urlPath = null;
        },
        flipCard(index) {
            this.$set(this.flipped, index, true);
        },
        unflipCard(index) {
            this.$set(this.flipped, index, false);
        },
    }
};
</script>
<style>
</style>
