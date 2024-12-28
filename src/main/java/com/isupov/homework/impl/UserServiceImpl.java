package com.isupov.homework.impl;

import expense.ExpenseOuterClass;
import io.grpc.stub.StreamObserver;
import user.User;
import user.UserServiceGrpc;

public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {
    @Override
    public void registerUser(User.RegisterUserRequest request, StreamObserver<User.UserResponse> responseObserver) {
        System.out.println("registerUser rq:" + request);
        User.UserResponse response = User.UserResponse.newBuilder()
                .setUserId(1)
                .setName("Evgenii")
                .build();

        System.out.println("Send response: " + response);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getUser(User.GetUserRequest request, StreamObserver<User.UserResponse> responseObserver) {

        System.out.println("getUser rq:" + request.toString());
        User.UserResponse response = User.UserResponse.newBuilder()
                .setUserId(1)
                .setName("Evgenii")
                .build();

        System.out.println("Send response: " + response);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
