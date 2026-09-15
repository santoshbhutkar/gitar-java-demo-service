# Order ownership specification

## Goal
Only the owner of an order may retrieve its details.

## Requirements

1. `GET /orders/{id}` requires the `X-User-Id` request header.
2. The service returns the order only if `X-User-Id` matches `ownerId`.
3. A request for another user's order returns HTTP 403 and does not include order details.
4. An unknown order returns HTTP 404.
5. Tests cover both permitted and denied access.
