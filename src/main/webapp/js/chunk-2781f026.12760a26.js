(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2781f026","chunk-2d21b2be","chunk-774aadad"],{"1efa":function(t,e,s){"use strict";s.r(e);var a=function(){var t=this,e=t._self._c;return e("div",{staticClass:"panel panel-default"},[e("div",{staticClass:"panel-heading"},[t._v("我的聊天记录")]),e("div",{staticClass:"panel-body"},[null!=t.listTarget&&t.listTarget.length>0?e("el-row",[e("el-col",{attrs:{span:6}},[e("div",{staticClass:"target-list"},[e("div",{staticClass:"hd"},[t._v(" 聊天记录 ")]),e("div",{staticClass:"bd"},[e("ul",t._l(t.listTarget,(function(s,a){return e("li",{class:{active:a==t.selectedIndex}},[e("div",{staticClass:"figure"},[e("img",{attrs:{src:t.hostHead+s.photo}})]),e("div",{staticClass:"info"},[e("div",{staticClass:"chatbtn",on:{click:function(e){return t.showChat(s,a)}}},[e("div",{staticClass:"title"},[t._v(t._s(s.name))]),e("div",{staticClass:"subtitle"},[t._v(t._s(s.tno))])])]),e("el-badge",{staticClass:"item",attrs:{value:t.messageCount(s.id)}},[e("el-button",[t._v("消息")])],1)],1)})),0)])])]),e("el-col",{attrs:{span:18}},[e("div",{staticClass:"chat-box"},[e("div",{staticClass:"panel panel-default"},[e("div",{staticClass:"panel-heading"},[t._v("与"+t._s(t.target.name)+"聊天记录")]),e("div",{staticClass:"panel-body"},[e("div",{staticClass:"messages-content"},[t._l(t.listLeaveword,(function(s){return[e("div",{staticClass:"item"},[e("div",{staticClass:"message-user"},[e("div",{staticClass:"avatar"},[e("img",{attrs:{src:t.hostHead+s.pbrphoto}})]),e("div",{staticClass:"name"},[t._v(t._s(s.pbrname)+"--"+t._s(s.pubtime))])]),e("div",{staticClass:"message-wrap"},[e("div",{staticClass:"toolbar"},[e("el-button",{attrs:{circle:"",type:"danger",icon:"el-icon-delete",size:"small"},on:{click:function(e){return t.deleteRc(s.id)}}})],1),t._v(" "+t._s(s.dcontent)+" ")])]),2==s.state?e("div",{staticClass:"item outgoing"},[e("div",{staticClass:"message-user"},[e("div",{staticClass:"avatar"},[e("img",{attrs:{src:t.hostHead+s.rpphoto}})]),e("div",{staticClass:"name"},[t._v(t._s(s.rpname)+"--"+t._s(s.replytime))])]),e("div",{staticClass:"message-wrap"},[t._v(t._s(s.replycontent))])]):t._e()]}))],2)])])])])],1):e("div",{staticClass:"no-record-tip"},[e("div",{staticClass:"content"},[e("i",{staticClass:"el-icon-warning"}),t._v("暂无聊天记录 ")])])],1)])},i=[],n=(s("fa01"),s("bf48"),{name:"chat",data(){return{hostHead:this.$app.contextPath,listLeaveword:[],dcontent:"",target:{},selectedIndex:0,listTarget:[],listNotice:[]}},props:{accountInfo:{type:Object}},methods:{async deleteRc(t){let e="admin/leaveword/delete",s=[t];this.$confirm("是否要删除聊天记录?","系统提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(async()=>{let{data:t}=await this.$http.post(e,{ids:s});null!=t&&t.stateCode<0?this.$message.error(t.des):this.getLeaveword()}).catch(()=>{})},async showChat(t,e){this.target=t,this.selectedIndex=e,console.log("target=",t),this.getLeaveword(t.id)},async getLeaveword(t){let e="admin/leaveword/list",s={sendorid:this.accountInfo.id,ispaged:"-1"};s.targetid=null!=t?t:this.target.id;let{data:a}=await this.$http.post(e,s);null!=a&&a.stateCode<0?this.$message.error(a.des):this.listLeaveword=a.data},async getTargets(){let t="admin/leaveword/targets",{data:e}=await this.$http.post(t,{sendorid:this.accountInfo.id,ispaged:"-1"});null!=e&&e.stateCode<0?this.$message.error(e.des):(this.listTarget=e.data,null!=this.listTarget&&this.listTarget.length>0&&(this.target=this.listTarget[0]))},messageCount(t){if(null==this.listLeaveword)return 0;if(null==t)return this.listLeaveword.length;let e=this.listLeaveword.filter(e=>e.targetid==t);return null==e?0:e.length}},async created(){await this.getTargets(),await this.getLeaveword()}}),l=n,r=s("2877"),c=Object(r["a"])(l,a,i,!1,null,"877cd0b0",null);e["default"]=c.exports},bf48:function(t,e,s){"use strict";s.r(e),s.d(e,"VueUtil",(function(){return a})),Date.prototype.format=function(t){let e={"M+":this.getMonth()+1,"d+":this.getDate(),"H+":this.getHours(),"m+":this.getMinutes(),"s+":this.getSeconds(),"q+":Math.floor((this.getMonth()+3)/3),S:this.getMilliseconds()};/(y+)/.test(t)&&(t=t.replace(RegExp.$1,(this.getFullYear()+"").substr(4-RegExp.$1.length)));for(let s in e)new RegExp("("+s+")").test(t)&&(t=t.replace(RegExp.$1,1==RegExp.$1.length?e[s]:("00"+e[s]).substr((""+e[s]).length)));return t};let a=function(t){this.http=t.$http,this.alert=t.$alert,this.confirm=t.$confirm,this.message=t.$message,this.isDuringDate=function(t,e){let s=new Date,a=new Date(t),i=new Date(e);return s>=a&&s<=i},this.isPasted=function(t,e){let s=new Date,a=(new Date(t),new Date(e));return s>a}}},fa01:function(t,e,s){}}]);
//# sourceMappingURL=chunk-2781f026.12760a26.js.map