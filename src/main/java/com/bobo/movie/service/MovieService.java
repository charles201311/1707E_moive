package com.bobo.movie.service;

import com.bobo.movie.domain.Movie;
import com.bobo.movie.vo.MovieVO;
import com.github.pagehelper.PageInfo;

public interface MovieService {

	/**
	 * 
	 * @Title: selects 
	 * @Description: TODO
	 * @param movieVO
	 * @return
	 * @return: List<Movie>
	 */
	PageInfo<Movie> selects(MovieVO movieVO,Integer page,Integer pageSize);
	
	/**
	 * 
	 * @Title: deleteBatch 
	 * @Description: T批量删
	 * @param ids
	 * @return
	 * @return: int
	 */
	boolean deleteBatch(Integer[] ids);
	
	/**
	 * 
	 * @Title: update 
	 * @Description: TODO
	 * @param movie
	 * @return
	 * @return: int
	 */
	boolean update(Movie movie);

}
