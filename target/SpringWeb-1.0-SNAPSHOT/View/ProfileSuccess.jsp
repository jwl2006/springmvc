<%--
  Created by IntelliJ IDEA.
  User: wanghao
  Date: 3/22/16
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>Group 12: Profile</title>
</head>

    <h3>Group 12: Profile Summary</h3>
    <h3>${msg}</h3>

    <table>
        <tr>
            <td>&lt pre &gt</td>
        </tr>
        <tr>
            <td>ID :</td>
            <td>${profile1.id}</td>
        </tr>
        <tr>
            <td>First Name :</td>
            <td>${profile1.firstname}</td>
        </tr>
        <tr>
            <td>Last Name: </td>
            <td>${profile1.lastname}</td>
        </tr>

        <tr>
            <td>Email: </td>
            <td>${profile1.email}</td>
        </tr>

        <tr>
            <td>Address: </td>
            <td>${profile1.address}</td>
        </tr>
        <tr>
            <td>Organization: </td>
            <td>${profile1.organization}</td>
        </tr>

        <tr>
            <td>About Myself: </td>
            <td>${profile1.aboutmyself}</td>
        </tr>

        <tr>
            <td>&lt /pre &gt</td>
        </tr>
    </table>
</body>
</html>
