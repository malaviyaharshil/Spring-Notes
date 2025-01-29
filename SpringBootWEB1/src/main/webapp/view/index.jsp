<%@page language="java" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="../style.css">
</head>
</body>
<h2>Alien form</h2>

<form action="addAlien">
    <%--@declare id="aid"--%><label for="aid">Enter IDr :</label>
    <input type="text" id=aid" name="aid"><br>
    <label for="aname">Enter Name :</label>
    <input type="text" id="aname" name="aname"><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>