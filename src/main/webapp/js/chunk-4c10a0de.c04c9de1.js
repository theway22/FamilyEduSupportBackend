(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4c10a0de","chunk-7b5f3435","chunk-409e35d2","chunk-6b9264b1","chunk-2d0cb71f","chunk-2d21b2be"],{"37a1":function(t,e,s){"use strict";s.r(e);var i=function(){var t=this,e=t._self._c;return e("div",[e("shead",{attrs:{headid:t.$route.query.id}}),e("div",{staticClass:"wrap round-block"},[e("div",{staticClass:"two-split"},[e("div",{staticClass:"split-left white-paper"},[e("div",{staticClass:"show-details"},[e("div",{staticClass:"picture-box"},[e("img",{attrs:{id:"imgTupian",src:t.hostHead+t.demand.tupian}}),e("div",{staticClass:"operation"})]),e("div",{staticClass:"text-box"},[e("div",{staticClass:"title"},[t._v(" "+t._s(t.demand.title)+" ")]),e("div",{staticClass:"sub-title"}),e("div",[e("ul",[e("li",[e("strong",[t._v("发布时间")]),t._v(" "+t._s(t.demand.pubtime)+" ")]),e("li",[e("strong",[t._v("发布人")]),t._v(" "+t._s(t.demand.hyname)+"--"+t._s(t.demand.hyaccount)+" ")]),e("li",[e("strong",[t._v("状态")]),1==t.demand.state?e("span",[t._v("寻找中")]):t._e(),2==t.demand.state?e("span",[t._v("已完成")]):t._e()]),e("li",[e("strong",[t._v("点击次数")]),t._v(" "+t._s(t.demand.clickcount)+" ")]),e("li",[e("strong",[t._v("类别")]),t._v(" "+t._s(t.demand.typename)+" ")]),e("li",[e("span",{staticClass:"el-button el-button--primary",on:{click:t.shoucangHandler}},[e("i",{staticClass:"el-icon-folder-add"}),t._v("关注")])])])])])]),e("el-tabs",{attrs:{value:"first"}},[e("el-tab-pane",{attrs:{name:"first",label:"介绍"}},[e("div",{staticClass:"brief-content",domProps:{innerHTML:t._s(t.demand.dcontent)}})]),e("el-tab-pane",{attrs:{label:"评论",name:"second"}},[e("comment",{attrs:{belongid:t.$route.query.id,xtype:"demand"}})],1)],1),e("loginmodal",{attrs:{show:t.openLogin},on:{"update:show":function(e){t.openLogin=e}}})],1),e("div",{staticClass:"split-right"},[e("div",{staticClass:"vm-sidebar"},[e("div",{staticClass:"hd"},[t._v("热门信息")]),e("div",{staticClass:"bd"},t._l(t.listHotXinxi,(function(s){return e("div",{key:s.id,staticClass:"item"},[e("a",{attrs:{href:"/e/xinxiinfo?id="+s.id}},[e("div",{staticClass:"image-wrap"},[e("img",{attrs:{src:t.hostHead+s.images[0]}})]),e("div",{staticClass:"tag"},[t._v(t._s(s.lmname))]),e("div",{staticClass:"text-wrap"},[e("div",{staticClass:"name"},[t._v(t._s(s.title))]),e("div",{staticClass:"muted"},[t._v(t._s(s.pubtime))]),e("div",{staticClass:"bm-wrap"},[t._v(t._s(s.clickcount)+"人点击")])])])])})),0)])])])]),e("bottom")],1)},a=[],n=s("bf48"),o=s("3869"),l=s("f558"),d=s("f32f"),r=s("4a62"),c={name:"demandinfo",data(){return{hostHead:this.$app.contextPath,demand:{},hyid:"",listHotXinxi:[],openLogin:!1,name:""}},async created(){console.log("created"),this.getInfo(),this.getHotXinxis()},methods:{async getInfo(){let t=new n["VueUtil"](this),e="admin/demand/info",s=this.$route.query.id,{data:i}=await t.http.post(e,{id:s});null!=i&i.stateCode<0?t.message.error(i.des):null!=i.data&&(this.demand=i.data)},async getHotXinxis(){let t=new n["VueUtil"](this),{data:e}=await t.http.post("admin/xinxi/hot");null!=e&&e.stateCode>0&&(this.listHotXinxi=e.data,console.log(this.listHotXinxi))},async shoucangHandler(){if(""==this.hyid)return void(this.openLogin=!0);let t="admin/shoucang/save",e=new n["VueUtil"](this),{data:s}=await e.http.post(t,{targetid:this.demand.id,targetname:this.demand.title,tupian:this.demand.images[0],hyid:this.huiyuan.id,xtype:"demand",href:"/e/demandinfo?id="+this.demand.id});null!=s&&s.stateCode<0?e.message.error(s.des):e.message.success("收藏成功")}},computed:{huiyuan(){return this.$app.mycas.getAccount(this.$app.mycas.huiyuan_key)},isLogin(){return this.$app.mycas.isLogin(this.$app.mycas.huiyuan_key)}},components:{Loginmodal:r["default"],Comment:d["default"],Shead:l["default"],Bottom:o["default"]}},u=c,p=s("2877"),h=Object(p["a"])(u,i,a,!1,null,"dd34db34",null);e["default"]=h.exports},3869:function(t,e,s){"use strict";s.r(e);var i=function(){var t=this,e=t._self._c;return e("div",{staticClass:"site-footer2"},[e("div",{staticClass:"bd"},[e("div",{staticClass:"logo"}),e("ul",[e("li",[e("router-link",{attrs:{to:"/e/index"}},[t._v("首页")])],1),e("li",[e("router-link",{attrs:{to:"/admin/login"}},[t._v("后台登录")])],1)])])])},a=[],n={name:"bottom",data(){return{hostHead:this.$app.contextPath}}},o=n,l=(s("b1d8"),s("2877")),d=Object(l["a"])(o,i,a,!1,null,"3f9502d7",null);e["default"]=d.exports},"4a62":function(t,e,s){"use strict";s.r(e);var i=function(){var t=this,e=t._self._c;return e("div",[e("el-dialog",{attrs:{width:"30%","close-on-click-modal":!1,visible:t.show},on:{"update:visible":t.closeHandler}},[e("span",{attrs:{slot:"title"},slot:"title"},[t._v("会员登录")]),e("el-form",{ref:"form",attrs:{"label-width":"80px"}},[e("el-form-item",{attrs:{label:"名称"}},[e("el-input",{attrs:{"prefix-icon":"el-icon-user"},model:{value:t.accountname,callback:function(e){t.accountname=e},expression:"accountname"}})],1),e("el-form-item",{attrs:{label:"密码"}},[e("el-input",{attrs:{type:"password","prefix-icon":"el-icon-lock"},model:{value:t.password,callback:function(e){t.password=e},expression:"password"}})],1)],1),e("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("el-button",{attrs:{type:"primary"},on:{click:t.loginHandler}},[t._v("确 定")]),e("el-button",{on:{click:t.cancelHandler}},[t._v("取 消")]),e("el-divider"),e("router-link",{attrs:{to:"/e/register"}},[t._v("注册")])],1)],1)],1)},a=[],n={name:"loginmodal",data(){return{accountname:"",password:"",hostHead:this.$app.contextPath}},methods:{cancelHandler(){this.$emit("update:show",!1)},async loginHandler(){let t="admin/admin/login",{data:e}=await this.$http.post(t,{username:this.accountname,password:this.password,usertype:2});null!=e&&e.stateCode<0?this.$message.error(e.des):null!=e&&e.stateCode>0&&(console.log("登录成功"),this.$emit("update:show",!1),this.$app.mycas.login(this.$app.mycas.huiyuan_key,e.data),this.$emit("afterLogin",!0),window.location.reload())},closeHandler(t){console.log("执行关闭"),this.$emit("update:show",t)}},props:{show:{type:Boolean,default:!1}}},o=n,l=s("2877"),d=Object(l["a"])(o,i,a,!1,null,"f2e2a76c",null);e["default"]=d.exports},"736b":function(t,e,s){"use strict";s("cf55")},b1d8:function(t,e,s){"use strict";s("fb50")},bf48:function(t,e,s){"use strict";s.r(e),s.d(e,"VueUtil",(function(){return i})),Date.prototype.format=function(t){let e={"M+":this.getMonth()+1,"d+":this.getDate(),"H+":this.getHours(),"m+":this.getMinutes(),"s+":this.getSeconds(),"q+":Math.floor((this.getMonth()+3)/3),S:this.getMilliseconds()};/(y+)/.test(t)&&(t=t.replace(RegExp.$1,(this.getFullYear()+"").substr(4-RegExp.$1.length)));for(let s in e)new RegExp("("+s+")").test(t)&&(t=t.replace(RegExp.$1,1==RegExp.$1.length?e[s]:("00"+e[s]).substr((""+e[s]).length)));return t};let i=function(t){this.http=t.$http,this.alert=t.$alert,this.confirm=t.$confirm,this.message=t.$message,this.isDuringDate=function(t,e){let s=new Date,i=new Date(t),a=new Date(e);return s>=i&&s<=a},this.isPasted=function(t,e){let s=new Date,i=(new Date(t),new Date(e));return s>i}}},cf55:function(t,e,s){},f32f:function(t,e,s){"use strict";s.r(e);var i=function(){var t=this,e=t._self._c;return e("div",{staticClass:"comment-box"},[e("div",{staticClass:"comment-list"},[e("h4",[t._v("评论信息")]),e("ul",t._l(t.listComment,(function(s,i){return e("li",{key:s.id},[e("div",{staticClass:"hd"},[t._v("第"+t._s(i+1)+"楼回帖")]),e("div",{staticClass:"comment-item"},[e("div",{staticClass:"comment-user"},[e("div",{staticClass:"pic"},[e("img",{staticClass:"image",attrs:{width:"48",height:"48",src:t.hostHead+s.photo}})]),e("div",{staticClass:"subtitle"},[e("div",[t._v(t._s(s.createtime))]),e("div",[t._v(t._s(s.hyaccount)+"("+t._s(s.hyname)+")")])])]),e("div",{staticClass:"item-content"},[e("div",{domProps:{innerHTML:t._s(s.cdata)}}),e("div",{staticClass:"action-row"},[t.deleteComment?e("span",{staticClass:"btn-sm btn-danger",staticStyle:{cursor:"pointer"},on:{click:function(e){return t.deleteHandler(s.id)}}},[e("i",{staticClass:"fa fa-trash"})]):t._e()])])])])})),0)]),t.withComment?e("div",[t.isLogin?e("div",{staticClass:"comment-container"},[e("div",{staticClass:"inner-container"},[e("div",{staticClass:"comment-message"},[e("quill-editor",{attrs:{options:{placeholder:"说点啥吧"}},model:{value:t.cdata,callback:function(e){t.cdata=e},expression:"cdata"}})],1),e("div",{staticClass:"comment-action-box"},[t._m(0),e("el-button",{attrs:{type:"success"},on:{click:t.submitComment}},[e("i",{staticClass:"el-icon-plus"}),t._v("发布")])],1)])]):e("div",{staticStyle:{"font-size":"18px",padding:"20px 120px"}},[t._v(" 登录后才能进行回复 ,"),e("span",{staticStyle:{color:"#e9ab32",cursor:"pointer"},on:{click:function(e){t.openLogin=!0}}},[t._v("登录")])]),e("loginmodal",{attrs:{show:t.openLogin},on:{"update:show":function(e){t.openLogin=e}}})],1):t._e()])},a=[function(){var t=this,e=t._self._c;return e("span",{staticClass:"white-color"},[e("span",{attrs:{id:"hasInputedCount"}},[t._v("0")]),t._v("/"),e("strong",{attrs:{id:"removeCount"}},[t._v("210")]),t._v("字")])}],n=s("4a62"),o={name:"comment",components:{Loginmodal:n["default"]},data(){return{listComment:[],cdata:"",openLogin:!1,hostHead:this.$app.contextPath}},created(){this.getComment()},methods:{async deleteHandler(t){let e="admin/comment/delete";this.$confirm("是否要删除评论?","系统提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(()=>{this.$http.post(e,{id:t},{emulateJSON:!1}).then(t=>{null!=t.data&&t.data.stateCode>0&&this.getComment()})}).catch(()=>{})},async getComment(){let t={};console.log("this.belongid="+this.belongid),console.log("this.xtype="+this.xtype),""!=this.belongid&&(t.belongid=this.belongid),""!=this.xtype&&(t.xtype=this.xtype);let e="admin/comment/list",s={};Object.assign(s,t);let i=await this.$http.post(e,s);null!=i.data&&null!=i.data.data&&(this.listComment=i.data.data,console.log(i.data)),this.$nextTick(()=>{})},async submitComment(){if(""==this.cdata)return void this.$message.error("请输入评论内容");let t="admin/comment/save",e={hyid:null==this.huiyuan?0:this.huiyuan.id,cdata:this.cdata,istopic:1,topicid:0,xtype:this.xtype,belongid:this.belongid},{data:s}=await this.$http.post(t,e);if(null!=s&&s.stateCode>0){let t={};""!=this.belongid&&(t.belongid=this.belongid),""!=this.xtype&&(t.xtype=this.xtype),this.$message.success("发布成功"),this.getComment(t),this.cdata=""}}},computed:{isLogin(){return this.$app.mycas.isLogin(this.$app.mycas.huiyuan_key)},huiyuan(){return this.$app.mycas.getAccount(this.$app.mycas.huiyuan_key)}},props:{belongid:{required:!0},withComment:{type:Boolean,default:!0},xtype:{type:String,default:"xinxi"},deleteComment:{type:Boolean,default:!1}},watch:{belongid(t){}}},l=o,d=s("2877"),r=Object(d["a"])(l,i,a,!1,null,"0e531130",null);e["default"]=r.exports},f558:function(t,e,s){"use strict";s.r(e);var i=function(){var t=this,e=t._self._c;return e("div",[e("div",{staticClass:"p-head2"},[e("div",{staticClass:"cont"},[e("div",{staticClass:"site-name"},[t._v(" 家庭教育救助网站 ")]),e("div",{staticClass:"navigation"},[e("ul",t._l(t.listSitenav,(function(s){return e("li",{key:s.id},[t.withParam(s.href)?e("span",{class:{current:s.id==t.headid,item:!0},on:{click:function(e){return t.navigatePage(s.href+"&headid="+s.id)}}},[t._v(t._s(s.title))]):e("span",{class:{current:s.id==t.headid,item:!0},attrs:{id:s.id},on:{click:function(e){return t.navigatePage(s.href+"?headid="+s.id)}}},[t._v(t._s(s.title))])])})),0)])]),e("div",{staticClass:"oper-con"},[e("router-link",{staticClass:"el-button el-button--primary is-circle",attrs:{to:"/e/search"}},[e("i",{staticClass:"el-icon-search"})]),t.isLogin()?t._e():[e("router-link",{staticClass:"el-button el-button--waring is-circle",attrs:{title:"登录",to:"/admin/login"}},[e("i",{staticClass:"el-icon-user"})]),e("router-link",{staticClass:"el-button el-button--success is-circle",attrs:{title:"注册",to:"/e/register"}},[e("i",{staticClass:"el-icon-plus"})])],t.isLogin()?[e("el-dropdown",{staticStyle:{padding:"2px 10px",cursor:"pointer"}},[e("span",{staticClass:"el-dropdown-link"},[t._v(" "+t._s(t.huiyuan.accountname)+"--"+t._s(t.huiyuan.name)),e("i",{staticClass:"el-icon-arrow-down el-icon--right"})]),e("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[e("el-dropdown-item",[e("router-link",{attrs:{to:"/huiyuan/index"}},[e("i",{staticClass:"fa fa-user"}),t._v("进入后台")])],1),e("el-dropdown-item",{attrs:{divided:""}}),e("el-dropdown-item",{nativeOn:{click:function(e){return t.exitHandler(2)}}},[e("span",{staticClass:"exit"},[t._v("退出")])])],1)],1)]:t._e(),t.isAdminLogin()?[e("el-dropdown",{staticStyle:{padding:"2px 10px",cursor:"pointer"}},[e("span",{staticClass:"el-dropdown-link"},[t._v(" "+t._s(t.users.username)+"--"+t._s(t.users.realname)),e("i",{staticClass:"el-icon-arrow-down el-icon--right"})]),e("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[e("el-dropdown-item",[e("router-link",{attrs:{to:"/admin/index"}},[e("i",{staticClass:"fa fa-user"}),t._v("进入后台")])],1),e("el-dropdown-item",{attrs:{divided:""}}),e("el-dropdown-item",{nativeOn:{click:function(e){return t.exitHandler(1)}}},[e("span",{staticClass:"exit"},[t._v("退出")])])],1)],1)]:t._e(),t.isTeacherLogin()?[e("el-dropdown",{staticStyle:{padding:"2px 10px"}},[e("span",{staticClass:"el-dropdown-link"},[t._v(" "+t._s(t.teacher.tno)+"--"+t._s(t.teacher.name)+"(教育指导师)"),e("i",{staticClass:"el-icon-arrow-down el-icon--right"})]),e("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[e("el-dropdown-item",[e("router-link",{attrs:{to:"/teacher/index"}},[e("i",{staticClass:"fa fa-user"}),t._v("我的账户")])],1),e("el-dropdown-item",{attrs:{divided:""}}),e("el-dropdown-item",{nativeOn:{click:function(e){return t.exitHandler(3)}}},[e("span",{staticClass:"exit"},[t._v("退出")])])],1)],1)]:t._e()],2)]),e("div",{staticStyle:{height:"70px"}})])},a=[],n=(s("14d9"),{name:"shead",data(){return{listSitenav:[],keyword:"",logindlg:!1,hostHead:this.$app.contextPath}},methods:{withParam(t){return null!=t&&t.split("?").length>1},async list(){let t="admin/sitenav/list",e={ispaged:"-1",order:" order by id desc"},{data:s}=await this.$http.post(t,e);null!=s.data&&(console.log("header res=",s),this.listSitenav=s.data)},navigatePage(t){null!=t&&""!=t&&(this.$router.push(t),this.$app.key=t)},isLogin(){return this.$app.mycas.isLogin(this.$app.mycas.huiyuan_key)},isAdminLogin(){return this.$app.mycas.isLogin(this.$app.mycas.users_key)},isTeacherLogin(){return this.$app.mycas.isLogin(this.$app.mycas.teacher_key)},async exitHandler(t){this.$confirm("确定要离开?","系统提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(async e=>{2==t&&this.$app.mycas.logout(this.$app.mycas.huiyuan_key),1==t&&this.$app.mycas.logout(this.$app.mycas.users_key),3==t&&this.$app.mycas.logout(this.$app.mycas.teacher_key),window.location.reload()}).catch(t=>{})},searchHandler(){""!=this.keyword?this.$router.push("/e/search?title="+this.keyword):this.$message.error("请输入搜索内容")}},created(){this.list()},props:{headid:{type:String,default:"1"}},computed:{huiyuan(){return this.$app.mycas.getAccount(this.$app.mycas.huiyuan_key)},users(){return this.$app.mycas.getAccount(this.$app.mycas.users_key)},teacher(){return this.$app.mycas.getAccount(this.$app.mycas.teacher_key)}}}),o=n,l=(s("736b"),s("2877")),d=Object(l["a"])(o,i,a,!1,null,"5dc65d1b",null);e["default"]=d.exports},fb50:function(t,e,s){}}]);
//# sourceMappingURL=chunk-4c10a0de.c04c9de1.js.map