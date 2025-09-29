<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setAttribute("pageTitle", "Question"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setAttribute("bodyClass", "page-game");%>

<jsp:include page="/WEB-INF/_layout/header.jsp"/>

<div class="row gy-4 justify-content-center">
    <div class="col-lg-8">
        <div class="d-flex justify-content-between align-items-center mb-3">
            <a class="btn btn-outline-secondary" href="${pageContext.request.contextPath}/">⟵ Exit</a>
            <span class="badge text-bg-secondary">Session active</span>
        </div>

        <div class="card shadow-sm mb-4">
            <div class="card-body">
                <h2 class="h4 mb-3">Question</h2>
                <p class="fs-5 mb-4"><c:out value="${state.text()}"/></p>

                <form method="post" action="${pageContext.request.contextPath}/game" class="d-flex gap-2 flex-wrap">
                    <input type="hidden" name="stepToken" value="${sessionScope.stepToken}">
                    <button name="answer" value="true" class="btn btn-success btn-lg">
                        <c:out value="${trueLabel}"/>
                    </button>
                    <button name="answer" value="false" class="btn btn-danger btn-lg">
                        <c:out value="${falseLabel}"/>
                    </button>
                </form>
            </div>
        </div>

        <div class="card shadow-sm">
            <div class="card-header d-flex justify-content-between align-items-center">
                <span>Decision History</span>
                <span class="text-muted small">(only visible events)</span>
            </div>
            <div class="card-body">
                <c:choose>
                    <c:when test="${not empty sessionScope.history}">
                        <ul class="list-group">
                            <c:forEach var="line" items="${sessionScope.history}" varStatus="st">
                                <li class="list-group-item d-flex justify-content-between align-items-start">
                                    <div class="me-2">
                                        <code class="text-body"><c:out value="${line}"/></code>
                                    </div>
                                    <span class="badge text-bg-light">#<c:out value="${st.index + 1}"/></span>
                                </li>
                            </c:forEach>
                        </ul>
                    </c:when>
                    <c:otherwise>
                        <div class="text-muted">History is empty. Make your first choice.</div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/_layout/footer.jsp"/>