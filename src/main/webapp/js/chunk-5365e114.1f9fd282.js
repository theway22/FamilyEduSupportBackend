(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-5365e114","chunk-707e9921","chunk-2d0a47f7","chunk-2d21b2be"],{"0760":function(e,t,s){"use strict";s.r(t);var l=function(){var e=this,t=e._self._c;return t("el-dialog",{attrs:{width:e.width,title:e.title,"close-on-click-modal":!1,visible:e.show},on:{"update:visible":e.closeHandler}},[e.reload?t(e.view,{tag:"component",attrs:{params:e.params},on:{close:e.closeHandler}}):e._e()],1)},i=[],a={name:"mydialog",data(){return{view:null,reload:!0,params:{}}},props:{url:{type:String,require:!0},width:{type:String,default:"80%"},xdata:{type:Object},title:{type:String,default:"详情"},show:{type:Boolean,require:!0}},methods:{loadComponent(e){return s("8673")("./"+e)},getParam(){if(-1==this.url.indexOf("?"))return{};let e=this.url.split("?")[1],t=new Object,s=e.split("&");for(var l=0;l<s.length;l++)t[s[l].split("=")[0]]=unescape(s[l].split("=")[1]);t=Object.assign(t,this.xdata),console.log("params",t),this.params=t},closeHandler(e){console.log("执行关闭"),this.$emit("update:show",e),this.$emit("close",!0)}},created(){let e=this.url;-1!=this.url.indexOf("?")&&(e=this.url.split("?")[0]),this.getParam(),console.log("this.params",this.params),e.startsWith("/")&&(e=e.substring(1)),this.loadComponent(e).then(e=>{this.view=e.default}),this.reload=!1,this.$nextTick(()=>{this.reload=!0})},watch:{show:{handler(e){if(!e)return;let t=this.url;-1!=this.url.indexOf("?")&&(t=this.url.split("?")[0]),this.getParam(),console.log("this.params",this.params),t.startsWith("/")&&(t=t.substring(1)),this.loadComponent(t).then(e=>{this.view=e.default}),this.reload=!1,this.$nextTick(()=>{this.reload=!0})},immediate:!0}}},n=a,r=s("2877"),o=Object(r["a"])(n,l,i,!1,null,"c578a174",null);t["default"]=o.exports},"17ab":function(e,t,s){"use strict";s.r(t);var l=function(){var e=this,t=e._self._c;return t("div",{staticClass:"panel panel-default"},[t("div",{staticClass:"panel-heading"},[e._v(" 后台角色管理 ")]),t("div",{staticClass:"panel-body"},[t("div",{staticClass:"search-options"},[t("table",{attrs:{cellspacing:"0",width:"100%"}},[t("tbody",[t("tr",[t("td",[e._v(" 名称:"),t("input",{directives:[{name:"model",rawName:"v-model",value:e.name,expression:"name"}],staticClass:"input-txt",attrs:{name:"name",type:"text"},domProps:{value:e.name},on:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.search.apply(null,arguments)},input:function(t){t.target.composing||(e.name=t.target.value)}}}),t("el-button",{attrs:{type:"primary"},on:{click:e.search}},[t("i",{staticClass:"el-icon-search"}),e._v("搜索 ")])],1)])])])]),t("div",{staticClass:"action-details"},[t("div",{staticClass:"el-button-group"},[t("el-button",{attrs:{type:"danger",icon:"el-icon-delete"},on:{click:e.deleteRec}},[e._v("删除")]),t("pop-dialg-button",{attrs:{width:"50%",title:"新增角色","css-class":"el-button",url:"/admin/sysroleadd"},on:{refresh:e.search}},[t("i",{staticClass:"el-icon-plus"}),e._v("新增角色")])],1)]),t("table",{staticClass:"ui-record-table",attrs:{width:"100%",border:"0",cellspacing:"0",cellpadding:"0"}},[t("thead",[t("tr",[t("th",[t("input",{directives:[{name:"model",rawName:"v-model",value:e.selectedAll,expression:"selectedAll"}],attrs:{type:"checkbox"},domProps:{checked:Array.isArray(e.selectedAll)?e._i(e.selectedAll,null)>-1:e.selectedAll},on:{click:e.selectedAllHandler,change:function(t){var s=e.selectedAll,l=t.target,i=!!l.checked;if(Array.isArray(s)){var a=null,n=e._i(s,a);l.checked?n<0&&(e.selectedAll=s.concat([a])):n>-1&&(e.selectedAll=s.slice(0,n).concat(s.slice(n+1)))}else e.selectedAll=i}}})]),e._m(0),t("th",[e._v(" 操作 ")])])]),t("tbody",[e._l(e.listSysrole,(function(s,l){return t("tr",{key:s.id},[t("td",[t("input",{directives:[{name:"model",rawName:"v-model",value:s.rowSelected,expression:"sysrole.rowSelected"}],staticClass:"check",attrs:{name:"ids",type:"checkbox"},domProps:{checked:Array.isArray(s.rowSelected)?e._i(s.rowSelected,null)>-1:s.rowSelected},on:{change:function(t){var l=s.rowSelected,i=t.target,a=!!i.checked;if(Array.isArray(l)){var n=null,r=e._i(l,n);i.checked?r<0&&e.$set(s,"rowSelected",l.concat([n])):r>-1&&e.$set(s,"rowSelected",l.slice(0,r).concat(l.slice(r+1)))}else e.$set(s,"rowSelected",a)}}})]),t("td",[e._v(" "+e._s(s.name)+" ")]),t("td",[t("div",{staticClass:"el-button-group"},[t("pop-dialg-button",{attrs:{width:"50%",title:"编辑角色","css-class":"el-button el-button--warning",url:"/admin/sysroleadd?id="+s.id},on:{refresh:e.search}},[t("i",{staticClass:"el-icon-edit"}),e._v("修改")])],1)])])})),0==e.listSysrole.length?t("tr",[t("td",{attrs:{colspan:"20"}},[e._v(" 没有相关后台角色信息 ")])]):e._e()],2)]),t("el-pagination",{attrs:{"current-page":e.pageindex,"page-sizes":[e.pagesize],"page-size":e.pagesize,layout:"total, sizes, prev, pager, next, jumper",total:e.total},on:{"size-change":e.pagesizeChange,"current-change":e.pageindexChange}}),t("div",{staticClass:"clear"})],1)])},i=[function(){var e=this,t=e._self._c;return t("th",[t("b",[e._v("名称")])])}],a=(s("14d9"),s("bf48")),n=s("8a8f"),r={name:"sysrolemanager",components:{PopDialgButton:n["default"]},data(){return{name:"",acldlg:!1,listSysresource:[],hostHead:this.$app.contextPath,selectedAll:!1,checkedIds:[],listAcl:[],listSysrole:[],sysrole:{},pageindex:1,pagesize:10,total:10}},methods:{pagesizeChange:function(e){this.pagesize=e},pageindexChange:function(e){this.pageindex=e,console.log(this.pageindex),this.search()},async setCheckedIds(){let e="admin/roleacl/list",t={roleid:this.sysrole.id};this.checkedIds=[];let{data:s}=await this.$http.post(e,t);null!=s&&(this.listAcl=s.data,null!=this.listAcl&&this.listAcl.length>0&&(this.checkedIds=this.listAcl.map(e=>e.id),console.log("this.checkedIds=",this.checkedIds)))},checkHandler(e,t,s){if(t){let t=this.checkedIds.findIndex(t=>t==e.id);-1==t&&this.checkedIds.push(e.id)}else{let t=this.checkedIds.findIndex(t=>t==e.id);-1!=t&&this.checkedIds.splice(t,1)}console.log(e,t,s)},async search(){let e="admin/sysrole/list",t={currentpageindex:this.pageindex,pagesize:this.pagesize,name:this.name},s=new a["VueUtil"](this);console.log("this.pageindex="+this.pageindex);let l=await s.http.post(e,t);if(null!=l.data){let e=l.data.data;this.total=e.total,this.listSysrole=e.list,console.log(e)}},async deleteRec(){let e="admin/sysrole/delete",t=new a["VueUtil"](this),s=this.listSysrole.some(e=>1==e.rowSelected);if(!s)return void t.alert("请选择需要删除的记录","系统提示",{confirmButtonText:"确定"});let l=this.listSysrole.filter(e=>e.rowSelected).map(e=>e.id);t.confirm("是否要删除数据?","系统提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(()=>{t.http.post(e,{ids:l},{emulateJSON:!1}).then(e=>{null!=e.data&&e.data.stateCode>0&&this.search()})}).catch(()=>{})},selectedAllHandler(){console.log(this.selectedAll),null!=this.listSysrole&&this.listSysrole.forEach(e=>{e.rowSelected=!this.selectedAll})}},created(){this.search()}},o=r,c=s("2877"),d=Object(c["a"])(o,l,i,!1,null,"512cfb13",null);t["default"]=d.exports},6821:function(e,t,s){},"8a8f":function(e,t,s){"use strict";s.r(t);var l=function(){var e=this,t=e._self._c;return t("div",{class:{inline:e.inline}},[t("span",{class:e.cssClass,on:{click:e.popHandler}},[e._t("default")],2),t("mydialog",{attrs:{width:e.width,show:e.showDlg,url:e.url,xdata:e.xdata,title:e.title},on:{"update:show":function(t){e.showDlg=t},close:e.closeHandler}})],1)},i=[],a=s("0760"),n={name:"PopDialogButton",data(){return{showDlg:!1}},methods:{popHandler(){this.showDlg=this.visible},closeHandler(e){this.$emit("refresh",!0)}},props:{url:{type:String,require:!0},visible:{type:Boolean,default:!0},inline:{type:Boolean,default:!0},xdata:{type:Object},title:{type:String,default:"标题"},cssClass:{type:String},width:{type:String,default:"80%"}},components:{mydialog:a["default"]},watch:{visible(e,t){this.showDlg=e}}},r=n,o=(s("e298"),s("2877")),c=Object(o["a"])(r,l,i,!1,null,"38004ee7",null);t["default"]=c.exports},bf48:function(e,t,s){"use strict";s.r(t),s.d(t,"VueUtil",(function(){return l})),Date.prototype.format=function(e){let t={"M+":this.getMonth()+1,"d+":this.getDate(),"H+":this.getHours(),"m+":this.getMinutes(),"s+":this.getSeconds(),"q+":Math.floor((this.getMonth()+3)/3),S:this.getMilliseconds()};/(y+)/.test(e)&&(e=e.replace(RegExp.$1,(this.getFullYear()+"").substr(4-RegExp.$1.length)));for(let s in t)new RegExp("("+s+")").test(e)&&(e=e.replace(RegExp.$1,1==RegExp.$1.length?t[s]:("00"+t[s]).substr((""+t[s]).length)));return e};let l=function(e){this.http=e.$http,this.alert=e.$alert,this.confirm=e.$confirm,this.message=e.$message,this.isDuringDate=function(e,t){let s=new Date,l=new Date(e),i=new Date(t);return s>=l&&s<=i},this.isPasted=function(e,t){let s=new Date,l=(new Date(e),new Date(t));return s>l}}},e298:function(e,t,s){"use strict";s("6821")}}]);
//# sourceMappingURL=chunk-5365e114.1f9fd282.js.map