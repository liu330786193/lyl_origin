<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div>
    <form action="http://192.168.145.48:9999/user/dsubmit" method="post">
        <input type="text" name="username" value="lyl" />
        <input type="hidden" name="token" value="${token}" />
        <input type="hidden" name="tokenKey" value="${tokenKey}" />
        <input type="submit" value="提交"/>
    </form>
</div>
</body>
</html>