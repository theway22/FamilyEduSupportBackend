(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-ae2c3140","chunk-2d21b2be"],{"44c4":function(e,t,s){"use strict";s.r(t);var l=function(){var e=this,t=e._self._c;return t("div",{staticClass:"panel panel-default"},[t("div",{staticClass:"panel-heading"},[e._v(" "+e._s(e.sysconfig.name)+" ")]),t("div",{staticClass:"panel-body"},[t("div",{staticClass:"action-details"},[t("el-button-group",[t("el-button",{attrs:{type:"danger",icon:"el-icon-delete"},on:{click:e.deleteRec}},[e._v(" 删除")]),t("route-button",{attrs:{icon:"el-icon-plus",url:"/admin/sysconfigitemadd?cfgid="+e.sysconfig.id}},[e._v("新增")])],1)],1),t("table",{staticClass:"ui-record-table",attrs:{width:"100%",border:"0",cellspacing:"0",cellpadding:"0"}},[t("thead",[t("tr",[t("th",[t("input",{directives:[{name:"model",rawName:"v-model",value:e.selectedAll,expression:"selectedAll"}],attrs:{type:"checkbox"},domProps:{checked:Array.isArray(e.selectedAll)?e._i(e.selectedAll,null)>-1:e.selectedAll},on:{click:e.selectedAllHandler,change:function(t){var s=e.selectedAll,l=t.target,i=!!l.checked;if(Array.isArray(s)){var c=null,n=e._i(s,c);l.checked?n<0&&(e.selectedAll=s.concat([c])):n>-1&&(e.selectedAll=s.slice(0,n).concat(s.slice(n+1)))}else e.selectedAll=i}}})]),e._m(0),e._m(1),t("th",[e._v(" 操作 ")])])]),t("tbody",[e._l(e.sysconfig.cfgitems,(function(s){return t("tr",{key:s.id},[t("td",[t("input",{directives:[{name:"model",rawName:"v-model",value:s.rowSelected,expression:"sysconfigitem.rowSelected"}],staticClass:"check",attrs:{name:"ids",type:"checkbox"},domProps:{checked:Array.isArray(s.rowSelected)?e._i(s.rowSelected,null)>-1:s.rowSelected},on:{change:function(t){var l=s.rowSelected,i=t.target,c=!!i.checked;if(Array.isArray(l)){var n=null,a=e._i(l,n);i.checked?a<0&&e.$set(s,"rowSelected",l.concat([n])):a>-1&&e.$set(s,"rowSelected",l.slice(0,a).concat(l.slice(a+1)))}else e.$set(s,"rowSelected",c)}}})]),t("td",[e._v(" "+e._s(s.title)+" ")]),t("td",[1==s.type?t("el-tag",[e._v("内部显示")]):e._e(),2==s.type?t("el-tag",[e._v("外部显示")]):e._e()],1),t("td",[t("el-button-group",[t("route-button",{attrs:{icon:"el-icon-edit",url:"/admin/sysconfigitemadd?id="+s.id}},[e._v("编辑")])],1)],1)])})),null!=e.sysconfig.cfgitem&&0==e.sysconfig.cfgitems.length?t("tr",[t("td",{attrs:{colspan:"20"}},[e._v(" 没有相关设置项信息 ")])]):e._e()],2)])])])},i=[function(){var e=this,t=e._self._c;return t("th",[t("b",[e._v("标题")])])},function(){var e=this,t=e._self._c;return t("th",[t("b",[e._v("类型")])])}],c=s("bf48"),n={name:"sysconfigdetails",data(){return{hostHead:this.$app.contextPath,sysconfig:{},selectedAll:!1}},methods:{async load(){let e=this.$route.query.id,t=new c["VueUtil"](this);if(null!=e){let s="admin/sysconfig/load",{data:l}=await t.http.post(s,{id:e});console.log("res",l),null!=l&&null!=l.data&&(this.sysconfig=l.data)}},async deleteRec(){let e="admin/sysconfigitem/delete",t=new c["VueUtil"](this),s=this.sysconfig.cfgitems.some(e=>1==e.rowSelected);if(!s)return void t.alert("请选择需要删除的记录","系统提示",{confirmButtonText:"确定"});let l=this.sysconfig.cfgitems.filter(e=>e.rowSelected).map(e=>e.id);t.confirm("是否要删除数据?","系统提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(()=>{t.http.post(e,{ids:l},{emulateJSON:!1}).then(e=>{null!=e.data&&e.data.stateCode>0&&this.load()})}).catch(()=>{})},selectedAllHandler(){console.log(this.selectedAll),null!=this.sysconfig.cfgitems&&this.sysconfig.cfgitems.forEach(e=>{e.rowSelected=!this.selectedAll})}},created(){this.load()}},a=n,o=s("2877"),r=Object(o["a"])(a,l,i,!1,null,"02bde5e3",null);t["default"]=r.exports},bf48:function(e,t,s){"use strict";s.r(t),s.d(t,"VueUtil",(function(){return l})),Date.prototype.format=function(e){let t={"M+":this.getMonth()+1,"d+":this.getDate(),"H+":this.getHours(),"m+":this.getMinutes(),"s+":this.getSeconds(),"q+":Math.floor((this.getMonth()+3)/3),S:this.getMilliseconds()};/(y+)/.test(e)&&(e=e.replace(RegExp.$1,(this.getFullYear()+"").substr(4-RegExp.$1.length)));for(let s in t)new RegExp("("+s+")").test(e)&&(e=e.replace(RegExp.$1,1==RegExp.$1.length?t[s]:("00"+t[s]).substr((""+t[s]).length)));return e};let l=function(e){this.http=e.$http,this.alert=e.$alert,this.confirm=e.$confirm,this.message=e.$message,this.isDuringDate=function(e,t){let s=new Date,l=new Date(e),i=new Date(t);return s>=l&&s<=i},this.isPasted=function(e,t){let s=new Date,l=(new Date(e),new Date(t));return s>l}}}}]);
//# sourceMappingURL=chunk-ae2c3140.e3603b34.js.map