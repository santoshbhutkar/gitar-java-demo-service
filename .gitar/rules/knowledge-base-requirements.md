---
title: "Knowledge base requirements check"
description: "Retrieve the applicable order-access requirements for relevant pull requests"
when: "Pull requests modify order endpoints, OrderController, OrderRepository, or authorization logic"
actions: "Use the Knowledge Base integration to find the approved order-access requirements; compare them with the pull request; comment with relevant sources and any unmet requirements"
---

# Requirements enrichment

When this rule matches, use the `Knowledge Base` integration to search for the current approved order-access requirements.

* Prefer the official order-ownership specification over informal discussions.
* Summarize the requirements relevant to the changed code in the PR comment.
* Flag a missing ownership check, missing denied-access test, or response that reveals another user's order details.
* If no external source is available, use `docs/specs/order-ownership.md` as the repository fallback and state that the external knowledge-base lookup was unavailable.