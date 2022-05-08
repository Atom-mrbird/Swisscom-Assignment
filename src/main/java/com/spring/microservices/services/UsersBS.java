package com.spring.microservices.services;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.spring.microservices.vo.DynamicFilteringVO;
import com.spring.microservices.vo.UserVO;

@Service
public class UsersBS implements UsersBSI {

	private static List<UserVO> users = new ArrayList<>();
	private static int usersCount = 5;
	private List<DynamicFilteringVO> dynamicVOS = new ArrayList<>();

	{
		dynamicVOS.add(new DynamicFilteringVO("1", "Ataberk", "Yakar","ataberkyakar@gmail.com","******"));
		dynamicVOS.add(new DynamicFilteringVO("2", "James", "Gordon","james.gordon@bluewin.ch","******"));
		dynamicVOS.add(new DynamicFilteringVO("3", "John", "Appleseed","j.appleseed@bluewin.ch","******"));
		dynamicVOS.add(new DynamicFilteringVO("4", "Steve", "Rogers","steverogers@bluewin.ch","******"));
	}

	static {
		users.add(new UserVO(1, "Ataberk", "Yakar","ataberkyakar@gmail.com","******","aleksanra caka iela","Premium"));
		users.add(new UserVO(2, "Peter", "Parker","peter.parker@bluewin.ch","******","Malibu/California","Standart"));
		users.add(new UserVO(3, "Steve", "Rogers","steverogers@bluewin.ch","******","sanfrancisco/California","Standart"));
		users.add(new UserVO(4, "Tony", "Stark","tonystark@bluewin.ch","******","los angles","Premium"));
		users.add(new UserVO(5, "Bruce", "Wayne","b.wayne@bluewin.ch","******","Santa Monica/CA, USA","Premium"));
	}

	@Override
	public UserVO getUserById(int id) {
		return users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
	}

	@Override
	public ResponseEntity<String> updateUserByAccount(String account) {
		//return users.stream().filter(u -> u.getAccount() == account).findFirst().orElse(null);
		return ResponseEntity.ok("resource updated");
	}

	@Override
	public DynamicFilteringVO getUserByFirstName(@NotNull String firstName) {
		return dynamicVOS.stream().filter(u -> u.getFirstName().equals(firstName)).findFirst().orElse(null);
	}

	@Override
	public List<UserVO> getUsers() {
		return users;
	}

	@Override
	public UserVO saveUser(UserVO user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		if (user != null) {
			users.add(user);
		}
		return user;
	}

	/**
	 * Filtering VO on the basis of field name.
	 */
	@Override
	public MappingJacksonValue filterProperties(DynamicFilteringVO vo, String fieldName) {

		// creating filter.
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", fieldName);

		FilterProvider filters = new SimpleFilterProvider().addFilter("BeanFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(vo);

		mapping.setFilters(filters);

		return mapping;
	}
}
