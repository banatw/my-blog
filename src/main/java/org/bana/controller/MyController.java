package org.bana.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.bana.entity.Category;
import org.bana.entity.Post;
import org.bana.model.CategoryView;
import org.bana.model.Pagination;
import org.bana.model.PostForm;
import org.bana.model.PostView;
import org.bana.repo.AuthorRepo;
import org.bana.repo.CategoryRepo;
import org.bana.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MyController {
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private AuthorRepo authorRepo;

	
	public MyController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/login")
	public String showLogin(String logout,String error, Model model) {
		if(logout!=null) {
			model.addAttribute("warning", "Anda telah logout");
		}
		if(error!=null) {
			model.addAttribute("warning", "Username atau Password Salah");
		}
		return "login";
	}

	
	@GetMapping("/admin")
	public String showAuthorList(Model model,
			@RequestParam(name="page",defaultValue="1") String pageParam,
			@RequestParam(name="query",defaultValue="") String query) {
		Integer page=null;
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			page=Integer.parseInt(pageParam)-1;
		}
		catch(NumberFormatException nfe) {
			page=1;
		}
		PageRequest pageRequest = new PageRequest(Integer.valueOf(page), 10);
		List<PostView> postsView = new ArrayList<>();
		Page<Post> posts = postRepo.findByAuthorUsernameAndPostTitleContainsIgnoreCaseOrderByPostDateDesc(user.getUsername(),query,pageRequest);
		for(Post post:posts) {
			PostView postView = new PostView();
			postView.setIdPost(post.getIdPost());
			postView.setCategoryDescription(post.getCategory().getCategoryDescription());
			postView.setPostDate(new SimpleDateFormat("dd MMMM yyyy").format(post.getPostDate()));
			postView.setPostTitle(post.getPostTitle());
			postsView.add(postView);
		}
		List<Pagination> paginations = new ArrayList<>();
		Integer nilaiPageAwal = null;
		Integer nilaiPageAkhir = null;
		Integer currPage = page+1;
		
		if(currPage-5 <= 1) {
			nilaiPageAwal = 1;
			if(posts.getTotalPages() < nilaiPageAwal + 9) {
				nilaiPageAkhir = posts.getTotalPages();
			}
			else {
				nilaiPageAkhir = 10; 
			}
		}
		else {
			nilaiPageAwal = currPage-5;
			if(posts.getTotalPages() < nilaiPageAwal + 9) {
				nilaiPageAkhir = posts.getTotalPages();
			}
			else {
				nilaiPageAkhir = nilaiPageAwal + 9; 
			}
		}
		
//		System.out.println(nilaiPageAwal);
//		System.out.println(nilaiPageAkhir);
		for(int i = nilaiPageAwal;i<=nilaiPageAkhir;i++) {
			Pagination pagination = new Pagination(String.valueOf(i),currPage==i?"active":null);
			paginations.add(pagination);
		}
		
		//model.addAttribute("totalPages",posts.getTotalPages());
		model.addAttribute("posts",postsView);
		//model.addAttribute("currentPage", pageParam);
		if(query!=null || query!="") {
			model.addAttribute("query", query);
		}
		model.addAttribute("paginations", paginations);
		return "/admin/index";
	}
	
	
	@GetMapping("/admin/post_add")
	public String showFormAddd(Model model) {
		PostForm postForm = new PostForm();
		postForm.setPostDate(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date()));
		//postForm.setPostTime(new SimpleDateFormat("HH:mm").format(new Date()));
		List<Category> categories = (List<Category>) categoryRepo.findAll();
		List<CategoryView> categoryViews = new ArrayList<>();
		for(Category category : categories) {
			CategoryView categoryView = new CategoryView();
			categoryView.setCategoryDescription(category.getCategoryDescription());
			categoryView.setIdCategory(String.valueOf(category.getIdCategory()));
			categoryView.setSelected(null);
			categoryViews.add(categoryView);
		}
		model.addAttribute("postForm",postForm);
		model.addAttribute("categories", categoryViews);
		return "/admin/form";
	}
	
	@PostMapping("/admin/post_simpan")
	public String simpan(@Valid @ModelAttribute PostForm form,BindingResult bindingResult,RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			if(form.getIdPost()=="") {
				redirectAttributes.addFlashAttribute("error", bindingResult.getFieldError().getDefaultMessage());
				return "redirect:/admin/post_add";
			}
			else {
				redirectAttributes.addFlashAttribute("error",  bindingResult.getFieldError().getDefaultMessage());
				return "redirect:/admin/post_edit?idPost=" + form.getIdPost();
			}
		}
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(form.getIdPost()=="") {
			Post post = new Post();
			//String stringTgl = "";
			try {
				post.setAuditDate(new Date());
				post.setPostDate(new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(form.getPostDate()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				//stringTgl = form.getPostDate() + " 00:00";
			}
			
			post.setIdPost(UUID.randomUUID().toString().replace("-", ""));
			post.setPostSubTitle(form.getPostSubTitle());
			post.setAuthor(authorRepo.findByUsername(user.getUsername()));
			post.setCategory(categoryRepo.findOne(Integer.valueOf(form.getIdCategory())));
			post.setPostTitle(form.getPostTitle());
			post.setPostContent(form.getPostContent());
			postRepo.save(post);
		}
		else {
			Post post = new Post();
			post.setAuditDate(new Date());
			try {
				post.setAuditDate(new Date());
				post.setPostDate(new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(form.getPostDate()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
			}
			
			post.setIdPost(form.getIdPost());
			post.setPostSubTitle(form.getPostSubTitle());
			post.setAuthor(authorRepo.findByUsername(user.getUsername()));
			post.setCategory(categoryRepo.findOne(Integer.valueOf(form.getIdCategory())));
			post.setPostTitle(form.getPostTitle());
			post.setPostContent(form.getPostContent());
			postRepo.save(post);
		}
		return "redirect:/admin";
	}
	
	
	@GetMapping("/admin/post_edit")
	public String showFormEdit(@RequestParam("idPost") String idPost,Model model) {
		Post post = postRepo.findOne(idPost);
		PostForm postForm = new PostForm();
		postForm.setIdCategory(String .valueOf(post.getCategory().getIdCategory()));
		postForm.setIdPost(idPost);
		postForm.setPostContent(post.getPostContent());
		postForm.setPostDate(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(post.getPostDate()));
		//postForm.setPostTime(new SimpleDateFormat("HH:mm").format(post.getPostDate()));
		postForm.setPostTitle(post.getPostTitle());
		postForm.setPostSubTitle(post.getPostSubTitle());
		//System.out.println(post.getCategory().getIdCategory());
		List<Category> categories = (List<Category>) categoryRepo.findAll();
		List<CategoryView> categoryViews = new ArrayList<>();
		for(Category category : categories) {
			CategoryView categoryView = new CategoryView();
			categoryView.setCategoryDescription(category.getCategoryDescription());
			categoryView.setIdCategory(String.valueOf(category.getIdCategory()));
			//System.out.println(category.getIdCategory());
			if(post.getCategory().getIdCategory()==category.getIdCategory()) {
				categoryView.setSelected("selected");
			}
			categoryViews.add(categoryView);
		}
		model.addAttribute("postForm",postForm);
		/*for(CategoryView cv:categoryViews) {
			System.out.println("id : " + cv.getIdCategory() + " ; " + cv.getSelected());
		}*/
		model.addAttribute("categories", categoryViews);
		return "/admin/form";
	}
	
	@GetMapping("")
	public String redirectIndex() {
		return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String showBlog(@RequestParam(name="page",defaultValue="0") String page, Model model) {
		Integer iPage = 0;
		try {
			iPage = Integer.parseInt(page);
		}
		catch (NumberFormatException nfe) {
			iPage = 0;
		}
		PageRequest pageRequest = new PageRequest(iPage, 5);
		Page<Post> posts = postRepo.findAllByOrderByPostDateDesc((pageRequest));
		if(posts.getTotalPages()-1==iPage) {
			iPage=1;
		}
		if(posts.hasPrevious()) {
			model.addAttribute("previousPage", iPage-1);
		}
		if(posts.hasNext()) {
			model.addAttribute("nextPage", iPage+1);
		}
		List<PostView> postViews = new ArrayList<>();
		for(Post post : posts) {
			PostView postView = new PostView();
			postView.setPostSubTitle(post.getPostSubTitle());
			postView.setPostTitle(post.getPostTitle());
			postView.setPostContent(post.getPostContent());
			postView.setPostDate(new SimpleDateFormat("dd MMMM yyyy").format(post.getPostDate()));
			postView.setAuthorName(post.getAuthor().getAuthorName());
			postView.setIdPost(post.getIdPost());
			postViews.add(postView);
		}
		model.addAttribute("posts", postViews);
		return "/blog/index";
	}
	
	@GetMapping("/post")
	public String showPost(@RequestParam("idPost") String idPost, Model model) {
		Post post = postRepo.findOne(idPost);
		PostView postView = new PostView();
		postView.setPostSubTitle(post.getPostSubTitle());
		postView.setPostTitle(post.getPostTitle());
		postView.setPostContent(post.getPostContent());
		postView.setPostDate(new SimpleDateFormat("dd MMMM yyyy").format(post.getPostDate()));
		postView.setAuthorName(post.getAuthor().getAuthorName());
		postView.setIdPost(post.getIdPost());
		model.addAttribute("postView", postView);
		return "/blog/post";
	}
	
	@GetMapping("/admin/post_delete")
	public String showFormDelete(@RequestParam("idPost") String idPost) {
		postRepo.delete(idPost);
		return "redirect:/admin";
	}
	
}
