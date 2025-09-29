<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setAttribute("pageTitle", "Backstory"); %>
<% request.setAttribute("bodyClass", "page-story"); %>

<jsp:include page="/WEB-INF/_layout/header.jsp"/>

<main class="flex-grow-1">

    <section class="bg-dark text-white">
        <div class="container-fluid py-5">
            <div class="row align-items-center gy-4 px-4">
                <div class="col-lg-6 order-2 order-lg-1">
                    <h1 class="display-4 fw-bold mb-3">A Call From the Unknown</h1>
                    <p class="lead mb-4">
                        Strange lights. A faint signal. And a sudden blank in your memory.
                        You awaken aboard an alien craft, with only fragments of who you were.
                    </p>
                    <form method="post" action="${pageContext.request.contextPath}/main" class="d-inline-block">
                        <button class="btn btn-primary btn-lg px-4">Start the Quest</button>
                    </form>
                    <a href="${pageContext.request.contextPath}/" class="btn btn-outline-light btn-lg ms-2 px-4">Back to Main</a>
                </div>
                <div class="col-lg-6 order-1 order-lg-2 text-center">
                    <img
                            src="https://img.freepik.com/premium-vector/modern-ufo-abduction-concept-with-flat-design_23-2147913442.jpg?w=2000"
                            alt="UFO Abduction illustration"
                            class="img-fluid rounded shadow"
                            loading="lazy">
                </div>
            </div>
        </div>
    </section>

    <section class="py-5">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-9">
                    <div class="p-4 rounded" style="background: rgba(0,0,0,0.6);">
                        <h2 class="h3 mb-3 text-white text-center">Backstory</h2>
                        <p class="fs-5 text-white">
                            One ordinary night, an unknown signal pulsed through the sky,
                            resonating with something deep inside you. The world blurred—then silence.
                            You came to on a pristine deck under an alien ceiling, your memories scattered
                            like stardust. Voices surrounded you, curious yet cautious, asking you to answer—
                            to prove who you are and whether you can be trusted.
                        </p>
                        <p class="fs-5 text-white">
                            Your path home lies through choices: honesty or deception, courage or doubt.
                            Each answer shapes how the crew perceives you—and whether they’ll risk helping.
                            Some endings bring you safely back, others teach harder lessons.
                            Choose carefully: out here, truth travels faster than light.
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </section>

</main>

<jsp:include page="/WEB-INF/_layout/footer.jsp"/>