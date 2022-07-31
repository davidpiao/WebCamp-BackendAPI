package com.rest.api.service;

import com.rest.api.model.Review;

import java.util.List;

public interface ReviewService {
    public Review saveReview(Review review);

    List<Review> getAllReviews();
}
