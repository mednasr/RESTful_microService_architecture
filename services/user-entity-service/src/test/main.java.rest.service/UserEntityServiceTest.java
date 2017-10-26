package main.java.rest.service;

import rest.service.UserEntityService;

public class UserEntityServiceTest
{
    public static void main(String[] args) throws Exception
    {
        new UserEntityService().run("server", "./config.yml");
    }
}
