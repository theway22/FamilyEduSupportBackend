(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-bbc87240","chunk-2d21b2be"],{"53b5":function(e,t,a){"use strict";a.r(t);var s=function(){var e=this,t=e._self._c;return t("div",{staticClass:"mypanel"},[t("div",{staticClass:"hd"},[e._v(" 页面设置管理 ")]),t("div",{staticClass:"bd"},[t("div",{staticClass:"search-options"},[t("table",{attrs:{cellspacing:"0",width:"100%"}},[t("tbody",[t("tr",[t("td",[e._v(" 名称: "),t("input",{directives:[{name:"model",rawName:"v-model",value:e.name,expression:"name"}],staticClass:"input-txt",attrs:{name:"name",type:"text"},domProps:{value:e.name},on:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.search.apply(null,arguments)},input:function(t){t.target.composing||(e.name=t.target.value)}}}),t("el-button",{attrs:{type:"primary"},on:{click:e.search}},[t("i",{staticClass:"el-icon-search"}),e._v("搜索 ")])],1)])])])]),t("div",{staticClass:"clear"}),t("div",{staticClass:"action-details"},[t("el-button-group",[t("el-button",{attrs:{type:"danger"},on:{click:e.deleteRec}},[t("i",{staticClass:"el-icon-delete"}),e._v("删除")])],1)],1),t("table",{staticClass:"ui-record-table",attrs:{id:"pagesetting",width:"100%",border:"0",cellspacing:"0",cellpadding:"0"}},[t("thead",[t("tr",[t("th",[t("input",{directives:[{name:"model",rawName:"v-model",value:e.selectedAll,expression:"selectedAll"}],attrs:{type:"checkbox"},domProps:{checked:Array.isArray(e.selectedAll)?e._i(e.selectedAll,null)>-1:e.selectedAll},on:{click:e.selectedAllHandler,change:function(t){var a=e.selectedAll,s=t.target,i=!!s.checked;if(Array.isArray(a)){var n=null,l=e._i(a,n);s.checked?l<0&&(e.selectedAll=a.concat([n])):l>-1&&(e.selectedAll=a.slice(0,l).concat(a.slice(l+1)))}else e.selectedAll=i}}})]),e._m(0),t("th",[e._v(" 操作 ")])])]),t("tbody",[e._l(e.listPagesetting,(function(a){return t("tr",{key:a.id},[t("td",[t("input",{directives:[{name:"model",rawName:"v-model",value:a.rowSelected,expression:"pagesetting.rowSelected"}],staticClass:"check",attrs:{name:"ids",type:"checkbox"},domProps:{checked:Array.isArray(a.rowSelected)?e._i(a.rowSelected,null)>-1:a.rowSelected},on:{change:function(t){var s=a.rowSelected,i=t.target,n=!!i.checked;if(Array.isArray(s)){var l=null,c=e._i(s,l);i.checked?c<0&&e.$set(a,"rowSelected",s.concat([l])):c>-1&&e.$set(a,"rowSelected",s.slice(0,c).concat(s.slice(c+1)))}else e.$set(a,"rowSelected",n)}}})]),t("td",[e._v(" "+e._s(a.name)+" ")]),t("td",[t("el-button-group",[t("route-button",{attrs:{icon:"el-icon-edit",url:"/admin/pagesettingadd?id="+a.id}},[e._v("编辑")]),t("route-button",{attrs:{icon:"el-icon-setting",type:"danger",url:"/admin/psitemmanager?pageid="+a.id}},[e._v("设置")])],1)],1)])})),0==e.listPagesetting.length?t("tr",[t("td",{attrs:{colspan:"20"}},[e._v(" 没有相关页面设置信息 ")])]):e._e()],2)]),t("el-pagination",{attrs:{"current-page":e.pageindex,"page-sizes":[e.pagesize],"page-size":e.pagesize,layout:"total, sizes, prev, pager, next, jumper",total:e.total},on:{"size-change":e.pagesizeChange,"current-change":e.pageindexChange}}),t("div",{staticClass:"clear"})],1)])},i=[function(){var e=this,t=e._self._c;return t("th",[t("b",[e._v("名称")])])}],n=a("bf48"),l={name:"pagesettingmanager",data(){return{name:"",hostHead:this.$app.contextPath,selectedAll:!1,listPagesetting:[],pageindex:1,pagesize:10,total:10}},methods:{pagesizeChange:function(e){this.pagesize=e},pageindexChange:function(e){this.pageindex=e,console.log(this.pageindex),this.search()},async search(){let e="admin/pagesetting/list",t={currentpageindex:this.pageindex,pagesize:this.pagesize,name:this.name},a=new n["VueUtil"](this);console.log("this.pageindex="+this.pageindex);let s=await a.http.post(e,t);if(null!=s.data){let e=s.data.data;this.total=e.total,this.listPagesetting=e.list,console.log(e)}},async deleteRec(){let e="admin/pagesetting/delete",t=new n["VueUtil"](this),a=this.listPagesetting.some(e=>1==e.rowSelected);if(!a)return void t.alert("请选择需要删除的记录","系统提示",{confirmButtonText:"确定"});let s=this.listPagesetting.filter(e=>e.rowSelected).map(e=>e.id);t.confirm("是否要删除数据?","系统提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(()=>{t.http.post(e,{ids:s},{emulateJSON:!1}).then(e=>{null!=e.data&&e.data.stateCode>0&&this.search()})}).catch(()=>{})},selectedAllHandler(){console.log(this.selectedAll),null!=this.listPagesetting&&this.listPagesetting.forEach(e=>{e.rowSelected=!this.selectedAll})}},created(){this.search()}},c=l,r=a("2877"),o=Object(r["a"])(c,s,i,!1,null,"b1c3c502",null);t["default"]=o.exports},bf48:function(e,t,a){"use strict";a.r(t),a.d(t,"VueUtil",(function(){return s})),Date.prototype.format=function(e){let t={"M+":this.getMonth()+1,"d+":this.getDate(),"H+":this.getHours(),"m+":this.getMinutes(),"s+":this.getSeconds(),"q+":Math.floor((this.getMonth()+3)/3),S:this.getMilliseconds()};/(y+)/.test(e)&&(e=e.replace(RegExp.$1,(this.getFullYear()+"").substr(4-RegExp.$1.length)));for(let a in t)new RegExp("("+a+")").test(e)&&(e=e.replace(RegExp.$1,1==RegExp.$1.length?t[a]:("00"+t[a]).substr((""+t[a]).length)));return e};let s=function(e){this.http=e.$http,this.alert=e.$alert,this.confirm=e.$confirm,this.message=e.$message,this.isDuringDate=function(e,t){let a=new Date,s=new Date(e),i=new Date(t);return a>=s&&a<=i},this.isPasted=function(e,t){let a=new Date,s=(new Date(e),new Date(t));return a>s}}}}]);
//# sourceMappingURL=chunk-bbc87240.e1e21fa3.js.map