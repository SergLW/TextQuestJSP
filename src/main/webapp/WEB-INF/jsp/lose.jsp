<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setAttribute("pageTitle", "Програш"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setAttribute("bodyClass", "page-lose");%>
<jsp:include page="/WEB-INF/_layout/header.jsp"/>

<div class="row justify-content-center">
    <div class="col-lg-8">
        <div class="card shadow-sm text-center">
            <div class="card-body p-5">
                <div style="font-size:96px;line-height:1" class="mb-3">🛸😞</div>
                <h1 class="h3 mb-3">Поразка</h1>
                <p class="text-muted mb-4"><c:out value="${state.text()}"/></p>
                <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
                    <a class="btn btn-outline-secondary btn-lg" href="${pageContext.request.contextPath}/">На головну</a>
                    <form method="post" action="${pageContext.request.contextPath}/game">
                        <button class="btn btn-primary btn-lg">Почати знову</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/_layout/footer.jsp"/>