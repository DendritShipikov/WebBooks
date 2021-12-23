<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
  </head>
  <body>
    <form method="POST" action="${pageContext.request.contextPath}/addbook">
      <table>
        <tr>
          <td>Title:</td>
          <td><input type="text" name="title"/></td>
        </tr>
        <tr>
          <td>Author:</td>
          <td>
            <ul>
              <c:forEach items="${authors}" var="author">
                <li>
                  <input type="checkbox" name="authorids" value="${author.id}">${author.name}
                </li>
              </c:forEach>
            </ul>
          </td>
        </tr>
        <tr>
          <td>Pages:</td>
          <td><input type="text" name="pages"/></td>
        </tr>
      </table>
      <input type="submit" value="Add book"/>
    </form>
  </body>
</html>