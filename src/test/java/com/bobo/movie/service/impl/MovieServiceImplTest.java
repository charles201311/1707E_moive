package com.bobo.movie.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bobo.movie.domain.Movie;
import com.bobo.movie.service.MovieService;
import com.github.pagehelper.PageInfo;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class MovieServiceImplTest {
	
	@Resource
	private MovieService movieService;

	@Test
	public void testSelects() {
		
		PageInfo<Movie> info = movieService.selects(null, 1, 10);
		
		
	}

}
