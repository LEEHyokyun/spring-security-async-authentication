# 비동기 인증 회원관리 시스템

## 1. javscript fetch/ajax(비동기) 인증

- javascript의 비동기 fetch 방식의 api 통신에 대한 인증
- 다중 security filter chain 구성
- 전용 fetch authentication provider 구성 필요

## 2. additional

- 401 - 인증예외 - authenticationEntryPoint
- 403 - 인가예외 - accessDeniedHandler

## 3. csrf

[thymeleaf에서]
- <meta name="_csrf" th:content="${_csrf.token}">
- <meta name="_csrf_header" th:content="${_csrf.headerName}">

이후 meta tag에서 csrf token을 추출

- csrfHeader = $('meta[name="_csrf.header"]').attr('content');
- csrfToken = $('meta[name="_csrf"]').attr('content');
- headers에 csrf 추가
  - [csrfHeader] : csrfToken