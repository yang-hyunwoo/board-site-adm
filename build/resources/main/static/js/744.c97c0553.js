"use strict";(self["webpackChunkboard_site_front"]=self["webpackChunkboard_site_front"]||[]).push([[744],{4116:function(t,e,o){o.r(e),o.d(e,{default:function(){return Z}});var n=o(3396),a=o(7139),s=o(9242);const i=t=>((0,n.dD)("data-v-404e745e"),t=t(),(0,n.Cn)(),t),r={class:"container bootstrap snippets bootdey",style:{"margin-top":"2rem"}},l={class:"jumbotron list-content"},p={class:"list-group"},u=i((()=>(0,n._)("li",{href:"#",class:"list-group-item title"}," 채팅방 ",-1))),c={class:"name"},g=i((()=>(0,n._)("br",null,null,-1))),h={class:"pull-right"},m=["onClick"],d={class:"pull-right",style:{"margin-right":"3rem"}},C=i((()=>(0,n._)("div",{class:"break"},null,-1))),f={style:{display:"flex","justify-content":"end"}},w={class:"pop-cont"},b=i((()=>(0,n._)("h3",null,"채팅방 제목",-1))),_=i((()=>(0,n._)("h3",null,"최대 인원",-1))),k={class:"pop-btn-area"};function v(t,e,o,i,v,y){const P=(0,n.up)("Pagination"),x=(0,n.up)("BlackBg"),L=(0,n.up)("Dialog");return(0,n.wg)(),(0,n.iD)(n.HY,null,[(0,n._)("div",r,[(0,n._)("div",l,[(0,n._)("ul",p,[u,((0,n.wg)(!0),(0,n.iD)(n.HY,null,(0,n.Ko)(t.roomList,((t,e)=>((0,n.wg)(),(0,n.iD)("li",{href:"#",class:"list-group-item text-left",key:e},[(0,n._)("label",c,[(0,n.Uk)((0,a.zw)(t.room_name),1),g]),(0,n._)("label",h,[(0,n._)("button",{class:"btn btn-danger",style:{"font-size":"10px"},onClick:e=>y.chatDetail(t.id)},"입장하기",8,m)]),(0,n._)("label",d,(0,a.zw)(t.roomPersonIngCount)+" / "+(0,a.zw)(t.roomCount)+" 명",1),C])))),128))])]),(0,n._)("div",f,[(0,n._)("button",{class:"btn btn-primary",style:{"font-size":"10px","margin-top":"1rem"},onClick:e[0]||(e[0]=(...t)=>y.newRoom&&y.newRoom(...t))},"채팅방 생성")])]),t.pageChk?((0,n.wg)(),(0,n.j4)(P,{key:0,pageListItem:t.pageListItem,onPageCurrent:y.pageCurr,pageTotal:t.pageTotal},null,8,["pageListItem","onPageCurrent","pageTotal"])):(0,n.kq)("",!0),t.loading?((0,n.wg)(),(0,n.j4)(x,{key:1})):(0,n.kq)("",!0),t.popOpen?((0,n.wg)(),(0,n.j4)(L,{key:2,onClose:e[5]||(e[5]=e=>t.popOpen=!1)},{cont:(0,n.w5)((()=>[(0,n._)("div",w,[b,(0,n.wy)((0,n._)("input",{class:"form-control",type:"text",name:"title",id:"title","onUpdate:modelValue":e[1]||(e[1]=e=>t.popTitle=e)},null,512),[[s.nr,t.popTitle]]),_,(0,n.wy)((0,n._)("input",{class:"form-control",type:"number",name:"count",id:"count","onUpdate:modelValue":e[2]||(e[2]=e=>t.popCount=e)},null,512),[[s.nr,t.popCount]]),(0,n._)("div",k,[(0,n._)("button",{class:"btn btn-danger",onClick:e[3]||(e[3]=e=>t.popOpen=!1)},"취소"),(0,n._)("button",{class:"btn btn-primary",onClick:e[4]||(e[4]=(...t)=>y.popSave&&y.popSave(...t))},"확인")])])])),_:1})):(0,n.kq)("",!0)],64)}var y=o(3266),P=o.n(y),x=o(4029),L=o.n(x),$=o(360),I=o(5033),D=o(4051),T={data:function(){return{roomList:[],pageListItem:10,page:0,pageTotal:0,pageChk:!1,loading:!1,stompClient:"",popOpen:!1,popTitle:"",popCount:2}},components:{Pagination:$.Z,BlackBg:I.Z,Dialog:D.Z},created(){this.init()},methods:{init(){this.roomListAxios(),this.connect()},roomListAxios(){let t={page:this.page};this.$axios.get("/api/chat/rooms",{params:t}).then((t=>{"SUCCESS"==t.data.resultCode&&(this.pageTotal=t.data.result.totalElements,this.roomList=[],t.data.result.content.forEach((t=>{let e=[];e.room_name=t.roomName,e.id=t.id,e.roomCount=t.roomCount,e.roomPersonIngCount=t.roomPersonIngCount,this.roomList.push(e)}))),0==this.pageTotal?this.pageChk=!1:this.pageChk=!0})).catch((t=>{this.$swal("",t.response.data.result,"error")})).finally((()=>{this.loading=!1}))},popSave(){if(""!=this.popTitle){if(this.popCount<=1)this.$swal("","최소 인원은 2명 입니다.","warning");else if(this.popCount>=301)this.$swal("","최대 인원은 300명 입니다.","warning");else if(null!=this.popTitle&&null!=this.popCount){let t={publicRoom:!0,roomCount:this.popCount,roomName:this.popTitle};const e={Authorization:"Bearer "+sessionStorage.getItem("token")};this.$axios.post("/api/chat/new-room",t,{headers:e}).then((t=>{this.stompClient.send("/app/roomList",{},e),this.$router.push({path:"/chatDetail",name:"chatDetail",query:{sn:t.data.result}})})).catch((t=>{this.$swal("",t.response.data.result,"error")})).finally((()=>{}))}}else this.$swal("","제목을 입력해주세요.","warning")},newRoom(){this.popOpen=!0},connect(){const t={Authorization:"Bearer "+sessionStorage.getItem("token")},e="http://localhost:8081/ws/chat";let o=new(L())(e);this.stompClient=P().over(o),console.log(`소켓 연결을 시도합니다. 서버 주소: ${e}`),this.stompClient.connect(t,(t=>{this.connected=!0,this.stompClient.subscribe("/topic/roomList",(t=>{this.roomListAxios()}))}),(t=>{console.log("소켓 연결 실패",t),this.connected=!1}))},chatDetail(t){const e={Authorization:"Bearer "+sessionStorage.getItem("token")};this.$axios.get("/api/chat/enter/"+t,{headers:e}).then((o=>{"SUCCESS"==o.data.resultCode&&(o.data.result&&(this.stompClient.send("/app/roomList",{},e),this.stompClient.send("/app/room-person/"+t,{},e)),this.$router.push({path:"/chatDetail",name:"chatDetail",query:{sn:t}}))})).catch((t=>{this.$swal("",t.response.data.result,"error")})).finally((()=>{}))},pageCurr(t){this.page=t-1,this.roomListAxios()}}},S=o(89);const z=(0,S.Z)(T,[["render",v],["__scopeId","data-v-404e745e"]]);var Z=z},4051:function(t,e,o){o.d(e,{Z:function(){return p}});var n=o(3396);const a={class:"c-popup"};function s(t,e,o,s,i,r){return(0,n.wg)(),(0,n.iD)("div",null,[(0,n._)("div",{class:"black-bg",onClick:e[0]||(e[0]=e=>t.$emit("close"))}),(0,n._)("div",a,[(0,n.WI)(t.$slots,"cont")])])}var i={},r=o(89);const l=(0,r.Z)(i,[["render",s]]);var p=l},360:function(t,e,o){o.d(e,{Z:function(){return c}});var n=o(3396);const a={class:"pagination"},s={class:"overflow-auto"},i={class:"mt-3"};function r(t,e,o,r,l,p){const u=(0,n.up)("b-pagination"),c=(0,n.up)("b-card");return(0,n.wg)(),(0,n.iD)("div",a,[(0,n.Wm)(c,{style:{"justify-content":"center"}},{default:(0,n.w5)((()=>[(0,n._)("div",s,[(0,n._)("div",i,[(0,n.Wm)(u,{modelValue:t.ex4CurrentPage,"onUpdate:modelValue":e[0]||(e[0]=e=>t.ex4CurrentPage=e),pills:"","total-rows":t.ex4Rows,onPageClick:p.pageClick,"per-page":t.perPage,currPage:o.currPage},null,8,["modelValue","total-rows","onPageClick","per-page","currPage"])])])])),_:1}),(0,n.WI)(t.$slots,"default")])}var l={props:{pageListItem:Number,pageTotal:Number,currPage:{type:Number,default:1}},data:function(){return{ex4CurrentPage:this.currPage,ex4Rows:this.pageTotal,perPage:this.pageListItem}},created(){console.log(this.currPage)},methods:{pageClick:function(t,e){this.ex4CurrentPage=e,this.$emit("pageCurrent",this.ex4CurrentPage)}}},p=o(89);const u=(0,p.Z)(l,[["render",r]]);var c=u}}]);
//# sourceMappingURL=744.c97c0553.js.map