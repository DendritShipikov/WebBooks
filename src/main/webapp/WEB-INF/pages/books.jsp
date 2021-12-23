<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>Books</title>
  </head>
  <body>
    <div>
      <header>Books</header>
    </div>
    <div>
      <div>
        <ul>
          <li>
            <a href="${pageContext.request.contextPath}/books">Books</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath}/addbook">Add book</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath}/authors">Authors</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath}/addauthor">Add author</a>
          </li>
        </ul>
      </div>
    </div>
    <div>
      <table>
        <tr>
          <th>Title</th>
          <th>&nbsp;</th>
          <th>&nbsp;</th>
        </tr>
        <c:forEach items="${books}" var="book">
          <tr>
            <td>${book.title}</td>
            <td><a href="${pageContext.request.contextPath}/viewbook?id=${book.id}">View</a></td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </body>
</html>