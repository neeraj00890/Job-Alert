!function(){function n(n,t){if(!(n instanceof t))throw new TypeError("Cannot call a class as a function")}function t(n,t){for(var e=0;e<t.length;e++){var o=t[e];o.enumerable=o.enumerable||!1,o.configurable=!0,"value"in o&&(o.writable=!0),Object.defineProperty(n,o.key,o)}}function e(n,e,o){return e&&t(n.prototype,e),o&&t(n,o),n}(self.webpackChunkjob_alert_ui=self.webpackChunkjob_alert_ui||[]).push([[301],{9301:function(t,o,r){"use strict";r.r(o),r.d(o,{HomeModule:function(){return v}});var c,u,i=r(1116),f=r(3337),a=r(5366),s=r(8237),l=function(){var t=function(){function t(e){n(this,t),this._http=e}return e(t,[{key:"getStudents",value:function(){return this._http.get("/api/students")}}]),t}();return t.\u0275fac=function(n){return new(n||t)(a.LFG(s.O))},t.\u0275prov=a.Yz7({token:t,factory:t.\u0275fac}),t}(),p=[{path:"",component:(c=function(){function t(e){n(this,t),this._homeService=e}return e(t,[{key:"ngOnInit",value:function(){this._homeService.getStudents().then(console.log).catch(console.error)}}]),t}(),c.\u0275fac=function(n){return new(n||c)(a.Y36(l))},c.\u0275cmp=a.Xpm({type:c,selectors:[["app-welcome"]],decls:2,vars:0,template:function(n,t){1&n&&(a.TgZ(0,"p"),a._uU(1,"welcome works!"),a.qZA())},styles:[""]}),c)}],h=function(){var t=function t(){n(this,t)};return t.\u0275fac=function(n){return new(n||t)},t.\u0275mod=a.oAB({type:t}),t.\u0275inj=a.cJS({imports:[[f.Bz.forChild(p)]]}),t}(),m=r(669),v=((u=function t(){n(this,t)}).\u0275fac=function(n){return new(n||u)},u.\u0275mod=a.oAB({type:u}),u.\u0275inj=a.cJS({providers:[l],imports:[[i.ez,h,m.q]]}),u)}}])}();