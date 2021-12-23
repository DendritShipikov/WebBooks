<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>Books</title>
  </head>
  <body>
    <div>
      <table>
        <tr>
          <td>Name:</td>
          <td>${author.name}</td>
        </tr>
        <tr>
          <td>Books:</td>
          <td>
            <ul>
              <c:forEach items="${books}" var="book">
                <li>${book.title}</li>
              </c:forEach>
            </ul>
          </td>
        </tr>
      </table>
    </div>
    <div>
      <c:if test="${empty books}">
      <a href="${pageContext.request.contextPath}/deleteauthor?id=${author.id}">Delete</a>
      </c:if>
    </div>
  </body>
</html>