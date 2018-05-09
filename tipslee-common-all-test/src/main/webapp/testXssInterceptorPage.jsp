<html>
<head>
    <meta charset="UTF-8"/>
    <script type="text/javascript" src="/misc/js/lib/require.js"></script>
</head>
<body>
<br>

<h2>xss test</h2>
<textarea id="xss_requestValues" type="text">{"value":"test"}</textarea>
<input type="button" onclick="javascript:test();" value="Send Request"/>
<br/>
</body>
<script>
    function getValues() {
        return $("#xss_requestValues")[0].value;
    }

    function test() {
        $.ajax({
            url: "/testXssInterceptor",
            type: "post",
            data: eval("(" + getValues() + ")"),
            dataType: "json"
        }).done(function (result) {
            var success = false;
            if ((typeof result != "undefined") && result != null && (typeof result.success != "undefined")
                    && result.success != null) {
                success = result.success;
            }
            alert("sucess=" + success);
        }).fail(function (jqXHR, textStatus, errorThrown) {
            console.log(errorThrown.toString());
        }).error(function (jqXHR, textStatus, errorThrown) {
            console.log(errorThrown.toString());
        }).always(function () {
        });
    }
</script>
</html>
