"use strict";(self["webpackChunkboard_site_front"]=self["webpackChunkboard_site_front"]||[]).push([[603],{360:function(t,e,a){a.d(e,{Z:function(){return d}});var s=a(3396);const n={class:"pagination"},i={class:"overflow-auto"},r={class:"mt-3"};function l(t,e,a,l,o,u){const c=(0,s.up)("b-pagination"),d=(0,s.up)("b-card");return(0,s.wg)(),(0,s.iD)("div",n,[(0,s.Wm)(d,{style:{"justify-content":"center"}},{default:(0,s.w5)((()=>[(0,s._)("div",i,[(0,s._)("div",r,[(0,s.Wm)(c,{modelValue:t.ex4CurrentPage,"onUpdate:modelValue":e[0]||(e[0]=e=>t.ex4CurrentPage=e),pills:"","total-rows":t.ex4Rows,onPageClick:u.pageClick,"per-page":t.perPage,currPage:a.currPage},null,8,["modelValue","total-rows","onPageClick","per-page","currPage"])])])])),_:1}),(0,s.WI)(t.$slots,"default")])}var o={props:{pageListItem:Number,pageTotal:Number,currPage:{type:Number,default:1}},data:function(){return{ex4CurrentPage:this.currPage,ex4Rows:this.pageTotal,perPage:this.pageListItem}},created(){console.log(this.currPage)},methods:{pageClick:function(t,e){this.ex4CurrentPage=e,this.$emit("pageCurrent",this.ex4CurrentPage)}}},u=a(89);const c=(0,u.Z)(o,[["render",l]]);var d=c},5033:function(t,e,a){a.d(e,{Z:function(){return c}});var s=a(3396);const n=(0,s._)("div",{class:"customdis"},[(0,s._)("div",{class:"spinner-border text-secondary",style:{width:"3rem",height:"3rem"},role:"status"},[(0,s._)("span",{class:"visually-hidden"},"Loading...")])],-1),i=[n];function r(t,e,a,n,r,l){return(0,s.wg)(),(0,s.iD)("div",{class:"black-bg",onClick:e[0]||(e[0]=e=>t.$emit("close"))},i)}var l={},o=a(89);const u=(0,o.Z)(l,[["render",r]]);var c=u},3603:function(t,e,a){a.r(e),a.d(e,{default:function(){return $}});var s=a(3396),n=a(7139);const i=t=>((0,s.dD)("data-v-2fcd5aba"),t=t(),(0,s.Cn)(),t),r={class:"bootstrap snippets bootdey",style:{"margin-top":"4rem"}},l={class:"row",style:{"margin-left":"1rem"}},o={class:"col-lg-12"},u={class:"main-box no-header clearfix"},c={class:"main-box-body clearfix"},d={class:"table-responsive"},p={class:"mb-3"},g={class:"card-title"},h=(0,s.Uk)("목록 "),m={class:"text-muted fw-normal ms-2"},_={class:"table user-list"},b=i((()=>(0,s._)("thead",null,[(0,s._)("tr",null,[(0,s._)("th",null,[(0,s._)("span",null,"결제일")]),(0,s._)("th",null,[(0,s._)("span",null,"이름/Id/hp")]),(0,s._)("th",null,[(0,s._)("span",null,"결제 금액")]),(0,s._)("th",null,[(0,s._)("span",null,"인원 수")]),(0,s._)("th",{class:"text-center"},[(0,s._)("span",null,"결제 여부")]),(0,s._)("th",{class:"text-center"},[(0,s._)("span")])])],-1))),f={key:0},w=(0,s.Uk)(" 결제 완료 "),y=["onClick"],C={key:1},k=i((()=>(0,s._)("span",{style:{color:"blue"}},"환불 완료",-1))),v=[k],x={key:0,colspan:"5"},P=i((()=>(0,s._)("td",null,"결제 내역이 없습니다.",-1))),L=[P];function D(t,e,a,i,k,P){const D=(0,s.up)("Pagination"),I=(0,s.up)("BlackBg");return(0,s.wg)(),(0,s.iD)(s.HY,null,[(0,s._)("div",r,[(0,s._)("div",l,[(0,s._)("div",null,[(0,s._)("h3",null,(0,n.zw)(t.title)+" 구매 내역",1),(0,s._)("button",{class:"btn btn-primary",style:{"margin-left":"3px",height:"35px"},onClick:e[0]||(e[0]=t=>P.excelDownload("ALL"))},"전체 엑셀"),(0,s._)("button",{class:"btn btn-primary",style:{"margin-left":"3px",height:"35px"},onClick:e[1]||(e[1]=t=>P.excelDownload("SUCC"))},"결제 완료자 엑셀")]),(0,s._)("div",o,[(0,s._)("div",u,[(0,s._)("div",c,[(0,s._)("div",d,[(0,s._)("div",p,[(0,s._)("h5",g,[h,(0,s._)("span",m,(0,n.zw)(t.startPage)+" to "+(0,n.zw)(t.endPage)+" of "+(0,n.zw)(t.totalList),1)])]),(0,s._)("table",_,[b,(0,s._)("tbody",null,[((0,s.wg)(!0),(0,s.iD)(s.HY,null,(0,s.Ko)(t.purchase_list,((e,a)=>((0,s.wg)(),(0,s.iD)("tr",{key:a},[(0,s._)("td",null,(0,n.zw)(e.created_at),1),(0,s._)("td",null,(0,n.zw)(e.name)+"/"+(0,n.zw)(e.email)+"/"+(0,n.zw)(e.phoneNumber),1),(0,s._)("td",null,(0,n.zw)(t.$numberWithCommas(e.paid))+"원 ",1),(0,s._)("td",null,(0,n.zw)(e.person_count)+"명",1),"결제 완료"==e.state?((0,s.wg)(),(0,s.iD)("td",f,[w,"결제 완료"==e.state?((0,s.wg)(),(0,s.iD)("button",{key:0,class:"btn btn-danger",style:{"font-size":"10px","margin-left":"10px"},onClick:t=>P.refundClick(e.imp_uid,e.paid,e.person_count,e.id,e.list_id)},"결제 취소",8,y)):(0,s.kq)("",!0)])):(0,s.kq)("",!0),"결제 취소"==e.state?((0,s.wg)(),(0,s.iD)("td",C,v)):(0,s.kq)("",!0)])))),128)),0==t.purchase_list.length?((0,s.wg)(),(0,s.iD)("tr",x,L)):(0,s.kq)("",!0)])])])])])])])]),t.pageChk?((0,s.wg)(),(0,s.j4)(D,{key:0,pageListItem:t.pageListItem,onPageCurrent:P.pageCurr,pageTotal:t.pageTotal},null,8,["pageListItem","onPageCurrent","pageTotal"])):(0,s.kq)("",!0),t.loading?((0,s.wg)(),(0,s.j4)(I,{key:1})):(0,s.kq)("",!0)],64)}var I=a(5033),z=a(360),S={data:function(){return{travelAgencyListId:this.$route.query.sn,loading:!1,pageListItem:10,page:0,pageTotal:0,pageChk:!1,purchase_list:[],title:"",startPage:"",endPage:"",totalList:""}},components:{BlackBg:I.Z,Pagination:z.Z},created(){this.init()},methods:{init(){this.travelAgency()},travelAgency(){const t={Authorization:"Bearer "+sessionStorage.getItem("token")};this.loading=!0,this.$axios.get("/api/adm/agency-trip/"+this.travelAgencyListId,{headers:t}).then((t=>{"SUCCESS"==t.data.resultCode&&(this.title=t.data.result.title,this.purchaseList())})).catch((()=>{history.back(-1)})).finally((()=>{this.detail_viewer=!0,this.loading=!1}))},purchaseList(){const t={Authorization:"Bearer "+sessionStorage.getItem("token")};let e={page:this.page};this.loading=!0,this.$axios.get("/api/adm/reser/"+this.travelAgencyListId+"/purchaseList",{headers:t,params:e}).then((t=>{"SUCCESS"==t.data.resultCode&&(this.totalList=t.data.result.totalElements,this.startPage=t.data.result.number*t.data.result.size+1,t.data.result.numberOfElements==t.data.result.size?this.endPage=(t.data.result.number+1)*t.data.result.size:this.endPage=t.data.result.number*t.data.result.size+t.data.result.numberOfElements,this.pageTotal=t.data.result.totalElements,this.purchase_list=[],t.data.result.content.forEach((t=>{let e=[];e.created_at=this.$splitDateHyphenTime(t.createdAt),e.name=t.tripUserDto.name,e.email=t.tripUserDto.email,e.phoneNumber=t.tripUserDto.phoneNumber,e.paid=t.paid,e.person_count=t.personCount,e.imp_uid=t.imp_uid,e.id=t.id,e.list_id=t.travelAgencyListId,t.deleted?e.state="결제 취소":e.state="결제 완료",this.purchase_list.push(e)}))),0==this.pageTotal?this.pageChk=!1:this.pageChk=!0})).catch((t=>{this.$swal("",t.response.data.result,"error")})).finally((()=>{this.loading=!1}))},pageCurr(t){this.page=t-1,this.purchaseList()},qrImg(t,e){this.selectQr=e,this.qrOpen=!0},refundClick(t,e,a,s,n){this.$swal.fire({title:"환불 하시겠습니까?",text:"다시 되돌릴 수 없습니다.",icon:"warning",showCancelButton:!0,confirmButtonColor:"#3085d6",cancelButtonColor:"#d33",confirmButtonText:"확인",cancelButtonText:"취소",reverseButtons:!0}).then((i=>{if(i.isConfirmed){let i={impUid:t,money:e,personCount:a,id:s,travelAgencyListId:n};const r={Authorization:"Bearer "+sessionStorage.getItem("token")};this.loading=!0,this.$axios.post("/api/trip/reser/pay/refund",i,{headers:r}).then((t=>{t.data.result&&(this.$swal("","환불이 완료 되었습니다.","success"),this.purchaseList())})).catch((t=>{this.$swal("",t.response.data.result,"error")})).finally((()=>{this.loading=!1}))}}))},excelDownload(t){let e=new Date,a=String(e.getFullYear()),s=String(e.getMonth()+1<10?"0"+e.getMonth()+1:e.getMonth()+1),n=String(e.getDate()<10?"0"+e.getDate():e.getDate()),i=a+"-"+s+"-"+n;const r={Authorization:"Bearer "+sessionStorage.getItem("token")};let l={excelType:"PURCHASEHISTORY",Sn:this.travelAgencyListId,purchYn:t};this.$axios.get("/api/adm/excel/excel",{headers:r,responseType:"blob",params:l}).then((t=>{const e=window.URL.createObjectURL(new Blob([t.data])),a=document.createElement("a");a.href=e,a.setAttribute("download",i+"_"+this.title+"_결제 인원.xls"),document.body.appendChild(a),a.click()})).catch((()=>{this.$swal("","잠시후 다시 이용해주세요.","error")})).finally((()=>{this.chk=!0}))}}},A=a(89);const B=(0,A.Z)(S,[["render",D],["__scopeId","data-v-2fcd5aba"]]);var $=B}}]);
//# sourceMappingURL=603.dcac8a04.js.map