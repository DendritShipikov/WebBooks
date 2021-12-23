<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>Books</title>
  </head>
  <body>
    <div>
      <table>
        <tr>
          <td>Title:</td>
          <td>${book.title}</td>
        </tr>
        <tr>
          <td>Authors:</td>
          <td>
            <ul>
              <c:forEach items="${book.authors}" var="author">
                <li>${author.name}</li>
              </c:forEach>
            </ul>
          </td>
        </tr>
        <tr>
          <td>Pages:</td>
          <td>${book.pages}</td>
        </tr>
      </table>
    </div>
    <div>
      <a href="${pageContext.request.contextPath}/deletebook?id=${book.id}">Delete</a>
      <a href="${pageContext.request.contextPath}/editbook?id=${book.id}">Edit</a>
    </div>
  </body>
</html>