package com.rest.api.service;

import com.rest.api.model.Review;
import com.rest.api.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review saveReview(Review review) { return reviewRepository.save(review); }

    @Override
    public List<Review> getAllReviews() { return reviewRepository.findAll(); }
}
