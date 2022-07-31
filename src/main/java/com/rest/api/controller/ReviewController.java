package com.rest.api.controller;

import com.rest.api.model.Review;
import com.rest.api.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/review")
@CrossOrigin
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/add")
    public String add(@RequestBody Review review) {
        reviewService.saveReview(review);
        return "Review added";
    }

    @GetMapping("/getAll")
    public List<Review> list() {
        return reviewService.getAllReviews();
    }
}
