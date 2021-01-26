package com.ewolff.microservice.catalog;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CatalogApp.class, webEnvironment = WebEnvironment.NONE)
@ActiveProfiles("test")
public class RepositoryTest {

	@Autowired
	private ItemRepository itemRepository;

	@Test
	public void AreAllIPodReturned() {

		assertThat(itemRepository.findByNameContaining("iPod",Sort.unsorted()), hasSize(3));
		assertTrue(
				itemRepository.findByNameContaining("iPod",Sort.unsorted()).stream().anyMatch(s -> s.getName().equals("iPod touch")));

	}
}
