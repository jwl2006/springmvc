<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title></title>
</head>
<body>

    <h3>User Profile</h3>

    <%--<form:errors path="student1.*"/>--%>
    <form action="/profile" method="post">
        <table>
            <tr>
                <td>ID : </td> <td>    <input type="text" name="id" ></td>
            </tr>

            <tr>
                <td>First Name : </td> <td>    <input type="text" name="firstname"  ></td>
            </tr>

            <tr>
                <td>Last Name: </td> <td>    <input type="text" name="lastname" ></td>
            </tr>

            <tr>
                <td>Email: </td> <td><input type="text" name="email"></td>
            </tr>

            <tr>
                <td>Address: </td>  <td><input type="text" name="address" ></td>
            </tr>

            <tr>
                <td>Organization: </td>  <td><input type="text" name="organization" ></td>
            </tr>

            <tr>
                <td>About Myself: </td>  <td><input type="text" name="aboutmyself"></td>
            </tr>

            <tr><td><input type="submit" value="CREATE"/></td></tr>
            </table>

    </form>
</body>
</html>
