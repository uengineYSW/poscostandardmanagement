
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import StandardmanagementDispatchRequestManager from "./components/listers/StandardmanagementDispatchRequestCards"
import StandardmanagementDispatchRequestDetail from "./components/listers/StandardmanagementDispatchRequestDetail"
import StandardmanagementVehicleInfoManager from "./components/listers/StandardmanagementVehicleInfoCards"
import StandardmanagementVehicleInfoDetail from "./components/listers/StandardmanagementVehicleInfoDetail"
import StandardmanagementVehicleChangeManager from "./components/listers/StandardmanagementVehicleChangeCards"
import StandardmanagementVehicleChangeDetail from "./components/listers/StandardmanagementVehicleChangeDetail"
import StandardmanagementPreventiveInspectionManager from "./components/listers/StandardmanagementPreventiveInspectionCards"
import StandardmanagementPreventiveInspectionDetail from "./components/listers/StandardmanagementPreventiveInspectionDetail"
import StandardmanagementOperationRecordManager from "./components/listers/StandardmanagementOperationRecordCards"
import StandardmanagementOperationRecordDetail from "./components/listers/StandardmanagementOperationRecordDetail"
import StandardmanagementMaintenanceRecordManager from "./components/listers/StandardmanagementMaintenanceRecordCards"
import StandardmanagementMaintenanceRecordDetail from "./components/listers/StandardmanagementMaintenanceRecordDetail"
import StandardmanagementInsuranceInfoManager from "./components/listers/StandardmanagementInsuranceInfoCards"
import StandardmanagementInsuranceInfoDetail from "./components/listers/StandardmanagementInsuranceInfoDetail"
import StandardmanagementAccidentRecordManager from "./components/listers/StandardmanagementAccidentRecordCards"
import StandardmanagementAccidentRecordDetail from "./components/listers/StandardmanagementAccidentRecordDetail"

import OthermanagementVehicleManagementManager from "./components/listers/OthermanagementVehicleManagementCards"
import OthermanagementVehicleManagementDetail from "./components/listers/OthermanagementVehicleManagementDetail"
import OthermanagementSettlementManagementManager from "./components/listers/OthermanagementSettlementManagementCards"
import OthermanagementSettlementManagementDetail from "./components/listers/OthermanagementSettlementManagementDetail"
import OthermanagementCodeManagementManager from "./components/listers/OthermanagementCodeManagementCards"
import OthermanagementCodeManagementDetail from "./components/listers/OthermanagementCodeManagementDetail"
import OthermanagementEmployeeManagementManager from "./components/listers/OthermanagementEmployeeManagementCards"
import OthermanagementEmployeeManagementDetail from "./components/listers/OthermanagementEmployeeManagementDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/standardmanagements/dispatchRequests',
                name: 'StandardmanagementDispatchRequestManager',
                component: StandardmanagementDispatchRequestManager
            },
            {
                path: '/standardmanagements/dispatchRequests/:id',
                name: 'StandardmanagementDispatchRequestDetail',
                component: StandardmanagementDispatchRequestDetail
            },
            {
                path: '/standardmanagements/vehicleInfos',
                name: 'StandardmanagementVehicleInfoManager',
                component: StandardmanagementVehicleInfoManager
            },
            {
                path: '/standardmanagements/vehicleInfos/:id',
                name: 'StandardmanagementVehicleInfoDetail',
                component: StandardmanagementVehicleInfoDetail
            },
            {
                path: '/standardmanagements/vehicleChanges',
                name: 'StandardmanagementVehicleChangeManager',
                component: StandardmanagementVehicleChangeManager
            },
            {
                path: '/standardmanagements/vehicleChanges/:id',
                name: 'StandardmanagementVehicleChangeDetail',
                component: StandardmanagementVehicleChangeDetail
            },
            {
                path: '/standardmanagements/preventiveInspections',
                name: 'StandardmanagementPreventiveInspectionManager',
                component: StandardmanagementPreventiveInspectionManager
            },
            {
                path: '/standardmanagements/preventiveInspections/:id',
                name: 'StandardmanagementPreventiveInspectionDetail',
                component: StandardmanagementPreventiveInspectionDetail
            },
            {
                path: '/standardmanagements/operationRecords',
                name: 'StandardmanagementOperationRecordManager',
                component: StandardmanagementOperationRecordManager
            },
            {
                path: '/standardmanagements/operationRecords/:id',
                name: 'StandardmanagementOperationRecordDetail',
                component: StandardmanagementOperationRecordDetail
            },
            {
                path: '/standardmanagements/maintenanceRecords',
                name: 'StandardmanagementMaintenanceRecordManager',
                component: StandardmanagementMaintenanceRecordManager
            },
            {
                path: '/standardmanagements/maintenanceRecords/:id',
                name: 'StandardmanagementMaintenanceRecordDetail',
                component: StandardmanagementMaintenanceRecordDetail
            },
            {
                path: '/standardmanagements/insuranceInfos',
                name: 'StandardmanagementInsuranceInfoManager',
                component: StandardmanagementInsuranceInfoManager
            },
            {
                path: '/standardmanagements/insuranceInfos/:id',
                name: 'StandardmanagementInsuranceInfoDetail',
                component: StandardmanagementInsuranceInfoDetail
            },
            {
                path: '/standardmanagements/accidentRecords',
                name: 'StandardmanagementAccidentRecordManager',
                component: StandardmanagementAccidentRecordManager
            },
            {
                path: '/standardmanagements/accidentRecords/:id',
                name: 'StandardmanagementAccidentRecordDetail',
                component: StandardmanagementAccidentRecordDetail
            },

            {
                path: '/othermanagements/vehicleManagements',
                name: 'OthermanagementVehicleManagementManager',
                component: OthermanagementVehicleManagementManager
            },
            {
                path: '/othermanagements/vehicleManagements/:id',
                name: 'OthermanagementVehicleManagementDetail',
                component: OthermanagementVehicleManagementDetail
            },
            {
                path: '/othermanagements/settlementManagements',
                name: 'OthermanagementSettlementManagementManager',
                component: OthermanagementSettlementManagementManager
            },
            {
                path: '/othermanagements/settlementManagements/:id',
                name: 'OthermanagementSettlementManagementDetail',
                component: OthermanagementSettlementManagementDetail
            },
            {
                path: '/othermanagements/codeManagements',
                name: 'OthermanagementCodeManagementManager',
                component: OthermanagementCodeManagementManager
            },
            {
                path: '/othermanagements/codeManagements/:id',
                name: 'OthermanagementCodeManagementDetail',
                component: OthermanagementCodeManagementDetail
            },
            {
                path: '/othermanagements/employeeManagements',
                name: 'OthermanagementEmployeeManagementManager',
                component: OthermanagementEmployeeManagementManager
            },
            {
                path: '/othermanagements/employeeManagements/:id',
                name: 'OthermanagementEmployeeManagementDetail',
                component: OthermanagementEmployeeManagementDetail
            },



    ]
})
