package com.training.sgorodecki.homework.homework23.services.impl;

import com.training.sgorodecki.homework.homework23.config.AppConfiguration;
import com.training.sgorodecki.homework.homework23.config.WebConfiguration;
import com.training.sgorodecki.homework.homework23.converters.UserConverter;
import com.training.sgorodecki.homework.homework23.dao.api.OrderDAO;
import com.training.sgorodecki.homework.homework23.dao.api.UserDAO;
import com.training.sgorodecki.homework.homework23.dto.UserDto;
import com.training.sgorodecki.homework.homework23.entity.Order;
import com.training.sgorodecki.homework.homework23.entity.User;
import com.training.sgorodecki.homework.homework23.entity.enums.UserRole;
import com.training.sgorodecki.homework.homework23.services.api.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {AppConfiguration.class, WebConfiguration.class})
@WebAppConfiguration
public class UserServiceImplTest {

    @Mock
    private UserDAO userDAO;

    @Mock
    private UserConverter userConverter;

    @Mock
    private OrderDAO orderDAO;

    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserServiceImpl(userDAO, userConverter, orderDAO);
    }

    @Test
    public void shouldAddUserAndOrder() {
        when(userConverter.toEntity(any(UserDto.class))).thenReturn(getUserEntity());
        doNothing().when(userDAO).addUser(any(User.class));
        doNothing().when(orderDAO).addOrder(any(Order.class));

        userService.addUserAndOrder(getUserDto());

        verify(userConverter, times(1)).toEntity(any(UserDto.class));
        verify(userDAO, times(1)).addUser(any(User.class));
        verify(orderDAO, times(1)).addOrder(any(Order.class));

        verifyNoMoreInteractions(userConverter, userDAO, orderDAO);
    }

    private UserDto getUserDto() {
        UserDto userDto = new UserDto();
        userDto.setLogin("Peter");
        userDto.setPassword("");
        return userDto;
    }

    private User getUserEntity() {
        User user = new User();
        user.setId(1);
        user.setLogin("Peter");
        user.setPassword("");
        user.setUserRole(UserRole.USER);
        return user;
    }
}