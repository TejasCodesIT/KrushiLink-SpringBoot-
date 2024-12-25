package com.tejas.F2B_Farmer.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tejas.F2B_Farmer.model.Post;
import com.tejas.F2B_Farmer.services.PostServices;

@CrossOrigin(origins ="http://localhost:4200/")
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostServices postService;

    @GetMapping()
    public List<Post> getAllPosts() {
        return postService.getAllPosts() ; 
    } 
    
    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
    	
        return postService.getPostById(id).get();
    }   


    
    @PostMapping()
    public boolean addpost(@RequestBody Post post) {
         postService.addPost(post);
         System.out.println(post.getFarmer().getFarmerid()+"Farmer id");
         return true;
    }


    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable Long id) {
        postService.deletePost(id);
        return true;
    }

    
    
    @PutMapping("/{id}")
    public boolean updateproduct(@PathVariable Long id, @RequestBody Post updatedProduct) {
    	
    			postService.updatePost(id, updatedProduct);
      			
    return true;
       
    
}
    
    @GetMapping("farmer/{farmerid}")
    public List<Post> findByFarmer(@PathVariable Long farmerid) {
    	
    	
    	
    	return postService.findByFarmer(farmerid);
    	
    	
    	
    }


    
}













