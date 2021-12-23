<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
  </head>
  <body>
    <form method="POST" action="${pageContext.request.contextPath}/addauthor">
      <table>
        <tr>
          <td>Name:</td>
          <td><input type="text" name="name"/></td>
        </tr>
      </table>
      <input type="submit" value="Add author"/>
    </form>
  </body>
</html>