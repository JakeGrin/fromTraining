package com.training.sgorodecki.homework.homework23.services.impl;

import com.training.sgorodecki.homework.homework23.config.AppConfiguration;
import com.training.sgorodecki.homework.homework23.config.WebConfiguration;
import com.training.sgorodecki.homework.homework23.dao.api.GoodDAO;
import com.training.sgorodecki.homework.homework23.entity.Good;
import com.training.sgorodecki.homework.homework23.services.api.GoodService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {AppConfiguration.class, WebConfiguration.class})
@WebAppConfiguration
public class GoodServiceImplTest {

    @Mock
    private GoodDAO goodDAO;

    private GoodService goodService;

    @Before
    public void setUp() {
        goodService = new GoodServiceImpl(goodDAO);
    }

    @Test
    public void shouldGetAllGoods() {
        Map<Integer, Good> expected = getGoods()
                .stream()
                .collect(toMap(Good::getId, Function.identity()));

        when(goodDAO.getAll()).thenReturn(getGoods());

        assertEquals(expected, goodService.getAll());
    }

    @Test
    public void shouldGetById() {
        int id = 1;

        when(goodDAO.getById(anyInt())).thenReturn(getGood());
        assertEquals(getGood(), goodDAO.getById(id));
    }

    private Good getGood() {
        Good book = new Good();
        book.setName("Book");
        book.setId(1);
        book.setPrice(new BigDecimal("20.50"));
        return book;
    }

    private List<Good> getGoods() {
        Good book = new Good();
        book.setName("Book");
        book.setId(1);
        book.setPrice(new BigDecimal("20.50"));

        Good phone = new Good();
        phone.setName("Phone");
        phone.setId(2);
        phone.setPrice(new BigDecimal("10.00"));

        Good tv = new Good();
        tv.setName("TV");
        tv.setId(3);
        tv.setPrice(new BigDecimal("24.00"));

        Good radio = new Good();
        radio.setName("Radio");
        radio.setId(4);
        radio.setPrice(new BigDecimal("26.80"));

        Good table = new Good();
        table.setName("Table");
        table.setId(5);
        table.setPrice(new BigDecimal("30.40"));

        return List.of(book, phone, tv, radio, table);
    }
}