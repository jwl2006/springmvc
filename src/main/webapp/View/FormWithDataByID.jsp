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
    <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <title>Group 12: Profile</title>
</head>
<body>
    <h3>Summary</h3>
    <h3>Group 12: Profile</h3>

    <form id="profileForm" action=""  >
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

            <tr><td><input type="submit" value="UPDATE" name="update" onclick="submitForm()" /></td></tr>
            <tr><td><input type="submit" value="DELETE" name="delete" onclick="deleteForm()" /></td></tr>
            <div id="response"></div>
        </table>
    </form>


    <script>
        function submitForm() {
            var profileForm = document.getElementById("profileForm");
            var action = "/profile/";
            action += profileForm.elements[0].value + "?";
            var param="";
            for( var i = 0; i < profileForm.length; i++) {
                var ele = profileForm.elements[i];
                if(ele.type == "text") {
                    param += ele.name + "=" + ele.value +"&";
                }
            }
            var newForm = document.createElement("form");
            newForm.method = "post";
            newForm.action = action + param;
            document.body.appendChild(newForm);
            newForm.submit();
        }
          function deleteForm() {
              var profileForm = document.getElementById("profileForm");
              var action = "/profile/";
              action += profileForm.elements[0].value;

              var xp = new XMLHttpRequest();
              xp.onreadystatechange = function() {
                  if(xp.readyState == 4 && xp.status == 200) {
                      document.write("returned");
                  }
              }
              xp.open("DELETE", action, true);
              xp.send();
          }

    </script>

</body>
</html>
