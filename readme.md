this is a hands on for the youtube video https://www.youtube.com/watch?v=_PQd6aZ-ANk

Documentation
https://www.youtube.com/watch?v=q2l91Ffc_8U
https://www.learncodewithdurgesh.com/blogs/jwt-authentication-with-spring-boot-31


https://www.youtube.com/watch?v=U5wQn5SVC08 user auth through db









CORS (Cross-Origin Resource Sharing) is primarily a security feature implemented and enforced by web browsers. It operates on the client side (browser) to restrict web pages from making requests to a different origin (domain, protocol, or port) than the one that served the web page originally.

Understanding CORS:
Browser Enforcement: CORS is enforced by web browsers, such as Chrome, Firefox, Safari, etc. It is a security feature built into browsers to prevent malicious websites from accessing resources on other websites without permission.

Server Configuration: While CORS policies are enforced by browsers, they are configured and controlled on the server side. This means that servers can dictate which origins are allowed to access their resources by specifying CORS headers in HTTP responses.

CORS Headers:
When a server receives a cross-origin request from a browser, it responds with CORS headers that instruct the browser on whether the request is allowed:

Access-Control-Allow-Origin: Specifies which origins are allowed to access the resource.
Access-Control-Allow-Methods: Specifies the HTTP methods (GET, POST, etc.) allowed when accessing the resource.
Access-Control-Allow-Headers: Specifies which headers can be used in the actual request.
These headers are crucial for CORS functionality because they inform the browser whether to block or allow the request based on the server's policy.

Disabling CORS in Spring Security:
In the context of Spring Security, disabling CORS (cors().disable()) means that Spring Security will not set any CORS-related headers in its responses. This effectively tells the browser not to enforce CORS restrictions for requests made to the application.

Practical Implications:
Backend (Server Side): Disabling CORS in Spring Security means your application does not set CORS headers in its responses. This can simplify development and testing scenarios where you need to access resources from different origins without dealing with CORS-related errors during development.

Browser (Client Side): Disabling CORS on the server side does not disable it in the browser. Browsers will still enforce the same-origin policy unless explicitly allowed by CORS headers from the server. If CORS is disabled on the server side, the browser will treat cross-origin requests as same-origin requests, potentially bypassing the usual security restrictions.

Conclusion:
CORS is a browser-enforced security feature designed to protect web applications from unauthorized cross-origin requests. Disabling CORS on the server side (e.g., in Spring Security configuration) means that the server does not enforce CORS policies and does not include CORS headers in its responses. However, browsers will still enforce CORS policies based on the server's response headers, even if CORS is disabled on the server side.