<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>注册</h2>
<form action="${pageContext.request.contextPath }/User/register" method="post">
    账号：<input type="text" name="account"><br>
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    性别：<input type="text" name="sex"><br>
    <input type="submit" value="确定">
</form>

<h2>登陆</h2>
<form action="${pageContext.request.contextPath }/User/login" method="post">
    用户名：<input type="text" name="account">
    密码：<input type="password" name="password">
    <input type="submit" value="登陆">
</form>

<form action="${pageContext.request.contextPath }/User/uploadAvatar" method="post" enctype="multipart/form-data">
    上传头像：<input type="file" name="uploadFile">
    <input type="submit" value="上传">
</form>
<a href="${pageContext.request.contextPath }/User/getAllUser">获取全部用户信息</a>
<form action="${pageContext.request.contextPath }/User/modifyPassword" method="post">
    用户id：<input type="text" name="userID"><br>
    新密码:<input type="password" name="newPassword"><br>
    <input type="submit" value="确认修改">
</form>
<form action="${pageContext.request.contextPath }/User/getUser" method="POST">
    获取单个用户信息:<input type="text" name="userID">
    <input type="submit" value="获取">
</form>
<a href="${pageContext.request.contextPath }/User/test">测试mybatis</a>
<form action="${pageContext.request.contextPath }/User/forgetPassword" method="post">
    输入账号以获取用户id<input type="text" name="account"><br>
    <input type="submit" value="获取">
</form>
<h1>填写用户详细信息</h1>
<form action="${pageContext.request.contextPath }/User/addUserInfo" method="post">
    用户ID：<input type="text" name="user_id"><br>
    地址：<input type="text" name="address"> <br>
    个性签名：<input type="text" name="personal_sign"><br>
    <input type="submit" value="提交">
</form>
<form action="${pageContext.request.contextPath }/User/getUserInfo" method="post">
    用户ID:<input type="text" name="user_id"><br>
    <input type="submit" value="获取用户信息">
</form>
<h1>修改用户信息</h1>
<form action="${pageContext.request.contextPath }/User/updateUserInfo" method="post">
    用户ID：<input type="text" name="user_id"><br>
    地址：<input type="text" name="address"> <br>
    个性签名：<input type="text" name="personal_sign"><br>
    <input type="submit" value="修改">
</form>
</body>
</html>
