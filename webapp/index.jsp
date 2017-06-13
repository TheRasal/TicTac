<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12.06.2017
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Крестики Нолики</title>
  </head>
  <body>
<div>
  <form action="/tictak/game" method="post">
    <input type="hidden" name="varX" value="">
   <input type="submit" value="go">
  </form>
</div>
  <div>
   <center> <table style="cellspacing: 0;" >

    <c:forEach var="list" items="${result}">
      <tr>
      <c:forEach var="list1" items="${list}">

        <td>
            <c:if test="${'9'!=list1&&'10'!=list1}">
            <form action="/tictak/game" method="post">
                <input type="hidden" name="varX" value="${list1}">
                <input type="submit"
                   style="cellspacing: 0px; width: 50px; height: 50px;"
                   value="" />
            </form>
            </c:if>
            <c:if test="${'9'==list1}">
                <input type="button" style="border-collapse:collapse; border:1px solid black; width: 50px; height: 50px;" value="X">
            </c:if>
            <c:if test="${'10'==list1}">
                <input type="button" style="border-collapse:collapse; border:1px solid black; width: 50px; height: 50px;" value="O">
            </c:if>
            <%--<input type="submit" style="width: 50px; height: 50px;" value="${list1}"/>--%>
        </td>


      </c:forEach>
      </tr>

    </c:forEach>
    </table></center>
      <br>${winner}
  </div>

  </body>
</html>
