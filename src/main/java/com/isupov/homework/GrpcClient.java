package com.isupov.homework;

import expense.ExpenseOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import expense.ExpenseServiceGrpc;
import user.User;
import user.UserServiceGrpc;

public class GrpcClient {
    public static void main(String[] args) {

        System.out.println("Регистрация пользователя");
        registerUser();
        System.out.println("Получение данных пользователя");
        getUser();
        System.out.println("Добавление трат пользователя");
        addExpense();
        System.out.println("Получение трат пользователя");
        getExpense();
    }

    private static void addExpense() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8085)
                .usePlaintext()
                .build();

        ExpenseServiceGrpc.ExpenseServiceBlockingStub stub
                = ExpenseServiceGrpc.newBlockingStub(channel);

        ExpenseOuterClass.ExpenseResponse response = stub.addExpense(ExpenseOuterClass.AddExpenseRequest.newBuilder()
                .setAmount(1000)
                .build());

        channel.shutdown();

        System.out.println(response);
    }

    private static void getExpense() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8085)
                .usePlaintext()
                .build();

        ExpenseServiceGrpc.ExpenseServiceBlockingStub stub
                = ExpenseServiceGrpc.newBlockingStub(channel);

        ExpenseOuterClass.ExpensesListResponse response = stub.getExpenses(ExpenseOuterClass.GetExpensesRequest.newBuilder()
                .build());

        channel.shutdown();

        System.out.println(response);
    }

    private static void registerUser() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8090)
                .usePlaintext()
                .build();

        UserServiceGrpc.UserServiceBlockingStub stub
                = UserServiceGrpc.newBlockingStub(channel);

        User.UserResponse response = stub.registerUser(User.RegisterUserRequest.newBuilder()
                        .setName("Evgenii")
                .build());

        channel.shutdown();

        System.out.println(response);
    }

    private static void getUser() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8090)
                .usePlaintext()
                .build();

        UserServiceGrpc.UserServiceBlockingStub stub
                = UserServiceGrpc.newBlockingStub(channel);

        User.UserResponse response = stub.getUser(User.GetUserRequest.newBuilder()
                .setUserId("1")
                .build());

        channel.shutdown();

        System.out.println(response);
    }
}
