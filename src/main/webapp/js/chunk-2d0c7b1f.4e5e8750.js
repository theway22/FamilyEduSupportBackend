(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0c7b1f"],{"525a":function(t,a,e){"use strict";e.r(a);var s=function(){var t=this,a=t._self._c;return a("div",{staticClass:"mypanel"},[a("div",{staticClass:"hd"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",{attrs:{to:{path:"/admin/index"}}},[t._v("首页")]),a("el-breadcrumb-item",[a("a",{attrs:{href:"/admin/pagesettingmanager"}},[t._v("页面管理")])]),a("el-breadcrumb-item",[t._v("新增板块")])],1)],1),a("div",{staticClass:"bd"},[a("table",{staticClass:"ui-record-table",attrs:{width:"100%",border:"0",cellspacing:"0",cellpadding:"0"}},[t._m(0),a("tbody",[a("tr",{directives:[{name:"show",rawName:"v-show",value:0==t.listLanmu.length,expression:"listLanmu.length==0"}]},[a("td",{attrs:{colspan:"20"}},[t._v(" 没有相关板块信息 ")])]),t._l(t.listLanmu,(function(e){return a("tr",{key:e.id},[a("td",[t._v(t._s(e.lmname))]),a("td",[1==e.lmtype?a("span",[t._v("文章")]):t._e(),2==e.lmtype?a("span",[t._v("教育服务")]):t._e(),3==e.lmtype?a("span",[t._v("视频")]):t._e(),6==e.lmtype?a("span",[t._v("期刊")]):t._e()]),a("td",[null==e.pageid?a("span",[t._v("未加入")]):a("span",[t._v("已加入")])]),a("td",[null==e.pageid?a("span",{staticClass:"btn btn-danger",attrs:{title:"加入板块"},on:{click:function(a){return t.addToPage(e.lmid,t.pageid)}}},[a("i",{staticClass:"fa fa-plus"}),t._v("加入")]):t._e()])])}))],2)])])])},i=[function(){var t=this,a=t._self._c;return a("thead",[a("tr",[a("th",[a("b",[t._v("板块")])]),a("th",[a("b",[t._v("类型")])]),a("th",[a("b",[t._v("是否加入")])]),a("th",[t._v(" 操作 ")])])])}],n={name:"psitemadd",data(){return{hostHead:this.$app.contextPath,name:"",pageid:0,listLanmu:[]}},created(){this.search()},methods:{async search(){if(this.pageid=this.$route.query.pageid,console.log("pageid=",this.pageid),null!=this.pageid){let t="admin/psitem/load",{data:a}=await this.$http.post(t,{pageid:this.pageid});console.log("res",a),null!=a&&null!=a.data&&(this.listLanmu=a.data)}},async addToPage(t,a){let e="admin/psitem/save",{data:s}=await this.$http.post(e,{pageid:a,lmid:t},{emulateJSON:!1});s.stateCode<=0?this.$alert("提交异常","系统提示",{confirmButtonText:"确定"}):this.search()}}},d=n,l=e("2877"),r=Object(l["a"])(d,s,i,!1,null,"e80287bc",null);a["default"]=r.exports}}]);
//# sourceMappingURL=chunk-2d0c7b1f.4e5e8750.js.map