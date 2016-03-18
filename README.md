Echo Server
===========

A simple self-contained Jetty server that intercepts all requests, extracts information like the HTTP method,
request URI, headers, parameters and actual content, prints it to stdout and also returns it to the client. An
example output:

Request: http://localhost:7070/myapp/test?param1=hello&param2=world

Response:
```
Method: GET
Request URI: /myapp/test
Header[User-Agent]: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:42.0) Gecko/20100101 Firefox/42.0
Header[Connection]: keep-alive
Header[Host]: localhost:7070
Header[Accept-Language]: en-US,en;q=0.5
Header[Accept-Encoding]: gzip, deflate
Header[Accept]: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
Parameter[param1]: hello
Parameter[param2]: world
Content:
```
