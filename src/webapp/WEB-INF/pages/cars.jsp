<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<table>
    <c:set var="loc" value="${locale}"/>
        <tr>
            <th>${loc}</th>
        </tr>
    <c:forEach var="cars" items="${allCars}">
        <tr>
            <td><h1>${cars}</h1></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>