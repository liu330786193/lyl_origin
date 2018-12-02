<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <title>登录首页</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<script>
    /*$(document).ready(function(){
        $("form").click(function(){
            $.ajax({
                type:"POST",
                url:"http://localhost:9999/user/home",
                contentType:"text/json;charset=utf-8",
                dataType:"json",
                async:true,
                data:JSON.stringify({
                    "username":$("#username").val(),
                    "password":$("#password").val()
                }),
                success:function(result){
					if(result.code != 0){
                        alert(result.description);
//						window.location.href = "../home/home.ftl";
					}else{
						alert(result.code);
						alert(result.description);
						alert(result.result);
					}
                }
            });
        })
    })*/
  /* $(document).ready(function(){
   		$("form").submit()
   })*/
</script>

<body>
<div class="container">
    <section id="content">
        <form action="http://localhost:9999/user/home" method="post">
            <h1>登录</h1>
            <div>
                <input type="text" placeholder="username" required="required" value="lyl" id="username" />
            </div>
            <div>
                <input type="password" placeholder="password" required="required" value="123456" id="password" />
            </div>
            <div>
                <input type="submit" value="Log in" />
                <a href="#">Lost your password?</a>
                <a href="#">Register</a>
            </div>
        </form><!-- form -->
        <div class="button">
            <a href="#">Download source file</a>
        </div>
    </section>
</div>
</body>
</html>