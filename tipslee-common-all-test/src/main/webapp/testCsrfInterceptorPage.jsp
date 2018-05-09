<html>
<head>
    <meta charset="UTF-8" />
    <script>
        function getCookie(cname) {
            var name = cname + "=";
            var ca = document.cookie.split(';');
            for(var i=0; i<ca.length; i++) {
                var c = ca[i];
                while (c.charAt(0)==' ') c = c.substring(1);
                if (c.indexOf(name) != -1) return c.substring(name.length, c.length);
            }
            return "";
        }
        function delCookie(name)
        {
            var exp = new Date();
            exp.setTime(exp.getTime() - 1);
            document.cookie = name + "=;expires="+exp.toGMTString();
        }
    </script>
    <script>
        function csrf_ChangeCookieName() {
            var cookiename = document.getElementById("csrf_cookienameInput").value;
            var a = document.getElementById("csrf_accessedUrl");
            a.href = "/testCsrfInterceptor?" + cookiename + "=" + csrf_getToken();
            a.text = a.href;
        }
        function csrf_getToken() {
            var cookiename = document.getElementById("csrf_cookienameInput").value;
            return getCookie(cookiename);
        }
        function csrf_delToken() {
            var cookiename = document.getElementById("csrf_cookienameInput").value;
            delCookie(cookiename);
        }
        function csrf_ChangeFakedUrl() {
            var cookiename = document.getElementById("csrf_cookienameInput").value;
            var token = document.getElementById("csrf_fakedTokenInput").value;
            var a = document.getElementById("csrf_fakedUrl");
            a.href = "/testCsrfInterceptor?" + cookiename + "=" + token;
            a.text = a.href;
        }

    </script>
    <script>
        function onLoad() {
            csrf_ChangeCookieName();
            var input = document.getElementById("csrf_fakedTokenInput");
            var a = document.getElementById("csrf_fakedUrl");
            var cookiename = document.getElementById("csrf_cookienameInput").value;
            input.value = csrf_getToken();
            a.href = "/testCsrfInterceptor?" + cookiename + "=" + csrf_getToken();
            a.text = a.href;
        }
    </script>
</head>
<body onload="onLoad()">
<br>
<h2>csrf test</h2>
0.设置新的cookie:cookiename:<input id="csrf_cookienameInput" type="text" value="antiCsrfSecurityToken"/><input type="button" onclick="javascript:csrf_ChangeCookieName();" value="更新"/><br/>
1.清除cookie:<a href="#" onclick="javascript:csrf_delToken();">清除</a><br/>
2.模拟首次访问<a href="/testCsrfInterceptor">/testCsrfInterceptor</a><br/>
3.模拟第二次访问<a id="csrf_accessedUrl" href="/testCsrfInterceptor?antiCsrfSecurityToken=">/testCsrfInterceptor?antiCsrfSecurityToken=</a>
<br/>
4.模拟非法访问token=<input id="csrf_fakedTokenInput" type="text" value="token"/><input type="button" value="更新链接" onclick="javascript:csrf_ChangeFakedUrl();"><br/>
<a id="csrf_fakedUrl" href="/testCsrfInterceptor?antiCsrfSecurityToken=">/testCsrfInterceptor?antiCsrfSecurityToken=</a>
<br/>
</body>
</html>
