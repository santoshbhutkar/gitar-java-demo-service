# Gitar Java demo service

A small Spring Boot service for a Gitar sandbox demo. It contains an order endpoint protected by an ownership check.

## Run locally

```bash
mvn spring-boot:run
curl -i -H 'X-User-Id: alice' http://localhost:8080/orders/1001
curl -i -H 'X-User-Id: bob' http://localhost:8080/orders/1001
```

The first request returns `200`; the second returns `403`.

## Demo PR to prepare

Create a branch named `demo/missing-authorization-check`. In `OrderController`, remove the block that returns `403` when `order.ownerId()` does not equal `userId`. Keep `anotherUserCannotReadTheOrder` unchanged. Open a PR titled `Simplify order lookup`.

Gitar should identify the broken authorization behavior. In the PR, request: `@gitar-bot please fix the authorization issue and preserve the regression test.`
