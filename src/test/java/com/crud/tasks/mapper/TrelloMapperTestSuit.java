package com.crud.tasks.mapper;


import com.crud.tasks.domain.*;
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
        TrelloListDto trelloListDto1 = new TrelloListDto("1","list1",true);
        TrelloListDto trelloListDto2 = new TrelloListDto("2","list2",true);
        List<TrelloListDto> trelloListDtos = new LinkedList<>();
        trelloListDtos.add(trelloListDto1);
        trelloListDtos.add(trelloListDto2);

        TrelloBoardDto testBoardDto1 = new TrelloBoardDto("0","testboarddto1",trelloListDtos);
        TrelloBoardDto testBoardDto2 = new TrelloBoardDto("1","testboarddto2",trelloListDtos);


        List<TrelloBoardDto> testListDto = new LinkedList<>();
        testListDto.add(testBoardDto1);
        testListDto.add(testBoardDto2);

        TrelloList trelloList1 = new TrelloList("0","trellList1",false);
        TrelloList trelloList2 = new TrelloList("1","trellList2",false);

        List<TrelloList> trelloLists = new LinkedList<>();
        trelloLists.add(trelloList1);
        trelloLists.add(trelloList2);

        TrelloBoard testBoard1 = new TrelloBoard(testBoardDto1.getId(), testBoardDto1.getName(),trelloLists);
        TrelloBoard testBoard2 = new TrelloBoard(testBoardDto2.getId(), testBoardDto2.getName(),trelloLists);


        List<TrelloBoard> expectedBoard = new LinkedList<>();
        expectedBoard.add(testBoard1);
        expectedBoard.add(testBoard2);

        //When
        List<TrelloBoard> resultBoard = trelloMapper.mapToBoards(testListDto);

        //Then
        Assertions.assertEquals(expectedBoard.get(1).getName(),resultBoard.get(1).getName());

    }

    @Test
    void testMapToBoardsDto() {
        TrelloListDto trelloListDto1 = new TrelloListDto("1","list1",true);
        TrelloListDto trelloListDto2 = new TrelloListDto("2","list2",true);
        List<TrelloListDto> trelloListDtos = new LinkedList<>();
        trelloListDtos.add(trelloListDto1);
        trelloListDtos.add(trelloListDto2);

        TrelloBoardDto testBoardDto1 = new TrelloBoardDto("0","testboarddto1",trelloListDtos);
        TrelloBoardDto testBoardDto2 = new TrelloBoardDto("1","testboarddto2",trelloListDtos);


        List<TrelloBoardDto> expectedListDto = new LinkedList<>();
        expectedListDto.add(testBoardDto1);
        expectedListDto.add(testBoardDto2);

        TrelloList trelloList1 = new TrelloList("0","trellList1",false);
        TrelloList trelloList2 = new TrelloList("1","trellList2",false);

        List<TrelloList> trelloLists = new LinkedList<>();
        trelloLists.add(trelloList1);
        trelloLists.add(trelloList2);

        TrelloBoard testBoard1 = new TrelloBoard(testBoardDto1.getId(), testBoardDto1.getName(),trelloLists);
        TrelloBoard testBoard2 = new TrelloBoard(testBoardDto2.getId(), testBoardDto2.getName(),trelloLists);


        List<TrelloBoard> testBoardDto = new LinkedList<>();
        testBoardDto.add(testBoard1);
        testBoardDto.add(testBoard2);

        //When
        List<TrelloBoardDto> resultBoard = trelloMapper.mapToBoardsDto(testBoardDto);

        //Then
        Assertions.assertEquals(resultBoard.get(1).getName(),testBoardDto.get(1).getName());
    }

    @Test
    void testMapToList() {
        //Given

        TrelloListDto trelloListDto1 = new TrelloListDto("1","list1",true);
        TrelloListDto trelloListDto2 = new TrelloListDto("2","list2",true);
        List<TrelloListDto> trelloListDtos = new LinkedList<>();
        trelloListDtos.add(trelloListDto1);
        trelloListDtos.add(trelloListDto2);

        //When
        List<TrelloList> result = trelloMapper.mapToList(trelloListDtos);

        //Then
        Assertions.assertEquals(result.get(0).getName(), trelloListDtos.get(0).getName());

    }

    @Test
    void testMapToListDto() {
        //Given

        TrelloList trelloList1 = new TrelloList("0","trellList1",false);
        TrelloList trelloList2 = new TrelloList("1","trellList2",false);

        List<TrelloList> trelloLists = new LinkedList<>();
        trelloLists.add(trelloList1);
        trelloLists.add(trelloList2);


        //When
        List<TrelloListDto> result = trelloMapper.mapToListDto(trelloLists);

        //Then
        Assertions.assertEquals(result.get(0).getName(), trelloLists.get(0).getName());

    }

    @Test
    void testMapToCard() {
        //Given

        TrelloCardDto trelloCardDto = new TrelloCardDto();
        trelloCardDto.setName("name");



        //When
        TrelloCard result = trelloMapper.mapToCard(trelloCardDto);

        //Then
        Assertions.assertEquals(result.getName(), trelloCardDto.getName());

    }

    @Test
    void testMapToCardDto() {
        //Given

        TrelloCard trelloCard = new TrelloCard("name","desc","pos","id");




        //When
        TrelloCardDto result = trelloMapper.mapToCardDto(trelloCard);

        //Then
        Assertions.assertEquals(result.getName(), trelloCard.getName());

    }


}
