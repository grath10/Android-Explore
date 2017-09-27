package com.example.dell.app;

public class ClientManager {
    private static PahoMqttClient client;

    public static PahoMqttClient getInstance(){
        if(client == null){
            client = new PahoMqttClient();
        }
        return client;
    }

    private ClientManager(){

    }
}
