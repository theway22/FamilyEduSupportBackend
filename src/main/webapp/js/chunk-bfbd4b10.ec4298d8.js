(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-bfbd4b10","chunk-2d21b2be"],{"9ed1":function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e._self._c;return t("div",{staticClass:"panel panel-default"},[t("div",{staticClass:"panel-heading"},["save"==e.actiontype?t("div",[e._v("新建教育指导师")]):e._e(),"update"==e.actiontype?t("div",[e._v("编辑教育指导师")]):e._e()]),t("div",{staticClass:"panel-body"},[e._m(0),t("table",{staticClass:"smart-table",attrs:{border:"1",cellspacing:"1",width:"100%"}},[t("tr",[t("td",{attrs:{width:"10%",align:"right"}},[e._v("工号:")]),t("td",{attrs:{width:"*"}},[t("input",{directives:[{name:"model",rawName:"v-model",value:e.teacher.tno,expression:"teacher.tno"},{name:"validate",rawName:"v-validate",value:{required:!0,messages:{required:"请输入工号"}},expression:"{required:true,messages:{required:'请输入工号'}}"}],staticClass:"input-txt",attrs:{name:"tno",placeholder:"工号",type:"text"},domProps:{value:e.teacher.tno},on:{input:function(t){t.target.composing||e.$set(e.teacher,"tno",t.target.value)}}})]),t("td",{attrs:{colspan:"2",rowspan:"6"}},[t("dw-upload",{attrs:{"host-head":e.hostHead},model:{value:e.teacher.photo,callback:function(t){e.$set(e.teacher,"photo",t)},expression:"teacher.photo"}})],1)]),t("tr",[t("td",{attrs:{width:"10%",align:"right"}},[e._v("姓名:")]),t("td",{attrs:{width:"*"}},[t("input",{directives:[{name:"model",rawName:"v-model",value:e.teacher.name,expression:"teacher.name"},{name:"validate",rawName:"v-validate",value:{required:!0,messages:{required:"请输入姓名"}},expression:"{required:true,messages:{required:'请输入姓名'}}"}],staticClass:"input-txt",attrs:{name:"name",placeholder:"姓名",type:"text"},domProps:{value:e.teacher.name},on:{input:function(t){t.target.composing||e.$set(e.teacher,"name",t.target.value)}}})])]),t("tr",[t("td",{attrs:{width:"10%",align:"right"}},[e._v("性别:")]),t("td",{attrs:{width:"*"}},[t("el-radio-group",{model:{value:e.teacher.sex,callback:function(t){e.$set(e.teacher,"sex",t)},expression:"teacher.sex"}},[t("el-radio",{attrs:{label:"男"}},[e._v("男")]),t("el-radio",{attrs:{label:"女"}},[e._v("女")])],1)],1)]),t("tr",[t("td",{attrs:{width:"10%",align:"right"}},[e._v("籍贯:")]),t("td",{attrs:{width:"*"}},[t("input",{directives:[{name:"model",rawName:"v-model",value:e.teacher.jiguan,expression:"teacher.jiguan"},{name:"validate",rawName:"v-validate",value:{required:!0,messages:{required:"请输入籍贯"}},expression:"{required:true,messages:{required:'请输入籍贯'}}"}],staticClass:"input-txt",attrs:{name:"jiguan",placeholder:"籍贯",type:"text"},domProps:{value:e.teacher.jiguan},on:{input:function(t){t.target.composing||e.$set(e.teacher,"jiguan",t.target.value)}}})])]),t("tr",[t("td",{attrs:{width:"10%",align:"right"}},[e._v("学历:")]),t("td",{attrs:{width:"*"}},[t("el-select",{model:{value:e.teacher.xueli,callback:function(t){e.$set(e.teacher,"xueli",t)},expression:"teacher.xueli"}},[t("el-option",{attrs:{value:"博士"}}),t("el-option",{attrs:{value:"硕士"}}),t("el-option",{attrs:{value:"本科"}}),t("el-option",{attrs:{value:"大专"}})],1)],1)]),t("tr",[t("td",{attrs:{width:"10%",align:"right"}},[e._v("民族:")]),t("td",{attrs:{width:"*"}},[t("input",{directives:[{name:"model",rawName:"v-model",value:e.teacher.nation,expression:"teacher.nation"},{name:"validate",rawName:"v-validate",value:{required:!0,messages:{required:"请输入民族"}},expression:"{required:true,messages:{required:'请输入民族'}}"}],staticClass:"input-txt",attrs:{name:"nation",placeholder:"民族",type:"text"},domProps:{value:e.teacher.nation},on:{input:function(t){t.target.composing||e.$set(e.teacher,"nation",t.target.value)}}})])]),t("tr",[t("td",{attrs:{width:"10%",align:"right"}},[e._v("邮箱:")]),t("td",{attrs:{width:"*"}},[t("input",{directives:[{name:"model",rawName:"v-model",value:e.teacher.email,expression:"teacher.email"},{name:"validate",rawName:"v-validate",value:{required:!0,messages:{required:"请输入邮箱"}},expression:"{required:true,messages:{required:'请输入邮箱'}}"}],staticClass:"input-txt",attrs:{name:"email",placeholder:"邮箱",type:"text"},domProps:{value:e.teacher.email},on:{input:function(t){t.target.composing||e.$set(e.teacher,"email",t.target.value)}}})]),t("td",{attrs:{width:"10%",align:"right"}},[e._v("电话:")]),t("td",{attrs:{width:"*"}},[t("input",{directives:[{name:"model",rawName:"v-model",value:e.teacher.tel,expression:"teacher.tel"},{name:"validate",rawName:"v-validate",value:{required:!0,messages:{required:"请输入电话"}},expression:"{required:true,messages:{required:'请输入电话'}}"}],staticClass:"input-txt",attrs:{name:"tel",placeholder:"电话",type:"text"},domProps:{value:e.teacher.tel},on:{input:function(t){t.target.composing||e.$set(e.teacher,"tel",t.target.value)}}})])]),t("tr",[t("td",{attrs:{width:"10%",align:"right"}},[e._v("职称:")]),t("td",{attrs:{width:"*"}},[t("input",{directives:[{name:"model",rawName:"v-model",value:e.teacher.zhicheng,expression:"teacher.zhicheng"},{name:"validate",rawName:"v-validate",value:{required:!0,messages:{required:"请输入职称"}},expression:"{required:true,messages:{required:'请输入职称'}}"}],staticClass:"input-txt",attrs:{name:"zhicheng",placeholder:"职称",type:"text"},domProps:{value:e.teacher.zhicheng},on:{input:function(t){t.target.composing||e.$set(e.teacher,"zhicheng",t.target.value)}}})]),t("td",{attrs:{width:"10%",align:"right"}},[e._v("特长:")]),t("td",{attrs:{width:"*"}},[t("input",{directives:[{name:"model",rawName:"v-model",value:e.teacher.major,expression:"teacher.major"},{name:"validate",rawName:"v-validate",value:{required:!0,messages:{required:"请输入特长"}},expression:"{required:true,messages:{required:'请输入特长'}}"}],staticClass:"input-txt",attrs:{name:"major",placeholder:"特长",type:"text"},domProps:{value:e.teacher.major},on:{input:function(t){t.target.composing||e.$set(e.teacher,"major",t.target.value)}}})])]),t("tr",[t("td",{attrs:{align:"right"}},[e._v("介绍:")]),t("td",{attrs:{colspan:"3"}},[t("quill-editor",{attrs:{options:{placeholder:"介绍"}},model:{value:e.teacher.jieshao,callback:function(t){e.$set(e.teacher,"jieshao",t)},expression:"teacher.jieshao"}})],1)]),t("tr",[t("td",{attrs:{colspan:"4"}},[t("el-button",{attrs:{type:"primary",icon:"el-icon-check"},on:{click:e.submitHandler}},[e._v("提交")])],1)])])])])},i=[function(){var e=this,t=e._self._c;return t("div",{staticClass:"alert alert-warning"},[t("i",{staticClass:"el-icon-warning"}),e._v("账户默认密码为123456 ")])}],s=(a("14d9"),a("bf48")),n={name:"teacheradd",data(){return{actiontype:"save",hostHead:this.$app.contextPath,fileList:[],errors:{},teacher:{tno:"",password:"123456",sex:"男",jiguan:"",xueli:"硕士",photo:"/upload/nopic.jpg",nation:"",name:"",email:"",tel:"",zhicheng:"",major:"",jieshao:""}}},methods:{async load(){let e=this.$route.query.id;if(null!=e){this.actiontype="update",this.pageTitle="编辑教育指导师";let t="admin/teacher/load",a=new s["VueUtil"](this),{data:r}=await a.http.post(t,{id:e});console.log("res",r),null!=r&&null!=r.data&&(this.teacher=r.data)}},async submitHandler(){let e={url:"admin/teacher/save",actionTip:"教育指导师新增成功"};"update"==this.actiontype&&(e.url="admin/teacher/update",e.actionTip="教育指导师更新成功");const t=this.myValidator.valid(this);if(console.log("valRes",t),!t)return;let a=new s["VueUtil"](this),r={...this.teacher},{data:i}=await a.http.post(e.url,r);i.stateCode<=0?a.alert(i.des,"系统提示",{confirmButtonText:"确定"}):(a.message({message:e.actionTip,type:"success",duration:2e3}),this.$router.push("/admin/teachermanager"))}},created(){this.load()}},l=n,o=a("2877"),d=Object(o["a"])(l,r,i,!1,null,null,null);t["default"]=d.exports},bf48:function(e,t,a){"use strict";a.r(t),a.d(t,"VueUtil",(function(){return r})),Date.prototype.format=function(e){let t={"M+":this.getMonth()+1,"d+":this.getDate(),"H+":this.getHours(),"m+":this.getMinutes(),"s+":this.getSeconds(),"q+":Math.floor((this.getMonth()+3)/3),S:this.getMilliseconds()};/(y+)/.test(e)&&(e=e.replace(RegExp.$1,(this.getFullYear()+"").substr(4-RegExp.$1.length)));for(let a in t)new RegExp("("+a+")").test(e)&&(e=e.replace(RegExp.$1,1==RegExp.$1.length?t[a]:("00"+t[a]).substr((""+t[a]).length)));return e};let r=function(e){this.http=e.$http,this.alert=e.$alert,this.confirm=e.$confirm,this.message=e.$message,this.isDuringDate=function(e,t){let a=new Date,r=new Date(e),i=new Date(t);return a>=r&&a<=i},this.isPasted=function(e,t){let a=new Date,r=(new Date(e),new Date(t));return a>r}}}}]);
//# sourceMappingURL=chunk-bfbd4b10.ec4298d8.js.map