"use strict";var _typeof=typeof Symbol==="function"&&typeof Symbol.iterator==="symbol"?function(e){return typeof e}:function(e){return e&&typeof Symbol==="function"&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e};(function(e,t,n){if((typeof exports==="undefined"?"undefined":_typeof(exports))==="object"){module.exports=n()}else if(typeof define==="function"&&define.amd){define(n)}else if(t.layui&&e.define){e.define(["jquery"],function(e){e("formSelects",n())})}else{t.formSelects=n()}})(typeof layui=="undefined"?null:layui,window,function(){var t="4.0.0.0713",H="xm-select",E="xm-select-parent",D="xm-select-input",F="xm-select--suffix",m="xm-select-this",N="xm-select-label",O="xm-select-search",I="xm-select-search-type",P="xm-select-show-count",V="xm-select-create",c="xm-select-create-long",_="xm-select-max",U="xm-select-skin",M="xm-select-direction",W="xm-select-height",y="xm-dis-disabled",B="xm-select-dis",u="xm-select-temp",q="xm-select-radio",g="xm-select-linkage",J="xm-select-dl",h="xm-select-hide",z="xm-hide-input",Q="xm-select-sj",e="xm-icon-close",X="xm-select-title",Y="xm-form-select",d="xm-form-selected",v="xm-select-none",x="xm-select-empty",$="xm-input",G="xm-dl-input",k="xm-select-tips",r="iconfont",b="xm-cz",l="xm-cz-group",K="请选择",R={},C={on:{},filter:{},maxTips:{}},Z={type:"get",header:{},first:true,data:{},searchUrl:"",searchName:"keyword",searchVal:null,keyName:"name",keyVal:"value",keySel:"selected",keyDis:"disabled",keyChildren:"children",dataType:"",delay:500,beforeSuccess:null,success:null,error:null,beforeSearch:null},ee=[{icon:"iconfont icon-quanxuan",name:"全选",click:function e(t,n){n.selectAll(t,true,true)}},{icon:"iconfont icon-qingkong",name:"清空",click:function e(t,n){n.removeAll(t,true,true)}},{icon:"iconfont icon-fanxuan",name:"反选",click:function e(t,n){n.reverse(t,true,true)}},{icon:"iconfont icon-pifu",name:"换肤",click:function e(t,n){n.skin(t)}}],te=window.$||window.layui&&window.layui.jquery,o=te(window),ne={},ie=function e(t){var r=this;this.config={name:null,max:null,maxTips:function e(t,n,i){var a=te('[xid="'+r.config.name+'"]').prev().find("."+H);if(a.parents(".layui-form-item[pane]").length){a=a.parents(".layui-form-item[pane]")}a.attr("style","border-color: red !important");setTimeout(function(){a.removeAttr("style")},300)},init:null,on:null,filter:function e(t,n,i,a){return i.name.indexOf(n)==-1},clearid:-1,direction:"auto",height:null,isEmpty:false,btns:[ee[0],ee[1],ee[2]],searchType:0,create:function e(t,n){return Date.now()},template:function e(t,n,i,a){return t},showCount:0,isCreate:false,placeholder:K,clearInput:false};this.select=null;this.values=[];te.extend(this.config,t)};var n=function e(){this.appender();this.init();this.on();this.initVal();this.onreset()};n.prototype.appender=function(){if(!Array.prototype.map){Array.prototype.map=function(e,t){var n,i,a,r=Object(this),l=r.length>>>0;if(t){n=t}i=new Array(l);a=0;while(a<l){var o,s;if(a in r){o=r[a];s=e.call(n,o,a,r);i[a]=s}a++}return i}}if(!Array.prototype.forEach){Array.prototype.forEach=function e(t,n){var i,a;if(this==null){throw new TypeError("this is null or not defined")}var r=Object(this);var l=r.length>>>0;if(typeof t!=="function"){throw new TypeError(t+" is not a function")}if(arguments.length>1){i=n}a=0;while(a<l){var o;if(a in r){o=r[a];t.call(i,o,a,r)}a++}}}};n.prototype.init=function(e){var A=this;te(e?e:"select["+H+"]").each(function(e,t){var n=te(t),i=n.attr(H),a=n.next(".layui-form-select"),r=t.disabled,l=n.attr(_)-0,o=n.attr(O)!=undefined,s=o?n.attr(O):null,c=n.attr(V)!=undefined,f=n.attr(q)!=undefined,d=n.attr(U),u=n.attr(M),p=t.options[0],h=n.attr(W),v=n.attr("name"),m=n.attr("lay-verify"),y=n.attr("lay-verType"),g=n.attr(I)=="dl"?1:0,x=n.attr(P)-0,k=p?p.value?K:p.innerHTML||K:K,b=n.find("option[selected]").toArray().map(function(e){return{name:e.innerHTML,val:e.value}}),C=new ie(f?{btns:[ee[1]]}:{});var w=R[i];R[i]=C;C.values=b;C.config.init=b.concat([]);C.config.name=i;C.config.disabled=r;C.config.max=l;C.config.isSearch=o;C.config.searchUrl=s;C.config.isCreate=c;C.config.radio=f;C.config.skin=d;C.config.direction=u;C.config.height=h;C.config.searchType=g;C.config.formname=v;C.config.layverify=m;C.config.layverType=y;C.config.searchType=g;C.config.showCount=x;C.config.placeholder=k;if(w){te.extend(true,C.config,w.config);r=C.config.disabled;l=C.config.max;o=C.config.isSearch;s=C.config.searchUrl;f=C.config.radio;d=C.config.skin;h=C.config.height;v=C.config.formname;m=C.config.layverify;y=C.config.layverType;x=C.config.showCount;k=C.config.placeholder;if(w.config.init){C.values=w.config.init.map(function(e){if((typeof e==="undefined"?"undefined":_typeof(e))=="object"){return e}return{name:n.find('option[value="'+e+'"]').text(),val:e}}).filter(function(e){return e.name});C.config.init=C.values.concat([])}}if(isNaN(x)||x<=0){x=19921012}a[0]&&a.remove();var S=A.renderSelect(i,k,t);var T=!h||h=="auto"?"":'xm-hg style="height: 34px;"';var j=['<div class="'+N+'">','<input type="text" fsw class="'+$+" "+D+'" '+(o?"":'style="display: none;"')+' autocomplete="off" debounce="0" />',"</div>"];var L=te('<div class="'+Y+'" '+U+'="'+d+'">\n\t\t\t\t\t<input class="'+z+'" value="" name="'+v+'" lay-verify="'+m+'" lay-verType="'+y+'" type="text" style="position: absolute;bottom: 0; z-index: -1;width: 100%; height: 100%; border: none; opacity: 0;"/>\n\t\t\t\t\t<div class="'+X+" "+(r?B:"")+'">\n\t\t\t\t\t\t<div class="'+$+" "+H+'" '+T+">\n\t\t\t\t\t\t\t"+j.join("")+'\n\t\t\t\t\t\t\t<i class="'+Q+'"></i>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class="'+F+'">\n\t\t\t\t\t\t\t<input type="text" autocomplete="off" placeholder="'+k+'" readonly="readonly" unselectable="on" class="'+$+'">\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div></div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<dl xid="'+i+'" class="'+J+" "+(f?q:"")+'">'+S+"</dl>\n\t\t\t\t</div>");if(w){te('dl[xid="'+i+'"]').parents("."+E).html(L);C.select=n}else{n.wrap('<div class="'+E+'" FS_ID="'+i+'"></div>');n.after(L);C.select=n.remove()}if(o){ne[i]=te.extend(true,{},Z,{searchUrl:s});te(document).on("input","div."+E+'[FS_ID="'+i+'"] .'+D,function(e){A.search(i,e,s)});if(s){A.triggerSearch(L,true)}}else{L.find("dl dd."+G).css("display","none")}})};n.prototype.search=function(a,e,t,n){var i=this;var r=void 0;if(n){r=n}else{r=e.target;var l=e.keyCode;if(l===9||l===13||l===37||l===38||l===39||l===40){return false}}var o=te.trim(r.value);this.changePlaceHolder(te(r));var s=ne[a]?ne[a]:Z;t=s.searchUrl||t;var c=R[a],f=c.config.isCreate,d=te('dl[xid="'+a+'"]').parents("."+Y);if(t){if(s.searchVal){o=s.searchVal;s.searchVal=""}if(!s.beforeSearch||s.beforeSearch&&s.beforeSearch instanceof Function&&s.beforeSearch(a,t,o)){var u=s.delay;if(s.first){s.first=false;u=10}clearTimeout(c.clearid);c.clearid=setTimeout(function(){d.find("dl > *:not(."+k+")").remove();d.find("dd."+v).addClass(x).text("请求中");i.ajax(a,t,o,false,null,true)},u)}}else{d.find("dl ."+h).removeClass(h);d.find("dl dd:not(."+k+")").each(function(e,t){var n=te(t);var i=R[a].config.filter||C.filter[a];if(i&&i(a,o,{name:n.find("span").attr("name"),val:n.attr("lay-value")},n.hasClass(y))==true){n.addClass(h)}});d.find("dl dt").each(function(e,t){if(!te(t).nextUntil("dt",":not(."+h+")").length){te(t).addClass(h)}});this.create(a,f,o);var p=d.find("dl dd:not(."+k+"):not(."+h+")");if(!p.length){d.find("dd."+v).addClass(x).text("无匹配项")}else{d.find("dd."+v).removeClass(x)}}};n.prototype.isArray=function(e){return Object.prototype.toString.call(e)=="[object Array]"};n.prototype.triggerSearch=function(e,i){var a=this;(e?[e]:te("."+Y).toArray()).forEach(function(e,t){e=te(e);var n=e.find("dl").attr("xid");if(n&&R[n]&&R[n].config.isEmpty||i){a.search(n,null,null,R[n].config.searchType==0?e.find("."+N+" ."+D):e.find("dl ."+G+" ."+D))}})};n.prototype.clearInput=function(e){var t=te("."+E+'[fs_id="'+e+'"]');var n=R[e].config.searchType==0?t.find("."+N+" ."+D):t.find("dl ."+G+" ."+D);n.val("")};n.prototype.ajax=function(n,i,a,r,l,o){var s=this;var c=te("."+E+' dl[xid="'+n+'"]').parents("."+Y);if(!c[0]||!i){return}var f=ne[n]?ne[n]:Z;var e=te.extend(true,{},f.data);e[f.searchName]=a;te.ajax({type:f.type,headers:f.header,url:i,data:f.dataType=="json"?JSON.stringify(e):e,success:function e(t){if(typeof t=="string"){t=JSON.parse(t)}f.beforeSuccess&&f.beforeSuccess instanceof Function&&(t=f.beforeSuccess(n,i,a,t));if(s.isArray(t)){t={code:0,msg:"",data:t}}if(t.code!=0){c.find("dd."+v).addClass(x).text(t.msg)}else{c.find("dd."+v).removeClass(x);s.renderData(n,t.data,r,l,o);R[n].config.isEmpty=t.data.length==0}f.success&&f.success instanceof Function&&f.success(n,i,a,t)},error:function e(t){c.find("dd[lay-value]:not(."+k+")").remove();c.find("dd."+v).addClass(x).text("服务异常");f.error&&f.error instanceof Function&&f.error(n,i,a,t)}})};n.prototype.renderData=function(r,s,e,c,t){var n=this;if(e){var i=function(){var n=[],i=0,l={0:s},o=ne[r]?ne[r]:Z;var e=function e(){var r=n[i++]=[],t=l;l={};te.each(t,function(a,e){te.each(e,function(e,t){var n={pid:a,name:t[o.keyName],val:t[o.keyVal]};r.push(n);var i=t[o.keyChildren];if(i&&i.length){l[n.val]=i}})})};do{e()}while(Object.getOwnPropertyNames(l).length);var t=te("."+E+' dl[xid="'+r+'"]').parents("."+Y);var a=['<div class="xm-select-linkage">'];te.each(n,function(e,t){var i=['<div style="left: '+(c-0)*e+'px;" class="xm-select-linkage-group xm-select-linkage-group'+(e+1)+" "+(e!=0?"xm-select-linkage-hide":"")+'">'];te.each(t,function(e,t){var n='<li title="'+t.name+'" pid="'+t.pid+'" value="'+t.val+'"><span>'+t.name+"</span></li>";i.push(n)});i.push("</div>");a=a.concat(i)});a.push('<div style="clear: both; height: 288px;"></div>');a.push("</div>");t.find("dl").html(a.join(""));t.find("."+D).css("display","none");return{v:void 0}}();if((typeof i==="undefined"?"undefined":_typeof(i))==="object")return i.v}var a=te("."+E+' dl[xid="'+r+'"]').parents("."+Y);var l=ne[r]?ne[r]:Z;var o=a.find("."+F+" input");var f=[];a.find("dl").html(this.renderSelect(r,o.attr("placeholder")||o.attr("back"),s.map(function(e){if(e[l.keySel]){f.push({name:e[l.keyName],val:e[l.keyVal]})}return{innerHTML:e[l.keyName],value:e[l.keyVal],sel:e[l.keySel],disabled:e[l.keyDis],type:e.type,name:e.name}})));var d=a.find("."+N);var u=a.find("dl[xid]");if(t){var p=R[r].values;p.forEach(function(e,t){u.find('dd[lay-value="'+e.val+'"]').addClass(m)});f.forEach(function(e,t){if(n.indexOf(p,e)==-1){n.addLabel(r,d,e);u.find('dd[lay-value="'+e.val+'"]').addClass(m);p.push(e)}})}else{f.forEach(function(e,t){n.addLabel(r,d,e);u.find('dd[lay-value="'+e.val+'"]').addClass(m)});R[r].values=f}this.commonHanler(r,d)};n.prototype.create=function(e,t,n){if(t&&n){var i=R[e],a=te('[xid="'+e+'"]'),r=a.find("dd."+k+"."+G),l=null,o=a.find("dd."+u);a.find("dd:not(."+k+"):not(."+u+")").each(function(e,t){if(n==te(t).find("span").attr("name")){l=t}});if(!l){var s=i.config.create(e,n);if(o[0]){o.attr("lay-value",s);o.find("span").text(n);o.find("span").attr("name",n);o.removeClass(h)}else{r.after(te(this.createDD(e,{innerHTML:n,value:s},u+" "+c)))}}}else{te("[xid="+e+"] dd."+u).remove()}};n.prototype.createDD=function(e,t,n){var i=te.trim(t.innerHTML);var a=R[e].config.template(i,t.value,t.selected,t.disabled);return'<dd lay-value="'+t.value+'" class="'+(t.disabled?y:"")+" "+(n?n:"")+'">\n\t\t\t\t\t<div class="xm-unselect xm-form-checkbox '+(t.disabled?y:"")+'">\n\t\t\t\t\t\t<i class="'+r+'"></i>\n\t\t\t\t\t\t<span name="'+i+'">'+a+"</span>\n\t\t\t\t\t</div>\n\t\t\t\t</dd>"};n.prototype.createQuickBtn=function(e,t){return'<div class="'+b+'" method="'+e.name+'" title="'+e.name+'" '+(t?'style="margin-right: '+t+'"':"")+'><i class="'+e.icon+'"></i><span>'+e.name+"</span></div>"};n.prototype.renderBtns=function(e,t,n){var i=this;var a=[];var r=te('dl[xid="'+e+'"]');a.push('<div class="'+l+'" show="'+t+'" style="max-width: '+(r.prev().width()-54)+'px;">');te.each(R[e].config.btns,function(e,t){a.push(i.createQuickBtn(t,n))});a.push("</div>");a.push(this.createQuickBtn({icon:"iconfont icon-caidan",name:""}));return a.join("")};n.prototype.renderSelect=function(n,e,t){var i=this;var a=[];if(R[n].config.btns.length){setTimeout(function(){var e=te('dl[xid="'+n+'"]');e.parents("."+Y).attr(I,R[n].config.searchType);e.find("."+l).css("max-width",e.prev().width()-54+"px")},10);a.push(['<dd lay-value="" class="'+k+'" style="background-color: #FFF!important;">',this.renderBtns(n,null,"30px"),"</dd>",'<dd lay-value="" class="'+k+" "+G+'" style="background-color: #FFF!important;">','<i class="iconfont icon-sousuo"></i>','<input type="text" class="'+$+" "+D+'" placeholder="请搜索"/>',"</dd>"].join(""))}else{a.push('<dd lay-value="" class="'+k+'">'+e+"</dd>")}if(this.isArray(t)){te(t).each(function(e,t){if(t){if(t.type&&t.type==="optgroup"){a.push("<dt>"+t.name+"</dt>")}else{a.push(i.createDD(n,t))}}})}else{te(t).find("*").each(function(e,t){if(t.tagName.toLowerCase()=="option"&&e==0&&!t.value){return}if(t.tagName.toLowerCase()==="optgroup"){a.push("<dt>"+t.label+"</dt>")}else{a.push(i.createDD(n,t))}})}a.push('<dt style="display:none;"> </dt>');a.push('<dd class="'+k+" "+v+" "+(a.length===2?x:"")+'">没有选项</dd>');return a.join("")};n.prototype.on=function(){var n=this;this.one();te(document).on("click",function(e){if(!te(e.target).parents("."+X)[0]){te("."+E+" dl ."+h).removeClass(h);te("."+E+" dl dd."+x).removeClass(x);te("."+E+" dl dd."+u).remove();te.each(R,function(e,t){n.clearInput(e);if(!t.values.length){n.changePlaceHolder(te('div[FS_ID="'+e+'"] .'+N))}})}te("."+E+" ."+d).removeClass(d)})};n.prototype.calcLabelLeft=function(e,t,n){var i=this.getPosition(e[0]);i.y=i.x+e[0].clientWidth;var a=e[0].offsetLeft;if(!e.find("span").length){a=0}else if(n){var r=e.find("span:last");r.css("display")=="none"?r=r.prev()[0]:r=r[0];var l=this.getPosition(r);l.y=l.x+r.clientWidth;if(l.y>i.y){a=a-(l.y-i.y)-5}else{a=0}}else{if(t<0){var o=e.find(":last");o.css("display")=="none"?o=o.prev()[0]:o=o[0];var s=this.getPosition(o);s.y=s.x+o.clientWidth;if(s.y>i.y){a-=10}}else{if(a<0){a+=10}if(a>0){a=0}}}e.css("left",a+"px")};n.prototype.one=function(e){var v=this;te(e?e:document).off("click","."+X).on("click","."+X,function(e){var t=te(e.target),n=t.is(X)?t:t.parents("."+X),i=n.next(),a=i.attr("xid");te("dl[xid]").not(i).each(function(e,t){v.clearInput(te(t).attr("xid"))});te("dl[xid]").not(i).find("dd."+h).removeClass(h);if(n.hasClass(B)){return false}if(t.is("."+Q)||t.is("."+D+"[readonly]")){v.changeShow(n,!n.parents("."+Y).hasClass(d));return false}if(n.find("."+D+":not(readonly)")[0]){var r=n.find("."+D),l={x:e.pageX,y:e.pageY},o=v.getPosition(n[0]),s=n.width();while(l.x>o.x){if(te(document.elementFromPoint(l.x,l.y)).is(r)){r.focus();v.changeShow(n,true);return false}l.x-=50}}if(t.is("."+D)){v.changeShow(n,true);return false}if(t.is('i[fsw="'+H+'"]')){var c={name:t.prev().text(),val:t.parent().attr("value")},f=i.find("dd[lay-value='"+c.val+"']");if(f.hasClass(y)){return false}v.handlerLabel(a,f,false,c);return false}v.changeShow(n,!n.parents("."+Y).hasClass(d));return false});te(e?e:document).find("dl."+J).off("click").on("click",function(e){var t=te(e.target);if(t.is("."+g)||t.parents("."+g)[0]){t=t.is("li")?t:t.parents("li");var n=t.parents(".xm-select-linkage-group"),i=t.parents("dl").attr("xid");if(!i){return false}n.find(".xm-select-active").removeClass("xm-select-active");t.addClass("xm-select-active");n.nextAll(".xm-select-linkage-group").addClass("xm-select-linkage-hide");var a=n.next(".xm-select-linkage-group");a.find("li").addClass("xm-select-linkage-hide");a.find('li[pid="'+t.attr("value")+'"]').removeClass("xm-select-linkage-hide");if(!a[0]||a.find("li:not(.xm-select-linkage-hide)").length==0){var r=[],l=0,o=!t.hasClass("xm-select-this");if(R[i].config.radio){t.parents(".xm-select-linkage").find(".xm-select-this").removeClass("xm-select-this")}do{r[l++]={name:t.find("span").text(),val:t.attr("value")};t=t.parents(".xm-select-linkage-group").prev().find('li[value="'+t.attr("pid")+'"]')}while(t.length);r.reverse();var s={name:r.map(function(e){return e.name}).join("/"),val:r.map(function(e){return e.val}).join("/")};v.handlerLabel(i,null,o,s)}else{a.removeClass("xm-select-linkage-hide")}return false}if(t.is("dl")){return false}if(t.is("dt")){t.nextUntil("dt").each(function(e,t){t=te(t);if(t.hasClass(y)||t.hasClass(m)){}else{t.click()}});return false}var c=t.is("dd")?t:t.parents("dd");var f=c.parent("dl").attr("xid");if(c.hasClass(y)){return false}if(c.hasClass(k)){var d=t.is("."+b)?t:t.parents("."+b);if(!d[0]){return false}var u=d.attr("method");var p=R[f].config.btns.filter(function(e){return e.name==u})[0];p&&p.click&&p.click instanceof Function&&p.click(f,v);return false}var h=!c.hasClass(m);v.handlerLabel(f,c,h);return false})};n.prototype.linkageAdd=function(e,t){var n=te('dl[xid="'+e+'"]');n.find(".xm-select-active").removeClass("xm-select-active");var i=t.val.split("/");var a=void 0,r=void 0,l=0;var o=[];do{a=i[l];r=n.find(".xm-select-linkage-group"+(l+1)+' li[value="'+a+'"]');r[0]&&o.push(r);l++}while(r.length&&a!=undefined);if(o.length==i.length){te.each(o,function(e,t){t.addClass("xm-select-this")})}};n.prototype.linkageDel=function(e,t){var n=te('dl[xid="'+e+'"]');var i=t.val.split("/");var a=void 0,r=void 0,l=i.length-1;do{a=i[l];r=n.find(".xm-select-linkage-group"+(l+1)+' li[value="'+a+'"]');if(!r.parent().next().find("li[pid="+a+"].xm-select-this").length){r.removeClass("xm-select-this")}l--}while(r.length&&a!=undefined)};n.prototype.valToName=function(e,t){var i=te('dl[xid="'+e+'"]');var n=(t+"").split("/");if(!n.length){return null}var a=[];te.each(n,function(e,t){var n=i.find(".xm-select-linkage-group"+(e+1)+' li[value="'+t+'"] span').text();a.push(n)});return a.length==n.length?a.join("/"):null};n.prototype.commonHanler=function(e,t){if(!t||!t[0]){return}this.checkHideSpan(e,t);this.changePlaceHolder(t);this.retop(t.parents("."+Y));this.calcLabelLeft(t,0,true);t.parents("."+E).find("."+z).val(R[e].values.map(function(e){return e.val}).join(","));t.parents("."+X+" ."+H).attr("title",R[e].values.map(function(e){return e.name}).join(","))};n.prototype.initVal=function(e){var o=this;var t={};if(e){t[e]=R[e]}else{t=R}te.each(t,function(n,e){var t=e.values,i=te('dl[xid="'+n+'"]').parent(),a=i.find("."+N),r=i.find("dl");r.find("dd."+m).removeClass(m);var l=t.concat([]);l.concat([]).forEach(function(e,t){o.addLabel(n,a,e);r.find('dd[lay-value="'+e.val+'"]').addClass(m)});if(e.config.radio){l.length&&t.push(l[l.length-1])}o.commonHanler(n,a)})};n.prototype.handlerLabel=function(e,t,n,i,a){var r=te('[xid="'+e+'"]').prev().find("."+N),l=t&&{name:t.find("span").attr("name"),val:t.attr("lay-value")},o=R[e].values,s=R[e].config.on||C.on[e];if(i){l=i}var c=R[e];if(n&&c.config.max&&c.values.length>=c.config.max){var f=R[e].config.maxTips||C.maxTips[e];f&&f(e,o.concat([]),l,c.max);return}if(!a){if(s&&s instanceof Function&&s(e,o.concat([]),l,n,t&&t.hasClass(y))==false){return}}var d=te('dl[xid="'+e+'"]');n?(t&&t[0]?(t.addClass(m),t.removeClass(u)):d.find(".xm-select-linkage")[0]&&this.linkageAdd(e,l),this.addLabel(e,r,l),o.push(l)):(t&&t[0]?t.removeClass(m):d.find(".xm-select-linkage")[0]&&this.linkageDel(e,l),this.delLabel(e,r,l),this.remove(o,l));if(!r[0])return;if(c.config.radio){this.changeShow(r,false)}r.parents("."+X).prev().removeClass("layui-form-danger");c.config.clearInput&&this.clearInput(e);this.commonHanler(e,r)};n.prototype.addLabel=function(e,t,n){if(!n)return;var i='fsw="'+H+'"';var a=[te("<span "+i+' value="'+n.val+'"><font '+i+">"+n.name+"</font></span>"),te("<i "+i+' class="iconfont icon-close"></i>')],r=a[0],l=a[1];r.append(l);var o=R[e];if(o.config.radio){o.values.length=0;te('dl[xid="'+e+'"]').find("dd."+m+':not([lay-value="'+n.val+'"])').removeClass(m);t.find("span").remove()}t.find("input").css("width","50px");t.find("input").before(r)};n.prototype.delLabel=function(e,t,n){if(!n)return;t.find('span[value="'+n.val+'"]:first').remove()};n.prototype.checkHideSpan=function(e,t){var n=t.parents("."+H)[0].offsetHeight+5;t.find("span.xm-span-hide").removeClass("xm-span-hide");t.find("span[style]").remove();var i=R[e].config.showCount;t.find("span").each(function(e,t){if(e>=i){te(t).addClass("xm-span-hide")}});var a=t.find("span:eq("+i+")");a[0]&&a.before(te('<span style="padding-right: 6px;" fsw="'+H+'"> + '+(t.find("span").length-i)+"</span>"))};n.prototype.retop=function(e){var t=e.find("dl"),n=e.offset().top+e.outerHeight()+5-o.scrollTop(),i=t.outerHeight();var a=e.hasClass("layui-form-selectup")||t.css("top").indexOf("-")!=-1||n+i>o.height()&&n>=i;e=e.find("."+H);var r=R[t.attr("xid")];var l=t.parents(".layui-form-pane")[0]&&t.prev()[0].clientHeight>38?14:10;if(r){if(r.config.direction=="up"){t.css({top:"auto",bottom:"42px"});return}if(r.config.direction=="down"){t.css({top:e[0].offsetTop+e.height()+l+"px",bottom:"auto"});return}}if(a){t.css({top:"auto",bottom:"42px"})}else{t.css({top:e[0].offsetTop+e.height()+l+"px",bottom:"auto"})}};n.prototype.changeShow=function(e,t){te(".layui-form-selected").removeClass("layui-form-selected");var n=e.parents("."+Y);te("."+E+" ."+Y).not(n).removeClass(d);if(t){this.retop(n);n.addClass(d);n.find("."+D).focus();if(!n.find("dl dd[lay-value]:not(."+k+")").length){n.find("dl ."+v).addClass(x)}}else{var i=n.find("dl").attr("xid");n.removeClass(d);this.clearInput(i);n.find("dl ."+x).removeClass(x);n.find("dl dd."+h).removeClass(h);n.find("dl dd."+u).remove();if(i&&R[i]&&R[i].config.isEmpty){this.triggerSearch(n)}this.changePlaceHolder(n.find("."+N))}};n.prototype.changePlaceHolder=function(e){var t=e.parents("."+X);t[0]||(t=e.parents("dl").prev());if(!t[0]){return}var n=e.parents("."+E).find("dl[xid]").attr("xid");if(R[n]&&R[n].config.height){}else{var i=t.find("."+H)[0].clientHeight;t.css("height",(i>34?i+4:i)+"px");var a=t.parents("."+E).parent().prev();if(a.is(".layui-form-label")&&t.parents(".layui-form-pane")[0]){i=i>36?i+4:i;t.css("height",i+"px");a.css({height:i+2+"px",lineHeight:i-18+"px"})}}var r=t.find("."+F+" input"),l=!e.find("span:last")[0]&&!t.find("."+D).val();if(l){var o=r.attr("back");r.removeAttr("back");r.attr("placeholder",o)}else{var s=r.attr("placeholder");r.removeAttr("placeholder");r.attr("back",s)}};n.prototype.indexOf=function(e,t){for(var n=0;n<e.length;n++){if(e[n].val==t||e[n].val==(t?t.val:t)||e[n]==t||JSON.stringify(e[n])==JSON.stringify(t)){return n}}return-1};n.prototype.remove=function(e,t){var n=this.indexOf(e,t?t.val:t);if(n>-1){e.splice(n,1);return true}return false};n.prototype.selectAll=function(i,a,e){var r=this;var l=te('[xid="'+i+'"]');if(!l[0]){return}if(l.find(".xm-select-linkage")[0]){return}l.find("dd[lay-value]:not(."+k+"):not(."+m+")"+(e?":not(."+y+")":"")).each(function(e,t){t=te(t);var n={name:t.find("span").attr("name"),val:t.attr("lay-value")};r.handlerLabel(i,l.find('dd[lay-value="'+n.val+'"]'),true,n,!a)})};n.prototype.removeAll=function(n,i,a){var r=this;var l=te('[xid="'+n+'"]');if(!l[0]){return}if(l.find(".xm-select-linkage")[0]){R[n].values.concat([]).forEach(function(e,t){var n=e.val.split("/");var i=void 0,a=void 0,r=0;do{i=n[r++];a=l.find(".xm-select-linkage-group"+r+':not(.xm-select-linkage-hide) li[value="'+i+'"]');a.click()}while(a.length&&i!=undefined)});return}R[n].values.concat([]).forEach(function(e,t){if(a&&l.find('dd[lay-value="'+e.val+'"]').hasClass(y)){}else{r.handlerLabel(n,l.find('dd[lay-value="'+e.val+'"]'),false,e,!i)}})};n.prototype.reverse=function(i,a,e){var r=this;var l=te('[xid="'+i+'"]');if(!l[0]){return}if(l.find(".xm-select-linkage")[0]){return}l.find("dd[lay-value]:not(."+k+")"+(e?":not(."+y+")":"")).each(function(e,t){t=te(t);var n={name:t.find("span").attr("name"),val:t.attr("lay-value")};r.handlerLabel(i,l.find('dd[lay-value="'+n.val+'"]'),!t.hasClass(m),n,!a)})};n.prototype.skin=function(e){var t=["default","primary","normal","warm","danger"];var n=t[Math.floor(Math.random()*t.length)];te('dl[xid="'+e+'"]').parents("."+E).find("."+Y).attr("xm-select-skin",n);this.check(e)&&this.commonHanler(e,te('dl[xid="'+e+'"]').parents("."+E).find("."+N))};n.prototype.getPosition=function(e){var t=0,n=0;while(e!=null){t+=e.offsetLeft;n+=e.offsetTop;e=e.offsetParent}return{x:t,y:n}};n.prototype.onreset=function(){te(document).on("click","[type=reset]",function(e){te(e.target).parents("form").find("."+E+" dl[xid]").each(function(e,t){var n=t.getAttribute("xid"),i=te(t),a=void 0,r={};f.removeAll(n);R[n].config.init.forEach(function(e,t){if(e&&(!r[e]||R[n].config.repeat)&&(a=i.find('dd[lay-value="'+e.val+'"]'))[0]){f.handlerLabel(n,a,true);r[e]=1}})})})};n.prototype.bindEvent=function(n,e,i){if(e&&e instanceof Function){i=e;e=null}if(i&&i instanceof Function){if(!e){te.each(R,function(e,t){R[e]?R[e].config[n]=i:C[n][e]=i})}else{R[e]?R[e].config[n]=i:C[n][e]=i}}};n.prototype.check=function(e){if(te('dl[xid="'+e+'"]').length){return true}else{delete R[e];return false}};n.prototype.render=function(e,t){if(this.check(e)){t=R[e].select}f.init(t);f.one(te('dl[xid="'+e+'"]').parents("."+E));f.initVal(e)};var i=function e(){this.v=t};var f=new n;i.prototype.value=function(i,e,t){if(typeof i!="string"){return[]}var a=R[i];if(!f.check(i)){return[]}if(typeof e=="string"||e==undefined){var n=a.values.concat([])||[];if(e=="val"){return n.map(function(e){return e.val})}if(e=="valStr"){return n.map(function(e){return e.val}).join(",")}if(e=="name"){return n.map(function(e){return e.name})}if(e=="nameStr"){return n.map(function(e){return e.name}).join(",")}return n}if(f.isArray(e)){var r=te('[xid="'+i+'"]'),l={},o=void 0,s=true;if(t==false){s=false}else if(t==true){s=true}else{f.removeAll(i)}if(s){a.values.forEach(function(e,t){l[e.val]=1})}e.forEach(function(e,t){if(e&&(!l[e]||a.config.repeat)){if((o=r.find('dd[lay-value="'+e+'"]'))[0]){f.handlerLabel(i,o,s,null,true);l[e]=1}else{var n=f.valToName(i,e);if(n){f.handlerLabel(i,o,s,{name:n,val:e},true);l[e]=1}}}})}};i.prototype.on=function(e,t){f.bindEvent("on",e,t);return this};i.prototype.filter=function(e,t){f.bindEvent("filter",e,t);return this};i.prototype.maxTips=function(e,t){f.bindEvent("maxTips",e,t);return this};i.prototype.config=function(e,n,t){if(e&&(typeof e==="undefined"?"undefined":_typeof(e))=="object"){t=n==true;n=e;e=null}if(n&&(typeof n==="undefined"?"undefined":_typeof(n))=="object"){if(t){n.header||(n.header={});n.header["Content-Type"]="application/json; charset=UTF-8";n.dataType="json"}e?(ne[e]=te.extend(true,{},ne[e]||Z,n),!f.check(e)&&this.render(e),R[e]&&n.direction&&(R[e].config.direction=n.direction),R[e]&&n.clearInput&&(R[e].config.clearInput=true),n.searchUrl&&R[e]&&f.triggerSearch(te("."+E+' dl[xid="'+e+'"]').parents("."+Y),true)):(te.extend(true,Z,n),te.each(ne,function(e,t){te.extend(true,t,n)}))}return this};i.prototype.render=function(e,t){var n=this;if(e&&(typeof e==="undefined"?"undefined":_typeof(e))=="object"){t=e;e=null}var i={};e?f.check(e)&&(i[e]=R[e]):i=R;var a=t?{init:t.init,disabled:t.disabled,max:t.max,isSearch:t.isSearch,isCreate:t.isCreate,radio:t.radio,skin:t.skin,direction:t.direction,height:t.height,formname:t.formname,layverify:t.layverify,layverType:t.layverType,searchType:t.searchType=="dl"?1:0,showCount:t.showCount,placeholder:t.placeholder,create:t.create,filter:t.filter,maxTips:t.maxTips,on:t.on,template:t.template,clearInput:t.clearInput}:{};if(Object.getOwnPropertyNames(i).length){te.each(i,function(e,t){if(f.check(e)){n.value(e,[]);te.extend(R[e].config,a);f.render(e,t.select)}})}(te("select["+H+'="'+e+'"]')[0]?te("select["+H+'="'+e+'"]'):te("select["+H+"]")).each(function(e,t){var n=t.getAttribute(H);f.render(n,t)});return this};i.prototype.disabled=function(e){var t={};e?f.check(e)&&(t[e]=R[e]):t={};te.each(t,function(e,t){te('dl[xid="'+e+'"]').prev().addClass(B)});return this};i.prototype.undisabled=function(e){var t={};e?f.check(e)&&(t[e]=R[e]):t={};te.each(t,function(e,t){te('dl[xid="'+e+'"]').prev().removeClass(B)});return this};i.prototype.data=function(e,t,n){if(!e||!t||!n){return this}!f.check(e)&&this.render(e);this.value(e,[]);this.config(e,n);if(t=="local"){f.renderData(e,n.arr,n.linkage==true,n.linkageWidth?n.linkageWidth:"100")}else if(t=="server"){f.ajax(e,n.url,n.keyword,n.linkage==true,n.linkageWidth?n.linkageWidth:"100")}return this};i.prototype.btns=function(e,o,s){if(e&&f.isArray(e)){o=e;e=null}if(!o||!f.isArray(o)){return this}var t={};e?f.check(e)&&(t[e]=R[e]):t=R;o=o.map(function(e){if(typeof e=="string"){if(e=="select"){return ee[0]}if(e=="remove"){return ee[1]}if(e=="reverse"){return ee[2]}if(e=="skin"){return ee[3]}}return e});te.each(t,function(e,t){t.config.btns=o;var n=te('dl[xid="'+e+'"]').find("."+k+":first");if(o.length){var i=s&&s.show&&(s.show=="name"||s.show=="icon")?s.show:"";var a=f.renderBtns(e,i,s&&s.space?s.space:"30px");n.html(a)}else{var r=n.parents("."+Y).find("."+F+" input");var l=r.attr("placeholder")||r.attr("back");n.html(l);n.removeAttr("style")}});return this};i.prototype.search=function(e,t){if(e&&f.check(e)){ne[e]=te.extend(true,{},ne[e]||Z,{first:true,searchVal:t});f.triggerSearch(te('dl[xid="'+e+'"]').parents("."+Y),true)}return this};return new i});