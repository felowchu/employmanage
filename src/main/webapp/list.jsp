<%--
  Created by IntelliJ IDEA.
  User: bestchu
  Date: 2017/7/17
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
</head>
<body>
    <h1>欢迎你, ${sessionScope.loginInfo.name}</h1>
    <table>
        <tr>
            <td>序号</td>
            <td>员工姓名</td>
            <td>所在部门</td>
        </tr>
        <c:if test="${not empty requestScope.listEmp}">
            <c:forEach var="emp" items="${requestScope.listEmp}" varStatus="vs">
                <tr>
                    <td>${vs.count}</td>
                    <td>${emp.empName}</td>
                    <td>${emp.dept_id}</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</body>
</html>
