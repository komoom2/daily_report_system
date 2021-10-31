<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="constants.ForwardConst" %>
<%@ page import="constants.AttributeConst" %>

<c:set var="actCli" value="${ForwardConst.ACT_CLI.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_CLI_INDEX.getValue()}" />
<c:set var="commEdit" value="${ForwardConst.CMD_CLI_EDIT.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">

        <h2>id : ${client.id} の取引先情報 詳細ページ</h2>

        <table>
            <tbody>
                <tr>
                    <th>取引先名</th>
                    <td><c:out value="${client.name}" /></td>
                </tr>
                <tr>
                    <th>住所</th>
                    <td><c:out value="${client.address }"/></td>
                </tr>
                <tr>
                    <th>電話番号</th>
                    <td><c:out value="${client.phoneNumber }"/></td>
                </tr>
                <tr>
                    <th>登録日時</th>
                    <fmt:parseDate value="${client.createdAt}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="createDay" type="date" />
                    <td><fmt:formatDate value="${createDay}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                </tr>
                <tr>
                    <th>更新日時</th>
                    <fmt:parseDate value="${client.updatedAt}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="updateDay" type="date" />
                    <td><fmt:formatDate value="${updateDay}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                </tr>
            </tbody>
        </table>

        <p>
            <a href="<c:url value='?action=${actCli}&command=${commEdit}&id=${client.id}' />">この取引先情報を編集する</a>
        </p>

        <p>
            <a href="<c:url value='?action=${actCli}&command=${commIdx}' />">一覧に戻る</a>
        </p>
    </c:param>
</c:import>