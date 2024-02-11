if(typeof Math.imul == "undefined" || (Math.imul(0xffffffff,5) == 0)) {
    Math.imul = function (a, b) {
        var ah  = (a >>> 16) & 0xffff;
        var al = a & 0xffff;
        var bh  = (b >>> 16) & 0xffff;
        var bl = b & 0xffff;
        // the shift by 0 fixes the sign on the high part
        // the final |0 converts the unsigned value into a signed value
        return ((al * bl) + (((ah * bl + al * bh) << 16) >>> 0)|0);
    }
}


/*

 Copyright The Closure Library Authors.
 SPDX-License-Identifier: Apache-2.0
*/
            ;var c=this||self;const f=Array.prototype.indexOf?function(a,b){return Array.prototype.indexOf.call(a,b,void 0)}:function(a,b){if("string"===typeof a)return"string"!==typeof b||1!=b.length?-1:a.indexOf(b,0);for(let d=0;d<a.length;d++)if(d in a&&a[d]===b)return d;return-1};function g(a){const b=a.length;if(0<b){const d=Array(b);for(let e=0;e<b;e++)d[e]=a[e];return d}return[]};function h(){var a=c.navigator;return a&&(a=a.userAgent)?a:""}function k(a){return-1!=h().indexOf(a)};function l(){return k("iPhone")&&!k("iPod")&&!k("iPad")};k("Opera");k("Trident")||k("MSIE");k("Edge");!k("Gecko")||-1!=h().toLowerCase().indexOf("webkit")&&!k("Edge")||k("Trident")||k("MSIE")||k("Edge");-1!=h().toLowerCase().indexOf("webkit")&&!k("Edge")&&k("Mobile");k("Macintosh");k("Windows");k("Linux")||k("CrOS");var m=c.navigator||null;m&&(m.appVersion||"").indexOf("X11");k("Android");l();k("iPad");k("iPod");l()||k("iPad")||k("iPod");h().toLowerCase().indexOf("kaios");function n(a){var b=document;a=String(a);"application/xhtml+xml"===b.contentType&&(a=a.toLowerCase());return b.createElement(a)}function p(a,b){if("textContent"in a)a.textContent=b;else if(3==a.nodeType)a.data=String(b);else if(a.firstChild&&3==a.firstChild.nodeType){for(;a.lastChild!=a.firstChild;)a.removeChild(a.lastChild);a.firstChild.data=String(b)}else{for(var d;d=a.firstChild;)a.removeChild(d);a.appendChild((9==a.nodeType?a:a.ownerDocument||a.document).createTextNode(String(b)))}};function q(a){return"string"==typeof a.className?a.className:a.getAttribute&&a.getAttribute("class")||""}function r(a,b){if(a.classList)a.classList.add(b);else{if(a.classList)var d=a.classList.contains(b);else d=a.classList?a.classList:q(a).match(/\S+/g)||[],d=0<=f(d,b);d||(d=q(a),b=d+(0<d.length?" "+b:b),"string"==typeof a.className?a.className=b:a.setAttribute&&a.setAttribute("class",b))}};var t={},u={};if("undefined"===typeof t||"undefined"===typeof u||"undefined"===typeof v)var v={};if("undefined"===typeof t||"undefined"===typeof u||"undefined"===typeof w)var w=null;if("undefined"===typeof t||"undefined"===typeof u||"undefined"===typeof x)var x=null;if("undefined"===typeof t||"undefined"===typeof u||"undefined"===typeof y)var y=null;
var z="undefined"!==typeof Math&&"undefined"!==typeof Math.imul?function(a,b){return Math.imul(a,b)}:function(a,b){var d=a&65535,e=b&65535;return d*e+((a>>>16&65535)*e+d*(b>>>16&65535)<<16>>>0)|0};function A(a){a=z(a|0,-862048943);a=0^(z(a<<15|a>>>-15,461845907)|0);a=(z(a<<13|a>>>-13,5)+-430675100|0)^0;a=z(a^a>>>16,-2048144789);z(a^a>>>13,-1028477387)}A(1);A(0);if("undefined"===typeof t||"undefined"===typeof u||"undefined"===typeof B)var B=null;
"undefined"!==typeof console&&(w=function(){var a=arguments;return console.log.apply(console,g.call(null,a))},x=function(){var a=arguments;return console.error.apply(console,g.call(null,a))});if("undefined"===typeof t||"undefined"===typeof u||"undefined"===typeof C)var C=function(){throw Error("cljs.core/*eval* not bound");};var D=document.querySelector("body"),E=n("h2");p(E,"Work with html via goog.dom");r(E,"site__secondary_header");D.appendChild(E);var F=n("p");p(F,"This paragraph is written directly from the source code.");r(F,"site__paragraph");D.appendChild(F);document.body.style.backgroundColor="smokewhite";