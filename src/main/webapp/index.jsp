<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Text Quest — Головна</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/main.css" rel="stylesheet">
</head>

<body class="d-flex flex-column min-vh-100 bg-light">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">Text&nbsp;Quest</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#nav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div id="nav" class="collapse navbar-collapse">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link active" href="${pageContext.request.contextPath}/">Головна</a></li>
                <li class="nav-item"><a class="nav-link disabled" href="#" aria-disabled="true">Історія</a></li>
            </ul>
        </div>
    </div>
</nav>

<main class="flex-grow-1">
    <section class="hero">
        <div class="container py-5">
            <div class="row justify-content-center text-center">
                <div class="col-lg-8">
                    <h1 class="display-5 fw-bold mb-3">Виклик НЛО і втрата пам'яті</h1>
                    <p class="lead mb-4">Чи зможеш ти чесно відповісти на питання? Від відповідей залежить твоя доля.</p>
                    <form method="get" action="${pageContext.request.contextPath}/game" class="d-inline-block">
                        <button class="btn btn-primary btn-lg px-4">Почати квест</button>
                    </form>
                </div>
            </div>
        </div>
    </section>

    <section class="py-5">
        <div class="container">
            <div class="row row-cols-1 row-cols-md-3 g-4">
                <div class="col">
                    <div class="card shadow-sm feature-card">
                        <div class="card-body">
                            <h2 class="h5">Мінімалізм механік</h2>
                            <p class="text-muted mb-0">На кожному кроці лише два варіанти. А наслідки — зовсім не прості.</p>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card shadow-sm feature-card">
                        <div class="card-body">
                            <h2 class="h5">Адаптивний інтерфейс</h2>
                            <p class="text-muted mb-0">Можна грати на телефоні, планшеті та десктопі.</p>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card shadow-sm feature-card">
                        <div class="card-body">
                            <h2 class="h5">Історія рішень</h2>
                            <p class="text-muted mb-0">Будь обережний - ведеться запис кожного твого вибору.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section class="py-5 bg-body-tertiary">
        <div class="container">
            <div class="row align-items-center gy-4">
                <div class="col-md-6">
                    <h2 class="h4 mb-3">Незабаром: Історія</h2>
                    <p class="text-muted mb-4">
                        Ми готуємо сторінку з передісторією.
                    </p>
                    <a class="btn btn-outline-secondary disabled" href="#" aria-disabled="true">Історія</a>
                </div>
                <div class="col-md-6 text-center">
                    <div style="font-size:96px;line-height:1">📖✨</div>
                </div>
            </div>
        </div>
    </section>

</main>

<!-- Sticky footer -->
<footer class="bg-dark text-white py-4 mt-auto">
    <div class="container text-center">
        <small>&copy; <%= java.time.Year.now() %> Text Quest</small>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>