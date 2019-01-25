<!DOCTYPE html>
<!-- saved from url=(0039)https://v3.bootcss.com/examples/signin/ -->
<html lang="zh-CN"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>在线聊天登录</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstarp/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="bootstarp/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="bootstarp/signin.css" rel="stylesheet">

</head>

<body>

<div class="container">

    <form class="form-signin" action="javascript:;" >
        <h2 class="form-signin-heading">设置聊天昵称</h2>
        <label for="inputPassword" class="sr-only">输入昵称</label>
        <input type="text" id="username" class="form-control" placeholder="输入聊天昵称" required="" autofocus="">
        <#--<input type="text" id="token" hidden="true" value="{{ token }}">-->
        <button class="btn btn-lg btn-primary btn-block" id="sumbit">进 入</button>
    </form>

</div> <!-- /container -->


<script src="js/jquery.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script>
    $('#sumbit').click(function(){
        var username = $('#username').val();
        // var token = $('#token').val();
        if (username != ""){
            $.post("/session", {username:username}, function(data,status){
                window.location.href = '/chat/'+data;
            });
        }else{
            alert("请输入聊天昵称");
        }
    });

</script>


</body></html>