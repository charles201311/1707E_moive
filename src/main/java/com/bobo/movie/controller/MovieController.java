package com.bobo.movie.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bobo.movie.domain.Movie;
import com.bobo.movie.service.MovieService;
import com.bobo.movie.util.PageUtil;
import com.bobo.movie.vo.MovieVO;
import com.github.pagehelper.PageInfo;
/**
 * 
 * @ClassName: MovieController 
 * @Description: 电影控制器
 * @author: charles
 * @date: 2019年11月2日 上午9:58:54
 */
@Controller
public class MovieController {
	
	@Resource
	private MovieService movieService;
	/**
	 * 列表
	 * @Title: selects 
	 * @Description: TODO
	 * @param request
	 * @param movieVO
	 * @param page
	 * @param pageSize
	 * @return
	 * @return: String
	 */
	@RequestMapping("selects")
	public String selects(HttpServletRequest request, MovieVO movieVO,@RequestParam(defaultValue = "1")Integer page,
			@RequestParam(defaultValue = "3")Integer pageSize) {
		
		 if(null==movieVO.getOrderMethod()) {
			 movieVO.setOrderMethod("asc");//默认是正序排序 
		 }
		  
		
		 PageInfo<Movie> info = movieService.selects(movieVO, page, pageSize);
		 PageUtil.page(request, "/selects", pageSize, info.getList(), (int)info.getTotal(), page);
		 request.setAttribute("movies", info.getList());
		 request.setAttribute("movieVO", movieVO);
		 return "movies";
	}
	/**
	 * 
	 * @Title: deleteBatch 
	 * @Description: 批量删
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@RequestMapping("deleteBatch")
	public  boolean deleteBatch(@RequestParam("ids[]") Integer[] ids) {
		
		return movieService.deleteBatch(ids);
	}
  
	
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@RequestMapping("update")
	public  boolean update(Movie movie) {
		return movieService.update(movie);
	}
}
