package com.crud.tasks.mapper;


import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloBoardDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class TrelloMapperTestSuit {

    @Autowired
    private TrelloMapper trelloMapper;


    @Test
    void testMapToBoards() {
        //Given
        TrelloBoardDto testBoardDto1 = new TrelloBoardDto();
        TrelloBoardDto testBoardDto2 = new TrelloBoardDto();
        testBoardDto1.setName("test1");
        testBoardDto2.setName("test2");

        List<TrelloBoardDto> testListDto = new LinkedList<>();
        testListDto.add(testBoardDto1);
        testListDto.add(testBoardDto2);

        TrelloBoard testBoard1 = new TrelloBoard();
        TrelloBoard testBoard2 = new TrelloBoard();
        testBoard1.setName(testBoardDto1.getName());
        testBoard1.setId(testBoard1.getId());
        testBoard2.setName(testBoardDto2.getName());
        testBoard2.setId(testBoard2.getId());

        List<TrelloBoard> expectedBoard = new LinkedList<>();
        expectedBoard.add(testBoard1);
        expectedBoard.add(testBoard2);

        //When
        List<TrelloBoard> resultBoard = trelloMapper.mapToBoards(testListDto);

        //Then
        Assertions.assertEquals(expectedBoard,resultBoard);

    }

    @Test
    void testMapToBoardsDto() {

    }

    @Test
    void testMapToList() {

    }



}
