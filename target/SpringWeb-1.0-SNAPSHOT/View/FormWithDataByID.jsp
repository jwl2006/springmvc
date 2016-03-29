<%--
  Created by IntelliJ IDEA.
  User: wanghao
  Date: 3/22/16
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h3>Summary</h3>
    <h3>The Profile You Requested</h3>

    <form action="/profile/${profile1.id}" method="post">
        <table>
            <tr>
                <td>ID : </td> <td>  <input type="text" name="id" value=${profile1.id} readonly></td>
            </tr>
            <tr>
                <td>First Name : </td> <td>    <input type="text" name="firstname" value=${profile1.firstname}></td>
            </tr>

            <tr>
                <td>Last Name: </td> <td>    <input type="text" name="lastname" value=${profile1.lastname}></td>
            </tr>

            <tr>
                <td>Email: </td> <td><input type="text" name="email" value=${profile1.email}></td>
            </tr>

            <tr>
                <td>Address: </td>  <td><input type="text" name="address" value=${profile1.address}></td>
            </tr>

            <tr>
                <td>Organization: </td>  <td><input type="text" name="organization" value=${profile1.organization}></td>
            </tr>

            <tr>
                <td>About Myself: </td>  <td><input type="text" name="aboutmyself" value=${profile1.aboutmyself}></td>
            </tr>

            <tr><td><input type="submit" value="UPDATE" name="update"/></td></tr>
        </table>

    </form>
    <form action="/profile/${profile1.id}" method="delete">
        <input type="submit" value="DELETE" name="delete">
    </form>

</body>
</html>
