"use strict";(self["webpackChunkboard_site_front"]=self["webpackChunkboard_site_front"]||[]).push([[424],{360:function(e,t,a){a.d(t,{Z:function(){return u}});var s=a(3396);const i={class:"pagination"},l={class:"overflow-auto"},o={class:"mt-3"};function r(e,t,a,r,n,c){const d=(0,s.up)("b-pagination"),u=(0,s.up)("b-card");return(0,s.wg)(),(0,s.iD)("div",i,[(0,s.Wm)(u,{style:{"justify-content":"center"}},{default:(0,s.w5)((()=>[(0,s._)("div",l,[(0,s._)("div",o,[(0,s.Wm)(d,{modelValue:e.ex4CurrentPage,"onUpdate:modelValue":t[0]||(t[0]=t=>e.ex4CurrentPage=t),pills:"","total-rows":e.ex4Rows,onPageClick:c.pageClick,"per-page":e.perPage,currPage:a.currPage},null,8,["modelValue","total-rows","onPageClick","per-page","currPage"])])])])),_:1}),(0,s.WI)(e.$slots,"default")])}var n={props:{pageListItem:Number,pageTotal:Number,currPage:{type:Number,default:1}},data:function(){return{ex4CurrentPage:this.currPage,ex4Rows:this.pageTotal,perPage:this.pageListItem}},created(){console.log(this.currPage)},methods:{pageClick:function(e,t){this.ex4CurrentPage=t,this.$emit("pageCurrent",this.ex4CurrentPage)}}},c=a(89);const d=(0,c.Z)(n,[["render",r]]);var u=d},5033:function(e,t,a){a.d(t,{Z:function(){return d}});var s=a(3396);const i=(0,s._)("div",{class:"customdis"},[(0,s._)("div",{class:"spinner-border text-secondary",style:{width:"3rem",height:"3rem"},role:"status"},[(0,s._)("span",{class:"visually-hidden"},"Loading...")])],-1),l=[i];function o(e,t,a,i,o,r){return(0,s.wg)(),(0,s.iD)("div",{class:"black-bg",onClick:t[0]||(t[0]=t=>e.$emit("close"))},l)}var r={},n=a(89);const c=(0,n.Z)(r,[["render",o]]);var d=c},7424:function(e,t,a){a.r(t),a.d(t,{default:function(){return ae}});var s=a(3396),i=a(9242),l=a(7139);const o=e=>((0,s.dD)("data-v-23806c92"),e=e(),(0,s.Cn)(),e),r={class:"py-5 text-center container"},n={class:"row py-5"},c={class:"col-lg-12 mx-auto"},d={class:"text-white p-5 shadow-sm rounded banner"},u=o((()=>(0,s._)("h1",{class:"display-4"},"여행지 리스트",-1))),p=o((()=>(0,s._)("option",{selected:"",value:"TITLE"},"제목",-1))),g=o((()=>(0,s._)("option",{value:"CITY"},"도시",-1))),h=[p,g],m={class:"container"},_={class:"row"},k={class:"col-lg-12"},b={class:""},C={class:"table-responsive"},y={class:"table project-list-table table-nowrap align-middle table-borderless"},w=o((()=>(0,s._)("thead",null,[(0,s._)("tr",null,[(0,s._)("th",{scope:"col"},"제목"),(0,s._)("th",{scope:"col"},"도시 명"),(0,s._)("th",{scope:"col"},"조회수"),(0,s._)("th",{scope:"col"},"게시여부"),(0,s._)("th",{scope:"col",style:{width:"200px"}},"수정/삭제")])],-1))),f=["onClick"],v=["src"],x={class:"text-body"},D={key:0},P={class:"badge badge-soft-info mb-0"},S={key:1},I={class:"badge badge-soft-success mb-0"},$={key:2},L={class:"badge badge-soft-primary mb-0"},z={key:3},T={class:"badge badge-soft-danger mb-0"},q={key:0,class:"badge badge-soft-danger mb-0"},E={key:1,class:"badge badge-soft-info mb-0"},B={class:"list-inline mb-0"},W={class:"list-inline-item"},Z=["onClick"],U=o((()=>(0,s._)("i",{class:"bx bx-pencil font-size-18"},null,-1))),V=[U],j={class:"list-inline-item"},A=["onClick"],K=o((()=>(0,s._)("i",{class:"bx bx-trash-alt font-size-18"},null,-1))),M=[K],N={class:"list-inline-item dropdown"},Y=o((()=>(0,s._)("a",{class:"text-muted dropdown-toggle font-size-18 px-2",href:"#",role:"button","data-bs-toggle":"dropdown","aria-haspopup":"true"},[(0,s._)("i",{class:"bx bx-dots-vertical-rounded"})],-1))),H={class:"dropdown-menu dropdown-menu-end"},R=["onClick"],F=["onClick"],G=["onClick"];function J(e,t,a,o,p,g){const U=(0,s.up)("BlackBg"),K=(0,s.up)("Pagination");return(0,s.wg)(),(0,s.iD)(s.HY,null,[(0,s._)("section",r,[(0,s._)("div",n,[(0,s._)("div",c,[(0,s._)("div",d,[u,(0,s.wy)((0,s._)("select",{class:"form-select","aria-label":"Default select example","onUpdate:modelValue":t[0]||(t[0]=t=>e.search_type=t)},h,512),[[i.bM,e.search_type]]),(0,s.wy)((0,s._)("input",{class:"form-control mr-sm-2 custombar",type:"search",placeholder:"제목을 입력해주세요.","aria-label":"Search","onUpdate:modelValue":t[1]||(t[1]=t=>e.tour_title=t),onKeyup:t[2]||(t[2]=(0,i.D2)(((...e)=>g.tourSearch&&g.tourSearch(...e)),["enter"]))},null,544),[[i.nr,e.tour_title]]),(0,s._)("button",{class:"btn btn-outline-success my-2 my-sm-0",style:{"margin-left":"1rem"},onClick:t[3]||(t[3]=(...e)=>g.tourSearch&&g.tourSearch(...e))},"Search")])])]),(0,s._)("button",{style:{float:"right"},type:"button",class:"btn btn-primary",onClick:t[4]||(t[4]=e=>g.tourWriteClick())},"글작성")]),(0,s._)("div",m,[(0,s._)("div",_,[(0,s._)("div",k,[(0,s._)("div",b,[(0,s._)("div",C,[(0,s._)("table",y,[w,(0,s._)("tbody",null,[((0,s.wg)(!0),(0,s.iD)(s.HY,null,(0,s.Ko)(e.tour_list,((e,t)=>((0,s.wg)(),(0,s.iD)("tr",{key:t},[(0,s._)("td",{onClick:t=>g.todoCclick(e.id),style:{cursor:"pointer"}},[e.img_chk?((0,s.wg)(),(0,s.iD)("img",{key:0,src:e.img,alt:"",class:"avatar-sm rounded-circle me-2"},null,8,v)):(0,s.kq)("",!0),(0,s._)("a",x,(0,l.zw)(e.title),1)],8,f),e.read_count<1e3?((0,s.wg)(),(0,s.iD)("td",D,[(0,s._)("span",P,(0,l.zw)(e.city),1)])):(0,s.kq)("",!0),e.read_count>1e3&&e.read_count<5e3?((0,s.wg)(),(0,s.iD)("td",S,[(0,s._)("span",I,(0,l.zw)(e.city),1)])):(0,s.kq)("",!0),e.read_count>5e3&&e.read_count<1e4?((0,s.wg)(),(0,s.iD)("td",$,[(0,s._)("span",L,(0,l.zw)(e.city),1)])):(0,s.kq)("",!0),e.read_count>1e4?((0,s.wg)(),(0,s.iD)("td",z,[(0,s._)("span",T,(0,l.zw)(e.city),1)])):(0,s.kq)("",!0),(0,s._)("td",null,(0,l.zw)(e.read_count),1),(0,s._)("td",null,["게시 중단"==e.deleted?((0,s.wg)(),(0,s.iD)("span",q,(0,l.zw)(e.deleted),1)):(0,s.kq)("",!0),"게시 중"==e.deleted?((0,s.wg)(),(0,s.iD)("span",E,(0,l.zw)(e.deleted),1)):(0,s.kq)("",!0)]),(0,s._)("td",null,[(0,s._)("ul",B,[(0,s._)("li",W,[(0,s._)("a",{onClick:t=>g.updateClick(e.id),"data-bs-toggle":"tooltip","data-bs-placement":"top",title:"Edit",class:"px-2 text-primary",style:{cursor:"pointer"}},V,8,Z)]),(0,s._)("li",j,[(0,s._)("a",{onClick:t=>g.deleteClick(e.id,e.deleted),"data-bs-toggle":"tooltip","data-bs-placement":"top",title:"Delete",class:"px-2 text-danger",style:{cursor:"pointer"}},M,8,A)]),(0,s._)("li",N,[Y,(0,s._)("div",H,[(0,s._)("a",{class:"dropdown-item",onClick:t=>g.updateClick(e.id),style:{cursor:"pointer"}},"수정",8,R),(0,s._)("a",{class:"dropdown-item",onClick:t=>g.deleteClick(e.id,e.deleted),style:{cursor:"pointer"}},"삭제",8,F),(0,s._)("a",{class:"dropdown-item",onClick:t=>g.reDeleteClick(e.id,e.deleted)},"재등록",8,G)])])])])])))),128))])])])])])])]),e.loading?((0,s.wg)(),(0,s.j4)(U,{key:0})):(0,s.kq)("",!0),e.pageChk?((0,s.wg)(),(0,s.j4)(K,{key:1,pageListItem:e.pageListItem,onPageCurrent:g.pageCurr,pageTotal:e.pageTotal},null,8,["pageListItem","onPageCurrent","pageTotal"])):(0,s.kq)("",!0)],64)}var O=a(360),Q=a(5033),X={data:function(){return{pageListItem:9,page:0,tour_title:"",pageTotal:0,pageChk:!1,tour_list:[],loading:!1,search_type:"TITLE"}},components:{Pagination:O.Z,BlackBg:Q.Z},created(){this.init()},methods:{init(){this.tourList()},tourList(){let e={page:this.page,searchKeyWord:this.tour_title,searchType:this.search_type};const t={Authorization:"Bearer "+sessionStorage.getItem("token")};this.loading=!0,this.$axios.get("/api/adm/tour",{headers:t,params:e}).then((e=>{"SUCCESS"==e.data.resultCode&&(this.pageTotal=e.data.result.totalElements,this.tour_list=[],e.data.result.content.forEach((e=>{let t=[];t.title=e.title,t.id=e.id,t.city=e.city,t.read_count=e.readCount,null==e.thumbnailId||""==e.thumbnailId?t.img_chk=!1:t.img_chk=!0,e.deleted?t.deleted="게시 중단":t.deleted="게시 중",t.img="/api/common/image/thumb/"+e.thumbnailId+"/1",this.tour_list.push(t)})))})).catch((()=>{this.$swal("","잠시후 다시 이용해주세요.","error")})).finally((()=>{this.pageChk=!0,this.loading=!1}))},pageCurr(e){this.page=e-1,this.tourList()},tourSearch(){this.page=0,this.pageChk=!1,this.tourList()},updateClick(e){this.$router.push({path:"/tourModify",name:"tourModify",query:{sn:e}})},deleteClick(e,t){if("게시 중"!=t)return this.$swal("","이미 게시 중단된 게시글입니다.","error"),!1;{const t={Authorization:"Bearer "+sessionStorage.getItem("token")};this.loading=!0,this.$axios.put("/api/adm/tour/"+e+"/delete",null,{headers:t}).then((e=>{"SUCCESS"==e.data.resultCode&&this.tourList()})).catch((()=>{this.$swal("","잠시후 다시 이용해주세요.","error")})).finally((()=>{this.pageChk=!0,this.loading=!1}))}},reDeleteClick(e,t){if("게시 중단"!=t)return this.$swal("","이미 게시 된 게시글 입니다.","error"),!1;{const t={Authorization:"Bearer "+sessionStorage.getItem("token")};this.loading=!0,this.$axios.put("/api/adm/tour/"+e+"/re-delete",null,{headers:t}).then((e=>{console.log(e),"SUCCESS"==e.data.resultCode&&this.tourList()})).catch((()=>{this.$swal("","잠시후 다시 이용해주세요.","error")})).finally((()=>{this.pageChk=!0,this.loading=!1}))}},todoCclick(e){this.$router.push({path:"/tourDetail",name:"tourDetail",query:{sn:e}})},tourWriteClick(){this.$tokenCheck()?this.$router.push("/tourWrite"):this.$router.push("/login")}}},ee=a(89);const te=(0,ee.Z)(X,[["render",J],["__scopeId","data-v-23806c92"]]);var ae=te}}]);
//# sourceMappingURL=424.dd5f2ff0.js.map