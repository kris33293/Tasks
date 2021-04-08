package com.crud.tasks.service;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class TrelloServiceTest {

    @Autowired
    TrelloService trelloService;

    @Test
    void createTrelloCardTest(){
        //Given
        TrelloCardDto cardDto = new TrelloCardDto();
        cardDto.setListId("6012c7c705ccb546fac17843");
        cardDto.setPos("5");
        cardDto.setName("test cardDto");
        cardDto.setDescription("description");

        //When
        CreatedTrelloCardDto createdCard = trelloService.createTrelloCard(cardDto);

        //Then
        assertEquals(cardDto.getName(),createdCard.getName());


    }


}