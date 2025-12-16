# 비동기 인증 회원관리 시스템

## 1. javscript fetch/ajax(비동기) 인증

- javascript의 비동기 fetch 방식의 api 통신에 대한 인증
- 다중 security filter chain 구성
- 전용 fetch authentication provider 구성 필요

## 2. authentication/authorization http status

- 401 - 인증예외 - authenticationEntryPoint
- 403 - 인가예외 - accessDeniedHandler

## 3. csrf

[thymeleaf에서]
- `<meta name="_csrf" th:content="${_csrf.token}">`
- `<meta name="_csrf_header" th:content="${_csrf.headerName}">`

이후 meta tag에서 csrf token을 추출

- csrfHeader = $('meta[name="_csrf.header"]').attr('content');
- csrfToken = $('meta[name="_csrf"]').attr('content');
- headers에 csrf 추가
  - [csrfHeader] : csrfToken

## 4. api dsl

- filter 대신에 우선적으로, 그 자체를 모두 dsl로 대체하기 위한 방안
- filter의 success/failure handler 등을 한 곳에서 설정 및 구현 가능