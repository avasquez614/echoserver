package org.avasquez.echoserver;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

/**
 * Handler that intercepts all requests, extracts the HTTP method, request URI, headers, parameters and content, prints
 * them to stdout and then returns this info as a response to the client.
 *
 * @author avasquez
 */
public class EchoHandler extends AbstractHandler {

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        StringBuilder msg = new StringBuilder();

        msg.append("Method: ").append(request.getMethod()).append("\n");
        msg.append("Request URI: ").append(request.getRequestURI()).append("\n");

        for (Enumeration<String> names = request.getHeaderNames(); names.hasMoreElements();) {
            String name = names.nextElement();
            for (Enumeration<String> values = request.getHeaders(name); values.hasMoreElements();) {
                msg.append("Header[").append(name).append("]: ").append(values.nextElement()).append("\n");
            }
        }

        for (Enumeration<String> names = request.getParameterNames(); names.hasMoreElements();) {
            String name = names.nextElement();
            for (String value : request.getParameterValues(name)) {
                msg.append("Parameter[").append(name).append("]: ").append(value).append("\n");
            }
        }

        msg.append("Content:").append("\n").append(IOUtils.toString(request.getReader())).append("\n");

        System.out.println(msg.toString());

        response.setContentType("text/plain;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        IOUtils.write(msg, response.getWriter());

        baseRequest.setHandled(true);
    }

}
