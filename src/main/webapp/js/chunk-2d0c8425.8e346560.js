(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0c8425"],{"53b3":function(t,a,e){"use strict";e.r(a);var s=function(){var t=this,a=t._self._c;return a("div",{attrs:{id:"app"}},[a("table",{staticClass:"smart-table",attrs:{cellpadding:"0",cellspacing:"1",border:"1",width:"100%"}},[a("tr",[a("td",{staticClass:"tlabel",attrs:{align:"right"}},[t._v("名称:")]),a("td",[t._v(t._s(t.shangpin.name))]),a("td",{attrs:{colspan:"2",rowspan:"5"}},[a("img",{attrs:{id:"imgTupian",width:"200px",height:"200px",src:t.hostHead+t.shangpin.images[0]}})])]),a("tr",[a("td",{staticClass:"tlabel",attrs:{align:"right"}},[t._v("价格:")]),a("td",[t._v(t._s(t.shangpin.jiage)+"￥")])]),a("tr",[a("td",{staticClass:"tlabel",attrs:{align:"right"}},[t._v("物品库存:")]),a("td",{attrs:{colspan:"3"}},[t._v(t._s(t.shangpin.kucun)+t._s(t.shangpin.danwei))])]),a("tr",[a("td",{staticClass:"tlabel",attrs:{align:"right"}},[t._v("采购数量:")]),a("td",[a("input",{directives:[{name:"validate",rawName:"v-validate",value:{required:!0,digits:!0,messages:{required:"请输入数量",digits:"请输入正确数量"}},expression:"{required:true,digits:true,messages:{required:'请输入数量',digits:'请输入正确数量'}}"},{name:"model",rawName:"v-model",value:t.shuliang,expression:"shuliang"}],staticClass:"input-txt",staticStyle:{width:"120px"},attrs:{name:"shuliang",type:"text"},domProps:{value:t.shuliang},on:{input:function(a){a.target.composing||(t.shuliang=a.target.value)}}}),a("input",{directives:[{name:"model",rawName:"v-model",value:t.danwei,expression:"danwei"},{name:"validate",rawName:"v-validate",value:{required:!0,messages:{required:"请输入单位"}},expression:"{required:true,messages:{required:'请输入单位'}}"}],staticClass:"input-txt",staticStyle:{width:"80px"},attrs:{name:"danwei",type:"text"},domProps:{value:t.danwei},on:{input:function(a){a.target.composing||(t.danwei=a.target.value)}}})])]),a("tr",[a("td",{attrs:{colspan:"4"}},[a("el-button",{attrs:{type:"danger",icon:"el-icon-plus"},on:{click:t.addStockHandler}},[t._v("补充库存")])],1)])])])},i=[],n={name:"kucunadd",data(){return{count:1,hostHead:this.$app.contextPath,shangpin:{},shuliang:100,danwei:"",cgren:""}},created(){this.getShangpin(this.params.id)},props:{accountInfo:{type:Object},params:{type:Object,default:{}}},methods:{async getShangpin(t){let a="admin/shangpin/load",{data:e}=await this.$http.post(a,{id:t});null!=e&&e.stateCode<0?this.$message.error(e.des):(this.shangpin=e.data,this.danwei=this.shangpin.danwei)},async addStockHandler(){let t="admin/shangpin/addstock";const a=this.myValidator.valid(this);if(console.log("valRes",a),!a)return;let{data:e}=await this.$http.post(t,{id:this.shangpin.id,shuliang:this.shuliang,danwei:this.danwei});null!=e&&e.stateCode<0?this.$message.error(e.des):(this.$message.success("库存更新成功"),this.$emit("close",!1))}}},d=n,r=e("2877"),l=Object(r["a"])(d,s,i,!1,null,"4cadbd0c",null);a["default"]=l.exports}}]);
//# sourceMappingURL=chunk-2d0c8425.8e346560.js.map