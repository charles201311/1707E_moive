package com.bobo.movie.dao;

import java.util.List;

import com.bobo.movie.domain.Movie;
import com.bobo.movie.vo.MovieVO;
/**
 * 
 * @ClassName: MovieMapper 
 * @Description: TODO
 * @author: charles
 * @date: 2019年11月2日 上午9:05:14
 */
public interface MovieMapper {

	/**
	 * 
	 * @Title: selects 
	 * @Description: TODO
	 * @param movieVO
	 * @return
	 * @return: List<Movie>
	 */
	List<Movie> selects(MovieVO movieVO);
	/**
	 * 
	 * @Title: deleteBatch 
	 * @Description: T批量删
	 * @param ids
	 * @return
	 * @return: int
	 */
	int deleteBatch(Integer[] ids);
	/**
	 * 
	 * @Title: update 
	 * @Description: TODO
	 * @param movie
	 * @return
	 * @return: int
	 */
	int update(Movie movie);

}
