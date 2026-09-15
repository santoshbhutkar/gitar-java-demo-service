# Authorization and data-access review

For every pull request that changes controllers, endpoints, services, repositories, or authorization logic:

* Verify that an authenticated user can access only records they own or are explicitly authorized to access.
* Report a blocking finding when a user-controlled identifier can retrieve another user's resource without an ownership or permission check.
* Verify that error responses do not reveal another user's data.
* When proposing a fix, preserve or add a regression test that proves cross-user access is denied.
* Focus on correctness and security impact; do not report style-only suggestions for this rule.