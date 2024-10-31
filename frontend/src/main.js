 /*eslint-disable*/
import Vue from "vue";
import App from "./App.vue";
import vuetify from "./plugins/vuetify";
import Managing from "./components";
import router from './router';
Vue.config.productionTip = false;
require('./GlobalStyle.css');

const axios = require("axios").default;

// backend host url
axios.backend = null; //"http://localhost:8088";

// axios.backendUrl = new URL(axios.backend);
axios.fixUrl = function(original){

  if(!axios.backend && original.indexOf("/")==0) return original;

  var url = null;

  try{
    url = new URL(original);
  }catch(e){
    url = new URL(axios.backend + original);
  }

  if(!axios.backend) return url.pathname;

  url.hostname = axios.backendUrl.hostname;
  url.port = axios.backendUrl.port;

  return url.href;
}

const templateFiles = require.context("./components", true);
Vue.prototype.$ManagerLists = [];
templateFiles.keys().forEach(function(tempFiles) {
  if (!tempFiles.includes("Manager.vue") && tempFiles.includes("vue")) {
    Vue.prototype.$ManagerLists.push(
      tempFiles.replace("./", "").replace(".vue", "")
    );
  }
});
Vue.use(Managing);
const pluralCaseList = []

pluralCaseList.push( {plural: "standardmanagements/dispatchRequests", pascal: "StandardmanagementDispatchRequest"} )
pluralCaseList.push( {plural: "standardmanagements/vehicleInfos", pascal: "StandardmanagementVehicleInfo"} )
pluralCaseList.push( {plural: "standardmanagements/vehicleChanges", pascal: "StandardmanagementVehicleChange"} )
pluralCaseList.push( {plural: "standardmanagements/preventiveInspections", pascal: "StandardmanagementPreventiveInspection"} )
pluralCaseList.push( {plural: "standardmanagements/operationRecords", pascal: "StandardmanagementOperationRecord"} )
pluralCaseList.push( {plural: "standardmanagements/maintenanceRecords", pascal: "StandardmanagementMaintenanceRecord"} )
pluralCaseList.push( {plural: "standardmanagements/insuranceInfos", pascal: "StandardmanagementInsuranceInfo"} )
pluralCaseList.push( {plural: "standardmanagements/accidentRecords", pascal: "StandardmanagementAccidentRecord"} )

pluralCaseList.push( {plural: "othermanagements/vehicleManagements", pascal: "OthermanagementVehicleManagement"} )
pluralCaseList.push( {plural: "othermanagements/settlementManagements", pascal: "OthermanagementSettlementManagement"} )
pluralCaseList.push( {plural: "othermanagements/codeManagements", pascal: "OthermanagementCodeManagement"} )
pluralCaseList.push( {plural: "othermanagements/employeeManagements", pascal: "OthermanagementEmployeeManagement"} )


Vue.prototype.$ManagerLists.forEach(function(item, idx) {
  pluralCaseList.forEach(function(tmp) {
    if(item.toLowerCase() == tmp.pascal.toLowerCase()) {
      var obj = {
        name: item,
        plural: tmp.plural
      }
      Vue.prototype.$ManagerLists[idx] = obj
    }
  })
})

new Vue({
  vuetify,
  router,
  render: h => h(App)
}).$mount("#app");
