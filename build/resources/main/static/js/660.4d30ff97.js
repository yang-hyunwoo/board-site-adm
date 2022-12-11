"use strict";(self["webpackChunkboard_site_front"]=self["webpackChunkboard_site_front"]||[]).push([[660],{1660:function(e,t,a){a.r(t),a.d(t,{default:function(){return J}});var s=a(3396),l=a(9242),i=a(7139);const n=e=>((0,s.dD)("data-v-67d707f6"),e=e(),(0,s.Cn)(),e),r={class:"py-5 text-center container"},o={class:"row py-5"},c={class:"col-lg-12 mx-auto"},d={class:"text-white p-5 shadow-sm rounded banner",style:{"text-align":"center"}},g=n((()=>(0,s._)("h1",{class:"display-4"},"여행사",-1))),u={class:"container"},h={class:"row py-5"},p={class:"mb-3"},m={class:"card-title"},y=(0,s.Uk)("목록 "),k={class:"text-muted fw-normal ms-2"},_={class:"row"},b={class:"col-lg-12"},C={class:""},w={class:"table-responsive"},f={class:"table project-list-table table-nowrap align-middle table-borderless"},x=n((()=>(0,s._)("thead",null,[(0,s._)("tr",null,[(0,s._)("th",{scope:"col"},"여행사"),(0,s._)("th",{scope:"col"},"주소"),(0,s._)("th",{scope:"col"},"전화번호"),(0,s._)("th",{scope:"col"},"사용유무"),(0,s._)("th",{scope:"col",style:{width:"200px"}},"변경")])],-1))),v=["onClick"],P=["src"],S={class:"text-body"},D={class:"badge badge-soft-info mb-0"},$={key:0,class:"badge badge-soft-danger mb-0"},z={key:1,class:"badge badge-soft-info mb-0"},E={class:"list-inline mb-0"},L={class:"list-inline-item"},A=["onClick"],I=n((()=>(0,s._)("i",{class:"bx bx-pencil font-size-18"},null,-1))),U=[I],q={key:0,class:"list-inline-item"},B=["onClick"],T=n((()=>(0,s._)("i",{class:"bx bx-trash-alt font-size-18"},null,-1))),R=[T],Z={key:1,class:"list-inline-item dropdown"},W=n((()=>(0,s._)("a",{class:"text-muted dropdown-toggle font-size-18 px-2",href:"#",role:"button","data-bs-toggle":"dropdown","aria-haspopup":"true"},[(0,s._)("i",{class:"bx bx-dots-vertical-rounded"})],-1))),j={class:"dropdown-menu dropdown-menu-end"},M=["onClick"],N=["onClick"],V=["onClick"];function Y(e,t,a,n,I,T){const Y=(0,s.up)("BlackBg"),O=(0,s.up)("Pagination");return(0,s.wg)(),(0,s.iD)(s.HY,null,[(0,s._)("section",r,[(0,s._)("div",o,[(0,s._)("div",c,[(0,s._)("div",d,[g,(0,s.wy)((0,s._)("input",{style:{"margin-left":"1rem"},class:"form-control mr-sm-2 custombar",type:"search","aria-label":"Search","onUpdate:modelValue":t[0]||(t[0]=t=>e.agency_title=t),onKeyup:t[1]||(t[1]=(0,l.D2)(((...e)=>T.agencySearch&&T.agencySearch(...e)),["enter"]))},null,544),[[l.nr,e.agency_title]]),(0,s._)("button",{class:"btn btn-outline-success my-2 my-sm-0",style:{"margin-left":"1rem"},onClick:t[2]||(t[2]=(...t)=>e.articleSearch&&e.articleSearch(...t))},"Search")])])]),"SUPER"==e.adminAuth?((0,s.wg)(),(0,s.iD)("button",{key:0,style:{float:"right","margin-left":"10px"},type:"button",class:"btn btn-primary",onClick:t[3]||(t[3]=e=>T.agencyExcel())},"엑셀다운")):(0,s.kq)("",!0),"SUPER"==e.adminAuth?((0,s.wg)(),(0,s.iD)("button",{key:1,style:{float:"right"},type:"button",class:"btn btn-primary",onClick:t[4]||(t[4]=e=>T.tourWriteClick())},"신규등록")):(0,s.kq)("",!0)]),(0,s._)("div",u,[(0,s._)("div",h,[(0,s._)("div",p,[(0,s._)("h5",m,[y,(0,s._)("span",k,(0,i.zw)(e.startPage)+" to "+(0,i.zw)(e.endPage)+" of "+(0,i.zw)(e.totalList),1)])]),(0,s._)("div",_,[(0,s._)("div",b,[(0,s._)("div",C,[(0,s._)("div",w,[(0,s._)("table",f,[x,(0,s._)("tbody",null,[((0,s.wg)(!0),(0,s.iD)(s.HY,null,(0,s.Ko)(e.agency_list,((t,a)=>((0,s.wg)(),(0,s.iD)("tr",{key:a},[(0,s._)("td",{onClick:e=>T.todoCclick(t.id),style:{cursor:"pointer"}},[t.img_real?((0,s.wg)(),(0,s.iD)("img",{key:0,src:t.img,alt:"",class:"avatar-sm rounded-circle me-2"},null,8,P)):(0,s.kq)("",!0),(0,s._)("a",S,(0,i.zw)(t.agency_name),1)],8,v),(0,s._)("td",null,[(0,s._)("span",D,(0,i.zw)(t.address),1)]),(0,s._)("td",null,(0,i.zw)(t.tel),1),(0,s._)("td",null,["미사용"==t.deleted?((0,s.wg)(),(0,s.iD)("span",$,(0,i.zw)(t.deleted),1)):(0,s.kq)("",!0),"사용"==t.deleted?((0,s.wg)(),(0,s.iD)("span",z,(0,i.zw)(t.deleted),1)):(0,s.kq)("",!0)]),(0,s._)("td",null,[(0,s._)("ul",E,[(0,s._)("li",L,[(0,s._)("a",{onClick:e=>T.updateClick(t.id),"data-bs-toggle":"tooltip","data-bs-placement":"top",title:"Edit",class:"px-2 text-primary",style:{cursor:"pointer"}},U,8,A)]),"SUPER"==e.adminAuth?((0,s.wg)(),(0,s.iD)("li",q,[(0,s._)("a",{onClick:e=>T.deleteClick(t.id,t.deleted),"data-bs-toggle":"tooltip","data-bs-placement":"top",title:"Delete",class:"px-2 text-danger",style:{cursor:"pointer"}},R,8,B)])):(0,s.kq)("",!0),"SUPER"==e.adminAuth?((0,s.wg)(),(0,s.iD)("li",Z,[W,(0,s._)("div",j,[(0,s._)("a",{class:"dropdown-item",onClick:e=>T.updateClick(t.id),style:{cursor:"pointer"}},"수정",8,M),(0,s._)("a",{class:"dropdown-item",onClick:e=>T.deleteClick(t.id,t.deleted),style:{cursor:"pointer"}},"삭제",8,N),(0,s._)("a",{class:"dropdown-item",onClick:e=>T.reDeleteClick(t.id,t.deleted)},"재등록",8,V)])])):(0,s.kq)("",!0)])])])))),128))])])])])])]),e.loading?((0,s.wg)(),(0,s.j4)(Y,{key:0})):(0,s.kq)("",!0),e.pageChk?((0,s.wg)(),(0,s.j4)(O,{key:1,pageListItem:e.pageListItem,onPageCurrent:T.pageCurr,pageTotal:e.pageTotal},null,8,["pageListItem","onPageCurrent","pageTotal"])):(0,s.kq)("",!0)])])],64)}var O=a(360),H=a(5033),K={data:function(){return{pageListItem:12,page:0,pageTotal:0,pageChk:!1,loading:!1,agency_list:[],agency_title:"",totalList:"",startPage:"",endPage:"",adminAuth:""}},components:{Pagination:O.Z,BlackBg:H.Z},created(){this.init()},methods:{init(){this.agencyList(),this.authChk()},authChk(){const e={Authorization:"Bearer "+sessionStorage.getItem("token")};this.$axios.get("/api/adm/admin/auth",{headers:e}).then((e=>{"SUCCESS"==e.data.resultCode&&(this.adminAuth=e.data.result.role)})).catch((()=>{this.$swal("","잠시후 다시 이용해주세요.","error")})).finally((()=>{}))},agencyList(){let e={page:this.page,travelAgencyName:this.agency_title};const t={Authorization:"Bearer "+sessionStorage.getItem("token")};this.loading=!0,this.$axios.get("/api/adm/agency/list",{headers:t,params:e}).then((e=>{"SUCCESS"==e.data.resultCode&&(this.pageTotal=e.data.result.totalElements,this.agency_list=[],this.totalList=e.data.result.totalElements,this.startPage=e.data.result.number*e.data.result.size+1,e.data.result.numberOfElements==e.data.result.size?this.endPage=(e.data.result.number+1)*e.data.result.size:this.endPage=e.data.result.number*e.data.result.size+e.data.result.numberOfElements,console.log(e),e.data.result.content.forEach((e=>{let t=[];t.agency_name=e.name,t.id=e.id,t.agency_list=e.name,t.agency_comment=e.comment,null==e.filePath||""==e.filePath?t.img_real=!1:(t.img_real=!0,t.img=e.filePath),e.deleted?t.deleted="미사용":t.deleted="사용",t.address=e.address,t.tel=e.tel,this.agency_list.push(t)})))})).catch((()=>{this.$swal("","잠시후 다시 이용해주세요.","error")})).finally((()=>{this.pageChk=!0,this.loading=!1}))},pageCurr(e){this.page=e-1,this.agencyList()},agencySearch(){this.page=0,this.pageChk=!1,this.agencyList()},agency_click(e){this.$router.push({path:"/AgencyDetail",name:"agencyDetail",query:{sn:e}})},deleteClick(e,t){if("사용"==t){const t={Authorization:"Bearer "+sessionStorage.getItem("token")};this.loading=!0,this.$axios.put("/api/adm/agency/"+e+"/delete","",{headers:t}).then((e=>{"SUCCESS"==e.data.resultCode&&this.agencyList()})).catch((e=>{this.$swal("",e.response.data.result,"error")})).finally((()=>{this.loading=!1}))}else this.$swal("","이미 미사용된 여행사 입니다.","warning")},reDeleteClick(e,t){if("미사용"==t){const t={Authorization:"Bearer "+sessionStorage.getItem("token")};this.loading=!0,this.$axios.put("/api/adm/agency/"+e+"/re-delete","",{headers:t}).then((e=>{"SUCCESS"==e.data.resultCode&&this.agencyList()})).catch((e=>{this.$swal("",e.response.data.result,"error")})).finally((()=>{this.loading=!1}))}else this.$swal("","이미 사용중인 여행사 입니다.","warning")},todoCclick(e){this.$router.push({path:"/agencyDetail",name:"agencyDetail",query:{sn:e}})},updateClick(e){this.$router.push({path:"/agencyModify",name:"agencyModify",query:{sn:e}})},tourWriteClick(){this.$tokenCheck()?this.$router.push("/agencyWrite"):this.$router.push("/login")},agencyExcel(){let e=new Date,t=String(e.getFullYear()),a=String(e.getMonth()+1<10?"0"+e.getMonth()+1:e.getMonth()+1),s=String(e.getDate()<10?"0"+e.getDate():e.getDate()),l=t+"-"+a+"-"+s;const i={Authorization:"Bearer "+sessionStorage.getItem("token")};let n={excelType:"TRAVELAGENCY"};this.$axios.get("/api/adm/excel/excel",{headers:i,responseType:"blob",params:n}).then((e=>{const t=window.URL.createObjectURL(new Blob([e.data])),a=document.createElement("a");a.href=t,a.setAttribute("download",l+"_여행사 목록.xls"),document.body.appendChild(a),a.click()})).catch((()=>{this.$swal("","잠시후 다시 이용해주세요.","error")})).finally((()=>{this.chk=!0}))}}},F=a(89);const G=(0,F.Z)(K,[["render",Y],["__scopeId","data-v-67d707f6"]]);var J=G},360:function(e,t,a){a.d(t,{Z:function(){return g}});var s=a(3396);const l={class:"pagination"},i={class:"overflow-auto"},n={class:"mt-3"};function r(e,t,a,r,o,c){const d=(0,s.up)("b-pagination"),g=(0,s.up)("b-card");return(0,s.wg)(),(0,s.iD)("div",l,[(0,s.Wm)(g,{style:{"justify-content":"center"}},{default:(0,s.w5)((()=>[(0,s._)("div",i,[(0,s._)("div",n,[(0,s.Wm)(d,{modelValue:e.ex4CurrentPage,"onUpdate:modelValue":t[0]||(t[0]=t=>e.ex4CurrentPage=t),pills:"","total-rows":e.ex4Rows,onPageClick:c.pageClick,"per-page":e.perPage,currPage:a.currPage},null,8,["modelValue","total-rows","onPageClick","per-page","currPage"])])])])),_:1}),(0,s.WI)(e.$slots,"default")])}var o={props:{pageListItem:Number,pageTotal:Number,currPage:{type:Number,default:1}},data:function(){return{ex4CurrentPage:this.currPage,ex4Rows:this.pageTotal,perPage:this.pageListItem}},created(){console.log(this.currPage)},methods:{pageClick:function(e,t){this.ex4CurrentPage=t,this.$emit("pageCurrent",this.ex4CurrentPage)}}},c=a(89);const d=(0,c.Z)(o,[["render",r]]);var g=d},5033:function(e,t,a){a.d(t,{Z:function(){return d}});var s=a(3396);const l=(0,s._)("div",{class:"customdis"},[(0,s._)("div",{class:"spinner-border text-secondary",style:{width:"3rem",height:"3rem"},role:"status"},[(0,s._)("span",{class:"visually-hidden"},"Loading...")])],-1),i=[l];function n(e,t,a,l,n,r){return(0,s.wg)(),(0,s.iD)("div",{class:"black-bg",onClick:t[0]||(t[0]=t=>e.$emit("close"))},i)}var r={},o=a(89);const c=(0,o.Z)(r,[["render",n]]);var d=c}}]);
//# sourceMappingURL=660.4d30ff97.js.map