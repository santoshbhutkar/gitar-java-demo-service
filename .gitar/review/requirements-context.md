# Requirements context

@../../docs/specs/order-ownership.md

When reviewing changes to order retrieval, controllers, repositories, or authorization:

* Treat the referenced order-ownership specification as the expected behavior.
* Report a blocking finding if a change allows cross-user order access.
* Confirm tests demonstrate both successful owner access and denied non-owner access.