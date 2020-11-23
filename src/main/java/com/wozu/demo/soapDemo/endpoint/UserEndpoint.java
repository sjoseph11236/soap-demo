package com.wozu.demo.soapDemo.endpoint;


import com.wozu.demo.soapDemo.service.UserService;
import com.wozu.soapdemo.GetUserRequest;
import com.wozu.soapdemo.GetUserResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

    private final UserService userService;

    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @PayloadRoot(namespace = "http://wozu.com/soapDemo",
            localPart = "getUserRequest"
    )
    @ResponsePayload()
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        response.setUser(userService.getUsers(request.getName()));
        return response;
    }
}
