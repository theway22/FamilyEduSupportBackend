(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-942a0cd8","chunk-2d21b2be"],{"74cc":function(e,t,s){"use strict";s.r(t);var i=function(){var e=this,t=e._self._c;return t("div",{staticClass:"mypanel"},[t("div",{staticClass:"hd"},[e._v(" 系统设置管理 ")]),t("div",{staticClass:"bd"},[t("div",{staticClass:"search-options"},[t("table",{attrs:{cellspacing:"0",width:"100%"}},[t("tbody",[t("tr",[t("td",[e._v(" 名称: "),t("input",{directives:[{name:"model",rawName:"v-model",value:e.name,expression:"name"}],staticClass:"input-txt",attrs:{name:"name",type:"text"},domProps:{value:e.name},on:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.search.apply(null,arguments)},input:function(t){t.target.composing||(e.name=t.target.value)}}}),t("el-button",{attrs:{type:"primary",icon:"el-icon-search"},on:{click:e.search}},[e._v(" 搜索 ")])],1)])])])]),t("div",{staticClass:"action-details"},[t("el-button-group",[t("el-button",{attrs:{type:"danger",icon:"el-icon-delete"},on:{click:e.deleteRec}},[e._v(" 删除")]),t("route-button",{attrs:{url:"/admin/sysconfigadd",icon:"el-icon-plus"}},[e._v("新增介绍")])],1)],1),t("table",{staticClass:"ui-record-table",attrs:{width:"100%",border:"0",cellspacing:"0",cellpadding:"0"}},[t("thead",[t("tr",[t("th",[t("input",{directives:[{name:"model",rawName:"v-model",value:e.selectedAll,expression:"selectedAll"}],attrs:{type:"checkbox"},domProps:{checked:Array.isArray(e.selectedAll)?e._i(e.selectedAll,null)>-1:e.selectedAll},on:{click:e.selectedAllHandler,change:function(t){var s=e.selectedAll,i=t.target,a=!!i.checked;if(Array.isArray(s)){var n=null,l=e._i(s,n);i.checked?l<0&&(e.selectedAll=s.concat([n])):l>-1&&(e.selectedAll=s.slice(0,l).concat(s.slice(l+1)))}else e.selectedAll=a}}})]),e._m(0),t("th",[e._v(" 操作 ")])])]),t("tbody",[e._l(e.listSysconfig,(function(s){return t("tr",{key:s.id},[t("td",[t("input",{directives:[{name:"model",rawName:"v-model",value:s.rowSelected,expression:"sysconfig.rowSelected"}],staticClass:"check",attrs:{name:"ids",type:"checkbox"},domProps:{checked:Array.isArray(s.rowSelected)?e._i(s.rowSelected,null)>-1:s.rowSelected},on:{change:function(t){var i=s.rowSelected,a=t.target,n=!!a.checked;if(Array.isArray(i)){var l=null,c=e._i(i,l);a.checked?c<0&&e.$set(s,"rowSelected",i.concat([l])):c>-1&&e.$set(s,"rowSelected",i.slice(0,c).concat(i.slice(c+1)))}else e.$set(s,"rowSelected",n)}}})]),t("td",[t("el-tag",[t("router-link",{attrs:{to:"/admin/sysconfigadd?id="+s.id}},[e._v(e._s(s.name))])],1)],1),t("td",[t("el-button-group",[t("route-button",{attrs:{url:"/admin/sysconfigdetails?id="+s.id}},[e._v("编辑")])],1)],1)])})),0==e.listSysconfig.length?t("tr",[t("td",{attrs:{colspan:"20"}},[e._v(" 没有相关系统设置信息 ")])]):e._e()],2)]),t("el-pagination",{attrs:{"current-page":e.pageindex,"page-sizes":[e.pagesize],"page-size":e.pagesize,layout:"total, sizes, prev, pager, next, jumper",total:e.total},on:{"size-change":e.pagesizeChange,"current-change":e.pageindexChange}})],1)])},a=[function(){var e=this,t=e._self._c;return t("th",[t("b",[e._v("名称")])])}],n=s("bf48"),l={name:"sysconfigmanager",data(){return{name:"",hostHead:this.$app.contextPath,selectedAll:!1,listSysconfig:[],pageindex:1,pagesize:10,total:10}},methods:{pagesizeChange:function(e){this.pagesize=e},pageindexChange:function(e){this.pageindex=e,console.log(this.pageindex),this.search()},async search(){let e="admin/sysconfig/list",t={currentpageindex:this.pageindex,pagesize:this.pagesize,name:this.name},s=new n["VueUtil"](this);console.log("this.pageindex="+this.pageindex);let i=await s.http.post(e,t);if(null!=i.data){let e=i.data.data;this.total=e.total,this.listSysconfig=e.list,console.log(e)}},async deleteRec(){let e="admin/sysconfig/delete",t=new n["VueUtil"](this),s=this.listSysconfig.some(e=>1==e.rowSelected);if(!s)return void t.alert("请选择需要删除的记录","系统提示",{confirmButtonText:"确定"});let i=this.listSysconfig.filter(e=>e.rowSelected).map(e=>e.id);t.confirm("是否要删除数据?","系统提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(()=>{t.http.post(e,{ids:i},{emulateJSON:!1}).then(e=>{null!=e.data&&e.data.stateCode>0&&this.search()})}).catch(()=>{})},selectedAllHandler(){console.log(this.selectedAll),null!=this.listSysconfig&&this.listSysconfig.forEach(e=>{e.rowSelected=!this.selectedAll})}},created(){this.search()}},c=l,o=s("2877"),r=Object(o["a"])(c,i,a,!1,null,"9e98ac78",null);t["default"]=r.exports},bf48:function(e,t,s){"use strict";s.r(t),s.d(t,"VueUtil",(function(){return i})),Date.prototype.format=function(e){let t={"M+":this.getMonth()+1,"d+":this.getDate(),"H+":this.getHours(),"m+":this.getMinutes(),"s+":this.getSeconds(),"q+":Math.floor((this.getMonth()+3)/3),S:this.getMilliseconds()};/(y+)/.test(e)&&(e=e.replace(RegExp.$1,(this.getFullYear()+"").substr(4-RegExp.$1.length)));for(let s in t)new RegExp("("+s+")").test(e)&&(e=e.replace(RegExp.$1,1==RegExp.$1.length?t[s]:("00"+t[s]).substr((""+t[s]).length)));return e};let i=function(e){this.http=e.$http,this.alert=e.$alert,this.confirm=e.$confirm,this.message=e.$message,this.isDuringDate=function(e,t){let s=new Date,i=new Date(e),a=new Date(t);return s>=i&&s<=a},this.isPasted=function(e,t){let s=new Date,i=(new Date(e),new Date(t));return s>i}}}}]);
//# sourceMappingURL=chunk-942a0cd8.9992293b.js.map