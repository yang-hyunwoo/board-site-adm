"use strict";(self["webpackChunkboard_site_front"]=self["webpackChunkboard_site_front"]||[]).push([[247],{4247:function(e,t,a){a.r(t),a.d(t,{default:function(){return B}});var l=a(3396),i=a(9242),s=a(7139);const r={class:"py-5 text-center container"},o={class:"row py-5"},n={class:"col-lg-12 mx-auto"},c={class:"text-white p-5 shadow-sm rounded banner"},d=(0,l._)("h1",{class:"display-4"},"게시판",-1),p=(0,l._)("option",{selected:"",value:"TITLE"},"제목",-1),u=(0,l._)("option",{value:"NICKNAME"},"닉네임",-1),h=[p,u],g={class:"container"},_={class:"row"},m={class:"col-lg-12"},C={class:""},k={class:"table-responsive"},b={class:"table project-list-table table-nowrap align-middle table-borderless"},w=(0,l._)("thead",null,[(0,l._)("tr",null,[(0,l._)("th",{scope:"col"},"제목"),(0,l._)("th",{scope:"col"},"작성자"),(0,l._)("th",{scope:"col"},"작성일"),(0,l._)("th",{scope:"col"},"게시여부"),(0,l._)("th",{scope:"col",style:{width:"200px"}},"수정/삭제")])],-1),y=["onClick"],f={class:"text-body"},x={key:0,class:"badge badge-soft-danger mb-0"},v={key:1,class:"badge badge-soft-info mb-0"},P={class:"list-inline mb-0"},S={class:"list-inline-item"},D=["onClick"],$=(0,l._)("i",{class:"bx bx-pencil font-size-18"},null,-1),L=[$],I={class:"list-inline-item"},T=["onClick"],z=(0,l._)("i",{class:"bx bx-trash-alt font-size-18"},null,-1),E=[z],N={class:"list-inline-item dropdown"},U=(0,l._)("a",{class:"text-muted dropdown-toggle font-size-18 px-2",href:"#",role:"button","data-bs-toggle":"dropdown","aria-haspopup":"true"},[(0,l._)("i",{class:"bx bx-dots-vertical-rounded"})],-1),q={class:"dropdown-menu dropdown-menu-end"},V=["onClick"],W=["onClick"],A=["onClick"];function K(e,t,a,p,u,$){const z=(0,l.up)("Pagination");return(0,l.wg)(),(0,l.iD)(l.HY,null,[(0,l._)("section",r,[(0,l._)("div",o,[(0,l._)("div",n,[(0,l._)("div",c,[d,(0,l.wy)((0,l._)("select",{class:"form-select","aria-label":"Default select example","onUpdate:modelValue":t[0]||(t[0]=t=>e.search_type=t)},h,512),[[i.bM,e.search_type]]),(0,l.wy)((0,l._)("input",{style:{"margin-left":"1rem"},class:"form-control mr-sm-2 custombar",type:"search","aria-label":"Search","onUpdate:modelValue":t[1]||(t[1]=t=>e.article_title=t),onKeyup:t[2]||(t[2]=(0,i.D2)(((...e)=>$.articleSearch&&$.articleSearch(...e)),["enter"]))},null,544),[[i.nr,e.article_title]]),(0,l._)("button",{class:"btn btn-outline-success my-2 my-sm-0",style:{"margin-left":"1rem"},onClick:t[3]||(t[3]=(...e)=>$.articleSearch&&$.articleSearch(...e))},"Search")])])]),(0,l._)("div",g,[(0,l._)("div",_,[(0,l._)("div",m,[(0,l._)("div",C,[(0,l._)("div",k,[(0,l._)("table",b,[w,(0,l._)("tbody",null,[((0,l.wg)(!0),(0,l.iD)(l.HY,null,(0,l.Ko)(e.article_list,((e,t)=>((0,l.wg)(),(0,l.iD)("tr",{key:t},[(0,l._)("td",{onClick:t=>$.articleDetailClick(e.id),style:{cursor:"pointer"}},[(0,l._)("a",f,(0,s.zw)(e.title),1)],8,y),(0,l._)("td",null,(0,s.zw)(e.nickname),1),(0,l._)("td",null,(0,s.zw)(e.created_at),1),(0,l._)("td",null,["게시 중단"==e.deleted?((0,l.wg)(),(0,l.iD)("span",x,(0,s.zw)(e.deleted),1)):(0,l.kq)("",!0),"게시 중"==e.deleted?((0,l.wg)(),(0,l.iD)("span",v,(0,s.zw)(e.deleted),1)):(0,l.kq)("",!0)]),(0,l._)("td",null,[(0,l._)("ul",P,[(0,l._)("li",S,[(0,l._)("a",{onClick:t=>$.updateClick(e.id),"data-bs-toggle":"tooltip","data-bs-placement":"top",title:"Edit",class:"px-2 text-primary",style:{cursor:"pointer"}},L,8,D)]),(0,l._)("li",I,[(0,l._)("a",{onClick:t=>$.deleteClick(e.id,e.deleted),"data-bs-toggle":"tooltip","data-bs-placement":"top",title:"Delete",class:"px-2 text-danger",style:{cursor:"pointer"}},E,8,T)]),(0,l._)("li",N,[U,(0,l._)("div",q,[(0,l._)("a",{class:"dropdown-item",onClick:t=>$.updateClick(e.id),style:{cursor:"pointer"}},"수정",8,V),(0,l._)("a",{class:"dropdown-item",onClick:t=>$.deleteClick(e.id,e.deleted),style:{cursor:"pointer"}},"삭제",8,W),(0,l._)("a",{class:"dropdown-item",onClick:t=>$.reDeleteClick(e.id,e.deleted)},"재등록",8,A)])])])])])))),128))])])])])])])]),(0,l._)("button",{style:{float:"right"},type:"button",class:"btn btn-primary",onClick:t[4]||(t[4]=(...e)=>$.writer&&$.writer(...e))},"글작성")]),e.pageChk?((0,l.wg)(),(0,l.j4)(z,{key:0,pageListItem:e.pageListItem,onPageCurrent:$.pageCurr,pageTotal:e.pageTotal},null,8,["pageListItem","onPageCurrent","pageTotal"])):(0,l.kq)("",!0)],64)}var M=a(360),Z={data:function(){return{pageListItem:10,page:0,pageTotal:0,pageChk:!1,article_title:"",article_list:[],loading:!1,search_type:"TITLE"}},components:{Pagination:M.Z},created(){this.init()},methods:{init(){this.articleList()},articleList(){let e={page:this.page,searchKeyWord:this.article_title,searchType:this.search_type};this.$axios.get("/api/adm/articles",{params:e}).then((e=>{"SUCCESS"==e.data.resultCode&&(this.pageTotal=e.data.result.totalElements,this.article_list=[],e.data.result.content.forEach((e=>{let t=[];t.title=e.title,t.nickname=e.nickName,t.id=e.id,t.created_at=this.$splitDateHyphenLo(e.createdAt),t.read_count=e.readCount,e.deleted?t.deleted="게시 중단":t.deleted="게시 중",this.article_list.push(t)})))})).catch((()=>{this.$swal("","잠시후 다시 이용해주세요.","error")})).finally((()=>{this.pageChk=!0}))},deleteClick(e,t){if("게시 중"!=t)return this.$swal("","이미 게시 중단된 게시글입니다.","error"),!1;{const t={Authorization:"Bearer "+sessionStorage.getItem("token")};this.$axios.put("/api/adm/articles/"+e+"/delete",null,{headers:t}).then((e=>{"SUCCESS"==e.data.resultCode&&this.articleList()})).catch((()=>{this.$swal("","잠시후 다시 이용해주세요.","error")})).finally((()=>{}))}},articleDetailClick(e){this.$router.push({path:"/articleDetail",name:"articleDetail",query:{sn:e}})},articleSearch(){this.page=0,this.pageChk=!1,this.articleList()},pageCurr(e){this.page=e-1,this.articleList()},updateClick(e){this.$router.push({path:"/articleModify",name:"articleModify",query:{sn:e}})},writer(){this.$tokenCheck()?this.$router.push("/articleWrite"):this.$router.push("/login")},reDeleteClick(e,t){if("게시 중단"!=t)return this.$swal("","이미 게시 된 게시글 입니다.","error"),!1;{const t={Authorization:"Bearer "+sessionStorage.getItem("token")};this.$axios.put("/api/adm/articles/"+e+"/re-delete",null,{headers:t}).then((e=>{"SUCCESS"==e.data.resultCode&&this.articleList()})).catch((()=>{this.$swal("","잠시후 다시 이용해주세요.","error")})).finally((()=>{}))}}}},j=a(89);const H=(0,j.Z)(Z,[["render",K]]);var B=H},360:function(e,t,a){a.d(t,{Z:function(){return p}});var l=a(3396);const i={class:"pagination"},s={class:"overflow-auto"},r={class:"mt-3"};function o(e,t,a,o,n,c){const d=(0,l.up)("b-pagination"),p=(0,l.up)("b-card");return(0,l.wg)(),(0,l.iD)("div",i,[(0,l.Wm)(p,{style:{"justify-content":"center"}},{default:(0,l.w5)((()=>[(0,l._)("div",s,[(0,l._)("div",r,[(0,l.Wm)(d,{modelValue:e.ex4CurrentPage,"onUpdate:modelValue":t[0]||(t[0]=t=>e.ex4CurrentPage=t),pills:"","total-rows":e.ex4Rows,onPageClick:c.pageClick,"per-page":e.perPage,currPage:a.currPage},null,8,["modelValue","total-rows","onPageClick","per-page","currPage"])])])])),_:1}),(0,l.WI)(e.$slots,"default")])}var n={props:{pageListItem:Number,pageTotal:Number,currPage:{type:Number,default:1}},data:function(){return{ex4CurrentPage:this.currPage,ex4Rows:this.pageTotal,perPage:this.pageListItem}},created(){console.log(this.currPage)},methods:{pageClick:function(e,t){this.ex4CurrentPage=t,this.$emit("pageCurrent",this.ex4CurrentPage)}}},c=a(89);const d=(0,c.Z)(n,[["render",o]]);var p=d}}]);
//# sourceMappingURL=247.bb460369.js.map