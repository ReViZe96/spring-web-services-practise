package com.Spring_WS.practise;

import com.spring_ws.practise.GetItemRequest;
import com.spring_ws.practise.GetItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint //Регистрирует класс как потенциальный кандидат для обработки входящих SOAP сообщений (Аналог @Controller)
public class ItemsEndpoint {
    private static final String NAMESPACE_URI = "http://Spring_WS.com/practise";

    private ItemsRepository itemsRepository;

    @Autowired
    public ItemsEndpoint(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    //Используется Spring WS для выбора метода обработчика на основе namespace и localPart сообщения (Аналог @RequestMapping)
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getItemRequest")
    //Создает соответствующее значение возвращаемому значению полезной части ответа (Аналог @ResponseBody).
    @ResponsePayload
    public GetItemResponse getItem(@RequestPayload GetItemRequest request) { //Указывает на то, что входящее сообщение будет сопоставлено параметру request метода (Аналог @RequestBody).
        GetItemResponse response = new GetItemResponse();
        response.setItem(itemsRepository.findItem(request.getTitle()));
        return response;
    }
}